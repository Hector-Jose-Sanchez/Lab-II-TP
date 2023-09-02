import java.util.Scanner;
public class SumatoriaRecursiva {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese un número: ");
            int numero = scanner.nextInt();
            int resultado = calcularSumatoria(numero);
            System.out.println("La sumatoria de 1 hasta " + numero + " es: " + resultado);
        }
        public static int calcularSumatoria(int n) {
            if (n <= 0) {
                return 0;
            } else {
                return n + calcularSumatoria(n - 1);
            }
        }
    }

