package br.com.fatec.testes;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fatec.dao.UsuarioDAO;
import br.com.fatec.model.Usuario;

public class TestaLerTodosRegistros {
	public static void main(String[] args) throws SQLException {
		ArrayList<Usuario> usuarios = UsuarioDAO.lerTodosOsRegistros();
		System.out.println(usuarios);
	}
}
