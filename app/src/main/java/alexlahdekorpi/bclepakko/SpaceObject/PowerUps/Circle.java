package alexlahdekorpi.bclepakko.SpaceObject.PowerUps;

import android.view.WindowManager;
import android.widget.ImageView;

import alexlahdekorpi.bclepakko.Gun;
import alexlahdekorpi.bclepakko.ScoreBoard;
import alexlahdekorpi.bclepakko.SpaceObject.Enemies.Enemy;
import alexlahdekorpi.bclepakko.SpaceObject.SpaceObjectInterfaces.Renewable;

/**
 * Created by alex.lahdekorpi on 27.6.2017.
 */

public class Circle extends Enemy implements Renewable {

    public Circle(ImageView imageView, WindowManager wm, ScoreBoard scoreBoard) {
        super(imageView, wm, scoreBoard);
        setSpeed(20);
        setDefaultHitPoints(1);
        setPoints(100);
        setStartY(-20000);
    }
    @Override
    public void lepakkoCollideAction() {
            renew();
    }
    @Override
    public void destroyAction(Gun gun){
        renew();
        gun.upGunLevel();
        getScoreBoard().addScore(getPoints());
    }

}

