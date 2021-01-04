package com.dqpi.Service;

import com.dqpi.Dao.UserDao;
import com.dqpi.Dao.imp.Userdaoimp1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserService extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        name = new String(name.getBytes("iso-8859-1"), "utf-8");
        String pws = req.getParameter("password");
        HttpSession session = req.getSession();
        UserDao userDao = new Userdaoimp1();
        boolean tf = userDao.checked(name, pws);
        if (tf) {
            session.setAttribute("msg", "登录成功");
            session.setAttribute("pws", pws);
            session.setAttribute("name", name);
            resp.sendRedirect("Servlet/output.jsp");
        } else {
            session.setAttribute("msg", "登录失败");
            session.setAttribute("pws", pws);
            session.setAttribute("name", name);
            resp.sendRedirect("Servlet/output.jsp");
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }

}
