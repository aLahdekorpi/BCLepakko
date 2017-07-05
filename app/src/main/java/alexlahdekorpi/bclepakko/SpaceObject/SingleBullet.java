package alexlahdekorpi.bclepakko.SpaceObject;

import android.view.WindowManager;
import android.widget.ImageView;

import alexlahdekorpi.bclepakko.ScoreBoard;
import alexlahdekorpi.bclepakko.SpaceObject.SpaceObjectInterfaces.Renewable;

/**
 * Created by alex.lahdekorpi on 28.6.2017.
 */

public class SingleBullet extends Bullet implements Renewable {
    public Bullet upBullet;
    private int defaultHitPoints;
    public SingleBullet(ImageView imageView, WindowManager wm, ScoreBoard scoreBoard, Lepakko lepakko) {
        super(imageView, wm, scoreBoard, lepakko);
        this.defaultHitPoints = 1;
        setSpeed(-100);
        setDamage(1);
    }

    @Override
    public int getDefaultHitPoints() {
        return this.defaultHitPoints;
    }

    @Override
    public void setDefaultHitPoints(int defaultHitPoints) {
        this.defaultHitPoints = defaultHitPoints;
    }

    public Lepakko getLepakko() {
        return lepakko;
    }

    @Override
    public void destroyAction(Gun gun) {
    }

 /*   @Override
    public void destroy() {
        this.imageView.setVisibility(View.GONE);
    }

    @Override
    public void reduceGunLevel() {
    }

    @Override
    public void upGunLevel() {
        this.upBullet = new BallBullet(getImageView(), getWindowManager(), getScoreBoard(), getLepakko());
    }

    @Override
    public void nullGunLevel() {

    }

    @Override
    public Bullet giveNewGun() {
        return this.upBullet;

    }*/

}
