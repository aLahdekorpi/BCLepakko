package alexlahdekorpi.bclepakko;

import android.view.WindowManager;
import android.widget.ImageView;

/**
 * Created by alex.lahdekorpi on 27.6.2017.
 */

public class Circle extends SpaceObject implements Renewable {
    public SpaceObject lepakko;
    public int defaultHitPoints;

    public Circle(ImageView imageView, WindowManager wm) {
        super(imageView, wm);
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
    public int getDefaultHitPoints() {
        return 0;
    }

    @Override
    public void setDefaultHitPoints(int defaultHitPoints) {
        this.defaultHitPoints = defaultHitPoints;
    }

}

