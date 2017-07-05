package alexlahdekorpi.bclepakko.SpaceObject.Enemies;

import android.view.WindowManager;
import android.widget.ImageView;

import alexlahdekorpi.bclepakko.ScoreBoard;

/**
 * Created by alex.lahdekorpi on 5.7.2017.
 */

public class Square extends Enemy {

    public Square(ImageView imageView, WindowManager wm, ScoreBoard scoreBoard) {
        super(imageView, wm, scoreBoard);
        setDefaultHitPoints(15);
        setSpeed(15);
        setPoints(2000);
        setStartY(-30000);
    }
}
