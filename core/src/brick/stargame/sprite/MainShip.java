package brick.stargame.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import brick.stargame.base.Sprite;
import brick.stargame.math.Rect;

public class MainShip extends Sprite {

    private static final float VELOCITY = 0.005f;

    private Rect worldBounds;

    private final Vector2 v;
    private Vector2 touch;

    private int keycode;
    private boolean controlKeyDown = false;

    public MainShip(TextureAtlas atlas) {
        super(new TextureRegion(atlas.findRegion("main_ship"), 0, 0, 195, 287));
        v = new Vector2();
        touch = new Vector2();
    }

    @Override
    public void update(float delta) {
        super.update(delta);

        if (pos.x - touch.x > 0) {
//            System.out.println("L");
            if (pos.x - touch.x <= VELOCITY) {
                pos.x = touch.x;
            } else {
                pos.add(v);
            }
        }
        if (pos.x - touch.x < 0) {
//            System.out.println("R");
            if (pos.x - touch.x >= VELOCITY) {
                pos.x = touch.x;
            } else {
                pos.add(v);
            }
        }

        if (controlKeyDown) {
            switch (keycode) {
                case (21):
                case (29):
                    pos.x -= VELOCITY;
                    break;
                case (22):
                case (32):
                    pos.x += VELOCITY;
                    break;
                default:
                    break;
            }
        }

        if (pos.x + getWidth() > worldBounds.getRight()) {
            pos.x = worldBounds.getRight() - getWidth();
        }

        if (pos.x - getWidth() < worldBounds.getLeft()) {
            pos.x = worldBounds.getLeft() + getWidth();
        }
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        this.worldBounds = worldBounds;
        setHeightProportion(0.2f);
        setBottom(worldBounds.getBottom() + 0.01f);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        this.touch = touch;
        v.x = touch.x - pos.x;
        v.setLength(VELOCITY);
        return false;
    }

    public boolean keyDown(int keycode) {
        this.keycode = keycode;
        v.setZero();
        touch = pos;
//        System.out.println("keycode " + this.keycode);

        if (keycode == 21 || keycode == 29 || keycode == 22 || keycode == 32) {
            controlKeyDown = true;
        }
        return true;
    }

    public boolean keyUp(int keycode) {
        if (keycode == 21 || keycode == 29 || keycode == 22 || keycode == 32) {
            controlKeyDown = false;
        }
        return true;
    }
}
