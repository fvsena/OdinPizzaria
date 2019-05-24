package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {
	public int codigo;
	public Date data;
	public float total;
	public boolean entrega;
	public float taxaEntrega;
	public List<ItemPedido> itens = new ArrayList<>();
	
}
