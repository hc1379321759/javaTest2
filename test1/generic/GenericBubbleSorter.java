package test1.generic;

import java.util.ArrayList;
import java.util.List;

public class GenericBubbleSorter<T extends Animal> {
    private Animal animal;//动物对象
    private List<Animal> list;//存储动物对象

    public GenericBubbleSorter() {
        list = new ArrayList<>();//初始为ArrayList;
    }

    /**
     * 在list中增加动物对象
     * @param animal
     */
    public void add(Animal animal){
        list.add(animal);
    }

    /**
     * 根据list中的动物体重排序，升序
     */
    public void sort(){
        for (int i =0;i<list.size();i++){
            for(int j=0;j<list.size()-1-i;j++) {
                if (list.get(j).getWeight() > list.get(j + 1).getWeight()) {
                    Animal temp = list.get(j);
                    list.set(j,list.get(j+1));
                    list.set(j+1,temp);
                }
            }
        }
    }

    /**
     * 打印List
     */
    public void printT(){
        for (int i =0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }

}
