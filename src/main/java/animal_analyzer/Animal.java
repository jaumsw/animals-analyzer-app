package animal_analyzer;

import java.util.ArrayList;
import java.util.List;

public class Animal {
    private String name;
    private List<Animal> children;

    public Animal(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }


    public List<Animal> getChildren() {
        return children;
    }

    public void addChild(Animal child) {
        children.add(child);
    }
}
