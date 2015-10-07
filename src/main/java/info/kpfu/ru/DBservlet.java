package info.kpfu.ru;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DBservlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        getList(out);
    }

    protected void getList(PrintWriter out){
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
        ArrayList<String> list = getList();
        for (int i = 0; i < list.size(); i += 4) {
            out.print("<tr style='text-align:left;'>"
                    +"<td>" + list.get(i)+"</td><td>"
                    + list.get(i+1) + "</td><td>"
                    + list.get(i+2) + "</td><td>"
                    + list.get(i+3) + "</td><td>");
        }
        out.print("</table></body></html>");
    }
    private ArrayList<String> getList(){
        ArrayList<String> list = new ArrayList<>();
        try(Scanner sc = new Scanner(mainServlet.FILE)) {
            while (sc.hasNext()){
                list.add(sc.next());
            }
        } catch (IOException e) {
            e.getMessage();
        }
        return list;
    }

}
