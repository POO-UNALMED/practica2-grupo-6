package GUI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class FieldPane extends HBox {
	
	String tituloCriterios;
	String [] criterios;
	String valor;
	String [] valores;
	boolean [] habilitado;
	
	public FieldPane(String tituloCriterios, String[] criterios, String valor,String[] valores, boolean[] habilitado) {
		super();
		this.tituloCriterios = tituloCriterios;
		this.criterios = criterios;
		this.valor = valor;
		this.habilitado = habilitado;
		this.valores=valores;
		
		GridPane panel = new GridPane();
		panel.setVgap(5.0D);
	    panel.setHgap(100.0D);
	    panel.setPadding(new Insets(10,10,10,10));
		VBox crit = new VBox(5);
		VBox val = new VBox(5);
		
	    Label c = new Label(tituloCriterios);
	    c.setFont(new Font("Arial",15));
	    Label v = new Label(valor);
	    v.setFont(new Font("Arial",15));
	    
	    
	    panel.add(c, 2, 0);
	    panel.add(v, 3,0);
	  
	    
	    if(habilitado==null) {
	    	for (int i = 0; i < criterios.length; i++) {
				
		    	Label valores1 = new Label(criterios[i]);
		    	TextField campo = new TextField();
		    	valores1.setFont(new Font("Arial",13));
		    	panel.add(valores1, 2, i+1);
		    	panel.add(campo, 3, i+1);
		    	
			}
	    }else {
	    	
	    }
	    
	    
	    getChildren().addAll(panel);
	    
	}
	
	
}
