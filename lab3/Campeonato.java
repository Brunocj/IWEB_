import java.util.ArrayList;
public class Campeonato {
    public String Nombre;
    public double Premio;
    public ArrayList<Equipo> ListaEquipos;
    public ArrayList<Partido> ListaPartidos;
    public String getNombre(){
        return Nombre;
    }
    public double getPremio(){
        return Premio;
    }
    public void setNombre(String Nombre){
        this.Nombre = Nombre;
    }
    public void setPremio(double Premio){
        this.Premio = Premio;
    }
    public void setEquipo(Equipo NuevoEquipo){
        ListaEquipos.add(NuevoEquipo);
    }
    public void setPartido(Partido NuevoPartido){
        ListaPartidos.add(NuevoPartido);
    }
    public Campeonato() {
        ListaEquipos = new ArrayList<>();
        ListaPartidos = new ArrayList<>();
    }
}
