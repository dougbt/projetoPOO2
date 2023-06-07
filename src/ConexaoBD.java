import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexaoBD {

    static String url = "jdbc:mysql://localhost:3306/teste";

    private static void conectaBD(){
        Connection con = null;

        try{
            con = (Connection) DriverManager.getConnection(url, "root", "anhanguera");
            Statement stm = con.createStatement();
            String sql = "SELECT * FROM usuario";
            ResultSet rs = stm.executeQuery(sql);

            while(rs.next()){
                System.out.println(rs.getString("nome"));
            }
        } catch(SQLException ex){
            Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            if(con != null){
                try{
                    con.close();
                } catch(SQLException ex){
                    Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
