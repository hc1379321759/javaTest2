package test3.test3_1.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import test3.Dependency;

import java.util.ArrayList;
import java.util.List;

public class MyHandler extends DefaultHandler {
    private List<Dependency> dependencies;
    private Dependency dependency;
    private String tag1 ="" ;
    private String tag2;

    /**
     * 表示解析开始
     * @throws SAXException
     */
    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        //实例化dependencies
        dependencies = new ArrayList<>();
    }

    /**
     * 表示解析结束
     * @throws SAXException
     */
    @Override
    public void endDocument() throws SAXException {
        super.endDocument();

    }

    /**
     * 表示开始解析某个元素
     * @param uri
     * @param localName
     * @param qName
     * @param attributes
     * @throws SAXException
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            super.startElement(uri, localName, qName, attributes);
            tag2 = qName;
            if (qName.equals("dependencies")){
                tag1 =qName;
            }
            if (qName.equals("dependency")){
                dependency = new Dependency();
            }
    }


    /**
     * 表示结束解析某个元素
     * @param uri
     * @param localName
     * @param qName
     * @throws SAXException
     */
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        if (qName.equals("dependency")){
            dependencies.add(dependency);
        }
        tag2 = "";
        if (qName.equals("dependencies")){
            tag1 ="";
        }
    }

    /**
     * 解析元素属性
     * @param ch
     * @param start
     * @param length
     * @throws SAXException
     */
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        String string =new String(ch,start,length);
        if (tag1.equals("dependencies")) {
            if (tag2.equals("groupId")) {
                dependency.setGroupId(string);
            } else if (tag2.equals("artifactId")) {
                dependency.setArtifactId(string);
            } else if (tag2.equals("version")) {
                dependency.setVersion(string);
            } else if (tag2.equals("scope")) {
                dependency.setScope(string);
            }
        }
    }

    public List<Dependency> getDependencies() {
        return dependencies;
    }

    public void setDependencies(List<Dependency> dependencies) {
        this.dependencies = dependencies;
    }

    public Dependency getDependency() {
        return dependency;
    }

    public void setDependency(Dependency dependency) {
        this.dependency = dependency;
    }
}
