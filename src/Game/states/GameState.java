package game.states;

import game.Game;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GameState extends BasicGameState {

    private Game game = new Game();

    public void init(GameContainer gc, StateBasedGame s) throws SlickException {
        game.init(gc, s);
    }

    public void render(GameContainer gc, StateBasedGame s, Graphics g) throws SlickException {
        game.render(gc, s, g);
    }

    public void update(GameContainer gc, StateBasedGame s, int delta) throws SlickException {
        game.update(gc, s, delta);
    }

    public int getID() {
        return States.GAME;
    }

}
