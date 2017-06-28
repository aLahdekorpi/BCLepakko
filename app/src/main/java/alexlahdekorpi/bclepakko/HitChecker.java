package alexlahdekorpi.bclepakko;

import alexlahdekorpi.bclepakko.SpaceObject.SpaceObjectInterfaces.Collideable;

/**
 * Created by alex.lahdekorpi on 26.6.2017.
 */

public class HitChecker {

    public Collideable collideable;

    public HitChecker(Collideable collideable){
        this.collideable = collideable;

    }
    public boolean isHit(Collideable otherCol){
        //checks if otherCol hits with this.collideable, false if not.
        if (
                this.collideable.getHitX()- otherCol.getHitX() < 50
                        && this.collideable.getHitX()- otherCol.getHitX() > -50
                        && this.collideable.getHitY()- otherCol.getHitY() > -30
                        && this.collideable.getHitY() - otherCol.getHitY() < 30
                ){
            return true;
        }
        return false;
    }
}
