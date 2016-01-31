package objects;

public class Stone extends WorldObject {

    public Stone() {
        super("Stone", false, true);
    }

    public String[] getResources() {
        return new String[] {"Stone"};
    }

}
