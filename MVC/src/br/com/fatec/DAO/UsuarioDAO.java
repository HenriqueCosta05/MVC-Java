
package br.com.fatec.DAO;

import br.com.fatec.factory.ConnectionFactory;
import br.com.fatec.model.Usuario;
import java.sql.*;

public class UsuarioDAO {
    
    public void insert(Usuario user)throws SQLException{
        String sql = "INSERT INTO usuarios(nome,login,senha) VALUES(?,?,?)";
        Connection conn=null;
        PreparedStatement pstm = null;
        try{
            conn = ConnectionFactory.createConnection();
            pstm = (PreparedStatement) conn.prepareCall(sql);
            
            pstm.setString(1, user.getNome());
            pstm.setString(2, user.getLogin());
            pstm.setString(3, user.getSenha());
            pstm.execute();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(pstm!=null)pstm.close();
            if(conn!=null)conn.close();
        }
        
    }
    
}
