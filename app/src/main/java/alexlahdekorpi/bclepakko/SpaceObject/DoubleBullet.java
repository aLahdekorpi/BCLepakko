package alexlahdekorpi.bclepakko.SpaceObject;

import android.view.WindowManager;
import android.widget.ImageView;

import alexlahdekorpi.bclepakko.ScoreBoard;
import alexlahdekorpi.bclepakko.SpaceObject.SpaceObjectInterfaces.Gun;
import alexlahdekorpi.bclepakko.SpaceObject.SpaceObjectInterfaces.Renewable;

/**
 * Created by alex.lahdekorpi on 3.7.2017.
 */

public class DoubleBullet extends SingleBullet implements Renewable, Gun {
        public ImageView secondIW;

    public DoubleBullet(ImageView iw, WindowManager wm, ScoreBoard sb, Lepakko lep){
        super(iw, wm, sb, lep);
        this.secondIW = getImageView();
        getImageView().setX(getLepakko().getX()-50);
        this.secondIW.setX(getLepakko().getX()+50);
    }
    @Override
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
    public int getDefaultHitPoints() {
        return 0;
    }

    @Override
    public void setDefaultHitPoints(int defaultHitPoints) {

    }
}
