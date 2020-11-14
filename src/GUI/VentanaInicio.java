package GUI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class VentanaInicio {
	
	Scene scene, scene1, scene2;
	
	public VentanaInicio() {
		
		VBox p1 = new VBox(20);
		
		Label text = new Label("Bienvenidos a CompuElectronics");
		text.setFont(new Font("Arial",15));
		text.setAlignment(Pos.CENTER);
		
		Button b1 = new Button("Siguiente");
		b1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				scene = scene2;
			}
			
		});
		
		Rectangle rt = new Rectangle(250,50,Color.TRANSPARENT);
		rt.setStroke(Color.GRAY);
		StackPane sp = new StackPane(new Node[] { rt, text });
		
		p1.setAlignment(Pos.CENTER);
		p1.getChildren().addAll(sp,b1);
		
		 scene1 = new Scene(p1,300,300);
		
		VBox p2 = new VBox(20);
		Label text2 = new Label("ventana principal");
		text2.setFont(new Font("Arial",15));
		text2.setAlignment(Pos.CENTER);
		
		Button b2 = new Button("atras");
		b2.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				scene = scene1;				
			}
			
		});
		
		p2.setAlignment(Pos.CENTER);
		p2.getChildren().addAll(text2,b2);
		
		scene2 = new Scene(p2,300,300);
		
		scene = scene1;
		
	}

	public Scene getScene() {
		return scene;
	}
	
	
}
