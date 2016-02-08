package objects;

import objects.templates.WorldObject;

public class WoodenWall extends WorldObject {

    public WoodenWall() {
        super("woodenWall", false, true, 150);
    }

    @Override
    public String[] getResources() {
        return new String[]{"Tree"};
    }

}
