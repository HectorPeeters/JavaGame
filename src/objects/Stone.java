package objects;

import objects.templates.WorldObject;

public class Stone extends WorldObject {

    public Stone() {
        super("Stone", false, true, 150);
    }

    @Override
    public String[] getResources() {
        return new String[]{"Stone"};
    }

}
