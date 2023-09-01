import java.util.Scanner;

public class Gerencia {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorEmpleados gestor = new GestorEmpleados();

        while (true) {
            System.out.println("1. Agregar Empleado Por Horas");
            System.out.println("2. Agregar Empleado Asalariado");
            System.out.println("3. Agregar Empleado Comision");
            System.out.println("4. Mostrar Empleados");
            System.out.println("5. Salir");
            System.out.print("Opción: ");
            int opcion = scanner.nextInt();

            if (opcion == 5) {
                break;
            }

            System.out.print("Nombre: ");
            String nombre = scanner.next();
            System.out.print("ID: ");
            int id = scanner.nextInt();
            System.out.print("Sueldo Base: ");
            double sueldoBase = scanner.nextDouble();

            switch (opcion) {
                case 1:
                    System.out.print("Horas Trabajadas: ");
                    int horasTrabajadas = scanner.nextInt();
                    gestor.agregarEmpleado(new EmpleadoPorHoras(nombre, id, sueldoBase, horasTrabajadas));
                    break;
                case 2:
                    gestor.agregarEmpleado(new EmpleadoAsalariado(nombre, id, sueldoBase));
                    break;
                case 3:
                    System.out.print("Ventas Realizadas: ");
                    double ventasRealizadas = scanner.nextDouble();
                    gestor.agregarEmpleado(new EmpleadoComision(nombre, id, sueldoBase, ventasRealizadas));
                    break;
            }
        }

        System.out.println("Empleados registrados:");
        gestor.mostrarEmpleados();
    }
}
