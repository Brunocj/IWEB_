import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        int menu = 0;
        Scanner scanner = new Scanner(System.in);
        int opciones = 0;
        int equipos = 0;
        Campeonato campeonato = null;
        while(menu == 0){
            
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("|                              Menu                                    |");
            System.out.println("| (1) Registre un campeoneto                                           |");
            System.out.println("| (2) Registre un equipo en el campeonato                              |");
            System.out.println("| (3) Registre un partido al campeonato                                |");
            System.out.println("| (4) Mostrar las especificaciones de cada jugador del equipo          |");
            System.out.println("| (5) Mostrar equipo(s) con mejor puntaje                              |");
            System.out.println("| (6) Salir                                                            |");
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.print("Ingrese una opcion: ");
            int opcion = Integer.parseInt(scanner.nextLine());
            

            switch(opcion){
                case 1:{
                    if(opciones == 0){
                        System.out.println("--------------------------------------");
                        System.out.println("Ingrese la información del campeonato");
                        System.out.println("--------------------------------------");
                        campeonato = new Campeonato();
                        System.out.print("Ingrese el nombre: ");
                        String nombre = scanner.nextLine();
                        if(nombre != null){
                            campeonato.setNombre(nombre);
                        }
                        else{
                            System.out.print("Debe registrar un nombre");
                        }
                        System.out.print("Ingrese el premio en soles: ");
                        String premio = scanner.nextLine();
                        campeonato.setPremio(Double.parseDouble(premio));      
                        opciones = 1;
                        break;
                    }
                    else{
                        System.out.println("Ya existe un campeonato registrado");
                        break;
                    }
                }
                case 2:{
                    if(opciones == 1){
                        Equipo equipo = new Equipo();
                        System.out.println("--------------------------------------");
                        System.out.println("Ingrese la información del equipo");
                        System.out.println("--------------------------------------");
                        System.out.print("Ingrese el pais: ");
                        String eIngresado = scanner.nextLine();
                        equipo.setPais(eIngresado);
                        boolean encontrado = false;
                        if(!campeonato.ListaEquipos.isEmpty()){
                            for(Equipo e : campeonato.ListaEquipos){
                                if(e.getPais().equals(eIngresado)){
                                    encontrado = true;
                                }
                            }
                        }    
                        if(campeonato.ListaEquipos.isEmpty() || !encontrado){
                            System.out.print("Ingrese la cantidad de puntos del equipo: ");
                            equipo.setPuntos(Integer.parseInt(scanner.nextLine()));
                            equipos = 1;
                            boolean menuJugadores = true;
                            while(menuJugadores){
                                int opcionJugadores  = 0;
                                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                                System.out.println("|                       Inserte jugador                                |");
                                System.out.println("| (1) Arquero                                                          |");
                                System.out.println("| (2) Defensor                                                         |");
                                System.out.println("| (3) Atacante                                                         |");
                                System.out.println("| (4) Salir                                                            |");
                                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                                System.out.print("Ingrese una opcion: ");
                                opcionJugadores  = Integer.parseInt(scanner.nextLine());
                                switch(opcionJugadores){
                                    case 1:{
                                        System.out.println("--------------------------------------");
                                        System.out.println("Ingrese la información del arquero");
                                        System.out.println("--------------------------------------");
                                        Arquero a = new Arquero();
                                        a.Registrar(a);
                                        equipo.setJugador(a);
                                        break;
                                    }
                                    case 2:{
                                        System.out.println("--------------------------------------");
                                        System.out.println("Ingrese la información del defensor");
                                        System.out.println("--------------------------------------");
                                        Defensor defensa = new Defensor();
                                        defensa.Registrar(defensa);
                                        equipo.setJugador(defensa);
                                        break;
                                    }
                                        
                                    case 3:{
                                        System.out.println("--------------------------------------");
                                        System.out.println("Ingrese la información del atacante");
                                        System.out.println("--------------------------------------");
                                        Atacante atacante = new Atacante();
                                        atacante.Registrar(atacante);
                                        equipo.setJugador(atacante);
                                        break;
                                    }
                                    case 4:{
                                        menuJugadores = false;
                                        campeonato.setEquipo(equipo);
                                        break;
                                    }
                                    default:{
                                        System.out.println("Ingrese una opción válida");
                                    }
                                }

                            }
                                
                        }
                        else{
                            System.out.println("Ingrese Ingrese un equipo diferente");
                                
                        }
                    }
                    else{
                        System.out.println("No existe un campeonato registrado");
                    }
                    break;
                }
                case 3:{
                    if(opciones == 1 && equipos == 1){
                        Partido partido = new Partido();
                        boolean bLocal = true;
                        String LocalG = "";
                        while(bLocal){
                            Equipo eLocal = null;
                            System.out.print("Ingrese el nombre del equipo local: ");
                            String Local = scanner.nextLine();
                            for(Equipo e : campeonato.ListaEquipos){
                                if(e.Pais.equals(Local)){
                                    eLocal = e;
                                    partido.setELocal(eLocal);
                                }
                            }
                            if(eLocal != null){
                                bLocal = false;
                                LocalG = Local;
                            }
                            else{
                                System.out.println("Ingrese un equipo valido");
                            }
                        }
                        boolean bVisita = true;
                        while (bVisita) {
                            Equipo eVisita = null;
                            System.out.print("Ingrese el nombre del equipo visitante: ");
                            String Visitante = scanner.nextLine();
                            if(LocalG != Visitante){
                                for(Equipo e : campeonato.ListaEquipos){
                                    if(e.Pais.equals(Visitante)){
                                        eVisita = e;
                                        partido.setEVisitante(eVisita);
                                    }
                                }
                                if(eVisita != null){
                                    bVisita = false;
                                }
                                else{
                                    System.out.println("Ingrese un equipo valido");
                                }
                            }
                            else{
                                System.out.println("Ingrese un equipo diferente");
                            }
                        }

                        
                        System.out.print("Ingrese el tipo de resultado: ");
                        partido.setResultado(Integer.parseInt(scanner.nextLine()));
                    }
                    else if(opciones == 1 && equipos == 0){
                        System.out.println("No existen equipos en el campeonato");
                    }
                    else{
                        System.out.println("No existe un campeonato registrado");
                    }

                    break;
                }
                case 4:{
                    if(opciones == 1 && equipos == 1){
                        boolean contIter = true;
                        while(contIter){
                            System.out.println("Ingrese el nombre del país para conocer los jugadores: ");
                            String pIngresado = scanner.nextLine();
                            if(pIngresado == null){
                                System.out.println("Debe ingresar un país");
                            }
                            else{
                                boolean showTeam = false;
                                Equipo equipoMostrar = null;
                                for(Equipo e : campeonato.ListaEquipos){
                                    if(e.Pais.equals(pIngresado)){
                                        showTeam = true;
                                        equipoMostrar = e;
                                    }
                                }
                                if(showTeam){
                                    System.out.println("-----------------------------------------------------------");
                                    System.out.println("Equipo: " + equipoMostrar.getPais());
                                    System.out.println("-----------------------------------------------------------");
                                    for(Jugador j : equipoMostrar.ListaJugadores){
                                        System.out.println("Jugador: " + j.getNombre() + " '"+j.getApodo() + "' " + j.getApellidoP());
                                        if(j instanceof Atacante){
                                            Atacante a = (Atacante) j;    
                                            System.out.println("Precisión de disparo: " + a.getPrecision());
                                            System.out.println("Potencia de disparo: " + a.getPotencia());
                                            System.out.println("-----------------------------------------------------------");
                                        }
                                        else if(j instanceof Defensor){
                                            Defensor d = (Defensor) j;
                                            System.out.println("Alcance de barrida: " + d.getBarrida());
                                            System.out.println("Capacidad defensiva: " + d.getDefensa());
                                            System.out.println("-----------------------------------------------------------");
                                        }
                                        else if(j instanceof Arquero){
                                            Arquero aq = (Arquero) j;
                                            System.out.println("Reacción a disparo: " + aq.getReaccion());
                                            System.out.println("Capacidad de vuelo: " + aq.getVuelo());
                                            System.out.println("-----------------------------------------------------------");
                                        }
                                    }
                                    contIter = false;
                                }
                                else{
                                    System.out.println("Debe ingresar un país existente");
                                }
                            }
                        }
                    }
                    else if(opciones == 1 && equipos == 0){
                        System.out.println("No existen equipos en el campeonato");
                    }
                    else{
                        System.out.println("No existe un campeonato registrado");
                    }

                    break;
                }
                case 5:{
                    if(opciones == 1 && equipos == 1){
                        //System.out.priintln(ganador.getPais()+ "ha ganado el torneo con " + ganador.getPuntos() + " puntos y gano S/. "campeonato.getPremio() );
                    }   
                    else if(opciones == 1 && equipos == 0){
                        System.out.println("No existen equipos en el campeonato");
                    }
                    else{
                        System.out.println("No existe un campeonato registrado");
                    }

                    break;
                }
                case 6:{
                    if(opciones == 1 && equipos == 1){
                        
                        menu = 1;
                    }
                    else if(opciones == 1 && equipos == 0){
                        System.out.println("No existen equipos en el campeonato");
                    }
                    else{
                        System.out.println("No existe un campeonato registrado");
                    }

                    break;
                }
                default:{
                    System.out.println("Ingrese una opcion valida");
                }
            }
            
            
        }
        scanner.close();
    }
}
