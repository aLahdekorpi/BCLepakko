package alexlahdekorpi.bclepakko.SpaceObject;

import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.ImageView;

import alexlahdekorpi.bclepakko.ScoreBoard;
import alexlahdekorpi.bclepakko.SpaceObject.SpaceObjectInterfaces.LepakkoCollideable;

/**
 * Created by alex.lahdekorpi on 28.6.2017.
 */

public class Lepakko extends SpaceObject {
    public Lepakko(ImageView imageView, WindowManager wm, ScoreBoard scoreBoard) {
        super(imageView, wm, scoreBoard);
    }
    public void checkCollisionWithLepakkoCollideable(LepakkoCollideable colo){
        if(this.getHitChecker().isHit(colo)) {
            colo.lepakkoCollideAction();
        }
    }
    public void moveToTouch(MotionEvent me){
        moveYTo((int) me.getY() - 300);
        moveXTo((int) me.getX() - 60);
    }




}
