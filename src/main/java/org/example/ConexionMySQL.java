package org.example;

import java.sql.*;

public class ConexionMySQL {
    public static void main(String[] args) {
        String url = "jdbc:mysql://azure-mysqlxd.mysql.database.azure.com:3306/consecionario";
        String usuario = "consumidor";
        String contraseña = "nose1234*";

        try {
            Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
            if (conexion != null) {
                System.out.println("Conexión establecida con éxito");
                conexion.close();
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar: " + e.getMessage());
        }
    }
}