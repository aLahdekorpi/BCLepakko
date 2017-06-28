package alexlahdekorpi.bclepakko.SpaceObject.SpaceObjectInterfaces;

/**
 * Created by alex.lahdekorpi on 27.6.2017.
 */

public interface Renewable extends Destroyable {
    public void renew();
    public int getDefaultHitPoints();
    public void setDefaultHitPoints(int defaultHitPoints);
}
