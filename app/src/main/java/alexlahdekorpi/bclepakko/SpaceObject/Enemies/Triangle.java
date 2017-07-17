package alexlahdekorpi.bclepakko.SpaceObject.Enemies;

import android.app.Activity;
import android.widget.ImageView;

import alexlahdekorpi.bclepakko.Gui.ScoreBoard;
import alexlahdekorpi.bclepakko.R;

/**
 * Created by alex.lahdekorpi on 27.6.2017.
 */

public class Triangle extends Enemy {

    public Triangle(Activity activity, ScoreBoard scoreBoard) {
        super(activity, scoreBoard);
        setImageView((ImageView) this.activity.findViewById(R.id.triangle));
        setSpeed(20);
        setDefaultHitPoints(3);
        setPoints(100);
        setStartY(-100);
    }

}
