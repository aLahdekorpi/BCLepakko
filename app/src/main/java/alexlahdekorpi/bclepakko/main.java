package alexlahdekorpi.bclepakko;

import android.graphics.Point;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;


public class main extends AppCompatActivity {

    private TextView startLabel;
    private TextView scoreLabel;

    //SpaceObjects
    private SpaceObject lepakko;
    private SpaceObject triangle;
    private SpaceObject circle;
    private SpaceObject shot;



    //Size
    private int screenHeight;
    private int screenWidth;

    //Initialize Class
    private Handler handler = new Handler();
    private Timer timer = new Timer();
    public int score = 0;


    //Status Check
    private boolean start_flg = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startLabel = (TextView) findViewById(R.id.startLabel);
        scoreLabel = (TextView) findViewById(R.id.scoreText);

        createSpaceObjects();
        setScreenSizes();
    }

    public void changePos(){
        moveTriangle();
        moveCircle();
        moveShot();
    }

    public boolean onTouchEvent(MotionEvent me){
        if(start_flg == false){
            start_flg = true;
            startLabel.setVisibility((View.GONE));
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            changePos();
                            checkIfLepakkoHit();
                            checkIfShotHit();
                            updateScore();
                        }
                    });
                }
            }, 0 , 20);


        } else {
            lepakko.moveYTo((int) me.getY() - 300);
            lepakko.moveXTo((int) me.getX() - 60);
        }
        return true;
    }

    private void updateScore() {
        scoreLabel.setText("Score : " + this.score);
    }

    private void checkIfLepakkoHit() {
        if(lepakko.getHitChecker().isHit(circle)){
            circle.moveYTo(-100);
            this.score = 0;
        }
        if(lepakko.getHitChecker().isHit(triangle)){
            triangle.moveYTo(100);
            this.score = 0;
        }
    }

    public void createSpaceObjects(){
        lepakko = new SpaceObject ((ImageView) findViewById(R.id.lepakkoImg));
        shot = new SpaceObject ((ImageView) findViewById(R.id.shot));
        shot.moveYTo(lepakko.getY());
        shot.moveXTo(lepakko.getX());
        shot.setSpeed(-100);

        triangle = new SpaceObject((ImageView) findViewById(R.id.triangle));
        triangle.setSpeed(20);
        circle = new SpaceObject((ImageView) findViewById(R.id.circle));
        circle.setSpeed(15);


    }

    public void setScreenSizes(){
        WindowManager wm = getWindowManager();
        Display disp = wm.getDefaultDisplay();
        Point size = new Point();
        disp.getSize(size);
        screenWidth = size.x;
        screenHeight = size.y;

    }

    public void moveTriangle(){
        triangle.moveY(triangle.getSpeed());
        if(triangle.getY() > screenHeight){
            triangle.moveYTo(0);
            triangle.moveXTo((int) Math.floor(Math.random() * (screenWidth - triangle.getImageView().getWidth() )));
        }
    }

    public void moveCircle(){

        circle.moveY(circle.getSpeed());
        if(circle.getY() > screenHeight){
            circle.moveYTo(0);
            circle.moveXTo((int) Math.floor(Math.random() * (screenWidth - circle.getImageView().getWidth() )));
        }
    }
    public void moveShot() {
        shot.moveY(shot.getSpeed());
        checkIfShotHit();
        if (shot.getY() < 0) {
            shot.moveXTo(lepakko.getX());
            shot.moveYTo(lepakko.getY());
        }


        }

    public void checkIfShotHit() {
        if (shot.getHitChecker().isHit(triangle)) {
            triangle.moveYTo(-50);
            triangle.moveXTo((int) Math.floor(Math.random() * (screenWidth - triangle.getImageView().getWidth())));
            shot.moveXTo(lepakko.getX());
            shot.moveYTo(lepakko.getY());
            this.score += 50;

        }
        if (shot.getHitChecker().isHit(circle)) {
            circle.moveYTo(-50);
            circle.moveXTo((int) Math.floor(Math.random() * (screenWidth - circle.getImageView().getWidth())));
            shot.moveXTo(lepakko.getX());
            shot.moveYTo(lepakko.getY());
            this.score += 100;

        }
    }
}


