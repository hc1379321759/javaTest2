package test3.test3_3;

import com.alibaba.fastjson.JSON;
import com.sun.deploy.util.StringUtils;
import test3.Project;

import java.io.*;

/**
 * json转对象
 */
public class Test {
    public static void main(String[] args) {
        Project project = new Project();
        String json = fromJson("D:\\IdeaProjects\\javaTest2\\src\\test3\\pom.json");
        //json转对象
        project = JSON.parseObject(StringUtils.trimWhitespace(json),Project.class);
        System.out.println(project);
    }

    /**
     * 读取json文件
     * @param filePath
     * @return
     */
    static String fromJson(String filePath){
        File src = new File(filePath);
        String json ="";
        String line =null;
        try {
            FileReader fr =new FileReader(src);
            BufferedReader reader =new BufferedReader(fr);
            while ((line=reader.readLine())!=null){
                json += line;
            }
            reader.close();
            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }

}
