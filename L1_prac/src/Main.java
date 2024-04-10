import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Juego juego = new Juego();
        Scanner sc = new Scanner(System.in);
        System.out.println("-----------------------------------------------------------");
        System.out.println("Bienvenido al juego de Esparco, la hormiga que come trigo");
        System.out.println("-----------------------------------------------------------");
        System.out.printf("Ingrese el ancho de la chacra en hormigómetros (hgmn): ");
        juego.setCols(sc.nextInt());
        sc.nextLine();
        System.out.printf("Ingrese el largo de la chacra en hormigómetros (hgmn): ");
        juego.setRows(sc.nextInt());
        sc.nextLine();
        System.out.printf("Ingrese la posición (x,y) de la hormiga: ");
        String posicion = sc.nextLine();
        String[] posiciones = posicion.split(" ");
        juego.setPosx(Integer.parseInt(posiciones[0]));
        juego.setPosy(Integer.parseInt(posiciones[1]));
        System.out.printf("Ingrese la dirección hacia la que apunta la cabeza de la hormiga (U,R,D,L): ");
        String[] direcciones = {"U", "R", "D", "L"};
        String direccion = sc.nextLine();
        for (int i = 0; i <3 ; i++) {
            if(direccion.equals(direcciones[i])){
                juego.setDirInicio(direccion);
                System.out.printf("Ingrese el número de fotos que capturará el poblador observador: ");
                juego.setNumfotos(sc.nextInt());
                sc.nextLine();
                System.out.printf("Ingrese el número de amplificación de filas y columnas en las que se ampliará la matriz: ");
                juego.setAmpliacion(sc.nextInt());
                sc.nextLine();

                juego.Juego();
            }
        }




    }
}