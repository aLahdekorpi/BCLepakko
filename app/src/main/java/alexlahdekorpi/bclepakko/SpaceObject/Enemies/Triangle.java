package alexlahdekorpi.bclepakko.SpaceObject.Enemies;

import android.view.WindowManager;
import android.widget.ImageView;

import alexlahdekorpi.bclepakko.ScoreBoard;

/**
 * Created by alex.lahdekorpi on 27.6.2017.
 */

public class Triangle extends Enemy {

    public Triangle(ImageView imageView, WindowManager wm, ScoreBoard scoreBoard) {
        super(imageView, wm, scoreBoard);
        setSpeed(20);
        setDefaultHitPoints(3);
        setPoints(100);
        setStartY(-100);
    }

}
