package brick.stargame.pool;

import com.badlogic.gdx.audio.Sound;

import brick.stargame.base.SpritesPool;
import brick.stargame.math.Rect;
import brick.stargame.sprite.EnemyShip;
import brick.stargame.sprite.MainShip;

public class EnemyPool extends SpritesPool<EnemyShip> {

    private final Rect worldBounds;
    private final BulletPool bulletPool;
    private final Sound bulletSound;

    public EnemyPool(Rect worldBounds, BulletPool bulletPool, Sound bulletSound) {
        this.worldBounds = worldBounds;
        this.bulletPool = bulletPool;
        this.bulletSound = bulletSound;
    }

    @Override
    public void updateActiveSprites(float delta) {
        super.updateActiveSprites(delta);
    }

    @Override
    protected EnemyShip newObject() {
        return new EnemyShip(worldBounds, bulletPool, bulletSound);
    }
}
