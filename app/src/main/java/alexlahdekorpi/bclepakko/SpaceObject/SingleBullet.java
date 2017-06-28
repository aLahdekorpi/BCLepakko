package alexlahdekorpi.bclepakko.SpaceObject;

import android.view.WindowManager;
import android.widget.ImageView;

import alexlahdekorpi.bclepakko.ScoreBoard;
import alexlahdekorpi.bclepakko.SpaceObject.SpaceObjectInterfaces.Renewable;

/**
 * Created by alex.lahdekorpi on 28.6.2017.
 */

public class SingleBullet extends SpaceObject implements Renewable {

    private Lepakko lepakko;
    private int defaultHitPoints;
    public SingleBullet(ImageView imageView, WindowManager wm, ScoreBoard scoreBoard, Lepakko lepakko) {
        super(imageView, wm, scoreBoard);
        this.defaultHitPoints = 1;
        this.lepakko = lepakko;
        setSpeed(-100);
    }

    @Override
    public int getDefaultHitPoints() {
        return this.defaultHitPoints;
    }

    @Override
    public void setDefaultHitPoints(int defaultHitPoints) {
        this.defaultHitPoints = defaultHitPoints;
    }

    public Lepakko getLepakko() {
        return lepakko;
    }

    public void returnToLepakko(){
        moveYTo(this.lepakko.getY());
        moveXTo(this.lepakko.getX());
    }
    public void checkShotOutOfBounds(){
        if(getY()<0){
            returnToLepakko();
        }
    }
    public void checkShotHit(Renewable rew){
        if (getHitChecker().isHit(rew)) {
            rew.dropHitPoints(1);
            if (rew.isDestroyed()) {
                rew.destroyAction(getScoreBoard());
            }
            returnToLepakko();
        }
    }

    @Override
    public void destroyAction(ScoreBoard scoreBoard) {

    }
}
