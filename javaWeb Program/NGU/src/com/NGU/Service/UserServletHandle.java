package com.NGU.Service;

import com.NGU.Moduel.*;
import com.NGU.UserDao.Imp.*;
import com.NGU.UserDao.Interface.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserServletHandle extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String flag = req.getParameter("key");
        List<User> list = new ArrayList<>();

        /*登录校验*/
        if (flag.equals("login")) {
            String no = req.getParameter("name");
            String password = req.getParameter("password");
            String authority = req.getParameter("authority");
            UserDAOI userDAOI = new UserDaoImpLogin(no, password, authority);
            list = userDAOI.read();
            session.setAttribute("list_login", list);
            if (list.size() == 0) {
                resp.sendRedirect("NGU/index.jsp?msg=error");
            } else {
                if (list.get(0).getAuthority() == 1) {

                    /*获取所有员工的编号*/
                    PersonDAOI personDAOI = new UserDaoImpPerson();
                    List<Integer> list_no = new ArrayList<>();
                    list_no = personDAOI.readno();
                    session.setAttribute("list_no", list_no);
                    /*获取所有员工的编号*/

                    resp.sendRedirect("NGU/admin.jsp");
                } else {
                    /*签到模块嵌入*/
                    SignDAOI signDAOI = new UserDaoImpSign();/*读取签到表是为了查看用户当天的签到状态*/
                    String time = new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString();/*获取今天日期*/
                    signDAOI.insertintosign(Integer.parseInt(no), time);
                    int statues = signDAOI.readstatues(Integer.parseInt(no), time);
                    session.setAttribute("statues", statues);
                    /*签到模块嵌入*/

                    /*个人信息模块嵌入*/
                    List<Person> list7 = new ArrayList<>();
                    PersonDAOI personDAOI = new UserDaoImpPerson();
                    list7 = personDAOI.lookInfo(no);
                    session.setAttribute("userinfo", list7);
                    /*个人信息模块嵌入*/

                    resp.sendRedirect("NGU/user.jsp");
                }
            }

            /*密码修改*/
        } else if (flag.equals("UserPasswordUpdate")) {
            String no = req.getParameter("name");
            String psw = req.getParameter("psw");
            UserDAOI userDAOI = new UserDaoImpLogin(no, psw);
            list = userDAOI.update();
            resp.sendRedirect("NGU/index.jsp?msg=flag&no=" + list.get(0).getNo() + "&authority=" + list.get(0).getAuthority());//msg用于表示变量，告知页面修改密码成功

            /*查询全部考勤信息*/
        } else if (flag.equals("searchsign")) {
            List<Sign> listsign = new ArrayList<>();
            SignDAOI signDAOI = new UserDaoImpSign();
            listsign = signDAOI.read();
            session.setAttribute("listsign", listsign);
            resp.sendRedirect("NGU/Sign.jsp?index=0");

            /*按照编号查询考勤信息*/
        } else if (flag.equals("searchsignby")) {
            List<Sign> listsign = new ArrayList<>();
            SignDAOI signDAOI = new UserDaoImpSign();
            int signbyno = Integer.parseInt(req.getParameter("signbyno"));
            if (signbyno == -1) {
                resp.sendRedirect("NGU/Sign.jsp?index=0");
            } else {
                listsign = signDAOI.read(signbyno);
                session.setAttribute("listsign", listsign);
                resp.sendRedirect("NGU/Sign.jsp?index=0");
            }

            /*普通用户签到*/
        } else if (flag.equals("sign")) {
            String no = req.getParameter("no");
//            System.out.println("*******************" + no);//获取判断
            String time = new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString();/*获取今天日期*/
            int statues = 0;
            SignDAOI signDAOI = new UserDaoImpSign();
            signDAOI.update(no, time, statues);/*把编号，日期，当天签到状态传参修改当天签到状态*/
            session.setAttribute("statues", 1);
            resp.sendRedirect("NGU/user.jsp");
        } else if (flag.equals("Dialog")) {
            ArrayList list_login = (ArrayList) session.getAttribute("list_login");
            List<Dialog> list_dialog = new ArrayList<>();
            DialogDAOI dialogDAOI = new UserDaoImpDialog();
            list_dialog = dialogDAOI.read();
            User user = (User) list_login.get(0);
            int authority = user.getAuthority();
            if (authority == 1) {
                session.setAttribute("list_dialog", list_dialog);
                resp.sendRedirect("NGU/adminDialogOutput.jsp");
            } else {
                session.setAttribute("list_dialog", list_dialog);
                resp.sendRedirect("NGU/userDialogOutput.jsp");
            }
        } /*else if (flag.equals("Upform")) {
            ArrayList list_login = (ArrayList) session.getAttribute("list_login");
            String dno = req.getParameter("Dno");
            String no = req.getParameter("No");
            String name = req.getParameter("Name");
            String message = req.getParameter("Message");
            message = new String(message.getBytes("iso8859-1"), "utf-8");
            DialogDAOI dialogDAOI = new UserDaoImpDialog(dno, no, name, message);
            List<Dialog> list_dialog = new ArrayList<>();
            list_dialog = dialogDAOI.update();
            User user = (User) list_login.get(0);
            int authority = user.getAuthority();
            if (authority == 1) {
                session.setAttribute("list_dialog", list_dialog);
                resp.sendRedirect("NGU/adminDialogOutput.jsp");
            } else {
                session.setAttribute("list_dialog", list_dialog);
                resp.sendRedirect("NGU/userDialogOutput.jsp");
            }
        }*/ else if (flag.equals("upNew")) {
            ArrayList list_login = (ArrayList) session.getAttribute("list_login");
            String no = req.getParameter("userDialog");
            String message = req.getParameter("Message");
            message = new String(message.getBytes("iso8859-1"), "utf-8");
            DialogDAOI dialogDAOI = new UserDaoImpDialog(no, message);
            List<Dialog> list_dialog = new ArrayList<>();
            list_dialog = dialogDAOI.create();
            User user = (User) list_login.get(0);
            int authority = user.getAuthority();
            if (authority == 1) {
                session.setAttribute("list_dialog", list_dialog);
                resp.sendRedirect("NGU/adminDialogOutput.jsp");
            } else {
                session.setAttribute("list_dialog", list_dialog);
                resp.sendRedirect("NGU/userDialogOutput.jsp");
            }
        } else if (flag.equals("submitAdvance")) {
            String no = req.getParameter("userAdvice");
            String Smessage = req.getParameter("advice");
            Smessage = new String(Smessage.getBytes("iso8859-1"), "utf-8");
            AdviceDAOI adviceDAOI = new UserDaoImpAdvise(no, Smessage);
            List<Advice> list_advice = new ArrayList<>();
            list_advice = adviceDAOI.create();
            resp.sendRedirect("NGU/user.jsp");
        } else if (flag.equals("readAdvice")) {
            ArrayList list_login = (ArrayList) session.getAttribute("list_login");
            String no = req.getParameter("userAdvice");
            AdviceDAOI adviceDAOI = new UserDaoImpAdvise();
            List<Advice> list_advice = new ArrayList<>();
            list_advice = adviceDAOI.read();
            session.setAttribute("list_advice", list_advice);
            resp.sendRedirect("NGU/adviceOutput.jsp");
        }

        //person
        else if (flag.equals("personInfo")) {
            PersonDAOI personDAOI = new UserDaoImpPerson();
            List<Person> list3 = new ArrayList<>();
            list3 = personDAOI.read();
            session.setAttribute("personlist", list3);
            resp.sendRedirect("NGU/Person.jsp?index=0");
        }

        /*工资管理*/
        else if (flag.equals("searchwage")) {
            List<Salary> listsalary = new ArrayList<>();
            WageDAOI wageDAOI = new UserDaoImpWage();
            listsalary = wageDAOI.readWage();
            session.setAttribute("listsalary", listsalary);
            resp.sendRedirect("NGU/Wage.jsp?index=0");

        } else if (flag.equals("searchwageby")) {/*按照编号查询工资信息*/
            List<Salary> listsalary = new ArrayList<>();
            WageDAOI wageDAOI = new UserDaoImpWage();
            String wagebyno = req.getParameter("wagebyno");
            wagebyno = new String(wagebyno.getBytes("iso-8859-1"), "utf-8");
            if (wagebyno.equals("-请选择-")) {
                resp.sendRedirect("NGU/Wage.jsp?index=0");
            } else {
                int swagebyno = Integer.parseInt(wagebyno);
                listsalary = wageDAOI.readby(swagebyno);
                session.setAttribute("listsalary", listsalary);
                resp.sendRedirect("NGU/Wage.jsp?index=0");
            }

        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String flag = req.getParameter("key");

        /*管理员修改某员工某天的签到状态*/
        if (flag.equals("signupdate")) {
            List<Sign> listsign = new ArrayList<>();
            String signupdateno = req.getParameter("signupdateno");
            String signupdatetime = req.getParameter("signupdatetime");
            int signupdatestatues = Integer.parseInt(req.getParameter("signupdatestatues"));
            SignDAOI signDAOI = new UserDaoImpSign();
            signDAOI.update(signupdateno, signupdatetime, signupdatestatues);/*把编号，日期，当天签到状态传参修改当天签到状态*/
            signDAOI = new UserDaoImpSign();/*要是没有重新初始化会报：结果集中没有值*/
            listsign = signDAOI.read();/*在修改成功后再重新加载刷新页面*/
            session.setAttribute("listsign", listsign);
            resp.sendRedirect("NGU/Sign.jsp?index=0");
        }

        /*dialog*/
        else if (flag.equals("deleteAll")) {
            ArrayList list_login = (ArrayList) session.getAttribute("list_login");
            User user = (User) list_login.get(0);
            int authority = user.getAuthority();
            String idAll = req.getParameter("idAll");
            if (!idAll.equals("")) {
                String[] idallone = idAll.split(",");
                for (String string : idallone) {
                    DialogDAOI dialogDAOI = new UserDaoImpDialog(string);
                    dialogDAOI.delete();
                }
                List<Dialog> list_dialog = new ArrayList<>();
                DialogDAOI dialogDAOI = new UserDaoImpDialog();
                list_dialog = dialogDAOI.read();
                if (authority == 1) {
                    session.setAttribute("list_dialog", list_dialog);
                    resp.sendRedirect("NGU/adminDialogOutput.jsp");
                } else {
                    session.setAttribute("list_dialog", list_dialog);
                    resp.sendRedirect("NGU/userDialogOutput.jsp");
                }
            } else {
                if (authority == 1) {
                    System.out.print("请先选择!");
                    resp.sendRedirect("NGU/adminDialogOutput.jsp");
                } else {
                    System.out.print("请先选择!");
                    resp.sendRedirect("NGU/userDialogOutput.jsp");
                }
            }
        } else if (flag.equals("delete")) {
            ArrayList list_login = (ArrayList) session.getAttribute("list_login");
            String dno = req.getParameter("dno");
            DialogDAOI dialogDAOI = new UserDaoImpDialog(dno);
            dialogDAOI.delete();
            List<Dialog> list_dialog = new ArrayList<>();
            DialogDAOI dialogDAOIread = new UserDaoImpDialog();
            list_dialog = dialogDAOIread.read();
            User user = (User) list_login.get(0);
            int authority = user.getAuthority();
            if (authority == 1) {
                session.setAttribute("list_dialog", list_dialog);
                resp.sendRedirect("NGU/adminDialogOutput.jsp");
            } else {
                session.setAttribute("list_dialog", list_dialog);
                resp.sendRedirect("NGU/userDialogOutput.jsp");
            }
        } else if (flag.equals("update")) {
            String dno = req.getParameter("dno");
            DialogDAOI dialogDAOIno = new UserDaoImpDialog(dno);
            List<Dialog> list = new ArrayList<>();
            list = dialogDAOIno.readByDno();
            ArrayList list_login = (ArrayList) session.getAttribute("list_login");
            Dialog dialog = list.get(0);
            int no = dialog.getNo();
            String name = dialog.getName();
            String message = req.getParameter("message");
            message = new String(message.getBytes("iso8859-1"), "utf-8");
            DialogDAOI dialogDAOI = new UserDaoImpDialog(dno, no, name, message);
            List<Dialog> list_dialog = new ArrayList<>();
            list_dialog = dialogDAOI.update();
            User user = (User) list_login.get(0);
            int authority = user.getAuthority();
            if (authority == 1) {
                session.setAttribute("list_dialog", list_dialog);
                resp.sendRedirect("NGU/adminDialogOutput.jsp");
            } else {
                session.setAttribute("list_dialog", list_dialog);
                resp.sendRedirect("NGU/userDialogOutput.jsp");
            }
        } else if (flag.equals("readMine")) {
            String no = req.getParameter("no");
            int noInt = Integer.parseInt(no);
            DialogDAOI dialogDAOI = new UserDaoImpDialog(noInt);
            List<Dialog> list = new ArrayList<>();
            list = dialogDAOI.readByno();
            session.setAttribute("list_dialog", list);
            resp.sendRedirect("NGU/userDialogOutput.jsp");
        } else if (flag.equals("readByno")) {
            String no = req.getParameter("no");
            int noInt = Integer.parseInt(no);
            DialogDAOI dialogDAOI = new UserDaoImpDialog(noInt);
            List<Dialog> list = new ArrayList<>();
            list = dialogDAOI.readByno();
            session.setAttribute("list_dialog", list);
            resp.sendRedirect("NGU/adminDialogOutput.jsp");
        } else if (flag.equals("back")) {
            ArrayList list_login = (ArrayList) session.getAttribute("list_login");
            User user = (User) list_login.get(0);
            int authority = user.getAuthority();
            if (authority == 1) {
                session.setAttribute("list_login", list_login);
                resp.sendRedirect("NGU/admin.jsp");
            } else {
                session.setAttribute("list_login", list_login);
                resp.sendRedirect("NGU/user.jsp");
            }
        } else if (flag.equals("readAllDialog")) {
            ArrayList list_login = (ArrayList) session.getAttribute("list_login");
            User user = (User) list_login.get(0);
            int authority = user.getAuthority();
            List<Dialog> list_dialog = new ArrayList<>();
            DialogDAOI dialogDAOI = new UserDaoImpDialog();
            list_dialog = dialogDAOI.read();
            if (authority == 1) {
                session.setAttribute("list_dialog", list_dialog);
                resp.sendRedirect("NGU/adminDialogOutput.jsp");
            } else {
                session.setAttribute("list_dialog", list_dialog);
                resp.sendRedirect("NGU/userDialogOutput.jsp");
            }
        }

        /*Advice*/
        else if (flag.equals("deleteAdvice")) {
            ArrayList list_login = (ArrayList) session.getAttribute("list_login");
            String sno = req.getParameter("Sno");
            AdviceDAOI adviceDAOI = new UserDaoImpAdvise(sno);
            adviceDAOI.delete();
            List<Advice> list_advice = new ArrayList<>();
            AdviceDAOI adviceDAOIread = new UserDaoImpAdvise();
            list_advice = adviceDAOIread.read();
            session.setAttribute("list_advice", list_advice);
            resp.sendRedirect("NGU/adviceOutput.jsp");
        } else if (flag.equals("deleteAllAdvice")) {
            String idAll = req.getParameter("idAll");
            if (!idAll.equals("")) {
                String[] idallone = idAll.split(",");
                for (String string : idallone) {
                    AdviceDAOI adviceDAOI = new UserDaoImpAdvise(string);
                    adviceDAOI.delete();
                }
                List<Advice> list_advice = new ArrayList<>();
                AdviceDAOI adviceDAOI = new UserDaoImpAdvise();
                list_advice = adviceDAOI.read();
                session.setAttribute("list_advice", list_advice);
                resp.sendRedirect("NGU/adviceOutput.jsp");
            } else {
                System.out.print("请先选择!");
                resp.sendRedirect("NGU/adviceOutput.jsp");
            }
        } else if (flag.equals("readByNoAdvice")) {
            String no = req.getParameter("no");
            int noInt = Integer.parseInt(no);
            AdviceDAOI adviceDAOI = new UserDaoImpAdvise(noInt);
            List<Advice> list_advice = new ArrayList<>();
            list_advice = adviceDAOI.readByno();
            session.setAttribute("list_advice", list_advice);
            resp.sendRedirect("NGU/adviceOutput.jsp");
        } else if (flag.equals("readAllAdvice")) {
            List<Advice> list_advice = new ArrayList<>();
            AdviceDAOI adviceDAOI = new UserDaoImpAdvise();
            list_advice = adviceDAOI.read();
            session.setAttribute("list_advice", list_advice);
            resp.sendRedirect("NGU/adviceOutput.jsp");
        }

        /*Person*/
        else if (flag.equals("deletePerson")) {
            String noall = req.getParameter("noAll");
            if (!noall.equals("")) {
                String[] noone = noall.split(",");
                for (String string : noone) {
                    PersonDAOI personDAOI = new UserDaoImpPerson();
                    personDAOI.delete(string);
                }
                PersonDAOI personDAOI = new UserDaoImpPerson();
                List<Person> list4 = new ArrayList<>();
                list4 = personDAOI.read();
                session.setAttribute("personlist", list4);
                resp.sendRedirect("NGU/Person.jsp?index=0");
            } else {
                System.out.print("请先选择!");
                resp.sendRedirect("NGU/Person.jsp?index=0");
            }
        } else if (flag.equals("updatePerson")) {
            String lie = req.getParameter("type");
            String value = req.getParameter("value");
            String no = req.getParameter("no");
            PersonDAOI personDAOI = new UserDaoImpPerson();
            personDAOI.update(lie, value, no);
            personDAOI = new UserDaoImpPerson();
            List<Person> list5 = new ArrayList<>();
            list5 = personDAOI.read();
            session.setAttribute("personlist", list5);
            resp.sendRedirect("NGU/Person.jsp?index=0");
        } else if (flag.equals("searchPerson")) {
            String no = req.getParameter("no");
            String dept = req.getParameter("dept");
            dept = new String(dept.getBytes("iso-8859-1"), "utf-8");
            System.out.println(dept);
            PersonDAOI personDAOI = new UserDaoImpPerson();
            List<Person> list6 = new ArrayList<>();
            list6 = personDAOI.search(no, dept);
            session.setAttribute("personlist", list6);
            resp.sendRedirect("NGU/Person.jsp?index=0");
        } else if (flag.equals("insertPerson")) {
            String no = req.getParameter("pno");
            String name = req.getParameter("pname");
            String dept = req.getParameter("selectD");
            String age = req.getParameter("page");
            String sex = req.getParameter("selectSex");
            String salary = req.getParameter("psalary");
            String tel = req.getParameter("ptel");
            PersonDAOI personDAOI = new UserDaoImpPerson();
            personDAOI.insert(no, name, dept, age, sex, salary, tel);
            resp.sendRedirect("NGU/admin.jsp");
        } else if (flag.equals("changePerson")) {
            String no = req.getParameter("userno");
            String name = req.getParameter("username");
            String age = req.getParameter("userage");
            String dept = req.getParameter("userdept");
            String sex = req.getParameter("usersex");
            String tel = req.getParameter("usertel");
            //PrintWriter out = resp.getWriter();
            //out.println(no+" "+name+" "+age+" "+dept+" "+sex+" "+tel);
            PersonDAOI personDAOI = new UserDaoImpPerson();
            List<Person> list8 = new ArrayList<>();
            list8 = personDAOI.change(no, name, dept, age, sex, tel);
            session.setAttribute("userinfo", list8);
            //out.println(a);
            resp.sendRedirect("NGU/user.jsp");
        } else if (flag.equals("downloadInfo")) {
            String path1 = req.getParameter("path");
            String myname = req.getParameter("myname");
            myname = new String(myname.getBytes("ISO-8859-1"), "utf-8");
            String myage = req.getParameter("myage");
            String mydept = req.getParameter("mydept");
            mydept = new String(mydept.getBytes("ISO-8859-1"), "utf-8");
            String mysex = req.getParameter("mysex");
            mysex = new String(mysex.getBytes("ISO-8859-1"), "utf-8");
            String mytel = req.getParameter("mytel");
            PersonDAOI personDAOI = new UserDaoImpPerson();
            personDAOI.writeTxt(path1, myname, mysex, myage, mydept, mytel);
            personDAOI.download(path1, req, resp);
            resp.sendRedirect("NGU/user.jsp");
        }
    }
}
