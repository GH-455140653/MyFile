package com.NGU.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.NGU.Moduel.Advice;
import com.NGU.Moduel.User;
import com.NGU.UserDao.Imp.UserDaoImpAdvise;
import com.NGU.UserDao.Interface.AdviceDAOI;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;


public class Upload extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //解决post请求乱码
        req.setCharacterEncoding("utf-8");
        /*String name = request.getParameter("name");
        String photo = request.getParameter("photo");
        System.out.println(name+"--"+photo);
        */
        //获取一个流
        /*ServletInputStream in = request.getInputStream();
        String str = IOUtils.toString(in);
        System.out.println(str);*/
        //获取一个工厂类实例
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //创建解析器实例
        ServletFileUpload fileUpload = new ServletFileUpload(factory);
        fileUpload.setHeaderEncoding("iso-8859-1");
        try {
            //解析request
            List<FileItem> fileItems = fileUpload.parseRequest(new ServletRequestContext(req));
            //fileList = upload.parseRequest(new ServletRequestContext(req));
            //fileList = upload.parseRequest(req);//获取上传列表
            //System.out.println(fileItems.size());
            //遍历fileItems,读取表单的信息
            for (FileItem fileItem : fileItems) {
                //判断当前表单项是否是一个普通表单项
                if (fileItem.isFormField()) {
                    //获取属性名
                    String fieldName = fileItem.getFieldName();
//                    fieldName = new String(fieldName.getBytes("iso-8859-1"), "utf-8");
                    //获取属性值
                    String value = fileItem.getString("utf-8");
                    System.out.println(fieldName + "=" + value);
                } else {
                    //如果是文件表单项
                    //获取文件的大小
                    long size = fileItem.getSize();
                    //获取文件的类型
                    String contentType = fileItem.getContentType();
                    //获取文件的名字
                    String name = fileItem.getName();
                    name = new String(name.getBytes("iso-8859-1"), "utf-8");
                    if (name.contains("\\")) {
                        //如果包含则截取字符串
                        name = name.substring(name.lastIndexOf("\\") + 1);
                    }

                    //获取表单项的属性名
                    String fieldName = fileItem.getFieldName();
                    System.out.println("文件的大小:" + size);
                    System.out.println("文件的类型:" + contentType);
                    System.out.println("文件的名字:" + name);
                    System.out.println("表单项name属性名:" + fieldName);
                    //获取ServletContext对象
                    ServletContext context = this.getServletContext();
                    //获取项目的真实路径
                    String path = context.getRealPath("\\upload");
                    //判断路径是否存在
                    File file = new File(path);
                    if (!file.exists()) {
                        //如果不存在该路径，则创建一个路径
                        file.mkdirs();
                    }

                    System.out.println(path);
                    //将文件写入到磁盘中
                    fileItem.write(new File(path + "\\" + name));


                    ArrayList list = new ArrayList();
                    String pathRead = path + "\\" + name;
//                    BufferedReader bin = new BufferedReader(new FileReader(new File(pathRead)));//中文会乱码，改用下面字节流读取并转码
                    BufferedReader bin = new BufferedReader(new InputStreamReader(new FileInputStream(pathRead), "UTF-8"));

                    String s;
                    while ((s = bin.readLine()) != null) {
                        list.add(s);
                    }
                    bin.close();
                    HttpSession session = req.getSession();
                    ArrayList list_login = (ArrayList) session.getAttribute("list_login");
                    User user = (User) list_login.get(0);
                    int no = user.getNo();
                    //String Smessage = req.getParameter("advice");
                    String Smessage = "";
                    for (int i = 0; i < list.size(); i++)
                        Smessage = Smessage + list.get(i);
//                    Smessage = new String(Smessage.getBytes("GBK2312"), "utf-8");
                    AdviceDAOI adviceDAOI = new UserDaoImpAdvise(no, Smessage);
                    List<Advice> list_advice = new ArrayList<>();
                    list_advice = adviceDAOI.create();
                    //resp.sendRedirect("NGU/user.jsp");
                }
            }

        } catch (FileUploadException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        resp.sendRedirect("NGU/user.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        this.doGet(req, resp);
    }

}
