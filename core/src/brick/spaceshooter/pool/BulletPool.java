package brick.spaceshooter.pool;

import brick.spaceshooter.base.SpritesPool;
import brick.spaceshooter.sprite.Bullet;

public class BulletPool extends SpritesPool<Bullet> {

    @Override
    protected Bullet newObject() {
        return new Bullet();
    }
}
