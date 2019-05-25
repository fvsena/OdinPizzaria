package view;

import controller.UsuarioController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Usuario;

public class TelaLogin extends Application implements EventHandler<ActionEvent>{

	UsuarioController controller = new UsuarioController();
	
	private Label lblUsuario = new Label("Usuário: ");
	private Label lblSenha = new Label("Senha: ");
	private Label lblEsqueciASenha = new Label("Esqueci a senha");
	private Button btnAcessar = new Button("Acessar");
	private Button btnSair = new Button("Sair");
	private TextField txtUsuario = new TextField();
	private TextField txtSenha = new TextField();
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	public void start(Stage stage) throws Exception {
		Pane painel = new Pane();
		Scene scn = new Scene(painel, 400, 200);
		
		lblUsuario.relocate(180, 100);
		txtUsuario.relocate(230, 100);
		lblSenha.relocate(180, 130);
		txtSenha.relocate(230, 130);
		lblEsqueciASenha.relocate(230, 160);
		btnSair.relocate(10, 160);
		btnAcessar.relocate(320, 160);
		
		painel.getChildren().add(lblUsuario);
		painel.getChildren().add(lblSenha);
		painel.getChildren().add(lblEsqueciASenha);
		painel.getChildren().add(btnAcessar);
		painel.getChildren().add(txtUsuario);
		painel.getChildren().add(txtSenha);
		painel.getChildren().add(btnSair);
		
		btnSair.addEventFilter(ActionEvent.ACTION, this);
		btnAcessar.addEventFilter(ActionEvent.ACTION, this);
		
		stage.setScene(scn);
		stage.initStyle(StageStyle.UNDECORATED);
		stage.show();
	}

	@Override
	public void handle(ActionEvent event) {
		if (event.getTarget() == btnSair) {
			fechar();
		}
		if (event.getTarget() == btnAcessar) {
			logar();
		}
	}

	private void fechar() {
		try {
			Platform.exit();
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void logar() {
		try {
			Usuario usuario = new Usuario(txtUsuario.getText(), txtSenha.getText());
			controller.validarLogin(usuario);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
