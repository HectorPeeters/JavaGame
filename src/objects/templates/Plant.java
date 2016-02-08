package objects.templates;

public abstract class Plant extends WorldObject {

    public Plant(String name, boolean isSolid, int destoryTime) {
        super(name, false, isSolid, destoryTime);
    }

}
