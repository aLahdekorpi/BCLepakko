package alexlahdekorpi.bclepakko;

import alexlahdekorpi.bclepakko.SpaceObject.Lepakko;
import alexlahdekorpi.bclepakko.SpaceObject.SpaceObjectInterfaces.Renewable;

/**
 * Created by alex.lahdekorpi on 11.7.2017.
 */

public class UniversalHitChecker {
    private Gun mainGun;
    private Renewable[] renewables;
    private Lepakko lepakko;


    public UniversalHitChecker(Gun mainGun, Renewable[] renewables, Lepakko lepakko) {
        this.mainGun = mainGun;
        this.renewables = renewables;
        this.lepakko = lepakko;

    }

    public void checkMainGunHits() {
        for (Renewable renewable : this.renewables) {
            this.mainGun.checkShotHit(renewable);
        }
    }

    public void checkLepakkoHits() {
        for (Renewable renewable : this.renewables) {
            this.lepakko.checkCollisionWithRenewable(renewable);
        }
    }

}

