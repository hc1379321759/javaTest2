package test3.test3_1.dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import test3.Dependency;
import test3.Project;

import java.io.File;
import java.util.Iterator;

public class Dom4j {
    public static void main(String[] args) {
        Project project = new Project();
        //创建
        SAXReader reader = new SAXReader();
        try {
            //读取
            Document document =reader.read(new File("D:\\IdeaProjects\\javaTest2\\src\\test3\\pom.xml"));
            Element root = document.getRootElement();
            Element dependencies =null;
            Element dependency =null;
            for (Iterator i = root.elementIterator("dependencies"); i.hasNext();) {
                dependencies = (Element) i.next();
            }
            for (Iterator i = dependencies.elementIterator("dependency"); i.hasNext();) {
                dependency = (Element) i.next();
                Dependency dep = new Dependency();
                for (Iterator j = dependency.elementIterator("groupId"); j.hasNext();){
                    Element e =(Element)j.next();
                    dep.setGroupId(e.getText());
                }
                for (Iterator j = dependency.elementIterator("artifactId"); j.hasNext();){
                    Element e =(Element)j.next();
                    dep.setArtifactId(e.getText());
                }
                for (Iterator j = dependency.elementIterator("version"); j.hasNext();){
                    Element e =(Element)j.next();
                    dep.setVersion(e.getText());
                }
                for (Iterator j = dependency.elementIterator("scope"); j.hasNext();){
                    Element e =(Element)j.next();
                    dep.setScope(e.getText());
                }
                project.add(dep);
            }
            System.out.println(project.getDependencies());

        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
