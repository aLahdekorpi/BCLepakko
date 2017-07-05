package alexlahdekorpi.bclepakko.SpaceObject;

import android.view.WindowManager;
import android.widget.ImageView;

import alexlahdekorpi.bclepakko.ScoreBoard;
import alexlahdekorpi.bclepakko.SpaceObject.SpaceObjectInterfaces.Renewable;

/**
 * Created by alex.lahdekorpi on 5.7.2017.
 */

public class BallBullet extends Bullet implements Renewable {

    public BallBullet(ImageView imageView, WindowManager wm, ScoreBoard scoreBoard, Lepakko lepakko){
        super(imageView, wm, scoreBoard, lepakko);
        setDefaultHitPoints(2);
        setSpeed(-50);
        setDamage(3);
    }
/*    @Override
    public void destroy() {

    }

    @Override
    public void reduceGunLevel() {

    }

    @Override
    public void upGunLevel() {

    }

    @Override
    public void nullGunLevel() {

    }

    @Override
    public Bullet giveNewGun() {
        return null;
    }*/

    @Override
    public int getDefaultHitPoints() {
        return this.getDefaultHitPoints();
    }

    @Override
    public void setDefaultHitPoints(int defaultHitPoints) {

    }

    @Override
    public void destroyAction(Gun gun) {

    }
}
