package alexlahdekorpi.bclepakko;

/**
 * Created by alex.lahdekorpi on 27.6.2017.
 */

public interface Destroyable {
    int getHitPoints();
    int dropHitPoints(int amount);
    int setHitPoints(int amount);
    void destroyed();
}
