package alexlahdekorpi.bclepakko.SpaceObject;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.WindowManager;
import android.widget.ImageView;

import alexlahdekorpi.bclepakko.Gun;
import alexlahdekorpi.bclepakko.HitChecker;
import alexlahdekorpi.bclepakko.ScoreBoard;
import alexlahdekorpi.bclepakko.SpaceObject.SpaceObjectInterfaces.Collideable;
import alexlahdekorpi.bclepakko.SpaceObject.SpaceObjectInterfaces.Destroyable;

/**
 * Created by alex.lahdekorpi on 22.6.2017.
 */

public class SpaceObject extends AppCompatActivity implements Collideable, Destroyable {


    public ImageView imageView;
    public HitChecker hitChecker;
    public ScoreBoard scoreBoard;
    public int speed;
    public int hitPoints;
    public double screenWidth;
    public double screenHeight;
    private WindowManager wm;

    public SpaceObject(ImageView imageView, WindowManager wm, ScoreBoard scoreBoard) {
        this.imageView = imageView;
        this.wm = wm;
        this.scoreBoard = scoreBoard;
        createHitChecker();
        setScreenSizes();
    }

    public void renew(){
        moveYTo(-50);
        moveXTo(Math.floor(Math.random() * (this.screenWidth - getImageView().getWidth())));
    }
    //MOVEMENT
    public void moveX(double amount) {
        this.imageView.setX((float) (this.imageView.getX() + amount));
    }

    public void moveY(double amount) {
        this.imageView.setY((float) (this.imageView.getY() + amount));
    }

    public void moveXTo(double place) {
        this.imageView.setX((float) place);
    }

    public void moveYTo(double place) {
        this.imageView.setY((float) place);
    }

    //GETSET
    public ScoreBoard getScoreBoard() {return this.scoreBoard;}

    public float getY() {
        return this.imageView.getY();
    }

    public float getX() {
        return this.imageView.getX();
    }
    public int getSpeed() {
        return this.speed;
    }
    public void setSpeed(int speed) { this.speed = speed; }
    public ImageView getImageView() { return this.imageView;}
    public HitChecker getHitChecker() {return this.hitChecker;}

    public double getScreenWidth() {
        return this.screenWidth;
    }

    public double getScreenHeight() {
        return this.screenHeight;
    }

    //CREATE HITCHECKER FOR SPACEOBJECT
    @Override
    public void createHitChecker() {
        this.hitChecker = new HitChecker(this);
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
    public double getHitX() {
        return this.imageView.getWidth() + getX() / 2;
    }
    @Override
    public double getHitY() {
        return this.imageView.getHeight() + getY() / 2;
    }


    @Override
    public int getHitPoints() {
        return getHitPoints();
    }

    @Override
    public void setHitPoints(int amount) {
        this.hitPoints = amount;
    }

    @Override
    public void dropHitPoints(int amount) {
        this.hitPoints -= amount;
    }

    @Override
    public boolean isDestroyed() {
        if (this.hitPoints < 1){
            return true;
        }
        return false;
    }

    @Override
    public void destroyAction(Gun gun) {

    }

}
