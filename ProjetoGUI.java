import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Usuario {

    private int id;
    private String nome;
    private String senha;


    public Usuario(int id, String nome, String senha) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void gravarUsuario(){
        try{
            TesteBd.insereUsuario(this);
        } catch (SQLException ex){
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String toString() {
        return "Usuario [id=" + id + ", nome=" + nome + ", senha=" + senha + "]";
    }

}
