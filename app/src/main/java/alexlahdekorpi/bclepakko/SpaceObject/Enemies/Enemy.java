package alexlahdekorpi.bclepakko.SpaceObject.Enemies;

import android.app.Activity;
import android.view.View;

import alexlahdekorpi.bclepakko.Gun;
import alexlahdekorpi.bclepakko.ScoreBoard;
import alexlahdekorpi.bclepakko.SpaceObject.SpaceObject;
import alexlahdekorpi.bclepakko.SpaceObject.SpaceObjectInterfaces.MustKill;
import alexlahdekorpi.bclepakko.SpaceObject.SpaceObjectInterfaces.Renewable;

/**
 * Created by alex.lahdekorpi on 5.7.2017.
 */

public class Enemy extends SpaceObject implements Renewable, MustKill {
    public int startY;
    public int defaultHitPoints;
    public int points;

    public Enemy(Activity activity, ScoreBoard scoreBoard) {
        super(activity, scoreBoard);
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
        moveYTo(getStartY());
        moveXTo((int) Math.floor(Math.random() * (this.screenWidth - getImageView().getWidth())));
        setHitPoints(getDefaultHitPoints());
    }

    @Override
    public void lepakkoCollideAction() {
        renew();
        getScoreBoard().nullScore();
    }

    public int getStartY() {
        return this.startY;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }
    @Override
    public int getDefaultHitPoints() {
        return this.defaultHitPoints;
    }

    @Override
    public void setDefaultHitPoints(int defaultHitPoints) {
        this.defaultHitPoints = defaultHitPoints;
    }

    public int getPoints() {
        return this.points;
    }

    public void setPoints(int points) {
        this.points = points;
    }


    @Override
    public void destroyAction(Gun gun){
        renew();
        getScoreBoard().addScore(getPoints());
    }
    @Override
    public void outOfBoundsAction() {
        getScoreBoard().nullScore();
        renew();
    }

}
