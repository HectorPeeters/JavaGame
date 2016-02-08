package objects.templates;

import assets.Images;
import org.newdawn.slick.Image;

public abstract class WorldObject {

    public Image image;
    public boolean isWalkable;
    public boolean isSolid;
    public int destroyTime;

    public WorldObject(Image image, boolean isWalkable, boolean isSolid, int destroyTime) {
        this.image = image;
        this.isWalkable = isWalkable;
        this.isSolid = isSolid;
        this.destroyTime = destroyTime;
    }

    public WorldObject(String name, boolean isWalkable, boolean isSolid, int destroyTime) {
        image = Images.getImage(name);
        this.isWalkable = isWalkable;
        this.isSolid = isSolid;
        this.destroyTime = destroyTime;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

    public abstract String[] getResources();

}
