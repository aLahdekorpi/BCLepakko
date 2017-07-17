package alexlahdekorpi.bclepakko.SpaceObject.SpaceObjectInterfaces;


import alexlahdekorpi.bclepakko.Gui.ScoreBoard;

/**
 * Created by alex.lahdekorpi on 26.6.2017.
 */

public interface Collideable {

    double getHitX();

    double getHitY();

    void createHitChecker();

    ScoreBoard getScoreBoard();

}
