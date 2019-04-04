package test3.test3_1.sax;

import org.xml.sax.SAXException;
import test3.test3_1.Dependency;
import test3.test3_1.Project;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Sax {
    public static void main(String[] args) {
        Project project = new Project();
        List<Dependency> list = new ArrayList<>();
        //创建对象
        SAXParserFactory newInstance = SAXParserFactory.newInstance();
        //获取解析器
        try {
            SAXParser saxParser = newInstance.newSAXParser();
            //调用方法开始解析xml
            File file = new File("D:\\IdeaProjects\\javaTest2\\src\\test3\\pom.xml");
            MyHandler mh = new MyHandler();
            saxParser.parse(file, mh);
            list = mh.getDependencies();
            //输出集合
            for (int i = 0; i<list.size();i++){
                project.getDependencies().add(list.get(i));
//                System.out.println(project.getDependencies().get(i));
            }
            for (Dependency dependency:project.getDependencies()){
                System.out.println(dependency);
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
