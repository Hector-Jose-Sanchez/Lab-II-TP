import java.util.Scanner;
public class Tp1 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Ingrese el primer número: ");
            int num1 = scanner.nextInt();

            System.out.print("Ingrese el segundo número: ");
            int num2 = scanner.nextInt();

            System.out.print("Ingrese el tercer número: ");
            int num3 = scanner.nextInt();

            int mayor, medio, menor;

            if (num1 > num2) {
                if (num1 > num3) {
                    mayor = num1;
                    if (num2 > num3) {
                        medio = num2;
                        menor = num3;
                    } else {
                        medio = num3;
                        menor = num2;
                    }
                } else {
                    mayor = num3;
                    medio = num1;
                    menor = num2;
                }
            } else {
                if (num2 > num3) {
                    mayor = num2;
                    if (num1 > num3) {
                        medio = num1;
                        menor = num3;
                    } else {
                        medio = num3;
                        menor = num1;
                    }
                } else {
                    mayor = num3;
                    medio = num2;
                    menor = num1;
                }
            }

            System.out.println("Números ordenados de mayor a menor: " + mayor + ", " + medio + ", " + menor);
            scanner.close();
        }
}
