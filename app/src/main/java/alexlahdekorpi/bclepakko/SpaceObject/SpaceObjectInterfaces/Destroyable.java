package alexlahdekorpi.bclepakko.SpaceObject.SpaceObjectInterfaces;

import alexlahdekorpi.bclepakko.Logic.Gun;

/**
 * Created by alex.lahdekorpi on 27.6.2017.
 */

public interface Destroyable extends Collideable {
    int getHitPoints();

    void setHitPoints(int amount);

    void dropHitPoints(int amount);

    boolean isDestroyed();
    void destroyAction(Gun gun);

}
