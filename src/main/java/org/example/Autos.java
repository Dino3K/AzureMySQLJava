package org.example;

import java.sql.*;

public class Autos {
    public static void insertarAuto(String marca,String serie,String color, String placa) {
        String url = "jdbc:mysql://azure-mysqlxd.mysql.database.azure.com:3306/consecionario";
        String usuario = "consumidor";
        String contraseña = "nose1234*";

        try {
            Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
            if (conexion != null) {
                String sql = "INSERT INTO autos (marca,serie, color, placa) VALUES ( ?, ?,?,?)";
                PreparedStatement preparedStatement = conexion.prepareStatement(sql);
                preparedStatement.setString(1, marca);
                preparedStatement.setString(2, serie);
                preparedStatement.setString(3, color);
                preparedStatement.setString(4, placa);
                int filasAfectadas = preparedStatement.executeUpdate();
                if (filasAfectadas > 0) {
                    System.out.println("Auto insertado correctamente");
                } else {
                    System.out.println("Error al insertar el auto");
                }

                preparedStatement.close();
                conexion.close();
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar o insertar: " + e.getMessage());
        }

    }
    public static void mostrarAutos() {
        String url = "jdbc:mysql://azure-mysqlxd.mysql.database.azure.com:3306/consecionario";
        String usuario = "consumidor";
        String contraseña = "nose1234*";

        try {
            Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
            if (conexion != null) {
                String sql = "SELECT * FROM autos";  // Select all columns from autos table
                Statement statement = conexion.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);

                System.out.println(" | Marca | Serie | Color | Placa |");
                System.out.println("---------------------------------");
                while (resultSet.next()) {
                    String marca = resultSet.getString("marca");
                    String serie = resultSet.getString("serie");
                    String color = resultSet.getString("color");
                    String placa = resultSet.getString("placa");

                    System.out.println(" | " + marca + " | " + serie + " | " + color + " | " + placa + " |");
                }

                resultSet.close();
                statement.close();
                conexion.close();
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar o mostrar autos: " + e.getMessage());
        }
    }
    public static void eliminarAutoPP(String placa) {
        String url = "jdbc:mysql://azure-mysqlxd.mysql.database.azure.com:3306/consecionario";
        String usuario = "consumidor";
        String contraseña = "nose1234*";

        try {
            Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
            if (conexion != null) {
                String sql = "DELETE FROM autos WHERE placa = ?";
                PreparedStatement preparedStatement = conexion.prepareStatement(sql);
                preparedStatement.setString(1, placa);

                int filasAfectadas = preparedStatement.executeUpdate();
                if (filasAfectadas > 0) {
                    System.out.println("Auto con placa " + placa + " eliminado correctamente");
                } else {
                    System.out.println("No se encontró ningún auto con la placa " + placa);
                }

                preparedStatement.close();
                conexion.close();
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar el auto: " + e.getMessage());
        }
    }
    public static void actualizarCPP(String placa, String nuevoColor) {
        String url = "jdbc:mysql://azure-mysqlxd.mysql.database.azure.com:3306/consecionario";
        String usuario = "consumidor";
        String contraseña = "nose1234*";

        try {
            Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
            if (conexion != null) {
                String sql = "UPDATE autos SET color = ? WHERE placa = ?";
                PreparedStatement preparedStatement = conexion.prepareStatement(sql);
                preparedStatement.setString(1, nuevoColor);
                preparedStatement.setString(2, placa);

                int filasAfectadas = preparedStatement.executeUpdate();
                if (filasAfectadas > 0) {
                    System.out.println("El color del auto con placa " + placa + " se ha actualizado a " + nuevoColor);
                } else {
                    System.out.println("No se encontró ningún auto con la placa " + placa);
                }

                preparedStatement.close();
                conexion.close();
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar el color del auto: " + e.getMessage());
        }
    }


}
