package alexlahdekorpi.bclepakko.SpaceObject.Enemies;

import android.app.Activity;
import android.widget.ImageView;

import alexlahdekorpi.bclepakko.Gui.ScoreBoard;
import alexlahdekorpi.bclepakko.R;

/**
 * Created by alex.lahdekorpi on 5.7.2017.
 */

public class Square extends Enemy {

    public Square(Activity activity, ScoreBoard scoreBoard) {
        super(activity, scoreBoard);
        setImageView((ImageView) this.activity.findViewById(R.id.square));
        setDefaultHitPoints(15);
        setSpeed(15);
        setPoints(2000);
        setStartY(-30000);
    }
}
