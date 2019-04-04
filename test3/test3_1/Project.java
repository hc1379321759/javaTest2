package test3.test3_1;

import java.util.ArrayList;
import java.util.List;

public class Project {
    private List<Dependency> dependencies;

    public Project() {
        dependencies = new ArrayList<>();
    }

    public List<Dependency> getDependencies() {
        return dependencies;
    }

    /**
     * 在dependencies列表中增加Dependency对象
     * @param dependency
     */
    public void add(Dependency dependency){
        dependencies.add(dependency);
    }


}
