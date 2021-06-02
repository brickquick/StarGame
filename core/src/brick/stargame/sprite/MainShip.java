package brick.stargame.sprite;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import brick.stargame.base.Sprite;
import brick.stargame.math.Rect;

public class MainShip extends Sprite {

    private static final float VELOCITY = 0.005f;

    private final Vector2 v;
    private Vector2 touch;
    private Rect worldBounds;

    public MainShip(TextureAtlas atlas) {
        super(new TextureRegion(atlas.findRegion("main_ship"), 0, 0, 195, 287));
        v = new Vector2();
    }

    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        this.worldBounds = worldBounds;
        setHeightProportion(0.2f);
        setBottom(worldBounds.getBottom() + 0.01f);
    }

}
