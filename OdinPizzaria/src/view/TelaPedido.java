package view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TelaPedido extends Application implements EventHandler<ActionEvent>{


	private Label lblTelefone = new Label("TELEFONE");
	private Label lblNome = new Label("NOME");
	private Label lblEndereco= new Label("ENDERECO");
	private Label lblProduto = new Label("PRODUTO");
	private Label lblQuantidade = new Label("QUANTIDADE");
	private Label lblItens = new Label("ITENS");
	private Label lblTaxa = new Label("TAXA DE ENTREGA");
	private Label lblTotal = new Label("TOTAL");
	private Label lblPagamento = new Label("FORMA DE PAGAMENTO");

	private TextField txtTelefone = new TextField();
	private TextField txtNome = new TextField();
	private TextField txtEndereco = new TextField();
	private TextField txtProduto = new TextField();
	private TextField txtQuantidade = new TextField();
	private TextArea txaItens = new TextArea();
	private TextField txtTaxa = new TextField();
	private TextField txtTotal = new TextField();
	private TextField txtPagamento = new TextField();

	private Button btnGravar = new Button();
	private Button btnSair = new Button();	
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub


	}

	@Override
	public void start(Stage Stage) throws Exception {
		// TODO Auto-generated method stub



		lblTelefone.relocate(50,50);
		txtTelefone.relocate(250, 50);

		lblNome.relocate(50,75);
		txtNome.relocate(250, 75);

		lblEndereco.relocate(50,100);
		txtEndereco.relocate(250, 100);

		lblProduto.relocate(50,125);
		txtProduto.relocate(250,125);

		lblQuantidade.relocate(50,250);
		txtQuantidade.relocate(250, 250);

		lblItens.relocate(50,300);
		txaItens.relocate(250, 300);

		lblTaxa.relocate(50,550);
		txtTaxa.relocate(100, 400);

		lblTotal.relocate(50,425);
		txtTotal.relocate(100, 425);

		lblPagamento.relocate(50,500);
		txtPagamento.relocate(100, 500);


		Pane panel = new Pane();
		Stage.setTitle("PEDIDO");
		Scene scn = new Scene(panel, 1000, 700);
		Stage.setScene(scn);
		Stage.show();


		panel.getChildren().add(lblTelefone);
		panel.getChildren().add(lblNome);
		panel.getChildren().add(lblEndereco);
		panel.getChildren().add(lblProduto);
		panel.getChildren().add(lblQuantidade);
		panel.getChildren().add(lblItens);
		panel.getChildren().add(lblTaxa);
		panel.getChildren().add(lblTotal);
		panel.getChildren().add(lblPagamento);


		panel.getChildren().add(txtTelefone);
		panel.getChildren().add(txtNome);

		panel.getChildren().add(txtEndereco);
		panel.getChildren().add(txtProduto);
		panel.getChildren().add(txtQuantidade);
		panel.getChildren().add(txaItens);
		panel.getChildren().add(txtTaxa);
		panel.getChildren().add(txtTotal);
		panel.getChildren().add(txtPagamento);

		panel.getChildren().add(btnGravar);
		panel.getChildren().add(btnSair);
	}


}

