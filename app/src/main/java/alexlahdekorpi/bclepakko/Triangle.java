package alexlahdekorpi.bclepakko;

import android.view.WindowManager;
import android.widget.ImageView;

/**
 * Created by alex.lahdekorpi on 27.6.2017.
 */

public class Triangle extends SpaceObject implements Renewable {

    public int defaultHitPoints;

    public Triangle(ImageView imageView, WindowManager wm) {
        super(imageView, wm);
        setSpeed(15);
        setDefaultHitPoints(3);
    }
    public void drop(){
        moveY(getSpeed());
        if(getY() > getScreenHeight()){
            moveYTo(0);
            moveXTo((int) Math.floor(Math.random() * (getScreenWidth() - getImageView().getWidth() )));
        }
    }

    @Override
    public void renew(){
        moveYTo(-50);
        moveXTo((int) Math.floor(Math.random() * (this.screenWidth - getImageView().getWidth())));
        setHitPoints(getDefaultHitPoints());

    }
    public int getDefaultHitPoints() {
        return defaultHitPoints;
    }

    @Override
    public void setDefaultHitPoints(int defaultHitPoints) {
        this.defaultHitPoints = defaultHitPoints;
    }
}
