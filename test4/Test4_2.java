package test4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test4_2 {
    public static void main(String[] args) {
//        Connection con = getConn();
//        Student s1 = new Student("尼古拉斯",60.5);
//        insert(s1);
//        update("尼古拉斯","尼古拉斯.赵四");
        delete("尼古拉斯.赵四");

    }


    /**
     * 连接数据库
     * @return
     */
    private static Connection getConn() {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/BbcDB?useUnicode=true&amp;characterEncoding=utf-8";
        String username = "root";
        String password = "123456";
        Connection conn = null;
        try {
            Class.forName(driver); //classLoader,加载对应驱动
            conn = DriverManager.getConnection(url, username, password);
//            System.out.println("数据库连接成功");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 插入学生数据
     * @param student
     * @return
     */
    private static void insert(Student student) {
        Connection conn = getConn();
        String sql = "insert into students (name,score) values(?,?)";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, student.getName());
            ps.setDouble(2,student.getScore());
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据姓名修改姓名
     * @param oldName
     * @param newName
     */
    private static void update(String oldName,String newName) {
        Connection conn = getConn();
        String sql = "update students set name ='" +newName+ "' where Name='" + oldName + "'";
        PreparedStatement ps;
        try {
            ps =conn.prepareStatement(sql);
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据姓名删除记录
     * @param name
     */
    private static void delete(String name) {
        Connection conn = getConn();
        String sql = "delete from students where Name='" + name + "'";
        PreparedStatement ps;
        try {
            ps =conn.prepareStatement(sql);
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
