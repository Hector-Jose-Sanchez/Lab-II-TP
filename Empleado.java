import java.util.ArrayList;
import java.util.Scanner;

// Definición de la clase abstracta Empleado
abstract class Empleado {
    protected String nombre;
    protected int id;
    protected double sueldoBase;

    public Empleado(String nombre, int id, double sueldoBase) {
        this.nombre = nombre;
        this.id = id;
        this.sueldoBase = sueldoBase;
    }

    // Método abstracto para calcular el sueldo
    abstract double calcularSueldo();
}

// Clase concreta EmpleadoPorHoras
class EmpleadoPorHoras extends Empleado {
    private int horasTrabajadas;

    public EmpleadoPorHoras(String nombre, int id, double sueldoBase, int horasTrabajadas) {
        super(nombre, id, sueldoBase);
        this.horasTrabajadas = horasTrabajadas;
    }

    @Override
    double calcularSueldo() {
        return sueldoBase * horasTrabajadas;
    }
}

// Clase concreta EmpleadoAsalariado
class EmpleadoAsalariado extends Empleado {
    public EmpleadoAsalariado(String nombre, int id, double sueldoBase) {
        super(nombre, id, sueldoBase);
    }

    @Override
    double calcularSueldo() {
        return sueldoBase;
    }
}

// Clase concreta EmpleadoComision
class EmpleadoComision extends Empleado {
    private double ventasRealizadas;

    public EmpleadoComision(String nombre, int id, double sueldoBase, double ventasRealizadas) {
        super(nombre, id, sueldoBase);
        this.ventasRealizadas = ventasRealizadas;
    }

    @Override
    double calcularSueldo() {
        return sueldoBase + (0.1 * ventasRealizadas); // 10% de comisión
    }
}

// Definición de la interfaz Impuesto
interface Impuesto {
    double calcularImpuesto();
}

// Clase GestorEmpleados
class GestorEmpleados {
    private ArrayList<Empleado> empleados;

    public GestorEmpleados() {
        empleados = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public void mostrarEmpleados() {
        for (Empleado empleado : empleados) {
            System.out.println("Nombre: " + empleado.nombre);
            System.out.println("ID: " + empleado.id);
            System.out.println("Sueldo: " + empleado.calcularSueldo());
            if (empleado instanceof Impuesto) {
                System.out.println("Impuesto: " + ((Impuesto) empleado).calcularImpuesto());
            }
            System.out.println("----------");
        }
    }
}
