import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Hospital {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        List<Doctor> doctores = new ArrayList<>();
        List<Paciente> pacientes = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        doctores.add(new Doctor("Dr. Juan Pérez", "12345678", dateFormat.parse("10/05/1975"), "Cardiología"));
        doctores.add(new Doctor("Dra. María González", "98765432", dateFormat.parse("25/11/1900"), "Pediatría"));
        doctores.add(new Doctor("Dr. Simon Irondo", "13468728", dateFormat.parse("01/12/2000"), "Ginecologo"));

        do {
            System.out.println("Hospital Julio C. Perrando - Av. 9 de Julio 1100 · 0362 444-2399");
            System.out.println("Menú:");
            System.out.println("1. Listar Doctores.");
            System.out.println("2. Registrar un nuevo paciente.");
            System.out.println("3. Actualizar información personal de un paciente.");
            System.out.println("4. Consultar el historial médico de un paciente.");
            System.out.println("5. Nuevo historial para un paciente.");
            System.out.println("6. Guardar Historial de pacientes en archivo.");
            System.out.println("7. Cargar Historial de pacientes desde archivo.");
            System.out.println("8. Salir.");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> listarDoctores(doctores);
                case 2 -> registrarNuevoPaciente(pacientes);
                case 3 -> actualizarInformacionPaciente(pacientes);
                case 4 -> consultarHistorialMedico(pacientes);
                case 5 -> nuevoHistorialPaciente(pacientes);
                case 6 -> guardarHistorialEnArchivo();
                case 7 -> cargarHistorialDesdeArchivo();
                case 8 -> System.out.println("Saliendo del programa. ¡Hasta luego!");
                default -> System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 8);
        scanner.close();
    }

    private static void listarDoctores(List<Doctor> doctores) {
        System.out.println("Listado de Doctores:");
        for (Doctor doctor : doctores) {
            System.out.println("Nombre: " + doctor.nombre());
            System.out.println("DNI: " + doctor.dni());
            System.out.println("Fecha de Nacimiento: " + doctor.fechaNacimiento());
            System.out.println("Especialidad: " + doctor.especialidad());
            System.out.println();
        }
    }

    private static void registrarNuevoPaciente(List<Paciente> pacientes) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Registro de nuevo paciente:");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("DNI: ");
        String dni = scanner.nextLine();
        System.out.print("Fecha de Nacimiento (dd/MM/yyyy): ");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaNacimiento;
        try {
            fechaNacimiento = dateFormat.parse(scanner.nextLine());
        } catch (ParseException e) {
            System.out.println("Formato de fecha incorrecto. El paciente no se registró.");
            return;
        }
        System.out.print("Número de Teléfono: ");
        String telefono = scanner.nextLine();
        System.out.print("Tipo de Sangre: ");
        String tipoSangre = scanner.nextLine();

        Paciente nuevoPaciente = new Paciente(nombre, dni, fechaNacimiento, telefono, tipoSangre);
        pacientes.add(nuevoPaciente);
        System.out.println("Paciente registrado con éxito.");
    }

    private static void actualizarInformacionPaciente(List<Paciente> pacientes) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el DNI del paciente a actualizar: ");
        String dni = scanner.nextLine();
        Paciente pacienteEncontrado = null;
        for (Paciente paciente : pacientes) {
            if (paciente.dni().equals(dni)) {
                pacienteEncontrado = paciente;
                break;
            }
        }
        if (pacienteEncontrado == null) {
            System.out.println("Paciente no encontrado.");
        } else {
            System.out.println("Actualización de información de paciente:");
            System.out.print("Nuevo Nombre: ");
            pacienteEncontrado.actualizarNombre(scanner.nextLine());
            System.out.print("Nueva Fecha de Nacimiento (dd/MM/yyyy): ");
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date nuevaFechaNacimiento;
            try {
                nuevaFechaNacimiento = dateFormat.parse(scanner.nextLine());
                pacienteEncontrado.actualizarFechaNacimiento(nuevaFechaNacimiento);
            } catch (ParseException e) {
                System.out.println("Formato de fecha incorrecto. La fecha de nacimiento no se actualizó.");
            }
            System.out.println("Información de paciente actualizada con éxito.");
        }
    }

    private static void consultarHistorialMedico(List<Paciente> pacientes) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el DNI del paciente a consultar: ");
        String dni = scanner.nextLine();
        Paciente pacienteEncontrado = null;
        for (Paciente paciente : pacientes) {
            if (paciente.dni().equals(dni)) {
                pacienteEncontrado = paciente;
                break;
            }
        }
        if (pacienteEncontrado == null) {
            System.out.println("Paciente no encontrado.");
        } else {
            System.out.println("HISTORIAL MÉDICO de " + pacienteEncontrado.nombre() + ":");
            for (EventoMedico evento : pacienteEncontrado.historialMedico()) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                String fecha = dateFormat.format(evento.getFecha());
                System.out.println(fecha + " - " + evento.getObservaciones());
            }
        }
    }

    private static void nuevoHistorialPaciente(List<Paciente> pacientes) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el DNI del paciente al que desea agregar un nuevo evento médico: ");
        String dni = scanner.nextLine();
        Paciente pacienteEncontrado = null;
        for (Paciente paciente : pacientes) {
            if (paciente.dni().equals(dni)) {
                pacienteEncontrado = paciente;
                break;
            }
        }
        if (pacienteEncontrado == null) {
            System.out.println("Paciente no encontrado.");
        } else {
            System.out.println("Registro de nuevo evento médico:");
            System.out.print("Fecha (dd/MM/yyyy): ");
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date fecha;
            try {
                fecha = dateFormat.parse(scanner.nextLine());
            } catch (ParseException e) {
                System.out.println("Formato de fecha incorrecto. El evento médico no se registró.");
                return;
            }
            System.out.print("Observaciones: ");
            String observaciones = scanner.nextLine();

            pacienteEncontrado.agregarEventoMedico(fecha, observaciones);
            System.out.println("Evento médico registrado con éxito.");
        }
    }

    private static void guardarHistorialEnArchivo() {
        // Implementa la lógica para guardar el historial de pacientes en un archivo
    }

    private static void cargarHistorialDesdeArchivo() {
        // Implementa la lógica para cargar el historial de pacientes desde un archivo
    }
}

