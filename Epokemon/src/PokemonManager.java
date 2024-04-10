import java.util.ArrayList;
import java.util.Scanner;

public class PokemonManager {
    private ArrayList<Pokemon> bolsa = new ArrayList<>();
    private Pokemon[] pokedex = new Pokemon[151];
    private int contadorBolsa = 0;
    private int contadorPokedex = 0;



    public void capturarPokemon() {
        Scanner scanner = new Scanner(System.in);
        Pokemon pokemon = new Pokemon();
        System.out.println("Ingrese la información del Pokemon");
        System.out.print("Número: ");
        pokemon.setNumero(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Nombre: ");
        pokemon.setNombre(scanner.nextLine());
        System.out.println("Seleccione Tipo:");
        String[] listaTipos = new String[5];
        listaTipos[0] = "Agua";
        listaTipos[1] = "Bicho";
        listaTipos[2] = "Dragon";
        listaTipos[3] = "Planta";
        listaTipos[4] = "FUego";
        System.out.println("1. Agua\n2. Bicho\n3. Dragon\n4. Planta\n5. Fuego\n6. Otro");
        System.out.print("Opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        if(opcion == 6) {
            System.out.print("Ingrese nuevo tipo: ");
            pokemon.setTipo(scanner.nextLine());
        }
        else{
            pokemon.setTipo(listaTipos[opcion]);
        }

        System.out.print("Peso: ");
        pokemon.setPeso(scanner.nextDouble());
        System.out.print("Altura: ");
        pokemon.setAltura(scanner.nextDouble());
        System.out.print("PS: ");
        pokemon.setPs(scanner.nextInt());

        bolsa.add(pokemon);
        contadorBolsa++;
        registrarPokedex(pokemon);
    }

    public void registrarPokedex(Pokemon pokemon) {
        if(pokedex[pokemon.getNumero() - 1] == null){
            pokedex[pokemon.getNumero()] = pokemon;
            System.out.println("Se ha actualizado la pokedex");
            contadorPokedex++;
        } else if (pokedex[pokemon.getNumero() - 1].getPs() < pokemon.getPs()) {
            pokedex[pokemon.getNumero()] = pokemon;
            System.out.println("Se ha actualizado la pokedex");
            contadorPokedex++;
        }
    }
    public void listarPokemon(){
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Seleccione lista:\n1. Bolsa\n2. Pokedex\n Opcion: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        switch(opcion){
            case 1:
                System.out.println("Pokemon en bolsa: " + contadorBolsa);
                for(Pokemon p : bolsa){
                    p.imprimir();
                }
                break;
            case 2:
                System.out.println("Pokemon en bolsa: " + contadorPokedex);
                for (int i = 0; i < 151; i++) {
                    if(pokedex[i] != null){
                        pokedex[i].imprimir();
                    }
                }
                break;
            default:
                System.out.println("Opción ingresada no válida");
                break;
        }
    }
    public void buscarPokemon(){
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Seleccione lista:\n1. Bolsa\n2. Pokedex\n Opcion: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingrese el nombre del Pokemon a buscar: ");
        String pBuscar = scanner.nextLine();
        String pBuscarUC = pBuscar.substring(0,1).toUpperCase() + pBuscar.substring(1);
        switch(opcion){
            case 1:
                for(Pokemon p : bolsa){
                    if(p.getNombre().equals(pBuscar) || p.getNombre().equals(pBuscarUC)){
                        p.imprimir();
                    }
                }
                break;
            case 2:

                for (int i = 0; i < 151; i++) {
                    if(pokedex[i] != null){
                        if(pokedex[i].getNombre().equals(pBuscar) || pokedex[i].getNombre().equals(pBuscarUC)){
                            pokedex[i].imprimir();
                        }
                    }
                }
                break;
            default:
                System.out.println("Opción ingresada no válida");
                break;
        }
    }
    public void imprimirResumen(){
        System.out.println("Tiene " + contadorBolsa + " pokemon en Bolsa");
        System.out.println("Tiene " + contadorPokedex + " Pokemon en Pokedex");
    }
}

