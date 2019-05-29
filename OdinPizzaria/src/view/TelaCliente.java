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

public class TelaCliente extends Application implements EventHandler<ActionEvent> {

	private Label lblNome = new Label("NOME");
	private TextField txtNome = new TextField();
	private Label lblCpf = new Label("CPF");
	private TextField txtCpf = new TextField();
	private Label lblTelefone = new Label("TELEFONE");
	private TextField txtTelefone = new TextField();
	private Label lblCep = new Label("CEP");
	private TextField txtCep = new TextField();
	
	private Button btnSair = new Button("SAIR");
	private Button btnGravar = new Button("GRAVAR");
	
	private void gravarCliente(){
		String nome = txtNome.getText();
		String cep = txtCep.getText();
		String cpf = txtCpf.getText();
		String telefone = txtTelefone.getText();
		
	}
	
	
	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		
		if (event.getTarget()== btnGravar){
			
			
		}
		if (event.getTarget()==btnSair) {
			
		}
		}

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		
		Pane painel = new Pane();
		Scene scn = new Scene(painel, 800, 400);
		
		lblNome.relocate(50,50);
		txtNome.relocate(100, 50);
		lblCpf.relocate(50,100);
		txtCpf.relocate(100, 100);
		lblTelefone.relocate(50, 150);
		txtTelefone.relocate(100, 150);
		lblCep.relocate(50, 200);
		txtCep.relocate(100, 200);
		btnSair.relocate(100,250);
		btnGravar.relocate(250,250);
		
		painel.getChildren().add(lblNome);
		painel.getChildren().add(lblCpf);
		painel.getChildren().add(lblTelefone);
		painel.getChildren().add(lblCep);
		painel.getChildren().add(txtNome);
		painel.getChildren().add(txtCpf);
		painel.getChildren().add(txtTelefone);
		painel.getChildren().add(txtCep);
		painel.getChildren().add(btnSair);
		painel.getChildren().add(btnGravar);
		
		stage.setTitle("CLIENTE");
		stage.setScene(scn);
		stage.show();
		
		
		btnGravar.addEventFilter(ActionEvent.ACTION,this);
		btnSair.addEventFilter(ActionEvent.ACTION,this);
		
		
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	


}
