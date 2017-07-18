package alexlahdekorpi.bclepakko;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;


public class StartActivity extends AppCompatActivity {

    //Initialize Class
    private Handler handler = new Handler();
    private Timer timer = new Timer();
    private GameHandler gh;

    //Status Check
    private boolean start_flg = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.gh = new GameHandler(this);
    }


    @Override
    public boolean onTouchEvent(MotionEvent me){
        if(!start_flg){
            start_flg = true;
            this.gh.getSg().getStartLabel().setVisibility((View.GONE));
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            gh.onTouch();
                        }
                    });
                }
            }, 0 , 20);


        } else {
            this.gh.getSg().getLepakko().moveToTouch(me);
        }
        return true;
    }

}
