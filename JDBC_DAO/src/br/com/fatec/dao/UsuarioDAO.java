package br.com.fatec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fatec.factory.ConnectionFactory;
import br.com.fatec.model.Usuario;

public class UsuarioDAO {
   
    public static void insere(Usuario user) throws SQLException{
        String sql= "INSERT INTO usuarios(nome,login,senha) VALUES (?,?,?)";
        Connection conn=null;
        PreparedStatement pstm=null;
        
        try{
            //criar uma conexão com o BD
            conn= ConnectionFactory.createConnection();
            //Preparando a query
            pstm= (PreparedStatement) conn.prepareStatement(sql);
           // indicar as substituições na query- noem, login e senha do usuário
            pstm.setString(1,user.getNome());
            pstm.setString(2, user.getLogin());
            pstm.setString(3,user.getSenha());
            //Executando a query
             pstm.execute();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(pstm!= null) pstm.close();
            if(conn!=null) conn.close();
        }
    }
    
    public static void excluiPeloId(int id) throws SQLException {
    	String sql = "DELETE FROM usuarios WHERE id = ?";
    	
    	Connection conn = null;
    	PreparedStatement pstm = null;
    	
    	try {
    		conn = ConnectionFactory.createConnection();
    		pstm = conn.prepareStatement(sql);
    		pstm.setLong(1, id);
    		pstm.execute();
    	} catch (Exception e) {
    		e.printStackTrace();
    	} finally {
    		if (pstm != null) {
    			pstm.close();
    		}
    		if(conn != null) {
    			conn.close();
    		}
    	}
    }
    
    public static ArrayList<Usuario> lerTodosOsRegistros() throws SQLException {
    	String sql = "SELECT * FROM usuarios";
    	
    	Connection conn = null;
    	PreparedStatement pstm = null;
    	ResultSet query = null;
    	
    	ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    	try {
    		conn = ConnectionFactory.createConnection();
    		pstm = conn.prepareStatement(sql);
    		query = pstm.executeQuery();
    		
    		//Enquanto há dados a serem recuperados, faça...
    		while(query.next()) {
    			Usuario usuario = new Usuario();
    			
    			usuario.setId(query.getLong("id"));
    			usuario.setNome(query.getString("nome"));
    			usuario.setLogin(query.getString("login"));
    			usuario.setSenha(query.getString("senha"));

    			usuarios.add(usuario);
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    	} finally {
    		if (pstm != null) {
    			pstm.close();
    		}
    		if(conn != null) {
    			conn.close();
    		}
    		if(query != null) {
    			query.close();
    		}
    	}
		return usuarios;
    }
 
   public static void atualizaUsuario (Usuario usuario) {
	   String sql = "UPDATE usuarios SET nome = ?, login = ?, senha = ?" + "WHERE id = ?";
	   
	   Connection conn = null;
	   PreparedStatement pstm = null;
	   
	   try {
		   conn = ConnectionFactory.createConnection();
		   pstm = conn.prepareStatement(sql);
		   
		   pstm.setString(1, usuario.getNome());
		   pstm.setString(2, usuario.getLogin());
		   pstm.setString(3, usuario.getSenha());
		  
		   //Busca o id do usuário selecionado
		   pstm.setLong(4, usuario.getId());	   
		   
		   pstm.execute();
	   } catch (Exception e) {
		   e.printStackTrace();
	   } finally {
		   //Fechar as conexões
		   try {
			   if (pstm != null) pstm.close();
			   if (conn != null) conn.close();
		   } catch(Exception e) {
			   e.printStackTrace();
		   }
	   }
   }
}