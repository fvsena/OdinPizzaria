package model;

import java.util.ArrayList;
import java.util.List;

public class Pizza extends Produto {
	public String sabor;
	public TamanhoPizza tamanho;
	public List<Ingrediente> ingredientes = new ArrayList<>();
	
	public boolean adicionarIngrediente(Ingrediente ingrediente) {
		boolean existente = ingredientes.contains(ingrediente);
		if (!existente) {
			ingredientes.add(ingrediente);
		}
		return !existente;
	}
	
	public boolean removerIngrediente(Ingrediente ingrediente) {
		boolean existente = ingredientes.contains(ingrediente);
		if (existente) {
			ingredientes.remove(ingrediente);
		}
		return existente;
	}
	
}
