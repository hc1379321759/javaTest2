package test4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test4_3 {
    static long NUMBER =1000000L;
    static int MAX =100;
    public static void main(String[] args) {
        Connection conn = getConn();
        Student s1 = new Student();
        for (long i=0;i<NUMBER;i++){
            s1.setName("刘建国 "+i);
            s1.setScore(Math.random()*MAX);
            insert(conn,s1);
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
    private static void insert(Connection conn,Student student) {
//        Connection conn = getConn();
        String sql = "insert into students (name,score) values(?,?)";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, student.getName());
            ps.setDouble(2,student.getScore());
            ps.executeUpdate();
            ps.close();
//            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
