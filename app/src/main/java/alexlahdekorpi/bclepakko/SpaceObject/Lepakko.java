package alexlahdekorpi.bclepakko.SpaceObject;

import android.view.WindowManager;
import android.widget.ImageView;

import alexlahdekorpi.bclepakko.SpaceObject.SpaceObjectInterfaces.LepakkoCollideable;

/**
 * Created by alex.lahdekorpi on 28.6.2017.
 */

public class Lepakko extends SpaceObject {
    public Lepakko(ImageView imageView, WindowManager wm) {
        super(imageView, wm);
    }
    public void checkCollisionWithLepakkoCollideable(LepakkoCollideable colo){
        if(this.getHitChecker().isHit(colo)) {
            colo.lepakkoCollideAction(getScoreBoard());
        }
    }




}
