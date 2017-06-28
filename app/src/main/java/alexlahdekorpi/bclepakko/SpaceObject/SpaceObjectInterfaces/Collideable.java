package alexlahdekorpi.bclepakko.SpaceObject.SpaceObjectInterfaces;

import alexlahdekorpi.bclepakko.ScoreBoard;

/**
 * Created by alex.lahdekorpi on 26.6.2017.
 */

public interface Collideable {

    public int getHitX();
    public int getHitY();
    public void createHitChecker();
    public ScoreBoard getScoreBoard();

}
