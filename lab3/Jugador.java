import java.util.Scanner;
class Jugador{
    Scanner scanner = new Scanner(System.in);
    public String Nombre;
    public String Apodo;
    public String ApellidoP;
    public String getNombre(){
        return Nombre;
    }
    public String getApodo(){
        return Apodo;
    }
    public String getApellidoP(){
        return ApellidoP;
    }
    public void setNombre(String Nombre){
        this.Nombre = Nombre;
    }
    public void setApodo(String Apodo){
        this.Apodo = Apodo;
    }
    public void setApellidoP(String ApellidoP){
        this.ApellidoP = ApellidoP;
    }
    public void Registrar(){
        while(true){
            System.out.print("Ingrese el nombre: ");
            String Ningresado = scanner.nextLine();
            if(Ningresado != null){
                setNombre(Ningresado);
                break;
            }
        }
        while(true){
            System.out.print("Ingrese el apodo: ");
            String APingresado = scanner.nextLine();
            if(APingresado != null){
                setApodo(APingresado);
                break;
            }
        }
        while(true){
            System.out.print("Ingrese el apellido: ");
            String Aingresado = scanner.nextLine();
            if(Aingresado != null){
                setApellidoP(Aingresado);
                break;
            }
        }
    }
}

