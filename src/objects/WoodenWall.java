package objects;

public class WoodenWall extends WorldObject {

    public WoodenWall() {
        super("woodenWall", false, true);
    }

    public String[] getResources() {
        return new String[] {"Tree"};
    }

}
