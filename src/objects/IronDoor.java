package objects;

public class IronDoor extends Door {

    public IronDoor(Direction direction) {
        super("iron_doorNS", "iron_doorEW", direction, 5000);
    }

    public String[] getResources() {
        return new String[]{"Tree", "Iron"};
    }

}
