
package br.com.fatec.model;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Persistencia {
    private static ArrayList<Usuario> lista = new ArrayList<>();
    private static ArrayList<Produto> produto = new ArrayList<>();

    public static ArrayList<Produto> getProduto() {
        return produto;
    }

    public static void setProduto(ArrayList<Produto> produto) {
        Persistencia.produto = produto;
    }
    

    public static ArrayList<Usuario> getLista() {
        return lista;
    }

    public static void setLista(ArrayList<Usuario> aLista) {
        lista = aLista;
    }
    
    
    public boolean cadastrar(Usuario user){
        if(user != null){
            lista.add(user);
                    return true;
        }else{
            return false;
        }}
        
    public void excluir(long id){    
    
        lista.forEach((Usuario user) -> {
            if(user.getId() == id){
                lista.remove(user);
            }else{
                JOptionPane.showMessageDialog(null,"Usuario não encontrado");
            }
        });
    }
    
    public boolean alterar(Usuario alteruser){
        lista.forEach((Usuario user) -> {
            if(!lista.isEmpty() && user.getId() == alteruser.getId()){
                user.setNome(alteruser.getNome());
                user.setLogin(alteruser.getLogin());
                user.setSenha(alteruser.getSenha());
            } else{
                JOptionPane.showMessageDialog(null, "Usuario inexistente");
            }
        });
        
        return true;
    }
    public void  listar(Usuario user){
        if(lista.isEmpty()){
         JOptionPane.showMessageDialog(null,"Não contem resgistros");
        }else{
         JOptionPane.showMessageDialog(null, lista);
        }
           
  
    }
    
    public boolean cadastrarProduto(Produto product){
        if(product != null){
            produto.add(product);
                    return true;
        }else{
            return false;
        }}
        
    public void excluirProduto(String codigo){    
    
        produto.forEach((Produto product) -> {
            if(product.getCodigo().equalsIgnoreCase(codigo)){
                produto.remove(product);
            }else{
                JOptionPane.showMessageDialog(null,"Usuario não encontrado");
            }
        });
    }
    
    public boolean alterarProduto(Produto newProduct){
        produto.forEach((Produto product) -> {
            if(!produto.isEmpty() && product.getCodigo().equalsIgnoreCase(newProduct.getCodigo()) ){
                product.setNome(newProduct.getNome());
                product.setFornecedor(newProduct.getFornecedor());
            } else{
                JOptionPane.showMessageDialog(null, "Produto inexistente");
            }
        });
        
        return true;
    }
    public void  listarProduto(Produto product){
        if(produto.isEmpty()){
         JOptionPane.showMessageDialog(null,"Não contem registros");
        }else{
         JOptionPane.showMessageDialog(null, produto);
        }
    }
    
    public static void importar(String nomeDoArquivo){
        try {
            FileReader arq = new FileReader(nomeDoArquivo);
            BufferedReader lerArq = new BufferedReader(arq);
            String id, nome, login, senha;//criando strings para armazenamento das informações do usuario
            id = lerArq.readLine();
            while (id != null) {
                nome = lerArq.readLine();
                login = lerArq.readLine();
                senha = lerArq.readLine();
                lista.add(new Usuario(nome,login,senha));
                id = lerArq.readLine();
                }
            arq.close();} 
        catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.",e.getMessage());
}
    }
    
    public static void exportar(String nomeDoArquivo) throws IOException{
        FileWriter arq = new FileWriter(nomeDoArquivo);
        PrintWriter gravarArq = new PrintWriter(arq);
        for(Usuario user:lista){
            gravarArq.print(user);
        }
        gravarArq.close();
    }
    }