import java.util.Scanner;

public class Defensor extends Jugador{
    Scanner scanner = new Scanner(System.in);
    public int Barrida;
    public int Defensa;
    public int getBarrida(){
        return Barrida;
    }
    public void setBarrida(int Barrida){
        this.Barrida = Barrida;
    }
    public int getDefensa(){
        return Defensa;
    }
    public void setDefensa(int Defensa){
        this.Defensa = Defensa;
    }
    public void Registrar(Defensor defensor){
        super.Registrar();
        while(true){
            System.out.print("Ingrese el alcance de barrida: ");
            String barrida = scanner.nextLine();
            if(barrida != null && Integer.parseInt(barrida) <= 100 && Integer.parseInt(barrida) > 0){
                defensor.setBarrida(Integer.parseInt(barrida));
                break;
            }
            else{
                System.out.println("Estadística no valida");
            }
        }
        while(true){
            System.out.print("Ingrese capacidad defensiva:  ");
            String defensa = scanner.nextLine();
            if(defensa != null && Integer.parseInt(defensa) <= 100 && Integer.parseInt(defensa) > 0){
                defensor.setDefensa(Integer.parseInt(defensa));
                break;
            }
            else{
                System.out.println("Estadística no valida");
            }
        }
    }
}