class Persona {
    String nombre;
    private String dni;
    Date fechaNacimiento;

    public Persona(String nombre, String dni, Date fechaNacimiento) {
        this.nombre = nombre;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
    }
    public String nombre() {
        return nombre;
    }
    public String dni() {
        return dni;
    }
    public Date fechaNacimiento() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return fechaNacimiento;
    }
}

class Doctor extends Persona {
    private String especialidad;

    public Doctor(String nombre, String dni, Date fechaNacimiento, String especialidad) {
        super(nombre, dni, fechaNacimiento);
        this.especialidad = especialidad;
    }
    public String especialidad() {
        return especialidad;
    }
}

class Paciente extends Persona implements Informacion {
    private String telefono;
    private String tipoSangre;
    private List<EventoMedico> historialMedico;

    public Paciente(String nombre, String dni, Date fechaNacimiento, String telefono, String tipoSangre) {
        super(nombre, dni, fechaNacimiento);
        this.telefono = telefono;
        this.tipoSangre = tipoSangre;
        this.historialMedico = new ArrayList<>();
    }

    public String telefono() {
        return telefono;
    }

    public String tipoSangre() {
        return tipoSangre;
    }

    public List<EventoMedico> historialMedico() {
        return historialMedico;
    }

    public void actualizarNombre(String nuevoNombre) {
        this.nombre = nuevoNombre;
    }

    public void actualizarFechaNacimiento(Date nuevaFechaNacimiento) {
        this.fechaNacimiento = nuevaFechaNacimiento;
    }

    public void agregarEventoMedico(Date fecha, String observaciones) {
        EventoMedico nuevoEvento = new EventoMedico(fecha, observaciones);
        historialMedico.add(nuevoEvento);
    }

    @Override
    public void verHistorialDeEventos() {
        System.out.println("Historial médico del paciente:");
        for (EventoMedico evento : historialMedico) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String fecha = dateFormat.format(evento.getFecha());
            System.out.println(fecha + " - " + evento.getObservaciones());
        }
    }
}

class EventoMedico {
    private Date fecha;
    private String observaciones;

    public EventoMedico(Date fecha, String observaciones) {
        this.fecha = fecha;
        this.observaciones = observaciones;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getObservaciones() {
        return observaciones;
    }
}

interface Informacion {
    void verHistorialDeEventos();
}
