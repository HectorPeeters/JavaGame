package objects.plants;

import objects.templates.Plant;

public class Bush extends Plant {

    public Bush() {
        super("bush", false, 100);
    }

    public String[] getResources() {
        return new String[]{"Bush"};
    }

}
