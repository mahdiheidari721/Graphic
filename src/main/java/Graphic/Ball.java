package Graphic;

import javafx.scene.shape.Circle;

import java.util.ArrayList;

public class Ball extends Circle {
    public static ArrayList<Ball> Allball=new ArrayList<>();
    int Speed;
    double theta;
    public Ball(double centerX, double centerY, double radius,int Speed,double theta) {
        super(centerX, centerY, radius);
        this.Speed=Speed;
        this.theta=theta;
        Allball.add(this);
    }

    public static ArrayList<Ball> getAllball() {
        return Allball;
    }

    public static void setAllball(ArrayList<Ball> allball) {
        Allball = allball;
    }

    public int getSpeed() {
        return Speed;
    }

    public void setSpeed(int speed) {
        Speed = speed;
    }

    public double getTheta() {
        return theta;
    }

    public void setTheta(double theta) {
        this.theta = theta;
    }

    public void Move(double dx, double dy){
        this.setCenterX(this.getCenterX()+dx);
        this.setCenterY(this.getCenterY()+dy);
    }
    public boolean hitT(){
        return this.getCenterY()-this.getRadius()<=0;
    }
    public boolean hitL(){
        return this.getCenterX()-this.getRadius()<=0;
    }
    public boolean hitR(){
        return this.getCenterX()+this.getRadius()>=600;
    }
    public boolean hitB(){
        return this.getCenterY()+this.getRadius()>=400;
    }
public void collision(){
        for(int i=0;i<Allball.size();i++){
            if(this.getCenterY()==Allball.get(i).getCenterY()&&this.getCenterX()==Allball.get(i).getCenterX()){
                continue;
            }
          else  if(this.getBoundsInParent().intersects(Allball.get(i).getLayoutBounds())){
                this.setTheta(180-this.getTheta());
                Allball.get(i).setTheta( 180-Allball.get(i).getTheta());
               // System.out.println("collision");
            }
        }
}
}
