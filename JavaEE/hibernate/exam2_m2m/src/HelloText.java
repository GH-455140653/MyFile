import java.util.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.tutorial.util.HibernateUtil;

import com.dqpi.hibernate.model.Student;
import com.dqpi.hibernate.model.Teacher;;

public class HelloText {

    public void save() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Random rm = new Random(20);
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Student s = new Student();
            Teacher t = new Teacher();

            s.setName("lrl" + rm.nextInt(100));
            s.setAge(18 + rm.nextInt(10));
            s.setSex("男");
            t.setName("lrs" + rm.nextInt(100));
            t.setAge(22 + rm.nextInt(10));
            t.setSex("女");
            students.add(s);
            t.setStudents(students);
            session.save(t);
        }

        session.getTransaction().commit();
        HibernateUtil.getSessionFactory().close();
    }

    public void get() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();


        //HQL单表条件查询
//        Query query = session.createQuery("from Student");
//		Query query = session.createQuery("from Student s where s.id>:pre and s.id<:next");
//		query.setParameter("pre", 3);
//		query.setParameter("next", 10);
//        List<Student> s = (List<Student>) query.list();
//        for (Student student : s) {
//            System.out.println(student.getName());
//        }

        //HQL多表查询实现级联学生学号在(n,m)的查询
        Query query = session.createQuery("from Teacher t left join fetch t.students s where s.id>:pre and s.id<:next");
        query.setParameter("pre", 7);
        query.setParameter("next", 10);

        Set<Teacher> teacherList = new HashSet<Teacher>(query.list());
        Iterator<Teacher> it = teacherList.iterator();
        while (it.hasNext()) {
            Teacher t = it.next();
            int len = t.getStudents().size();
            for (int i = 0; i < len; i++) {
                System.out.println(t.getStudents().get(i).getName());
            }
        }

        //（n,m）单表查询并输出结果
//        List<String> stus = new ArrayList<>();
//        for (int i = 1; i < 3; i++) {
//            Student s = (Student) session.get(Student.class, i);
//            stus.add(s.getName());
//        }
//        for (String items : stus) {
//            System.out.println(items);
//        }

        //（n,m）多表查询并输出结果
//        for (int i = 1; i < 3; i++) {
//            Teacher t = (Teacher) session.get(Teacher.class, i);
//            stus.add(String.valueOf(t.getStudents().get(i).getName()));
//        }
//        for (String items : stus) {
//            System.out.println(items);
//        }

        session.getTransaction().commit();
        HibernateUtil.getSessionFactory().close();
    }

    public void up() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        //单表修改
//        Student s = (Student) session.get(Student.class, 2);
//        s.setName("lrl");

        //多表关联修改
        Teacher t = (Teacher) session.get(Teacher.class, 1);
        t.getStudents().get(0).setName("lrl");
        System.out.println(t.getStudents().get(0).getName());

        session.save(t);
        session.getTransaction().commit();
        HibernateUtil.getSessionFactory().close();
    }

    public void del() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Student student = null;
        for (int i = 0; i < 10; i++) {
            Teacher teacher = (Teacher) session.get(Teacher.class, i + 1);
            student = (Student) session.get(Student.class, 2);
            teacher.getStudents().remove(student);
        }
        session.delete(student);

        session.getTransaction().commit();
        HibernateUtil.getSessionFactory().close();
    }
}