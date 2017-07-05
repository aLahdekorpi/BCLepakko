package alexlahdekorpi.bclepakko.SpaceObject;

import android.view.WindowManager;
import android.widget.ImageView;

import alexlahdekorpi.bclepakko.ScoreBoard;

/**
 * Created by alex.lahdekorpi on 5.7.2017.
 */

public class Bullet extends SpaceObject {
    public Lepakko lepakko;
    public int damage;
    public Bullet(ImageView imageView, WindowManager wm, ScoreBoard scoreBoard, Lepakko lepakko) {
        super(imageView, wm, scoreBoard);
        this.lepakko = lepakko;
    }

    public int getDamage() {
        return this.damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}