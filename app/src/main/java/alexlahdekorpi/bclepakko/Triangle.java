package alexlahdekorpi.bclepakko;

import android.view.WindowManager;
import android.widget.ImageView;

/**
 * Created by alex.lahdekorpi on 27.6.2017.
 */

public class Triangle extends SpaceObject implements Collideable {

    public Triangle(ImageView imageView, WindowManager wm) {
        super(imageView, wm);
        setSpeed(15);
    }
    public void drop(){
        moveY(getSpeed());
        if(getY() > getScreenHeight()){
            moveYTo(0);
            moveXTo((int) Math.floor(Math.random() * (getScreenWidth() - getImageView().getWidth() )));
        }
    }
}
