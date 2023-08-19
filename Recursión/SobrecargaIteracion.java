import java.util.Scanner;
public class SobrecargaIteracion {
        public static long calcularFactorial(int numero) {
            if (numero < 0) {
                return -1;
            }
            long factorial = 1;
            for (int i = 1; i <= numero; i++) {
                factorial *= i;
            }
            return factorial;
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese un número : ");
            int numero = scanner.nextInt();

            long factorial = calcularFactorial(numero);

            if (factorial == -1) {
                System.out.println("No se puede calcular el factorial de un  negativo.");
            } else {
                System.out.println("El factorial de " + numero + " es: " + factorial);
            }
        }
}
