package alexlahdekorpi.bclepakko;

import android.content.Context;
import android.widget.ImageView;

/**
 * Created by alex.lahdekorpi on 22.6.2017.
 */

public class SpaceObject implements Collideable {


    public ImageView imageView;
    public HitChecker hitChecker;
    public int speed;

    public int hitX;
    public int hitY;

    public SpaceObject(ImageView imageView) {
        this.imageView = imageView;
        createHitChecker();
    }


    //MOVEMENT
    public void moveX(int amount){this.imageView.setX(this.imageView.getX() + amount);}
    public void moveY(int amount){this.imageView.setY(this.imageView.getY() + amount);}
    public void moveXTo(int place){this.imageView.setX(place);}
    public void moveYTo(int place){this.imageView.setY(place);}

    //GETSET
    public int getY(){
        return (int) this.imageView.getY();
    }
    public int getX(){return (int) this.imageView.getX();}
    public int getSpeed() {
        return this.speed;
    }
    public void setSpeed(int speed) { this.speed = speed; }
    public ImageView getImageView() { return this.imageView;}
    public HitChecker getHitChecker() {return this.hitChecker;}


    //IMPLEMENTED METHODS
    @Override
    public int getHitX() {
        return this.imageView.getWidth() + getX() / 2;
    }
    @Override
    public int getHitY() {return this.imageView.getHeight() + getY() / 2;}

    //CREATE HITCHECKER FOR SPACEOBJECT
    @Override
    public void createHitChecker() {
        this.hitChecker = new HitChecker(this);
    }

}
