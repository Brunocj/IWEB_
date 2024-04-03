public class Partido {
    public Equipo ELocal;
    public Equipo EVisitante;
    public int Resultado;
    public int getResultado(){
        return Resultado;
    }
    public Equipo getELocal(){
        return ELocal;
    }
    public Equipo getEVisitante(){
        return EVisitante;
    }
    public void setResultado(int Resultado){
        this.Resultado = Resultado;
        switch(Resultado){
            case 1:{
                ELocal.setPuntos(ELocal.getPuntos() + 3);
                break;
            }
            case 2:{
                ELocal.setPuntos(ELocal.getPuntos() + 1);
                EVisitante.setPuntos(EVisitante.getPuntos() + 1);
                break;
            }
            case 3:{
                EVisitante.setPuntos(EVisitante.getPuntos() + 3);
                break;
            }
            default:{
                System.out.println("Ingrese una opcion valida");
            }
        }
    }
    public void setELocal(Equipo Local){
        this.ELocal = Local;
    }
    public void setEVisitante(Equipo Visitante){
        this.EVisitante = Visitante;
    }
    
}
