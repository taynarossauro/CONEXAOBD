package br.com.aula.conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// Essa classe deleta dados
public class DeletaDados {
    public static void main(String[] args) {
        Connection conexao = ConexaoDB.conectar();
        if (conexao != null) {
            String sql = "DELETE FROM alunos WHERE nome = ?";
            try {
                PreparedStatement stmt = conexao.prepareStatement(sql);

                stmt.setString(1, "João Silva");
                stmt.executeUpdate();


                System.out.println("Os dados foram deletados!");
            } catch (SQLException e) {
                System.err.println("Erro ao deletar dados: " + e.getMessage());
            } finally {
                try {
                    if (conexao != null) conexao.close();
                } catch (SQLException e) {
                    System.err.println("Erro ao fechar conexão: " + e.getMessage());
                }
            }
        }
    }
}
