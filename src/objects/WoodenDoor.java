package objects;

public class WoodenDoor extends Door {

    public WoodenDoor(Direction direction) {
        super("wooden_doorNS", "wooden_doorEW", direction, 1000);
    }

    public String[] getResources() {
        return new String[]{"Tree"};
    }

}
