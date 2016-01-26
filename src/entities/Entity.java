package entities;

import assets.Images;
import math.Vector2i;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.StateBasedGame;
import world.Tile;

public abstract class Entity {
	
	public Vector2i position;
	public Image image;
	
	public Entity(Vector2i position, String imageName) {
		this.position = position;
		this.image = Images.getImage(imageName);
	}
	
	public abstract void update(GameContainer gc, StateBasedGame s, int delta);
	
	public void render(GameContainer gc, StateBasedGame s, Graphics g) {
		image.draw(position.x * Tile.TILE_SIZE, position.y * Tile.TILE_SIZE);
	}

}