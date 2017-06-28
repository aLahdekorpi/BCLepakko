package alexlahdekorpi.bclepakko.SpaceObject;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.WindowManager;
import android.widget.ImageView;

import alexlahdekorpi.bclepakko.HitChecker;
import alexlahdekorpi.bclepakko.ScoreBoard;
import alexlahdekorpi.bclepakko.SpaceObject.SpaceObjectInterfaces.Collideable;
import alexlahdekorpi.bclepakko.SpaceObject.SpaceObjectInterfaces.Destroyable;

/**
 * Created by alex.lahdekorpi on 22.6.2017.
 */

public class SpaceObject extends AppCompatActivity implements Collideable, Destroyable {


    private WindowManager wm;
    public ImageView imageView;
    public HitChecker hitChecker;
    public int speed;

    public int hitPoints;

    public int screenWidth;
    public int screenHeight;

    public SpaceObject(ImageView imageView, WindowManager wm) {
        this.imageView = imageView;
        this.wm = wm;
        createHitChecker();
        setScreenSizes();
    }


    //MOVEMENT
    public void renew(){
        moveYTo(-50);
        moveXTo((int) Math.floor(Math.random() * (this.screenWidth - getImageView().getWidth())));
    }
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
    public int getScreenWidth() {return this.screenWidth;}
    public int getScreenHeight() {return this.screenHeight;}

    //CREATE HITCHECKER FOR SPACEOBJECT
    @Override
    public void createHitChecker() {
        this.hitChecker = new HitChecker(this);
    }

    @Override
    public ScoreBoard getScoreBoard() {
        return this.getScoreBoard();
    }


    public void setScreenSizes(){
        Display disp = this.wm.getDefaultDisplay();
        Point size = new Point();
        disp.getSize(size);
        this.screenWidth = size.x;
        this.screenHeight = size.y;

    }


    //IMPLEMENTED METHODS
    @Override
    public int getHitX() {
        return this.imageView.getWidth() + getX() / 2;
    }
    @Override
    public int getHitY() {return this.imageView.getHeight() + getY() / 2;}


    @Override
    public int getHitPoints() {
        return getHitPoints();
    }

    @Override
    public void dropHitPoints(int amount) {
        this.hitPoints -= amount;
    }

    @Override
    public void setHitPoints(int amount) {
        this.hitPoints = amount;
    }

    @Override
    public boolean isDestroyed() {
        if (this.hitPoints < 1){
            return true;
        }
        return false;
    }

}
