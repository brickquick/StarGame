package brick.stargame;

import com.badlogic.gdx.Game;

import brick.stargame.screen.MenuScreen;

public class StarGame extends Game {

	@Override
	public void create() {
		setScreen(new MenuScreen());
	}

}
