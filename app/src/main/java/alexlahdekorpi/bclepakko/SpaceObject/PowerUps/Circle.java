package alexlahdekorpi.bclepakko.SpaceObject.PowerUps;

import android.app.Activity;
import android.widget.ImageView;

import alexlahdekorpi.bclepakko.Gun;
import alexlahdekorpi.bclepakko.R;
import alexlahdekorpi.bclepakko.ScoreBoard;
import alexlahdekorpi.bclepakko.SpaceObject.Enemies.Enemy;

/**
 * Created by alex.lahdekorpi on 27.6.2017.
 */

public class Circle extends Enemy {

    public Circle(Activity activity, ScoreBoard scoreBoard) {
        super(activity, scoreBoard);
        setImageView((ImageView) this.activity.findViewById(R.id.circle));
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

