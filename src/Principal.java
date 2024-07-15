import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static double hacerCalculo(String base, String cambio){
        Scanner sc = new Scanner(System.in);
        double val;
        while (true){
            System.out.println("Ingrese el monto que va a convertir");
            try {
                val = sc.nextDouble();
                break;
            } catch (InputMismatchException e){
                System.out.println("Ingrese un numero valido");
                sc.nextDouble();
            }
        }
        ServicioApi servicioApi = new ServicioApi();
        double tasaCambio = servicioApi.obtenerTasa(base, cambio);
        double valorFinal = val*tasaCambio;
        return valorFinal;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("""
                    Sea bienvenido/a al Conversor de Moneda =]
                                   \s
                                    1) Dólar =>> Peso argentino
                                    2) Peso argentino =>> Dólar
                                    3) Dólar =>> Real brasileño
                                    4) Real brasileño =>> Dólar
                                    5) Dólar =>> Peso colombiano
                                    6) Peso colombiano =>> Dólar
                                    7) Salir
                                    Elija una opción válida:
                    """);
            try {
                int respuesta = sc.nextInt();
                switch (respuesta){
                    case 1:
                        System.out.println(hacerCalculo("USD","ARS"));
                        break;
                    case 2:
                        System.out.println(hacerCalculo("ARS","USD"));
                        break;
                    case 3:
                        System.out.println(hacerCalculo("USD","BRL"));
                        break;
                    case 4:
                        System.out.println(hacerCalculo("BRL","USD"));
                        break;
                    case 5:
                        System.out.println(hacerCalculo("USD","COP"));
                        break;
                    case 6:
                        System.out.println(hacerCalculo("COP","ARS"));
                        break;
                    case 7:
                        break;
                    default:
                        System.out.println("Ingrese una opcion valida");

                }
            }catch (InputMismatchException e){
                System.out.println("Ingrese una opcion valida");
                sc.nextInt();
            }
        }
    }
}
