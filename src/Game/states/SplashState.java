package game.states;

import game.Window;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class SplashState extends BasicGameState {

    private Image splash;
    private Sound sound;
    private int elapsedTime;
    private int delay = 3000;

    public SplashState(Image splash, Sound sound, int delay, boolean playSound) {
        this.splash = splash;
        this.delay = delay;
        this.sound = sound;
        if (playSound)
            sound.play();
    }

    public void init(GameContainer gc, StateBasedGame s) throws SlickException {
    }

    public void render(GameContainer gc, StateBasedGame s, Graphics g) throws SlickException {
        g.drawImage(splash.getScaledCopy(Window.getWidth(), Window.getHeight()), 0, 0);
    }

    public void update(GameContainer gc, StateBasedGame s, int delta) throws SlickException {
        elapsedTime += delta;
        if (elapsedTime >= delay) {
            sound.stop();
            s.enterState(States.GAME);
        }
    }

    public int getID() {
        return States.SPLASH;
    }

}
