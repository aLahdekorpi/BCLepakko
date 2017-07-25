package alexlahdekorpi.bclepakko;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

import alexlahdekorpi.bclepakko.Logic.GameHandler;


public class StartActivity extends AppCompatActivity {

    //Initialize Class
    public Handler handler = new Handler();
    public Timer timer = new Timer();
    private GameHandler gh;
    private boolean alive;

    //Status Check
    private boolean start_flg = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.gh = new GameHandler(this);
        this.alive = true;
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

    public void resultStuff() {
        Intent intent = new Intent(getApplicationContext(), Result.class);
        intent.putExtra("SCORE, ", this.gh.getSg().getScoreBoard().score);
        startActivity(intent);
    }

}
