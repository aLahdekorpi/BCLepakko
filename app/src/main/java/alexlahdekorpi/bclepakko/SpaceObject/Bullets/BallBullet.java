package alexlahdekorpi.bclepakko.SpaceObject.Bullets;

import android.widget.ImageView;

import alexlahdekorpi.bclepakko.Gui.ScoreBoard;
import alexlahdekorpi.bclepakko.Logic.Gun;
import alexlahdekorpi.bclepakko.R;
import alexlahdekorpi.bclepakko.SpaceObject.Lepakko;
import alexlahdekorpi.bclepakko.SpaceObject.SpaceObjectInterfaces.Renewable;
import alexlahdekorpi.bclepakko.StartActivity;

/**
 * Created by alex.lahdekorpi on 5.7.2017.
 */

public class BallBullet extends Bullet implements Renewable {

    public BallBullet(StartActivity activity, ScoreBoard scoreBoard, Lepakko lepakko) {
        super(activity, scoreBoard, lepakko);
        setImageView((ImageView) this.activity.findViewById(R.id.ball));
        setDefaultHitPoints(2);
        setSpeed(-50);
        setDamage(3);
    }

    @Override
    public int getDefaultHitPoints() {
        return this.getDefaultHitPoints();
    }

    @Override
    public void setDefaultHitPoints(int defaultHitPoints) {

    }

    @Override
    public void lepakkoCollideAction() {
    }

    @Override
    public void destroyAction(Gun gun) {

    }
}
