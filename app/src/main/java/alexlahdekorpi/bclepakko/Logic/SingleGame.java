package alexlahdekorpi.bclepakko.Logic;

import android.view.WindowManager;
import android.widget.TextView;

import alexlahdekorpi.bclepakko.Gui.ScoreBoard;
import alexlahdekorpi.bclepakko.R;
import alexlahdekorpi.bclepakko.SpaceObject.Bullets.BallBullet;
import alexlahdekorpi.bclepakko.SpaceObject.Bullets.Bullet;
import alexlahdekorpi.bclepakko.SpaceObject.Bullets.SingleBullet;
import alexlahdekorpi.bclepakko.SpaceObject.Enemies.Enemy;
import alexlahdekorpi.bclepakko.SpaceObject.Enemies.Square;
import alexlahdekorpi.bclepakko.SpaceObject.Enemies.Triangle;
import alexlahdekorpi.bclepakko.SpaceObject.Lepakko;
import alexlahdekorpi.bclepakko.SpaceObject.PowerUps.Circle;
import alexlahdekorpi.bclepakko.SpaceObject.SpaceObjectInterfaces.Renewable;
import alexlahdekorpi.bclepakko.StartActivity;


/**
 * Created by alex.lahdekorpi on 11.7.2017.
 */

public class SingleGame extends StartActivity {

    Renewable[] ren;
    Enemy[] enemies;
    StartActivity activity;
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

    public SingleGame(StartActivity activity) {
        this.activity = activity;
        initializeActivity();
        createSpaceObjects();
    }

    public void moveEnemies() {
        for (Enemy enemy : this.enemies) {
            enemy.drop();
        }
    }

    public void initializeActivity() {
        this.wm = this.activity.getWindowManager();
        this.startLabel = (TextView) this.activity.findViewById(R.id.startLabel);
        this.scoreBoard = new ScoreBoard((TextView) this.activity.findViewById(R.id.scoreText));
    }


    private void createSpaceObjects() {

        this.lepakko = new Lepakko(this.activity, this.scoreBoard);
        this.triangle = new Triangle(this.activity, this.scoreBoard);
        this.circle = new Circle(this.activity, this.scoreBoard);
        this.square = new Square(this.activity, this.scoreBoard);
        this.ren = new Renewable[3];
        this.ren[0] = this.circle;
        this.ren[1] = this.triangle;
        this.ren[2] = this.square;
        this.enemies = new Enemy[3];
        this.enemies[0] = this.circle;
        this.enemies[1] = this.triangle;
        this.enemies[2] = this.square;

        this.singleBullet = new SingleBullet(this.activity, this.scoreBoard, this.lepakko);
        this.ballBullet = new BallBullet(this.activity, this.scoreBoard, this.lepakko);
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
