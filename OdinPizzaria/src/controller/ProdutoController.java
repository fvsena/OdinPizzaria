package controller;

import java.util.List;

import dao.ProdutoDAO;
import model.Ingrediente;
import model.Pizza;
import model.TamanhoPizza;

public class ProdutoController {
	private ProdutoDAO produtoDAO = new ProdutoDAO();
	public void InserirPizza(String sabor, TamanhoPizza tamanho, List<Ingrediente> ingredientes, String nome, float valor) {
		Pizza p = new Pizza();
		p.ingredientes = ingredientes;
		p.nome = nome;
		p.tamanho = tamanho;
		p.valor = valor;
		produtoDAO.adicionarPizza(p);
	}
}
