package model;

public class Usuario {
	public String login;
	public String senha;
	public String caminhoImagem;
	public TipoAcesso tipoAcesso;
	
	public Usuario(String login, String senha) {
		this.login = login;
		this.senha = senha;
	}
}
