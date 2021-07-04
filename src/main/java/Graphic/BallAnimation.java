package Graphic;

import javafx.animation.Transition;
import javafx.util.Duration;

public class BallAnimation extends Transition {
    public Ball ball;
    public BallAnimation( Ball ball) {

        this.ball = ball;
        this.setCycleDuration(Duration.millis(1000));
        this.setCycleCount(-1);
    }

    @Override
    protected void interpolate(double v) {
       double dx=this.ball.getSpeed()*Math.cos(Math.toRadians(this.ball.getTheta()));
       double dy=-this.ball.getSpeed()*Math.sin(Math.toRadians(this.ball.getTheta()));
       this.ball.Move(dx,dy);
       this.ball.collision();
       if(this.ball.hitT()){
           this.ball.setTheta(-this.ball.getTheta());
       }
        if(this.ball.hitR()||this.ball.hitL()){
            this.ball.setTheta(180-this.ball.getTheta());
        }
        if(this.ball.hitB()){
            this.ball.setTheta(360-this.ball.getTheta());
        }
    }
}
