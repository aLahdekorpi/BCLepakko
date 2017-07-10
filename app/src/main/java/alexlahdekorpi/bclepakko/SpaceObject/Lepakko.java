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

    public void checkCollisionWithLepakkoCollideable(LepakkoCollideable colo) {
        if (this.getHitChecker().isHit(colo)) {
            colo.lepakkoCollideAction();
        }
    }

    public void moveXToTouch(MotionEvent me) {
        moveXTo((int) me.getX() - 60);
    }

    public void moveYToTouch(MotionEvent me) {
        moveYTo((int) me.getY() - 300);
    }

    public void moveCloserToTouch(MotionEvent me) {
        int x = (int) me.getX() - 60;
        int y = (int) me.getY() - 300;

        //touch above lepakko
        if (y + 50 < getY()) {
            moveY(-50);
            //touch under lepakko
        } else if (y - 50 > getY()) {
            moveY(50);
        } else {
            moveYToTouch(me);
        }
        //touch right of lepakko
        if (x - 50  > getX()) {
            moveX(50);
            //touch left of lepakko
        } else if (x + 50 < getX()) {
            SlideLeft(x);
        } else {
            moveXToTouch(me);
        }


        }
        public void SlideLeft(int x) {
            while(getX()>x){
                moveX(1);
            }
        }
    }

