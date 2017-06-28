package alexlahdekorpi.bclepakko.SpaceObject.SpaceObjectInterfaces;

import alexlahdekorpi.bclepakko.ScoreBoard;

/**
 * Created by alex.lahdekorpi on 28.6.2017.
 */

public interface LepakkoCollideable extends Collideable {
    public void lepakkoCollideAction(ScoreBoard scoreBoard);
}
