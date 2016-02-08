package game;

import assets.Images;
import assets.Sounds;
import game.states.GameState;
import game.states.SplashState;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import java.io.File;

public class Engine extends StateBasedGame {

    private static GameState gameState = new GameState();

    public Engine() {
        super("Dwarf Castle");
    }

    public static void main(String[] args) throws SlickException {
        File f = new File("natives");
        if (f.exists())
            System.setProperty("org.lwjgl.librarypath", f.getAbsolutePath());
        AppGameContainer gc = new AppGameContainer(new Engine());
        gc.setDisplayMode(Window.getWidth(), Window.getHeight(), Window.FULLSCREEN);
        gc.start();
    }

    @Override
    public void initStatesList(GameContainer gc) throws SlickException {
        gc.setAlwaysRender(true);
        gc.setTargetFrameRate(60);
        gc.setShowFPS(false);

        addState(new SplashState(Images.getImage("splash"), Sounds.getSound("startup"), 0, true));
        addState(gameState);
    }
}