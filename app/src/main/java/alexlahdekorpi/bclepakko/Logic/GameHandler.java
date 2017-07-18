package alexlahdekorpi.bclepakko.Logic;

import alexlahdekorpi.bclepakko.StartActivity;

/**
 * Created by alex.lahdekorpi on 18.7.2017.
 */

public class GameHandler extends StartActivity {
    private UniversalHitChecker uhc;
    private SingleGame sg;
    private StartActivity activity;


    public GameHandler(StartActivity activity) {
        this.activity = activity;
        this.sg = new SingleGame(this.activity);
        this.uhc = new UniversalHitChecker(sg.getMainGun(), sg.getEnemies(), sg.getLepakko());
    }

    public void changePos() {
        this.sg.moveEnemies();
        this.sg.getMainGun().shoot();
        this.uhc.checkMainGunHits();
    }

    public void onTouch() {
        changePos();
        this.uhc.checkLepakkoHits();
        this.sg.getScoreBoard().update();
    }

    public UniversalHitChecker getUhc() {
        return uhc;
    }

    public SingleGame getSg() {
        return sg;
    }
}
