package alexlahdekorpi.bclepakko.SpaceObject;

import android.view.WindowManager;
import android.widget.ImageView;

import alexlahdekorpi.bclepakko.ScoreBoard;
import alexlahdekorpi.bclepakko.SpaceObject.SpaceObjectInterfaces.LepakkoCollideable;
import alexlahdekorpi.bclepakko.SpaceObject.SpaceObjectInterfaces.Renewable;

/**
 * Created by alex.lahdekorpi on 27.6.2017.
 */

public class Circle extends SpaceObject implements Renewable, LepakkoCollideable {

    public int defaultHitPoints;

    public Circle(ImageView imageView, WindowManager wm, ScoreBoard scoreBoard) {
        super(imageView, wm, scoreBoard);
        setSpeed(20);
        setDefaultHitPoints(1);
    }

    public void drop(){
        moveY(getSpeed());
        if(getY() > getScreenHeight()){
            moveYTo(0);
            moveXTo((int) Math.floor(Math.random() * (getScreenWidth() - getImageView().getWidth() )));
        }
    }

    @Override
    public void renew() {
        moveYTo(-50);
        moveXTo((int) Math.floor(Math.random() * (this.screenWidth - getImageView().getWidth())));
        setHitPoints(getDefaultHitPoints());
    }
    @Override
    public int getDefaultHitPoints() {return this.defaultHitPoints;}

    @Override
    public void setDefaultHitPoints(int defaultHitPoints) {this.defaultHitPoints = defaultHitPoints;}


    @Override
    public void lepakkoCollideAction(ScoreBoard scoreBoard) {
            moveYTo(-100);
            scoreBoard.nullScore();

    }

    @Override
    public void destroyAction(ScoreBoard scoreBoard){
        renew();
        scoreBoard.addScore(50);
    }


}

