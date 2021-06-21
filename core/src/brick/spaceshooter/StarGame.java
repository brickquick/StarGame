package brick.spaceshooter;

import com.badlogic.gdx.Game;

import brick.spaceshooter.screen.MenuScreen;

public class StarGame extends Game {

    @Override
    public void create() {
    	setScreen(new MenuScreen(this));
    }

}
