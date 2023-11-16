package ParDeHoy;

import java.sql.*;
import java.util.Date;

class DBHelper {
    private static final String URL = "jdbc:mysql://localhost:3306/ventas";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeStatement(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeResultSet(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void ejecutarConsulta(String consulta) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(consulta)) {

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet ejecutarConsultaConResultado(String consulta) {
        try {
            Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(consulta);
            return statement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}

class Producto {
    private int id;
    private String nombre;
    private double precio;
    private int stock;

    public Producto(int id, String nombre, double precio, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public static Producto obtenerProducto(int productoID) {
        String consulta = "SELECT * FROM productos WHERE producto_id = ?";
        try (Connection connection = DBHelper.getConnection();
             PreparedStatement statement = connection.prepareStatement(consulta)) {

            statement.setInt(1, productoID);
            ResultSet resultado = statement.executeQuery();
            if (resultado.next()) {
                return new Producto(resultado.getInt("producto_id"),
                        resultado.getString("nombre"),
                        resultado.getDouble("precio"),
                        resultado.getInt("stock"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Producto obtenerProductoMasVendido() {
        String consulta = "SELECT producto_id, SUM(cantidad_vendida) as total_vendido " +
                "FROM ventas " +
                "GROUP BY producto_id " +
                "ORDER BY total_vendido DESC " +
                "LIMIT 1";
        try (Connection connection = DBHelper.getConnection();
             PreparedStatement statement = connection.prepareStatement(consulta)) {

            ResultSet resultado = statement.executeQuery();
            if (resultado.next()) {
                int productoID = resultado.getInt("producto_id");
                return obtenerProducto(productoID);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

class Vendedor {
    private int id;
    private String nombre;
    private String apellido;
    private double dni;
    private Date nacimiento;
    private Date contratacion;

    public Vendedor(int id, String nombre, String apellido, double dni, Date nacimiento, Date contratacion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.nacimiento = nacimiento;
        this.contratacion = contratacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public double getDni() {
        return dni;
    }

    public void setDni(double dni) {
        this.dni = dni;
    }

    public Date getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    public Date getContratacion() {
        return contratacion;
    }

    public void setContratacion(Date contratacion) {
        this.contratacion = contratacion;
    }

    public Vendedor(String consultaBusqueda) {
        try (Connection connection = DBHelper.getConnection();
             PreparedStatement statement = connection.prepareStatement(consultaBusqueda)) {

            ResultSet resultado = statement.executeQuery();
            if (resultado.next()) {
                this.id = resultado.getInt("vendedor_id");
                this.nombre = resultado.getString("nombre");
                this.apellido = resultado.getString("apellido");
                this.dni = resultado.getDouble("dni");
                this.nacimiento = resultado.getDate("fecha_nacimiento");
                this.contratacion = resultado.getDate("fecha_contrato");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Vendedor obtenerVendedorPorID(int vendedorID) {
        String consulta = "SELECT * FROM vendedores WHERE vendedor_id = ?";
        try (Connection connection = DBHelper.getConnection();
             PreparedStatement statement = connection.prepareStatement(consulta)) {

            statement.setInt(1, vendedorID);
            ResultSet resultado = statement.executeQuery();
            if (resultado.next()) {
                return new Vendedor(resultado.getString("vendedor_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

class Comerciales {
    public static void generarInforme() {
        String consulta = "SELECT * FROM productos";
        try (Connection connection = DBHelper.getConnection();
             PreparedStatement statement = connection.prepareStatement(consulta)) {

            ResultSet resultSet = statement.executeQuery();

            System.out.println("Informe de Productos en Stock:");
            System.out.println("Producto\t\tStock\tPrecio\tTotal");
            System.out.println("--------------------------------------------");

            double valorTotalProductos = 0;

            while (resultSet.next()) {
                int stock = resultSet.getInt("stock");
                double precio = resultSet.getDouble("precio");
                double valorTotal = stock * precio;

                valorTotalProductos += valorTotal;

                System.out.printf("%-20s\t%d\t%.2f\t%.2f\n",
                        resultSet.getString("nombre"),
                        stock,
                        precio,
                        valorTotal);
            }

            System.out.println("--------------------------------------------");
            System.out.printf("Total:\t\t\t\t\t%.2f\n", valorTotalProductos);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
