package view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TelaProduto extends Application implements EventHandler<ActionEvent>  {

	private Button btnCadastrar = new Button("CADASTRAR");
	private Button btnBuscar = new Button("BUSCAR");
	private Button btnGravar = new Button("GRAVAR");
	private Button btnSair = new Button("SAIR");
	
	private Label lblTipo = new Label("TIPO");
	private Label lblNome = new Label("NOME");
	private Label lblValor = new Label("VALOR");
	private Label lblIngredientes  = new Label("TIPO");
	
	private TextField txtTipo = new TextField();
	private TextField txtNome = new TextField();
	private TextField txtValor = new TextField();
	private TextField txtIngredientes = new TextField();
	private TextField txtBuscar = new TextField();
	
	
	
	@Override
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		Pane painel = new Pane();
		Scene scn = new Scene(painel, 800, 400);
		
		
		btnCadastrar.relocate(100, 50);
		btnBuscar.relocate(220, 50);
		
		
		lblTipo.relocate(50,100);
		lblNome.relocate(50,150);
		lblValor.relocate(50,200);
		lblIngredientes.relocate(50,250);
		
		txtTipo.relocate(100,100);
		txtNome.relocate(100,150);
		txtValor.relocate(100,200);
		txtIngredientes.relocate(100,250);
		txtBuscar.relocate(300,50);
		
		btnGravar.relocate(100, 300);
		btnSair.relocate(200, 300);
		
		
		
		
		painel.getChildren().add(btnCadastrar);
		painel.getChildren().add(btnBuscar);
		
		painel.getChildren().add(lblTipo);
		painel.getChildren().add(lblNome);
		painel.getChildren().add(lblValor);
		painel.getChildren().add(lblIngredientes);
		
		painel.getChildren().add(txtTipo);
		painel.getChildren().add(txtNome);
		painel.getChildren().add(txtValor);
		painel.getChildren().add(txtIngredientes);
		painel.getChildren().add(txtBuscar);
		
		painel.getChildren().add(btnGravar);
		painel.getChildren().add(btnSair);
		
		stage.setTitle("PRODUTO");
		stage.setScene(scn);
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

	
}
