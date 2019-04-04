package test4;

import java.sql.*;

/**
 * 4.4未设置索引时，耗时658ms
 * 4.5设置索引后，耗时307ms
 */
public class Test4_4and4_5 {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        select("刘建国 20000");
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime+"ms");
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
     * 根据姓名查询
     * @param name
     */
    public static void select(String name) {
        Connection conn = getConn();
        String sql = "SELECT * FROM students where name ='"+name+"'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();		//将查询的结果放入ResultSet结果集中

            /**
             * 从结果集ResultSet中迭代取出查询结果并输出
             */
            while(rs.next()) {
                Integer id = rs.getInt("id");
                Double score = rs.getDouble("score");

                System.out.println("学号："+id +", "+ "姓名："+name +", "+ "成绩："+score);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
