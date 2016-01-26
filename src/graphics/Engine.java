package graphics;

import assets.Images;
import assets.Sounds;
import graphics.states.GameState;
import graphics.states.SplashState;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import java.io.File;

public class Engine extends StateBasedGame {

    public static GameState gameState = new GameState();

    public Engine(String title) {
        super(title);
    }

    public static void main(String[] args) throws SlickException {
        File f = new File("natives");
        if (f.exists())
            System.setProperty("org.lwjgl.librarypath", f.getAbsolutePath());
        AppGameContainer gc = new AppGameContainer(new Engine("Dwarf Castle"));
        gc.setDisplayMode(Window.getWidth(), Window.getHeight(), Window.FULLSCREEN);
        gc.start();
    }

    public void initStatesList(GameContainer gc) throws SlickException {
        gc.setMaximumLogicUpdateInterval(15);
        gc.setAlwaysRender(true);

        addState(new SplashState(Images.getImage("splash"), Sounds.getSound("startup"), 35, true));
        addState(gameState);
    }
}