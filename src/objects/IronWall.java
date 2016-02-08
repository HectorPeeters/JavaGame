package objects;

import objects.templates.WorldObject;

public class IronWall extends WorldObject {

    public IronWall() {
        super("iron_wall", false, true, 2000);
    }

    @Override
    public String[] getResources() {
        return new String[]{"Iron"};
    }

}
