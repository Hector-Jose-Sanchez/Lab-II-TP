import java.util.Scanner;
public class RECURSIVIDAD {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Ingrese el dividendo: ");
            int dividendo = scanner.nextInt();

            System.out.print("Ingrese el divisor: ");
            int divisor = scanner.nextInt();

            int cociente = dividirConRestas(dividendo, divisor);

            System.out.println("El cociente es: " + cociente);

            scanner.close();
        }
        public static int dividirConRestas(int dividendo, int divisor) {
            if (divisor == 0) {
                System.out.println("No se puede dividir por cero.");
                return -1;
            }

            int cociente = 0;
            while (dividendo >= divisor) {
                dividendo -= divisor;
                cociente++;
            }

            return cociente;
        }

}
