package world;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WorldGenerator {

	private static Random random = new Random();

	private static final int SEED = random.nextInt(1000000000);
	private static List<TileType> tilesToUse = new ArrayList<>();

	public static float AMPLITUDE;

	public static void addTileType(TileType tileType) {
		tilesToUse.add(tileType);
	}

	public static TileType getTile(int x, int y) {
		float smooth = generateHeight(x, y);
		return tilesToUse.get((int) smooth);
	}

	private static float generateHeight(int x, int y) {
		AMPLITUDE = tilesToUse.size();
		return getInterpolatedNoise(x, y) * AMPLITUDE;
	}

	private static float getInterpolatedNoise(float x, float y) {
		int intX = (int) x;
		int intY = (int) y;
		float fracX = x - intX;
		float fracY = y - intY;

		float v1 = getSmoothNoise(intX, intY);
		float v2 = getSmoothNoise(intX + 1, intY);
		float v3 = getSmoothNoise(intX, intY + 1);
		float v4 = getSmoothNoise(intX + 1, intY + 1);
		float i1 = interpolate(v1, v2, fracX);
		float i2 = interpolate(v3, v4, fracX);
		return interpolate(i1, i2, fracY);
	}

	private static float interpolate(float a, float b, float blend) {
		double theta = blend * Math.PI;
		float f = (float) (1f - Math.cos(theta)) * 0.5f;
		return a * (1f - f) + b * f;
	}

	private static float getSmoothNoise(int x, int y) {
		float corners = (getNoise(x - 1, y - 1) + getNoise(x + 1, y - 1) + getNoise(x - 1, y + 1) + getNoise(x + 1, y + 1)) / 16f;
		float sides = (getNoise(x - 1, y) + getNoise(x + 1, y) + getNoise(x, y - 1) + getNoise(x, y + 1)) / 8f;
		float center = getNoise(x, y) / 4f;
		return corners + sides + center;
	}

	private static float getNoise(int x, int y) {
		random.setSeed(x * 49632 + y * 325176 + SEED);
		return random.nextFloat();
	}

}
