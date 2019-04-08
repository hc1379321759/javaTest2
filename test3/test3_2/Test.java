package test3.test3_2;

import org.json.JSONObject;
import org.json.XML;

import java.io.*;


/**
 * 将.xml文件转换成.json文件
 */
public class Test {

    public static void main(String[] args) {
        String xml = fromXML("D:\\IdeaProjects\\javaTest2\\src\\test3\\pom.xml");
        String json = xmlTojson(xml);
        jsonToFile(json,"D:\\IdeaProjects\\javaTest2\\src\\test3\\pom.json");
    }

    /**
     * 读取xml文件
     * @param filePath
     * @return
     */
    static String fromXML(String filePath){
        File src = new File(filePath);
        String xml ="";
        String line =null;
        try {
            FileReader fr =new FileReader(src);
            BufferedReader reader =new BufferedReader(fr);
            while ((line=reader.readLine())!=null){
                xml += line;
            }
            reader.close();
            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return xml;
    }

    /**
     * 将xml字符串转换成json数据格式
     * @param xml
     * @return
     */
    static String xmlTojson(String xml){
        JSONObject xmlJSONObj = XML.toJSONObject(xml);
        return xmlJSONObj.toString();
    }

    static void jsonToFile(String json,String filePath){
        File dest = new File(filePath);
        try {
            FileWriter fw = new FileWriter(dest);
            BufferedWriter writer = new BufferedWriter(fw);
            writer.write(json,0,json.length());
            writer.flush();
            writer.close();
            fw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
