package objects;

import assets.Images;
import org.newdawn.slick.Image;

public abstract class WorldObject {

    public Image image;
    public boolean isWalkable;
    public boolean isSolid;

    public WorldObject(String name, boolean isWalkable, boolean isSolid) {
        image = Images.getImage(name);
        this.isWalkable = isWalkable;
        this.isSolid = isSolid;
    }

    public String toString() {
        return getClass().getSimpleName();
    }

    public abstract String[] getResources();

}
