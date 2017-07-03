package alexlahdekorpi.bclepakko.SpaceObject;

import android.view.WindowManager;
import android.widget.ImageView;

import alexlahdekorpi.bclepakko.MustKill;
import alexlahdekorpi.bclepakko.ScoreBoard;
import alexlahdekorpi.bclepakko.SpaceObject.SpaceObjectInterfaces.LepakkoCollideable;
import alexlahdekorpi.bclepakko.SpaceObject.SpaceObjectInterfaces.Renewable;

/**
 * Created by alex.lahdekorpi on 27.6.2017.
 */

public class Triangle extends SpaceObject implements Renewable, LepakkoCollideable, MustKill {

    public int defaultHitPoints;

    public Triangle(ImageView imageView, WindowManager wm, ScoreBoard scoreBoard) {
        super(imageView, wm, scoreBoard);
        setSpeed(15);
        setDefaultHitPoints(3);
    }
    public void drop(){
        moveY(getSpeed());
        if(getY() > getScreenHeight()){
            outOfBoundsAction();
        }
    }

    @Override
    public void renew(){
        moveYTo(-50);
        moveXTo((int) Math.floor(Math.random() * (this.screenWidth - getImageView().getWidth())));
        setHitPoints(getDefaultHitPoints());

    }
    public int getDefaultHitPoints() {
        return defaultHitPoints;
    }

    @Override
    public void setDefaultHitPoints(int defaultHitPoints) {
        this.defaultHitPoints = defaultHitPoints;
    }


    @Override
    public void lepakkoCollideAction() {
            moveYTo(-100);
            getScoreBoard().nullScore();

    }
    @Override
    public void destroyAction(){
        renew();
        getScoreBoard().addScore(100);
    }

    @Override
    public void outOfBoundsAction() {
        getScoreBoard().nullScore();
        renew();
    }
}
