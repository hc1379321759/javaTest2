package test3.test3_2;

import com.alibaba.fastjson.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import test3.Project;
import test3.Dependency;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static test3.test3_2.Test.jsonToFile;

/**
 * 通过已解析出的project对象，通过调用fastjson库将.xml转换为.json
 *PS:用dom解析获取project对象
 */
public class Test2 {
    public static void main(String[] args) {
        Project project =new Project();
        project = domGetProject("D:\\IdeaProjects\\javaTest2\\src\\test3\\pom.xml");
        String json;
        //将project对象转换为json
        json = JSONObject.toJSONString(project);
        System.out.println(json);
        //调用Test中的方法将json写入pom.json
        jsonToFile(json,"D:\\IdeaProjects\\javaTest2\\src\\test3\\pom.json");
    }

    static Project domGetProject(String filePath){
        Project project = new Project();
        String groupId = null;
        String artifactId= null;
        String version =null;
        String scope =null;
        //创建DocumentBuilderFactory的对象
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            //创建DocumentBuilder对象
            DocumentBuilder db = dbf.newDocumentBuilder();
            //通过documentBuilder对象 的parser方法加载pom.xml文件到当前项目下
            Document document =db.parse(filePath);
            //获取XML文件节点的集合
            NodeList dependencyList =document.getElementsByTagName("dependency");
            //遍历所有dependency
            for (int i =0 ;i<dependencyList.getLength();i++){
                Node dependency = dependencyList.item(i);
                //转成元素
                Element denpendencyElement = (Element)dependency;
                //得到相关对象属性的值
                groupId = denpendencyElement.getElementsByTagName("groupId").item(0).getFirstChild().getNodeValue();
                artifactId = denpendencyElement.getElementsByTagName("artifactId").item(0).getFirstChild().getNodeValue();
                version = denpendencyElement.getElementsByTagName("version").item(0).getFirstChild().getNodeValue();
                if (denpendencyElement.getElementsByTagName("scope").item(0)!=null) {
                    scope =denpendencyElement.getElementsByTagName("scope").item(0).getFirstChild().getNodeValue();
                    project.add(new Dependency(groupId,artifactId,version,scope));
                }else {
                    project.add(new Dependency(groupId,artifactId,version));
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return project;
    }
}
