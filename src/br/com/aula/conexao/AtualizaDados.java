package br.com.aula.conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// Essa classe atualiza dados
public class AtualizaDados {
    public static void main(String[] args) {
        Connection conexao = ConexaoDB.conectar();
        if (conexao != null) {
            String sql = "UPDATE alunos SET idade = ? WHERE nome = ?";
            try {
                PreparedStatement stmt = conexao.prepareStatement(sql);

                stmt.setInt(1, 21); 
                stmt.setString(2, "João Silva"); 
                stmt.executeUpdate();


                System.out.println("Dados atualizados!!");
            } catch (SQLException e) {
                System.err.println("Erro ao atualizar dados: " + e.getMessage());
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
