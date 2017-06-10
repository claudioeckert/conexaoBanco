package conexaoBanco;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao {

    private static Connection conn;
    private final static String driver = "org.postgresql.Driver";//sempre assim para o postgreeSQL
    private final static String ip = "localhost/";//banco nesta maquina, ou IP do computador que contem o banco
    public static String dataBase = "aula";//nome da base de dados no postegreeSQL
    public static String user = "postgres";//usuario do banco de dados
    public static String password = "postgres";//senha para o usuario

    public Conexao(Connection conn) {
        this.conn = conn;
    }

    public static Connection getConexao() throws SQLException, ClassNotFoundException {

        if (conn != null) {// se já existe conexão aberta retorna ela mesma em vez de criiar uma nova
            return conn;
        }

        Class.forName(driver);//não mexer -- definindo o jdbc utilizado
        conn = java.sql.DriverManager.getConnection("jdbc:postgresql://" + ip + dataBase, user, password);//não mexer -- definindo os parametros de conexão
        return conn;

    }

    public static void fechaConexao() {
        try {
            conn.close();
            conn = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            getConexao();
            System.out.println("Feito!");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
// chift + f6 executa so esta classe