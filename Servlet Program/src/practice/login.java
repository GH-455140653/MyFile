package practice;

import practice.inter.def.door1;
import practice.inter.door;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        name = new String(name.getBytes("iso-8859-1"), "utf-8");
        String pwd = req.getParameter("password");
        HttpSession session = req.getSession();
        door door = new door1();
        boolean tf = door.checked(name, pwd);
        if (tf) {
            session.setAttribute("msg", "登录成功");
            session.setAttribute("pws", pwd);
            session.setAttribute("name", name);
            resp.sendRedirect("Practice/out.jsp");
        } else {
            session.setAttribute("msg", "登录失败");
            session.setAttribute("pws", pwd);
            session.setAttribute("name", name);
            resp.sendRedirect("Practice/out.jsp");
        }
    }
}
