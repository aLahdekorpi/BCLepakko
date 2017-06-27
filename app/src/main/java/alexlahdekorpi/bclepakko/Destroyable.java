package alexlahdekorpi.bclepakko;

/**
 * Created by alex.lahdekorpi on 27.6.2017.
 */

public interface Destroyable {
    int getHitPoints();
    void dropHitPoints(int amount);
    void setHitPoints(int amount);
    boolean isDestroyed();

}
