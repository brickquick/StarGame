package brick.stargame.sprite;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import brick.stargame.base.ScaledButton;
import brick.stargame.math.Rect;
import brick.stargame.screen.GameScreen;

public class NewGameButton extends ScaledButton {

    private final Game game;

    private static final float HEIGHT = 0.08f;

    public NewGameButton(TextureAtlas atlas, Game game) {
        super(atlas.findRegion("button_new_game"));
        this.game = game;
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        float height = getHeight();
        height += 0.0001f;
        if (height >= HEIGHT + 0.012f) {
            height = HEIGHT;
        }
        setHeightProportion(height);
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        setHeightProportion(HEIGHT);
        setTop(worldBounds.pos.y);
    }

    @Override
    protected void action() {
        this.game.setScreen(new GameScreen(this.game));
    }
}
