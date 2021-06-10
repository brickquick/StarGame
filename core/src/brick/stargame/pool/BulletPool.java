package brick.stargame.pool;

import brick.stargame.base.SpritesPool;
import brick.stargame.sprite.Bullet;

public class BulletPool extends SpritesPool<Bullet> {

    @Override
    protected Bullet newObject() {
        return new Bullet();
    }
}
