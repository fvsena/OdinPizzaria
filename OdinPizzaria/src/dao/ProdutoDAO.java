package dao;

import java.util.ArrayList;
import java.util.List;

import model.Pizza;

public class ProdutoDAO {
	private List<Pizza> pizzas = new ArrayList();
	
	public void adicionarPizza(Pizza p) {
		this.pizzas.add(p);
	}
}
