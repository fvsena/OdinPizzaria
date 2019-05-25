package controller;

import dao.UsuarioDAO;
import model.Usuario;

public class UsuarioController {
	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	public void validarLogin(Usuario usuario) {
		if (usuarioDAO.validarLogin(usuario)) {
			System.out.println("Logado");
		}
		else {
			System.out.println("Usuário ou senha inválidos");
		}
	}
}
