package Graphic;

import com.sun.javafx.fxml.builder.JavaFXSceneBuilder;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Scanner;

public class Main extends Application {
  static  ArrayList<Ball> balls=new ArrayList();
    public static void main(String[] args) {
        launch(args);


    }
    @Override
    public void start(Stage primaryStage) throws Exception {

       Ball ball=new Ball(200,300,20,2,45);
       Ball ball1=new Ball(250,350,20,2,245);
        Ball ball2=new Ball(350,350,20,2,135);

        balls.add(ball);
        balls.add(ball1);
        balls.add(ball2);

        for(int i=0;i<balls.size();i++){
            BallAnimation a=new BallAnimation(balls.get(i));
            a.play();
        }
        //Creating the mouse event handler
        Circle circle=new Circle(100,100,40);
        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                System.out.println("Hello World");

                circle.setFill(Color.DARKSLATEBLUE);
            }
        };
        //Registering the event filter
        circle.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);



        MainView.getMV().setMainStage(primaryStage);
primaryStage.setResizable(false);
MainView.getMV().setScene("Start.fxml");
        for(int i=0;i<balls.size();i++){
            MainView.pane.getChildren().add(balls.get(i));
        }
MainView.getMV().getMainStage().setScene(new Scene(MainView.pane));
primaryStage.setTitle("horizontal");
primaryStage.show();

//while(b==1){
//  b=sc.nextInt();
//  if(b==1){
//      Ball balll=new Ball(100,100,20 , 2,45);
//      balls.add(balll);
//  }
//
//}

    }
}
