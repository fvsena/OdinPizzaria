package model;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	public String nome;
	public int telefone;
	public String cpf;
	public List<Endereco> enderecos = new ArrayList<>();
}
