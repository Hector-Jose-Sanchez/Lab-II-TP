package CursoJava.BasesDeDatos;

import java.sql.*;
import java.util.Scanner;

public class Estudiantes {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/universidad";
        String usuario = "root";
        String pass = "";

        try {
            Connection conexion = DriverManager.getConnection(url, usuario, pass);

            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("Seleccione una opción:");
                System.out.println("1. Mostrar estudiantes");
                System.out.println("2. Agregar estudiante");
                System.out.println("3. Borrar estudiante");
                System.out.println("4. Salir");

                int opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        mostrarEstudiantes(conexion);
                        break;
                    case 2:
                        agregarEstudiante(conexion, scanner);
                        break;
                    case 3:
                        borrarEstudiante(conexion, scanner);
                        break;
                    case 4:
                        System.out.println("Saliendo del programa.");
                        conexion.close();
                        System.exit(0);
                    default:
                        System.out.println("Opción no válida. Intente nuevamente.");
                        break;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void mostrarEstudiantes(Connection conexion) throws SQLException {
        Statement statement = conexion.createStatement();
        String consulta = "SELECT * FROM estudiantes";
        ResultSet resultado = statement.executeQuery(consulta);

        while (resultado.next()) {
            int id = resultado.getInt("id");
            String nombre = resultado.getString("nombre");
            String apellido = resultado.getString("apellido");
            String legajo = resultado.getString("legajo");
            String dni = resultado.getString("dni");

            System.out.println("ID: " + id);
            System.out.println("Nombre: " + nombre);
            System.out.println("Apellido: " + apellido);
            System.out.println("Legajo: " + legajo);
            System.out.println("DNI: " + dni);
            System.out.println("-----------------------");
        }

        resultado.close();
        statement.close();
    }

    private static void agregarEstudiante(Connection conexion, Scanner scanner) throws SQLException {
        System.out.println("Ingrese el nombre del estudiante:");
        String nombre = scanner.next();
        System.out.println("Ingrese el apellido del estudiante:");
        String apellido = scanner.next();
        System.out.println("Ingrese el legajo del estudiante:");
        String legajo = scanner.next();
        System.out.println("Ingrese el DNI del estudiante:");
        String dni = scanner.next();

        String consulta = "INSERT INTO estudiantes (nombre, apellido, legajo, dni) VALUES (?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(consulta)) {
            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, apellido);
            preparedStatement.setString(3, legajo);
            preparedStatement.setString(4, dni);

            int filasAfectadas = preparedStatement.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Estudiante agregado correctamente.");
            } else {
                System.out.println("No se pudo agregar el estudiante.");
            }
        }
    }

    private static void borrarEstudiante(Connection conexion, Scanner scanner) throws SQLException {
        System.out.println("Ingrese el ID del estudiante a borrar:");
        int id = scanner.nextInt();

        String consulta = "DELETE FROM estudiantes WHERE id = ?";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(consulta)) {
            preparedStatement.setInt(1, id);

            int filasAfectadas = preparedStatement.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Estudiante borrado correctamente.");
            } else {
                System.out.println("No se pudo borrar el estudiante. Verifique el ID.");
            }
        }
    }
}
