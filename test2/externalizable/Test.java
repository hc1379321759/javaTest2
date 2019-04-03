package test2.externalizable;


import java.io.*;

public class Test {
    public static void main(String[] args) {
        Student s1 = new Student();
        toFile(s1,"D:\\IdeaProjects\\javatest2\\src\\test2\\externalizable\\student.txt");
        System.out.println(fromFile("D:\\IdeaProjects\\javatest2\\src\\test2\\externalizable\\student.txt"));
    }

    /**
     * 使用对象流写入
     * @param student
     * @param filePath
     */
    public static void  toFile(Student student, String filePath){
        File dest = new File(filePath);
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(dest);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(student);
            oos.flush();
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 使用对象流读取
     * @param filePath
     * @return
     */
    public static Student fromFile(String filePath){
        File src = new File(filePath);
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(src);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Student student =(Student)ois.readObject();
            ois.close();
            return student;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
