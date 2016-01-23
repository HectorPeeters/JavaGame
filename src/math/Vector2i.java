package math;

public class Vector2i {

	public int x, y;

	public Vector2i(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Vector2i(int i) {
		this.x = i;
		this.y = i;
	}

	public Vector2i add(Vector2i other) {
		return new Vector2i(x + other.x, y + other.y);
	}

	public Vector2i sub(Vector2i other) {
		return new Vector2i(x - other.x, y - other.y);
	}

	public Vector2i div(Vector2i other) {
		return new Vector2i(x / other.x, y / other.y);
	}

	public Vector2i mul(Vector2i other) {
		return new Vector2i(x * other.x, y * other.y);
	}

	public Vector2i add(int other) {
		return new Vector2i(x + other, y + other);
	}

	public Vector2i sub(int other) {
		return new Vector2i(x - other, y - other);
	}

	public Vector2i div(int other) {
		return new Vector2i(x / other, y / other);
	}

	public Vector2i mul(int other) {
		return new Vector2i(x * other, y * other);
	}

	public float distance(Vector2i other) {
		return (float) Math.sqrt(Math.pow(x - other.x, 2) + Math.pow(y - other.y, 2));
	}

	public boolean equals(Object object) {
		if (!(object instanceof Vector2i))
			return false;
		Vector2i vec = (Vector2i) object;
		return vec.x == x && vec.y == y;
	}
	
	public String toString() {
		return "vector2i: " + x + ", " + y;
	}

}
