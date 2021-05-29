package brick.stargame.screen;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

import brick.stargame.base.BaseScreen;
import brick.stargame.math.Rect;
import brick.stargame.sprite.Background;
import brick.stargame.sprite.Logo;

public class MenuScreen extends BaseScreen {

    private Texture bg;
    private Texture tLogo;

    private Background background;
    private Logo logo;

    @Override
    public void show() {
        super.show();
        bg = new Texture("Andromeda-Galaxy.jpg");
        background = new Background(bg);
        tLogo = new Texture("badlogic.jpg");
        logo = new Logo(tLogo);
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
        logo.resize(worldBounds);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        ScreenUtils.clear(0.33f, 0.45f, 0.68f, 1);
        batch.begin();
        background.draw(batch);
        logo.draw(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
        bg.dispose();
        tLogo.dispose();
        batch.dispose();
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        logo.touchDown(touch, pointer, button);
        return false;
    }
}
