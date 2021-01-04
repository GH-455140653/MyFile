package com.dqpi.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dqpi.Model.User;
import com.dqpi.UserDao.UserDAOI;
import com.dqpi.UserDao.Imp.UserDaoImp;

public class Userservlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        UserDAOI userDAOI = new UserDaoImp();
        List<User> list = new ArrayList<>();
        list = userDAOI.add();
        session.setAttribute("userlist", list);
        session.setAttribute("pageNum", "1");
        resp.sendRedirect("output1.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String opera = req.getParameter("operate");
        System.out.println(opera);
        if (opera.equals("deleteQuery")) {
            String idall = req.getParameter("idAll");
            String[] idone = idall.split(",");
            for (String value : idone) {
                if (value.equals("checkbox")) continue;
                UserDAOI userDAOI = new UserDaoImp();
                userDAOI.delet(value);
            }
            this.doPost(req, resp);
        } else if ((opera.equals("updateQuery"))) {
            String id = req.getParameter("id");
            String name = req.getParameter("name");
            String password = req.getParameter("password");
            UserDAOI userDAOI = new UserDaoImp();
            userDAOI.update(id, name, password);
            this.doPost(req, resp);
        } else if (opera.equals("pageTurn")) {
            int pageNum = Integer.parseInt(req.getParameter("pageNum"));
            String flag = req.getParameter("name");
            if (flag.equals("next")) {
                pageNum++;
            } else if (flag.equals("pre")) {
                pageNum--;
            }
            session.setAttribute("pageNum", String.valueOf(pageNum));
        }
        if (opera.equals("pageTurn")) resp.sendRedirect("output1.jsp");
    }
}
