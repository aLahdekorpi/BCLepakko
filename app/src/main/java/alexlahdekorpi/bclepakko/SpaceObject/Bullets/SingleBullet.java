package alexlahdekorpi.bclepakko.SpaceObject.Bullets;

import android.app.Activity;
import android.widget.ImageView;

import alexlahdekorpi.bclepakko.Gui.ScoreBoard;
import alexlahdekorpi.bclepakko.Gun;
import alexlahdekorpi.bclepakko.R;
import alexlahdekorpi.bclepakko.SpaceObject.Lepakko;
import alexlahdekorpi.bclepakko.SpaceObject.SpaceObjectInterfaces.Renewable;

/**
 * Created by alex.lahdekorpi on 28.6.2017.
 */

public class SingleBullet extends Bullet implements Renewable {

    private int defaultHitPoints;

    public SingleBullet(Activity activity, ScoreBoard scoreBoard, Lepakko lepakko) {
        super(activity, scoreBoard, lepakko);
        setImageView((ImageView) this.activity.findViewById(R.id.shot));
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

    @Override
    public void lepakkoCollideAction() {

    }

    @Override
    public void destroyAction(Gun gun) {
    }


}
