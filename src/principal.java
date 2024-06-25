import java.util.Scanner;

public class principal {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Peticion p = new Peticion();

        int numero = 0;

        while(numero != 7) {
            System.out.println("**************************************");
            System.out.println("Sea bienvenido/a al conversor de Moneda");
            System.out.println("Ingrese el número dependiendo de la solicitud deseada");

            System.out.println("1) Dólar -> Peso argentino");
            System.out.println("2) Peso argentino -> Dólar");
            System.out.println("3) Dólar -> Peso Mexicano");
            System.out.println("4) Peso Mexicano -> Dólar");
            System.out.println("5) Dólar -> Peso colombiano");
            System.out.println("6) Peso colombiano -> Dólar");
            System.out.println("7) Salir");
            System.out.println("Elija la opcion válida: ");

            System.out.println("**************************************");
            numero = sc.nextInt();
            if (numero == 7){
                break;
            }

            System.out.println("¿Cuánto dinero deseas convertir?");
            int convertir = sc.nextInt();

            if (numero == 1){
                p.api("USD","ARS", convertir);
            }else if (numero == 2){
                p.api("ARS","USD", convertir);
            }else if (numero == 3){
                p.api("USD","MXN", convertir);
            }else if (numero == 4){
                p.api("MXN","USD", convertir);
            }else if (numero == 5){
                p.api("USD","COP", convertir);
            }else if (numero == 6){
                p.api("COP","USD", convertir);
            }else{
                System.out.println("Ingresaste un numero no valido");
            }
        }
    }
}
