import java.util.ArrayList;
public class Equipo {
    public String Pais;
    public int Puntos;
    public ArrayList<Jugador> ListaJugadores = new ArrayList<>();
    public String getPais(){
        return Pais;
    }
    public int getPuntos(){
        return Puntos;
    }
    public void setPais(String Pais){
        this.Pais = Pais;
    }
    public void setPuntos(int Puntos){
        this.Puntos = Puntos;
    }
    public void setJugador(Jugador jugador){
        ListaJugadores.add(jugador);
    }
}
