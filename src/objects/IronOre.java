package objects;

public class IronOre extends WorldObject{

	public IronOre() {
		super("iron_ore", false, true);
	}

	public String[] getResources() {
		return new String[]{"Iron"};
	}


}
