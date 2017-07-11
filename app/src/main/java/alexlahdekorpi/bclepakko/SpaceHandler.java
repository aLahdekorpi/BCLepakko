package alexlahdekorpi.bclepakko;

import android.app.Activity;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import alexlahdekorpi.bclepakko.SpaceObject.Bullets.BallBullet;
import alexlahdekorpi.bclepakko.SpaceObject.Bullets.Bullet;
import alexlahdekorpi.bclepakko.SpaceObject.Bullets.SingleBullet;
import alexlahdekorpi.bclepakko.SpaceObject.Enemies.Enemy;
import alexlahdekorpi.bclepakko.SpaceObject.Enemies.Square;
import alexlahdekorpi.bclepakko.SpaceObject.Enemies.Triangle;
import alexlahdekorpi.bclepakko.SpaceObject.Lepakko;
import alexlahdekorpi.bclepakko.SpaceObject.PowerUps.Circle;
import alexlahdekorpi.bclepakko.SpaceObject.SpaceObjectInterfaces.Renewable;


/**
 * Created by alex.lahdekorpi on 11.7.2017.
 */

public class SpaceHandler extends StartGame {

    Renewable[] ren;
    Enemy[] enemies;
    Activity activity;
    private Lepakko lepakko;
    private Triangle triangle;
    private Circle circle;
    private Square square;
    private Bullet[] bulletArray;
    private SingleBullet singleBullet;
    private BallBullet ballBullet;
    private Gun mainGun;
    private TextView startLabel;
    private ScoreBoard scoreBoard;
    private WindowManager wm;

    public SpaceHandler(Activity activity) {
        this.activity = activity;
        createSpaceObjects();
    }

    public void moveEnemies() {
        for (Enemy enemy : this.enemies) {
            enemy.drop();
        }
    }


    private void createSpaceObjects() {
        this.wm = this.activity.getWindowManager();
        this.startLabel = (TextView) this.activity.findViewById(R.id.startLabel);
        this.scoreBoard = new ScoreBoard((TextView) this.activity.findViewById(R.id.scoreText));
        this.lepakko = new Lepakko((ImageView) this.activity.findViewById(R.id.lepakkoImg), this.wm, this.scoreBoard);
        this.triangle = new Triangle((ImageView) this.activity.findViewById(R.id.triangle), this.wm, this.scoreBoard);
        this.circle = new Circle((ImageView) this.activity.findViewById(R.id.circle), this.wm, this.scoreBoard);
        this.square = new Square((ImageView) this.activity.findViewById(R.id.square), this.wm, this.scoreBoard);
        this.ren = new Renewable[3];
        this.ren[0] = this.circle;
        this.ren[1] = this.triangle;
        this.ren[2] = this.square;
        this.enemies = new Enemy[3];
        this.enemies[0] = this.circle;
        this.enemies[1] = this.triangle;
        this.enemies[2] = this.square;

        this.singleBullet = new SingleBullet((ImageView) this.activity.findViewById(R.id.shot), this.wm, this.scoreBoard, this.lepakko);
        this.ballBullet = new BallBullet((ImageView) this.activity.findViewById(R.id.ball), this.wm, this.scoreBoard, this.lepakko);
        this.bulletArray = new Bullet[2];
        this.bulletArray[0] = singleBullet;
        this.bulletArray[1] = this.ballBullet;

        this.mainGun = new Gun(this.bulletArray, this.lepakko);


    }


    public Lepakko getLepakko() {
        return lepakko;
    }

    public Gun getMainGun() {
        return mainGun;
    }

    public TextView getStartLabel() {
        return startLabel;
    }

    public ScoreBoard getScoreBoard() {
        return scoreBoard;
    }

    public Enemy[] getEnemies() {
        return enemies;
    }
}
