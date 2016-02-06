package resources;

import java.util.HashMap;
import java.util.Map;

public class ResourceManager {

	public static Map<String, Integer> resources = new HashMap<>();

	private static boolean windowCreated;

	public static void addResource(String resource, int amount) {
		if (!windowCreated) {
			ResourceWindow.createWindow();
			windowCreated = true;
		}
		if (resources.containsKey(resource))
			resources.put(resource, resources.get(resource) + amount);
		else
			resources.put(resource, amount);
		ResourceWindow.updateList(resources);
	}

	public static int getAmount(String resource) {
		if (!resources.containsKey(resource))
			return 0;
		return resources.get(resource);
	}

	public static boolean contains(String resource) {
		return resources.containsKey(resource) && resources.get(resource) > 0;
	}
}
