import java.util.Scanner;
public class Arquero extends Jugador{
    Scanner scanner = new Scanner(System.in);
    public int Reaccion;
    public int Vuelo;
    public int getReaccion(){
        return Reaccion;
    }
    public int getVuelo(){
        return Vuelo;
    }
    public void setReaccion(int Reaccion){
        this.Reaccion = Reaccion;
    }
    public void setVuelo(int Vuelo){
        this.Vuelo = Vuelo;
    }
    public void Registrar(Arquero arquero){
        super.Registrar(); 
        while(true){
            System.out.print("Ingrese reaccion a disparo: ");
            String reaccion = scanner.nextLine();
            if(reaccion != null && Integer.parseInt(reaccion) <= 100 && Integer.parseInt(reaccion) > 0){
                arquero.setReaccion(Integer.parseInt(reaccion));
                break;
            }
            else{
                System.out.println("Estadística no valida");
            }
        }
        while(true){
            System.out.print("Ingrese capacidad de vuelo: ");
            String vuelo = scanner.nextLine();
            if(vuelo != null && Integer.parseInt(vuelo) <= 100 && Integer.parseInt(vuelo) > 0){
                arquero.setVuelo(Integer.parseInt(vuelo));
                break;
            }
            else{
                System.out.println("Estadística no valida");
            }
        }
    }
}
