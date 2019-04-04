package test3.test3_1.jdom;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import test3.test3_1.Dependency;
import test3.test3_1.Project;

import java.io.IOException;
import java.util.List;


public class Jdom {
    public static void main(String[] args) {
        Project pro = new Project();
        //新建构造器解析xml
        SAXBuilder sax = new SAXBuilder();
        //建一个文档去接受数据
        Document doc;
        try {
            //获取pom.xml文档
            doc = sax.build(("D:\\IdeaProjects\\javaTest2\\src\\test3\\pom.xml"));
            //获得根节点
            Element project = doc.getRootElement();
            //获得根节点下的节点数据
            List<Element> list =project.getChildren();
            Element dependencies = null;

            for (int i=0;i<list.size();i++){
                if (list.get(i).getName().equals("dependencies")){
                    dependencies = list.get(i);
                }
            }
            List<Element> elements = dependencies.getChildren();
            for (int i=0;i<elements.size();i++){
                Element e =elements.get(i);
                String groupId = e.getChildText("groupId");
                String artifactId= e.getChildText("artifactId");
                String version = e.getChildText("version");
                String scope = e.getChildText("scope");
                pro.add(new Dependency(groupId,artifactId,version,scope));
            }
            System.out.println(pro.getDependencies());
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
