package test2.externalizable;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Arrays;

public class Student implements Externalizable {//实现反序列化接口
    private String name;//姓名
    private Double score;//分数
    private String[] addresses;//曾经的住处

    public Student() {
        this.name="尼古拉斯赵四";
        this.score =95.5;
        this.addresses=new String[2];
        this.addresses[0]="住址#100";
        this.addresses[1]="住址#220";
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {//控制要序列化的字段
        out.writeObject(this.name);
        out.writeObject(this.score);
        out.writeObject(this.addresses);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {//控制要序列化的字段
        this.name = (String) in.readObject();
        this.score = (double) in.readObject();
        this.addresses = (String[]) in.readObject();
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
