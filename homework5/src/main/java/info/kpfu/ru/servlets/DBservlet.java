package info.kpfu.ru.servlets;

import info.kpfu.ru.exceptions.DBEception;
import info.kpfu.ru.utils.DB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

public class DBservlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        try {
            getList(out);
        } catch (DBEception dbEception) {
            dbEception.printStackTrace();
        }
    }

    protected void getList(PrintWriter out) throws DBEception{
        out.print("<html>"
                +"<head><meta charset='utf-8'>"
                +"<title>database</title>"
                +"<style>"
                +"table{"
                +"border-collapse: collapse; border:3px solid black;}"
                +"td, th {border:2px solid black;}"
                +"</style>"
                +"</head>"
                +"<body>"
                +"<table cellpadding='10' style='margin:20px;'>"
                +"<tr style=text-align:center;>"
                +"<th>Email</th><th>Password</th><th>Пол</th><th>Подписка на новости</th>"
                +"</tr>");

        List<String[]> users = DB.getAllUsers();
        int i =0;
        while(!users.isEmpty()) {
            out.print("<tr style='text-align:left;'>"
                    +"<td>" + users.get(i)[0] +"</td><td>"
                    + users.get(i)[1] + "</td><td>"
                    + users.get(i)[2] + "</td><td>"
                    + users.get(i)[3] + "</td>");
            i++;
        }

        out.print("</table></body></html>");
    }
}
