package view;

import java.util.ArrayList;
import java.util.List;

import controller.ProdutoController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.property.ReadOnlyDoubleWrapper;
import javafx.beans.property.ReadOnlyFloatProperty;
import javafx.beans.property.ReadOnlyFloatWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Ingrediente;
import model.Pizza;
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
	private Label lblIngredientes  = new Label("INGREDIENTES");
	private Label lblTamanho  = new Label("TAMANHO");

	private TextField txtNome = new TextField();
	private TextField txtValor = new TextField();
	private TextField txtIngredientes = new TextField();
	private TextField txtBuscar = new TextField();
	
	private TableView<Pizza> tblPizzas = new TableView<>();
	
	ObservableList<String> tipoProduto = FXCollections.observableArrayList(
				"PIZZA",
				"BEBIDA"
			);
	
	ObservableList<String> tamanhoPizza = FXCollections.observableArrayList(
			"BROTO",
			"MEDIA",
			"GRANDE"
		);

	final ComboBox cmbTipoProduto = new ComboBox(tipoProduto);
	final ComboBox<String> cmbTamanho = new ComboBox<>(tamanhoPizza);

	@Override
	public void handle(ActionEvent event) {
		if (event.getTarget() == btnCadastrar) {
			habilitarControles(false);
		}
		if (event.getTarget() == btnBuscar) {
			buscarPizza();
		}
		if (event.getTarget() == btnGravar) {
			InserirPizza();
		}
		if (event.getTarget() == btnSair) {
			fechar();
		}

	}

	@Override
	public void start(Stage stage) throws Exception {
		VBox box = new VBox();
		GridPane grid = new GridPane();
		Scene scn = new Scene(box, 400, 300);
		
		box.getChildren().addAll(grid, tblPizzas);
		tblPizzas.setStyle(STYLESHEET_MODENA);

		popularTabelaPizza();

		grid.add(txtBuscar, 0, 0);
		grid.add(btnBuscar, 1, 0);
		
		grid.add(btnCadastrar, 0, 2);
		
		grid.add(lblTipo, 0, 3);
		grid.add(cmbTipoProduto, 1, 3);
		grid.add(lblNome, 0, 4);
		grid.add(txtNome, 1, 4);
		grid.add(lblIngredientes, 0, 5);
		grid.add(txtIngredientes, 1, 5);
		grid.add(lblTamanho, 0, 6);
		grid.add(cmbTamanho, 1, 6);
		grid.add(lblValor, 0, 7);
		grid.add(txtValor, 1, 7);
		grid.add(btnSair, 0, 9);
		grid.add(btnGravar, 1, 9);
		
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
			List<Ingrediente> ingredientes = new ArrayList<>();
			TamanhoPizza tamanho = Enum.valueOf(TamanhoPizza.class, cmbTamanho.getValue().toString());
			
			controller.InserirPizza(txtNome.getText(), tamanho, ingredientes, txtNome.getText(), Float.parseFloat(txtValor.getText()));
		}
		//controller.InserirPizza(txtNome, tamanho., ingredientes, nome, valor);
	}
	
	private void adicionarIngrediente() {
		
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
	
	private void buscarPizza() {
		String busca = txtBuscar.getText();
		controller.buscarPizza(busca);
	}
	
	private void popularTabelaPizza() {
		tblPizzas.setItems(controller.obterPizzas());
		tblPizzas.getSelectionModel().selectedItemProperty().addListener(
			new ChangeListener<Pizza>() {
				public void changed(ObservableValue<? extends Pizza> p, Pizza p1, Pizza p2) {
					if (p2 == null) {
						//pizzatoboundary(p2)
					}
				}
			});
		TableColumn<Pizza, String> colunaSabor = new TableColumn<>();
		colunaSabor.setCellValueFactory(item -> new ReadOnlyStringWrapper(item.getValue().sabor));
		
		TableColumn<Pizza, Double> colunaValor = new TableColumn<>("Preço");
		colunaValor.setCellValueFactory(
				new PropertyValueFactory<Pizza, Double>("valor"));
		
		
		colunaSabor.setText("SABOR");
		colunaValor.setText("VALOR");
		
		tblPizzas.getColumns().addAll(colunaSabor, colunaValor);
	}
}
