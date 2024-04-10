public class Juego {
    private int rows;
    private int cols;
    private int posx;
    private int posy;
    private int numfotos;
    private String dirInicio;
    private int ampliacion;
    private String[][] chacra;
    private String[][] chacraAmpliada;

    public String[][] getChacraAmpliada() {
        return chacraAmpliada;
    }

    public void setChacraAmpliada(String[][] chacraAmpliada) {
        this.chacraAmpliada = chacraAmpliada;
    }

    public String[][] getChacra() {
        return chacra;
    }


    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public int getPosx() {
        return posx;
    }

    public void setPosx(int posx) {
        this.posx = posx;
    }

    public int getPosy() {
        return posy;
    }

    public void setPosy(int posy) {
        this.posy = posy;
    }

    public int getNumfotos() {
        return numfotos;
    }

    public void setNumfotos(int numfotos) {
        this.numfotos = numfotos;
    }

    public String getDirInicio() {
        return dirInicio;
    }

    public void setDirInicio(String dirInicio) {
        this.dirInicio = dirInicio;
    }

    public int getAmpliacion() {
        return ampliacion;
    }

    public void setAmpliacion(int ampliacion) {
        this.ampliacion = ampliacion;
    }

    public void setChacra(){
        String[][] chacra = new String[getRows()][getCols()];
        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j <getCols() ; j++) {
                chacra[i][j] = ".";
            }
        }
        this.chacra = chacra;
    }
    public void imprimirMatriz(String[][] matriz){
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j <matriz[i].length ; j++) {
                System.out.printf(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }
    public void Juego(){
        setChacra();
        String cuadrado = "■";
        String direccion = getDirInicio();
        String[][] chacrita = getChacra();
        //Ubicando la posicion inicial de la hormiga
        int posX = getPosx();
        int posY = getPosy();
        chacrita[posY][posX] = "H"; //Prevpos
        int prevPosX = posX;
        int prevPosY = posY;
        String prevVal = cuadrado; /*1 PUTA HORA PARA PENSAR TODO LO RELACIONADO A ESTA VARIABLE CSM*/
        System.out.println("----------------------------------------------------------");
        System.out.println("Foto 1: Momento previo a la recoleccion de la hormiga");
        System.out.println("----------------------------------------------------------");
        imprimirMatriz(chacrita);
        for (int i = 0; i < getNumfotos() - 1; i++) {
            System.out.println("----------------------------------------------------------");
            System.out.println("Foto numero " + (i+2) + " de la hormiga en la chacra:");
            System.out.println("----------------------------------------------------------");
            switch (direccion) {
                case "U": //Arriba [-1][]
                    posX = prevPosX;
                    posY = prevPosY - 1;
                    chacrita[prevPosY][prevPosX] = prevVal;
                    //Actualizar direccion
                    if(chacrita[posY][posX].equals(".")){
                        prevVal = cuadrado;
                        direccion = "R";
                    }

                    else{
                        prevVal = ".";
                        direccion = "L";
                    }
                    chacrita[posY][posX] = "H";
                    prevPosY = posY;
                    prevPosX = posX;
                    break;
                case "R": //Derecha [][+1]
                    posX = prevPosX + 1;
                    posY = prevPosY;
                    chacrita[prevPosY][prevPosX] = prevVal;
                    if(chacrita[posY][posX].equals(".")){
                        prevVal = cuadrado;
                        direccion = "D";
                    }
                    else{
                        prevVal = ".";
                        direccion = "U";
                    }
                    chacrita[posY][posX] = "H";
                    prevPosY = posY;
                    prevPosX = posX;
                    break;
                case "D": //Abajo [+1][]
                    posX = prevPosX;
                    posY = prevPosY + 1;
                    chacrita[prevPosY][prevPosX] = prevVal;
                    if(chacrita[posY][posX].equals(".")){
                        prevVal = cuadrado;
                        direccion = "L";
                    }
                    else{
                        prevVal = ".";
                        direccion = "R";
                    }
                    chacrita[posY][posX] = "H";
                    prevPosY = posY;
                    prevPosX = posX;
                    break;
                case "L": //Izquierda [][-1]
                    posX = prevPosX - 1;
                    posY = prevPosY;
                    chacrita[prevPosY][prevPosX] = prevVal;
                    if(chacrita[posY][posX].equals(".")){
                        prevVal = cuadrado;
                        direccion = "U";
                    }
                    else{
                        prevVal = ".";
                        direccion = "D";
                    }
                    chacrita[posY][posX] = "H";
                    prevPosY = posY;
                    prevPosX = posX;
                    break;
            }
            ampliarMatriz(chacrita);
            imprimirMatriz(chacrita);
        }
        System.out.println("Chacra ampliada:");
        imprimirMatriz(getChacraAmpliada());
    }
    public void ampliarMatriz(String[][] matrizAmpliar){
        String[][] chacraAmpliada = new String[(getRows() + 2*getAmpliacion())][(getCols() + 2*getAmpliacion())];
        for (int i = 0; i < getRows() + 2*getAmpliacion(); i++) {
            for (int j = 0; j <getCols() + 2*getAmpliacion() ; j++) {
                chacraAmpliada[i][j] = ".";
            }
        }
        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j <getCols(); j++) {
                chacraAmpliada[(i + getAmpliacion())][(j + getAmpliacion())] = matrizAmpliar[i][j];
            }
        }
        setChacraAmpliada(chacraAmpliada);
    }

}