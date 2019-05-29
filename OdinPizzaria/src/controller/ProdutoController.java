package controller;

import java.util.List;

import dao.ProdutoDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Ingrediente;
import model.Pizza;
import model.TamanhoPizza;

public class ProdutoController {
	private ProdutoDAO produtoDAO = new ProdutoDAO();
	private ObservableList<Pizza> listaPizzas = FXCollections.observableArrayList();
	
	public void InserirPizza(String sabor, TamanhoPizza tamanho, List<Ingrediente> ingredientes, String nome, float valor) {
		Pizza p = new Pizza();
		p.sabor = sabor;
		p.ingredientes = ingredientes;
		p.nome = nome;
		p.tamanho = tamanho;
		p.valor = valor;
		produtoDAO.adicionarPizza(p);
		listaPizzas.clear();
		listaPizzas.addAll(produtoDAO.obterPizzas());
	}
	
	public ObservableList<Pizza> obterPizzas(){
		return this.listaPizzas;
	}
	
	public void buscarPizza(String nome) {
		if (nome.isEmpty() || nome == null) {
			obterPizzas();
			return;
		}
		listaPizzas.clear();
		for (Pizza pizza : listaPizzas) {
			if (pizza.sabor.contains(nome)) {
				listaPizzas.add(pizza);
			}
		}
	}
}
