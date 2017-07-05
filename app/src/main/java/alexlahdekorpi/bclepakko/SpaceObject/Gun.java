package alexlahdekorpi.bclepakko.SpaceObject;

import android.view.View;

import alexlahdekorpi.bclepakko.SpaceObject.SpaceObjectInterfaces.Renewable;

/**
 * Created by alex.lahdekorpi on 5.7.2017.
 */

public class Gun {
    public Bullet[] bulletArray;
    public int bulletLevel;
    public SpaceObject holder;

    public Gun(Bullet[] bulletArray, SpaceObject holder){
        this.bulletArray = bulletArray;
        this.holder = holder;
        bulletLevel= 0;

    }
    public void returnToHolder(){
        getBullet().moveYTo(this.holder.getY());
        getBullet().moveXTo(this.holder.getX());
    }
    public void checkBulletOutOfBounds(){
        if(getBullet().getY()<0){
            returnToHolder();
        }
    }
    public void shoot() {
        getBullet().moveY(getBullet().getSpeed());
        checkBulletOutOfBounds();
    }
    public void checkShotHit(Renewable rew){
        if (getBullet().getHitChecker().isHit(rew)) {
            rew.dropHitPoints(getBullet().getDamage());
            if (rew.isDestroyed()) {
                rew.destroyAction(this);
            }
            returnToHolder();
        }
    }

    public void reduceGunLevel(){

    }
    public void upGunLevel(){
        if(this.bulletLevel<1) {
            getBullet().getImageView().setVisibility(View.GONE);
            this.bulletLevel++;
            getBullet().getImageView().setVisibility(View.VISIBLE);
        }

    }
    public void nullGunLevel(){

    }
    public Bullet getBullet(){
        return this.bulletArray[this.bulletLevel];
    }
}
