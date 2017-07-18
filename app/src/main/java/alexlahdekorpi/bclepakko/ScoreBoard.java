package alexlahdekorpi.bclepakko;

import android.widget.TextView;

/**
 * Created by alex.lahdekorpi on 27.6.2017.
 */

public class ScoreBoard {
    public TextView scoreView;
    public int score;
    public ScoreBoard(TextView textView){
        this.scoreView = textView;
        this.score = 0;
        this.scoreView.setText("Score: " + this.score);
    }
    public void addScore(int amount){
        this.score += amount;
    }
    public void nullScore(){
        this.score = 0;
    }
    public void update(){
        this.scoreView.setText("Score: " + this.score);
    }
}
