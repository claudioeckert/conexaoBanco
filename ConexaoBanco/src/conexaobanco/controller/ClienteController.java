package conexaobanco.controller;

import conexaoBanco.Conexao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteController {

    public boolean inserir() {
        String sql = "INSERT INTO cliente (nome,codigo) VALUES ('Claudio',7)";
        PreparedStatement ps;
        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.execute();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static void main(String[] args) {
        ClienteController novo = new ClienteController();
        novo.inserir();

    }

}
