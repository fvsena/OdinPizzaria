package view;

import java.util.Arrays;

import controller.ProdutoController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Ingrediente;
import model.TamanhoPizza;

public class TelaProduto extends Application implements EventHandler<ActionEvent>  {

	private ProdutoController controller = new ProdutoController();
	private Button btnCadastrar = new Button("CADASTRAR");
	private Button btnBuscar = new Button("BUSCAR");
	private Button btnGravar = new Button("GRAVAR");
	private Button btnSair = new Button("SAIR");

	private Label lblTipo = new Label("TIPO");
	private Label lblNome = new Label("NOME");
	private Label lblValor = new Label("VALOR");
	private Label lblIngredientes  = new Label("TIPO");
	private Label lblTamanho  = new Label("TAMANHO");

	private TextField txtTipo = new TextField();
	private TextField txtNome = new TextField();
	private TextField txtValor = new TextField();
	private TextField txtIngredientes = new TextField();
	private TextField txtBuscar = new TextField();
	
	private TableView<Ingrediente> tblIngredientes = new TableView<>();
	
	ObservableList<String> tipoProduto = FXCollections.observableArrayList(
				"PIZZA",
				"BEBIDA"
			);
	
	ObservableList<String> tamanhoPizza = FXCollections.observableArrayList(
			"BROTO",
			"MÉDIA",
			"GRANDE"
		);

	final ComboBox cmbTipoProduto = new ComboBox(tipoProduto);
	final ComboBox cmbTamanho = new ComboBox(tamanhoPizza);

	@Override
	public void handle(ActionEvent event) {
		if (event.getTarget() == btnCadastrar) {
			habilitarControles(false);
		}
		if (event.getTarget() == btnBuscar) {
			//logar();
		}
		if (event.getTarget() == btnGravar) {
			//logar();
		}
		if (event.getTarget() == btnSair) {
			fechar();
		}

	}

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		Pane painel = new Pane();
		Scene scn = new Scene(painel, 800, 400);


		btnCadastrar.relocate(100, 50);
		btnBuscar.relocate(220, 10);
		lblTipo.relocate(50,100);
		lblNome.relocate(50,150);
		lblValor.relocate(50,200);
		lblIngredientes.relocate(50,250);
		lblTamanho.relocate(50, 300);
		cmbTipoProduto.relocate(120,100);
		txtNome.relocate(120,150);
		txtValor.relocate(120,200);
		txtIngredientes.relocate(120,250);
		cmbTamanho.relocate(120, 300);
		txtBuscar.relocate(50,10);
		btnGravar.relocate(120, 350);
		btnSair.relocate(200, 350);

		painel.getChildren().add(btnCadastrar);
		painel.getChildren().add(btnBuscar);
		painel.getChildren().add(lblTipo);
		painel.getChildren().add(lblNome);
		painel.getChildren().add(lblValor);
		painel.getChildren().add(lblIngredientes);
		painel.getChildren().add(lblTamanho);
		painel.getChildren().add(cmbTipoProduto);
		painel.getChildren().add(cmbTamanho);
		painel.getChildren().add(txtNome);
		painel.getChildren().add(txtValor);
		painel.getChildren().add(txtIngredientes);
		painel.getChildren().add(txtBuscar);
		painel.getChildren().add(btnGravar);
		painel.getChildren().add(btnSair);
		
		btnCadastrar.addEventFilter(ActionEvent.ACTION, this);
		btnBuscar.addEventFilter(ActionEvent.ACTION, this);
		btnGravar.addEventFilter(ActionEvent.ACTION, this);
		btnSair.addEventFilter(ActionEvent.ACTION, this);
		
		habilitarControles(true);
		
		stage.setTitle("PRODUTO");
		stage.setScene(scn);
		stage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

	private void habilitarControles(boolean habilitar) {
		lblTipo.setDisable(habilitar);
		lblNome.setDisable(habilitar);
		lblValor.setDisable(habilitar);
		lblIngredientes.setDisable(habilitar);
		lblTamanho.setDisable(habilitar);
		cmbTipoProduto.setDisable(habilitar);
		cmbTamanho.setDisable(habilitar);
		txtNome.setDisable(habilitar);
		txtValor.setDisable(habilitar);
		txtIngredientes.setDisable(habilitar);
	}
	
	private void fechar() {
		try {
			Platform.exit();
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void InserirPizza() {
		if(validaCamposPreenchidos()) {
			//controller.InserirPizza(txtNome.getText(), cmbTamanho.getValue().toString(), txtIngredientes.getText(), txtNome.getText(), Float.parseFloat(txtValor.getText()));
		}
		//controller.InserirPizza(txtNome, tamanho, ingredientes, nome, valor);
	}

	private boolean validaCamposPreenchidos() {
		boolean valido = true;
		if(cmbTipoProduto.getValue()== null
				|| txtNome.getText() == null
				|| txtValor.getText() == null
				|| txtIngredientes.getText() == null) {
			valido = false;
		}
		return valido;
	}
}
