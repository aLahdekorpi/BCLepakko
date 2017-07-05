package alexlahdekorpi.bclepakko.SpaceObject;

import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import alexlahdekorpi.bclepakko.ScoreBoard;
import alexlahdekorpi.bclepakko.SpaceObject.SpaceObjectInterfaces.LepakkoCollideable;
import alexlahdekorpi.bclepakko.SpaceObject.SpaceObjectInterfaces.MustKill;
import alexlahdekorpi.bclepakko.SpaceObject.SpaceObjectInterfaces.Renewable;

/**
 * Created by alex.lahdekorpi on 27.6.2017.
 */

public class Circle extends SpaceObject implements Renewable, LepakkoCollideable, MustKill {

    public int defaultHitPoints;

    public Circle(ImageView imageView, WindowManager wm, ScoreBoard scoreBoard) {
        super(imageView, wm, scoreBoard);
        setSpeed(20);
        setDefaultHitPoints(1);
    }

    public void drop(){
        moveY(getSpeed());
        if(getY() > getScreenHeight()){
            outOfBoundsAction();
        }
    }

    @Override
    public void renew() {
        getImageView().setVisibility(View.VISIBLE);
        moveYTo(-20000);
        moveXTo((int) Math.floor(Math.random() * (this.screenWidth - getImageView().getWidth())));
        setHitPoints(getDefaultHitPoints());
    }
    @Override
    public int getDefaultHitPoints() {return this.defaultHitPoints;}

    @Override
    public void setDefaultHitPoints(int defaultHitPoints) {this.defaultHitPoints = defaultHitPoints;}


    @Override
    public void lepakkoCollideAction() {
            renew();
            getScoreBoard().nullScore();

    }

    @Override
    public void destroyAction(Gun gun){
        renew();
        gun.upGunLevel();
        getScoreBoard().addScore(50);
    }




    @Override
    public void outOfBoundsAction() {
        getScoreBoard().nullScore();
        renew();
    }
}

