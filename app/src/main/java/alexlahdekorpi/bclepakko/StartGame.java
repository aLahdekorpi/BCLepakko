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

import alexlahdekorpi.bclepakko.SpaceObject.Bullets.BallBullet;
import alexlahdekorpi.bclepakko.SpaceObject.Bullets.Bullet;
import alexlahdekorpi.bclepakko.SpaceObject.Bullets.SingleBullet;
import alexlahdekorpi.bclepakko.SpaceObject.Enemies.Square;
import alexlahdekorpi.bclepakko.SpaceObject.Enemies.Triangle;
import alexlahdekorpi.bclepakko.SpaceObject.Lepakko;
import alexlahdekorpi.bclepakko.SpaceObject.PowerUps.Circle;


public class StartGame extends AppCompatActivity {

    private TextView startLabel;
    private ScoreBoard scoreBoard;

    //SpaceObjects
    private Lepakko lepakko;
    private Triangle triangle;
    private Circle circle;
    private Square square;
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
        square.drop();
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
            lepakko.moveCloserToTouch(me);
        }
        return true;
    }


    private void checkIfLepakkoHit() {
        lepakko.checkCollisionWithLepakkoCollideable(triangle);
        lepakko.checkCollisionWithLepakkoCollideable(circle);
        lepakko.checkCollisionWithLepakkoCollideable(square);
    }




    public void moveSingleShot() {
        mainGun.shoot();
        mainGun.checkShotHit(triangle);
        mainGun.checkShotHit(circle);
        mainGun.checkShotHit(square);


    }
    public void createSpaceObjects(){
        lepakko = new Lepakko ((ImageView) findViewById(R.id.lepakkoImg), this.wm, scoreBoard);
        triangle = new Triangle((ImageView) findViewById(R.id.triangle), this.wm, scoreBoard);
        circle = new Circle((ImageView) findViewById(R.id.circle), this.wm, scoreBoard);
        square = new Square((ImageView) findViewById(R.id.square), this.wm, scoreBoard);
        singleBullet = new SingleBullet ((ImageView) findViewById(R.id.shot), this.wm,scoreBoard, lepakko);
        ballBullet = new BallBullet((ImageView) findViewById(R.id.ball), this.wm,scoreBoard, lepakko);
        bulletArray = new Bullet[2];
        bulletArray[0]=singleBullet;
        bulletArray[1]=ballBullet;
        mainGun = new Gun(bulletArray, lepakko);

    }

}
