package info.kpfu.ru;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Scanner;
public class mainServlet extends HttpServlet {

    public static final File FILE = new File("/home/asus2/file.txt");

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
        writeToFile(req.getParameter("mail"), req.getParameter("pass"), req.getParameter("id"), req.getParameter("chb"));
        writeForm(out,"<br>Added");
        }


    protected void writeForm(PrintWriter out,String s){
        out.print("<h1>Регистрация</h1>"
                +"<form action= 'http://localhost:8080/main' method = 'post'"
                +"<label>Ваш e-mail: <br>"
                +"<input type ='email' name = 'mail'></label> <br>"
                +"<label>Пароль: <br>"
                +"<input type ='password' name='pass'></label> <br>"
                +"<input type='radio' name='sex'> Муж"
                +"<input type='radio' name='sex'> Жен <br>"
                +"<label><input type ='checkbox' name='chb'></label>Подписаться на новости <br>"
                +"<input type ='submit' value='Зарегестрироваться'>"
                + s +"</form>"
        );
    }


    protected void writeToFile(String email, String password, String sex, String checkbox_status){
        StringBuilder sb = new StringBuilder();
        try(Scanner sc = new Scanner(FILE)) {
            while (sc.hasNext()){
                sb.append(sc.nextLine()).append("\n");
            }
        } catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        try(PrintWriter pw = new PrintWriter(FILE)) {
            pw.print(sb.toString());
            if (checkbox_status == null){
                checkbox_status = "off";
            }
            if (sex == null) {
                sex = "unknown";
            }
            pw.printf("%s\t%s\t%s\t%s", email, password, sex, checkbox_status);
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }

    }

}
