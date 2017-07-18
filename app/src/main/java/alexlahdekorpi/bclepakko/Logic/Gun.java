package alexlahdekorpi.bclepakko.Logic;

import android.view.View;

import alexlahdekorpi.bclepakko.SpaceObject.Bullets.Bullet;
import alexlahdekorpi.bclepakko.SpaceObject.SpaceObject;
import alexlahdekorpi.bclepakko.SpaceObject.SpaceObjectInterfaces.Renewable;

/**
 * Created by alex.lahdekorpi on 5.7.2017.
 */

public class Gun {
    private Bullet[] bulletArray;
    private int bulletLevel;
    private SpaceObject holder;

    public Gun(Bullet[] bulletArray, SpaceObject holder) {
        this.bulletArray = bulletArray;
        this.holder = holder;
        bulletLevel = 0;

    }

    public void returnToHolder() {
        getBullet().moveYTo(this.holder.getY());
        getBullet().moveXTo(this.holder.getX());
    }

    public void checkBulletOutOfBounds() {
        if (getBullet().getY() < 0) {
            returnToHolder();
        }
    }

    public void shoot() {
        getBullet().moveY(getBullet().getSpeed());
        checkBulletOutOfBounds();
    }

    public void checkShotHit(Renewable rew) {
        if (getBullet().getHitChecker().isHit(rew)) {
            rew.dropHitPoints(getBullet().getDamage());
            if (rew.isDestroyed()) {
                rew.destroyAction(this);
            }
            returnToHolder();
        }
    }

    public void reduceGunLevel() {
        if (this.bulletLevel > 0) {
            getBullet().getImageView().setVisibility(View.GONE);
            this.bulletLevel--;
            getBullet().getImageView().setVisibility(View.VISIBLE);
        }
    }

    public void upGunLevel() {
        if (this.bulletLevel < this.bulletArray.length - 1) {
            getBullet().getImageView().setVisibility(View.GONE);
            this.bulletLevel++;
            getBullet().getImageView().setVisibility(View.VISIBLE);
        }

    }

    public void nullGunLevel() {
        getBullet().getImageView().setVisibility(View.GONE);
        this.bulletLevel = 0;
        getBullet().getImageView().setVisibility(View.VISIBLE);
    }

    public Bullet getBullet() {
        return this.bulletArray[this.bulletLevel];
    }
}

