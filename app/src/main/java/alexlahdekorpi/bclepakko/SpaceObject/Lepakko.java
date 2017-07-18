package alexlahdekorpi.bclepakko.SpaceObject;

import android.view.MotionEvent;
import android.widget.ImageView;

import alexlahdekorpi.bclepakko.Gui.ScoreBoard;
import alexlahdekorpi.bclepakko.R;
import alexlahdekorpi.bclepakko.SpaceObject.SpaceObjectInterfaces.Renewable;
import alexlahdekorpi.bclepakko.StartActivity;

/**
 * Created by alex.lahdekorpi on 28.6.2017.
 */

public class Lepakko extends SpaceObject {

    public Lepakko(StartActivity activity, ScoreBoard scoreBoard) {
        super(activity, scoreBoard);
        setImageView((ImageView) this.activity.findViewById(R.id.lepakkoImg));
    }

    public void checkCollisionWithRenewable(Renewable renewable) {
        if (this.getHitChecker().isHit(renewable)) {
            renewable.lepakkoCollideAction();
        }
    }

    public void moveXToTouch(MotionEvent me) {
        moveXTo(me.getX() - 60);
    }

    public void moveToTouch(MotionEvent me) {
        moveXToTouch(me);
        moveYToTouch(me);
    }

    public void moveYToTouch(MotionEvent me) {
        moveYTo((int) me.getY() - 300);
    }

    public void moveCloserToTouch(MotionEvent me) {
        int x = (int) me.getX() - 60;
        int y = (int) me.getY() - 300;

        //touch above lepakko
        if (y + 50 < getY()) {
            slideUp(y);
            //touch under lepakko
        } else if (y - 50 > getY()) {
            slideDown(y);
        } else {
            moveYToTouch(me);
        }
        //touch right of lepakko
        if (x - 50  > getX()) {
            slideRight(x);
            //touch left of lepakko
        } else if (x + 50 < getX()) {
            slideLeft(x);
        } else {
            moveXToTouch(me);
        }

    }

    public void slideLeft(int x) {
        while(getX()>x){
            moveX(-0.1);
        }
    }
    public void slideRight(int x){
        while(getX() < x){
            moveX(0.1);
        }
    }
    public void slideUp(int y){
        while (getY() > y){
            moveY(-0.1);
        }
    }
    public void slideDown(int y ){
        while(getY() < y){
            moveY(0.1);
        }
    }
}
