package test3;

import test3.Dependency;

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

    @Override
    public String toString() {
        return "Project{" +
                "dependencies=" + dependencies +
                '}';
    }
}
