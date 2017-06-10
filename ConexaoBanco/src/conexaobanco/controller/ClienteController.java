package conexaobanco.controller;

import conexaoBanco.Conexao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteController {

    public boolean inserir(int cod, String nm) {
        String sql = "INSERT INTO cliente (nome,codigo) VALUES (?,?)";//define instrução SQL
        PreparedStatement ps;
        try {
            ps = Conexao.getConexao().prepareStatement(sql);//prepara a instrução SQL
            ps.setString(1, nm);//primeiro parametro indica a ? correspondente, segundo parâmentro a variavel que substituirá a ?
            ps.setInt(2, cod);//primeiro parametro indica a ? correspondente, segundo parâmentro a variavel que substituirá a ?
            ps.execute();//executa SQL preparada
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static void main(String[] args) {
        ClienteController novo = new ClienteController();
        novo.inserir(11,"Pietra");

    }

}
