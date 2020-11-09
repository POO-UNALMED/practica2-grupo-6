package parte1;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Label;
import javafx.scene.control.Button;


import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;






public class VentanaInicio extends Application{
	
	@Override
	public void start(Stage primaryStage)  {
		// TODO Auto-generated method stub
		primaryStage.setTitle("Programa com GUI");
			
		
		
		
			
			
		//gripane
		GridPane p1 = new GridPane();
		p1.setHgap(10);
		p1.setAlignment(Pos.CENTER);
		p1.add(new Button("bienvenido"), 0, 0);
		
		
		//columna derecha
		Button btn2 = new Button("h1");
		Button btn3 = new Button("h2");
		Button btn4 = new Button("h3");
		VBox p2 = new VBox(btn2,btn3,btn4);
		
		//centro  controlador de los espacios
		BorderPane p3 =new BorderPane();
		p3.setRight(p2);		//derecha
		p3.setTop(p1);			//arriba
		
		
		
		Scene myScene = new Scene(p3,300,200);
		primaryStage.setScene(myScene);
		
		primaryStage.show();
	}
	
	
	public static void main(String[] args) {
	    launch(args);
	  }

	
}
