package test2.serializable;

import java.io.Serializable;
import java.util.Arrays;

public class Student implements Serializable{//实现序列化接口 transient控制需要序列化的字段
    private String name;//姓名
    private Double score;//分数
    private String[] addresses;//曾经的住处

    public Student() {
        this.name="尼古拉斯";
        this.score =99.5;
        this.addresses=new String[2];
        this.addresses[0]="住址#1";
        this.addresses[1]="住址#2";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String[] getAddresses() {
        return addresses;
    }

    public void setAddresses(String[] addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", addresses=" + Arrays.toString(addresses) +
                '}';
    }
}
