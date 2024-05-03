package br.com.fatec.testes;

import br.com.fatec.dao.UsuarioDAO;
import br.com.fatec.model.Usuario;

public class TestaUpdateBD {
	public static void main(String[] args) {
		UsuarioDAO.atualizaUsuario(new Usuario(3, "Henrique Benedicto", "henrique@example.com", "1234"));
	}
}
