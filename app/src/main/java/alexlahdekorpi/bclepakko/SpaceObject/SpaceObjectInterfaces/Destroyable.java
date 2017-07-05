package alexlahdekorpi.bclepakko.SpaceObject.SpaceObjectInterfaces;

import alexlahdekorpi.bclepakko.SpaceObject.Gun;

/**
 * Created by alex.lahdekorpi on 27.6.2017.
 */

public interface Destroyable extends Collideable {
    int getHitPoints();
    void dropHitPoints(int amount);
    void setHitPoints(int amount);
    boolean isDestroyed();
    void destroyAction(Gun gun);

}
