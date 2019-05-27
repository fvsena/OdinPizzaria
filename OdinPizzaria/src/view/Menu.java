package view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Menu extends Application implements EventHandler<ActionEvent>{

	private Button btnCliente =  new Button("CLIENTE");
	private Button btnPedido = new Button("PEDIDO");
	private Button btnProduto = new Button("PRODUTO");
	
	
	
	@Override
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub
	
		
	}

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		Pane painel = new Pane();
		Scene scn = new Scene(painel, 800, 400);
		btnCliente.relocate(50, 50);
		btnPedido.relocate(300,50);
		btnProduto.relocate(550, 50);
		
		painel.getChildren().add(btnCliente);
		painel.getChildren().add(btnPedido);
		painel.getChildren().add(btnProduto);
		
		btnCliente.setMinWidth(200);
		btnCliente.setMinHeight(50);
		
		btnPedido.setMinWidth(200);
		btnPedido.setMinHeight(50);

		btnProduto.setMinWidth(200);
		btnProduto.setMinHeight(50);
		
		stage.setTitle("MENU");
		
		stage.setScene(scn);
		stage.show();
		
		
		
		
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	

}
