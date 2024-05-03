package br.com.fatec.testes;

import java.sql.SQLException;

import br.com.fatec.dao.UsuarioDAO;

public class TestaDeleteByID {
	public static void main(String[] args) throws SQLException {
		UsuarioDAO.excluiPeloId(1);
	}
}
