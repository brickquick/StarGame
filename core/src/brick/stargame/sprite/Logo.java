package brick.stargame.sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import brick.stargame.base.Sprite;
import brick.stargame.math.Rect;

public class Logo extends Sprite {
    private static final float VELOCITY = 0.005f;

    private Vector2 v;
    private Vector2 tmp;
    private Vector2 touch;

    public Logo(Texture texture) {
        super(new TextureRegion(texture));
        v = new Vector2();
        tmp = new Vector2();
        touch = new Vector2();
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        setHeightProportion(0.2f);
        this.pos.set(worldBounds.pos);
    }

    @Override
    public void update(float delta) {
        super.update(delta);
    }

    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
        tmp.set(touch);
        if (tmp.sub(pos).len() <= v.len()) {
            pos.set(touch);
            v.setZero();
        } else {
            pos.add(v);
        }
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        this.touch = touch;
        v.set(touch.cpy().sub(pos)).setLength(VELOCITY);
        System.out.println(touch);
        return super.touchDown(touch, pointer, button);
    }
}
