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
            List<Element> dependenciesList =project.getChildren();
            Element dependencies = null;
            Element dependency =null;
            for (int i=0;i<dependenciesList.size();i++){
                if (dependenciesList.get(i).getName().equals("dependencies")){
                    dependencies = dependenciesList.get(i);
                }
            }
            List<Element> dependencyList = dependencies.getChildren();
            for (int i=0;i<dependencyList.size();i++){
                dependency=dependencyList.get(i);
                List<Element> elements =dependency.getChildren();
                for (int j=0;j<elements.size();j++){
                    Element element = elements.get(j);
                    Dependency dep = new Dependency();
                    if (element.getName().equals("groupId")){
                        dep.setGroupId(element.getText());
                    }else if(element.getName().equals("artifactId")){
                        dep.setArtifactId(element.getText());
                    }else if(element.getName().equals("version")){
                        dep.setVersion(element.getText());
                    }else if(element.getName().equals("scope")){
                        dep.setScope(element.getText());
                    }
                    pro.add(dep);
                }
            }
            System.out.println(pro.getDependencies());
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
