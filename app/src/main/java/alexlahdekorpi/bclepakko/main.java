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

import alexlahdekorpi.bclepakko.SpaceObject.BallBullet;
import alexlahdekorpi.bclepakko.SpaceObject.Bullet;
import alexlahdekorpi.bclepakko.SpaceObject.Circle;
import alexlahdekorpi.bclepakko.SpaceObject.Gun;
import alexlahdekorpi.bclepakko.SpaceObject.Lepakko;
import alexlahdekorpi.bclepakko.SpaceObject.SingleBullet;
import alexlahdekorpi.bclepakko.SpaceObject.Triangle;


public class main extends AppCompatActivity {

    private TextView startLabel;
    private ScoreBoard scoreBoard;

    //SpaceObjects
    private Lepakko lepakko;
    private Triangle triangle;
    private Circle circle;
    private Bullet[] bulletArray;
    private SingleBullet singleBullet;
    private BallBullet ballBullet;
    private Gun mainGun;

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
        moveSingleShot();
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
                            scoreBoard.update();
                        }
                    });
                }
            }, 0 , 20);


        } else {
            lepakko.moveToTouch(me);
        }
        return true;
    }


    private void checkIfLepakkoHit() {
        lepakko.checkCollisionWithLepakkoCollideable(triangle);
        lepakko.checkCollisionWithLepakkoCollideable(circle);
    }




    public void moveSingleShot() {
        mainGun.shoot();
        mainGun.checkShotHit(triangle);
        mainGun.checkShotHit(circle);


    }
    public void createSpaceObjects(){
        lepakko = new Lepakko ((ImageView) findViewById(R.id.lepakkoImg), this.wm, scoreBoard);
        triangle = new Triangle((ImageView) findViewById(R.id.triangle), this.wm, scoreBoard);
        circle = new Circle((ImageView) findViewById(R.id.circle), this.wm, scoreBoard);
        singleBullet = new SingleBullet ((ImageView) findViewById(R.id.shot), this.wm,scoreBoard, lepakko);
        ballBullet = new BallBullet((ImageView) findViewById(R.id.ball), this.wm,scoreBoard, lepakko);
        bulletArray = new Bullet[2];
        bulletArray[0]=singleBullet;
        bulletArray[1]=ballBullet;
        mainGun = new Gun(bulletArray, lepakko);

    }

}



