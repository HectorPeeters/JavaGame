package objects;

public class Tree extends WorldObject {

	public Tree() {
		super("tree", false, true, 300);
	}

	@Override
	public String[] getResources() {
		return new String[] { "Tree" };
	}

}
