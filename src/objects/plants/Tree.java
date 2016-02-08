package objects.plants;

import objects.templates.Plant;

public class Tree extends Plant {

    public Tree() {
        super("tree", true, 300);
    }

    @Override
    public String[] getResources() {
        return new String[]{"Tree"};
    }

}
