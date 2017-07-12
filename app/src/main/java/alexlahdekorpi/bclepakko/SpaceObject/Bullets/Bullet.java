package alexlahdekorpi.bclepakko.SpaceObject.Bullets;

import android.app.Activity;

import alexlahdekorpi.bclepakko.ScoreBoard;
import alexlahdekorpi.bclepakko.SpaceObject.Lepakko;
import alexlahdekorpi.bclepakko.SpaceObject.SpaceObject;

/**
 * Created by alex.lahdekorpi on 5.7.2017.
 */

public class Bullet extends SpaceObject {
    public Lepakko lepakko;
    public int damage;

    public Bullet(Activity activity, ScoreBoard scoreBoard, Lepakko lepakko) {
        super(activity, scoreBoard);
        this.lepakko = lepakko;
    }

    public int getDamage() {
        return this.damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
