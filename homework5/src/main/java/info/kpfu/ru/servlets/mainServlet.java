package info.kpfu.ru.servlets;

import info.kpfu.ru.entity.User;
import info.kpfu.ru.exceptions.*;
import info.kpfu.ru.repository.UserRepo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
public class mainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.print("<html><head><meta charset='UTF-8'></head>"
                + "<body>");
        this.writeForm(out,"");
        out.print("</body></html>");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        String email = req.getParameter("mail");
        String pwd = req.getParameter("pwd");
        String sex = req.getParameter("sex");
        String chb = req.getParameter("chb");
        try{
            User user = new User(email, pwd, sex, chb);
            UserRepo.addUserToList(user);
        }
        catch(DBEception ex){
            req.setAttribute("message", "Error with DB has been occured.");
        }
        catch(duplicateException ex){
            req.setAttribute("message", "User with such email already exists.");
        }
        writeForm(out,"<br>Added");
    }


    protected void writeForm(PrintWriter out,String s){
        out.print("<h1>Регистрация</h1>"
                +"<form action= 'http://localhost:8080/main' method = 'post'"
                +"<label>Ваш e-mail: <br>"
                +"<input type ='text' name = 'mail'></label> <br>"
                +"<label>Пароль: <br>"
                +"<input type ='password' name='pwd'></label> <br>"
                +"<input type='radio' name='sex' value='male'> Муж"
                +"<input type='radio' name='sex' value='female'> Жен <br>"
                +"<label><input type ='checkbox' name='chb'></label>Подписаться на новости <br>"
                +"<input type ='submit' value='Зарегестрироваться'>"
                + s +"</form>"
        );
    }


}
