package brick.stargame.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

import brick.stargame.base.BaseScreen;

public class MenuScreen extends BaseScreen {

    private static final float VELOCITY = 5.0f;

    private Texture img;
    private Texture img2;
    private Texture bg;
    private Vector2 pos;
    private Vector2 v;
    private Vector2 touch;
    private Vector2 tmp;

    @Override
    public void show() {
        super.show();
        img = new Texture("badlogic.jpg");
        img2 = new Texture("badlogic.jpg");
        bg = new Texture("Andromeda-Galaxy.jpg");
        pos = new Vector2((float) img.getWidth() / 4, (float) img.getHeight() / 4);
        touch = new Vector2(pos.x, pos.y);
        v = new Vector2();
        tmp = new Vector2();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        ScreenUtils.clear(0.33f, 0.45f, 0.68f, 1);
        batch.begin();
        batch.draw(bg, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.draw(img, pos.x - (float) img.getWidth() / 2 / 2, pos.y - (float) img.getHeight() / 2 / 2,
                (float) img.getWidth() / 2, (float) img.getHeight() / 2);
        tmp.set(touch);
        if (tmp.sub(pos).len() <= v.len()) {
            pos.set(touch);
            v.setZero();
        } else {
            pos.add(v);
            batch.draw(img2, touch.x - (float) img2.getWidth() / 50 / 2, touch.y - (float) img2.getHeight() / 50 / 2,
                    (float) img2.getWidth() / 50, (float) img2.getHeight() / 50);
        }
        batch.end();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        touch.set(screenX, Gdx.graphics.getHeight() - screenY);
        v.set(touch.cpy().sub(pos)).setLength(VELOCITY);
        return false;
    }

    @Override
    public void dispose() {
        super.dispose();
        img.dispose();
        bg.dispose();
        batch.dispose();
    }

}
