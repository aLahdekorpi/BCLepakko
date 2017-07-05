package alexlahdekorpi.bclepakko.SpaceObject.SpaceObjectInterfaces;

/**
 * Created by alex.lahdekorpi on 27.6.2017.
 */

public interface Renewable extends Destroyable {
    void renew();
    int getDefaultHitPoints();
    void setDefaultHitPoints(int defaultHitPoints);
}
