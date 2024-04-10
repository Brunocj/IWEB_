import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PokemonManager manager = new PokemonManager();
        boolean bucle = true;

        while(bucle){
            System.out.println("=== Menú ===");
            System.out.println("1. Capturar Pokemon");
            System.out.println("2. Listar Pokemon");
            System.out.println("3. Buscar Pokemon");
            System.out.println("4. Imprimir Resumen");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = (scanner.nextInt());
            scanner.nextLine();
            switch(opcion){
                case 1:
                    manager.capturarPokemon();
                    break;
                case 2:
                    manager.listarPokemon();
                    break;
                case 3:
                    manager.buscarPokemon();
                    break;
                case 4:
                    manager.imprimirResumen();
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    bucle = false;
                    break;
                default:
                    System.out.printf("Opción inválida. Intente nuevamente:");
                    break;
            }
        }
        scanner.close();
    }
}