import java.util.Scanner;

public class Atacante extends Jugador{
    Scanner scanner = new Scanner(System.in);
    public int Precision;
    public int Potencia;
    public int getPrecision(){
        return Precision;
    }
    public void setPrecision(int Precision){
        this.Precision = Precision;
    }
    public int getPotencia(){
        return Potencia;
    }
    public void setPotencia(int Potencia){
        this.Potencia = Potencia;
    }
    public void Registrar(Atacante atacante){
        super.Registrar(); 
        while(true){
            System.out.print("Ingrese precisión: ");
            String precision = scanner.nextLine();
            if(precision != null && Integer.parseInt(precision) <= 100 && Integer.parseInt(precision) > 0){
                atacante.setPrecision(Integer.parseInt(precision));
                break;
            }
            else{
                System.out.println("Estadística no valida");
            }
        }
        while(true){
            System.out.print("Ingrese potencia: ");
            String potencia = scanner.nextLine();
            if(potencia != null && Integer.parseInt(potencia) <= 100 && Integer.parseInt(potencia) > 0){
                atacante.setPotencia(Integer.parseInt(potencia));
                break;
            }
            else{
                System.out.println("Estadística no valida");
            }
        }
    }
}
