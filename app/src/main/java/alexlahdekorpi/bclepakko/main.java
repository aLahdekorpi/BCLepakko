package alexlahdekorpi.bclepakko;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;


public class main extends AppCompatActivity {

    private TextView startLabel;
    private ScoreBoard scoreBoard;

    //SpaceObjects
    private SpaceObject lepakko;
    private Triangle triangle;
    private Circle circle;
    private SpaceObject shot;

    //Initialize Class
    private Handler handler = new Handler();
    private Timer timer = new Timer();
    private WindowManager wm;

    //Status Check
    private boolean start_flg = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.wm = getWindowManager();
        startLabel = (TextView) findViewById(R.id.startLabel);
        scoreBoard = new ScoreBoard((TextView) findViewById(R.id.scoreText));

        createSpaceObjects();
    }

    public void changePos(){
        triangle.drop();
        circle.drop();
        moveShot();
    }

    public boolean onTouchEvent(MotionEvent me){
        if(!start_flg){
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
                            scoreBoard.update();
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


    private void checkIfLepakkoHit() {
        if(lepakko.getHitChecker().isHit(circle)){
            circle.moveYTo(-100);
            scoreBoard.nullScore();
        }
        if(lepakko.getHitChecker().isHit(triangle)){
            triangle.moveYTo(100);
            scoreBoard.nullScore();
        }
    }

    public void createSpaceObjects(){
        lepakko = new SpaceObject ((ImageView) findViewById(R.id.lepakkoImg), this.wm);
        shot = new SpaceObject ((ImageView) findViewById(R.id.shot), this.wm);
        shot.moveYTo(lepakko.getY());
        shot.moveXTo(lepakko.getX());
        shot.setSpeed(-100);

        triangle = new Triangle((ImageView) findViewById(R.id.triangle), this.wm);
        circle = new Circle((ImageView) findViewById(R.id.circle), this.wm);


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
            triangle.dropHitPoints(1);
            if (triangle.isDestroyed()) {
                triangle.renew();
            }
            shot.moveXTo(lepakko.getX());
            shot.moveYTo(lepakko.getY());
            scoreBoard.addScore(50);

        }
        if (shot.getHitChecker().isHit(circle)) {
            circle.dropHitPoints(1);
            if (circle.isDestroyed()) {
                circle.renew();
                shot.moveXTo(lepakko.getX());
                shot.moveYTo(lepakko.getY());
                scoreBoard.addScore(100);

            }
        }
    }

}


