package objects.ores;

import objects.templates.WorldObject;

public class DiamondOre extends WorldObject {

    public DiamondOre() {
        super("diamond_ore", false, true, 3000);
    }

    @Override
    public String[] getResources() {
        return new String[]{"Diamond"};
    }

}
