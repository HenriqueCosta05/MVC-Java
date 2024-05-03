package br.com.fatec.testes;

import java.sql.SQLException;

import br.com.fatec.dao.UsuarioDAO;
import br.com.fatec.model.Usuario;

public class TestaInsertBD {
	public static void main(String[] args) throws SQLException {
		UsuarioDAO.insere(new Usuario("Jão Addão", "jao@example.com", "1234"));
	}

}
