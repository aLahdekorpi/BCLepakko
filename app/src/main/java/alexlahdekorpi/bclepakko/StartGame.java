package alexlahdekorpi.bclepakko;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;


public class StartGame extends AppCompatActivity {

    //Initialize Class
    private Handler handler = new Handler();
    private Timer timer = new Timer();
    private UniversalHitChecker uhc;
    private SpaceHandler sh;

    //Status Check
    private boolean start_flg = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sh = new SpaceHandler(this);
        uhc = new UniversalHitChecker(sh.getMainGun(), sh.getEnemies(), sh.getLepakko());
    }

    public void changePos(){
        sh.moveEnemies();
        sh.getMainGun().shoot();
        uhc.checkMainGunHits();
    }

    public boolean onTouchEvent(MotionEvent me){
        if(!start_flg){
            start_flg = true;
            sh.getStartLabel().setVisibility((View.GONE));
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            changePos();
                            uhc.checkLepakkoHits();
                            sh.getScoreBoard().update();
                        }
                    });
                }
            }, 0 , 20);


        } else {
            sh.getLepakko().moveToTouch(me);
        }
        return true;
    }

}
