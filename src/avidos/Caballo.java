package avidos;
/*
Hector octubre 2019
Heuristica: Mover el caballo a la posicion con menor numero de posibles movimientos
*/



public class Caballo {
    private int tablero[][];
    private Coordenada pos;

    public Caballo(int size,int x, int y){
        this.tablero = new int[size][size];
        for (int i = 0; i < size ; i++) {
            for (int j = 0; j < size ; j++) {
                this.tablero[i][j] = 0;
            }
        }
        this.pos = new Coordenada(x,y);
        this.tablero[this.pos.getX()][this.pos.getY()]= 1;
    }

    public Coordenada[] posibleMovimiento(Coordenada pos){
        Coordenada[] aux = new Coordenada[8];
        for (int i = 0; i < 8 ; i++) {
            switch(i){
                case 0:
                    aux[i] = new Coordenada(pos.getX()-1,pos.getY()-2);
                    //aux[i].setX(pos.getX()-2);
                    //aux[i].setY(pos.getY()-1);
                    break;
                case 1:
                    aux[i] = new Coordenada(pos.getX()-2,pos.getY()-1);
                    //aux[i].setX(pos.getX()-1);
                    //aux[i].setY(pos.getY()-2);
                    break;
                case 2:
                    aux[i] = new Coordenada(pos.getX()-2,pos.getY()+1);
                    //aux[i].setX(pos.getX()+1);
                    //aux[i].setY(pos.getY()-2);
                    break;
                case 3:
                    aux[i] = new Coordenada(pos.getX()-1,pos.getY()+2);
                    //aux[i].setX(pos.getX()+2);
                    //aux[i].setY(pos.getY()-1);
                    break;
                case 4:
                    aux[i] = new Coordenada(pos.getX()+1,pos.getY()+2);
                    //aux[i].setX(pos.getX()+2);
                    //aux[i].setY(pos.getY()+1);
                    break;
                case 5:
                    aux[i] = new Coordenada(pos.getX()+2,pos.getY()+1);
                    //aux[i].setX(pos.getX()+1);
                    //aux[i].setY(pos.getY()+2);
                    break;
                case 6:
                    aux[i] = new Coordenada(pos.getX()+2,pos.getY()-1);
                    //aux[i].setX(pos.getX()-1);
                    //aux[i].setY(pos.getY()-2);
                    break;
                case 7:
                    aux[i] = new Coordenada(pos.getX()+1,pos.getY()-2);
                    //aux[i].setX(pos.getX()-2);
                    //aux[i].setY(pos.getY()+1);
                    break;
            }
        }

        return aux;
    }
    public boolean validarMovimiento(Coordenada pos){
        if (
                pos.getX() < this.tablero.length && pos.getX() >= 0 &&
                pos.getY() < this.tablero.length && pos.getY() >= 0 &&
                this.tablero[pos.getX()][pos.getY()] == 0
        )
            return true;
        return false;



    }
    public int recorridoCaballo( ){
        int numMovimientos = 1;
        int maxMovimientos = this.tablero.length * this.tablero.length;
        Coordenada aux []; //  Posibles movimientos apartir de posiciones

        boolean salto= true;
        while (numMovimientos < maxMovimientos && salto){
            salto = false;
            aux= posibleMovimiento(this.pos);
            int minSiguientes= 8;
            Coordenada sigMov = this.pos;
            for (int i = 0; i < 8 ; i++) {
                if(validarMovimiento(aux[i])){
                    salto= true;
                    Coordenada[] pos= posibleMovimiento(aux[i]); // Movimientos apartir de posibles pos
                    int cont=0;
                    for (int j = 0; j < 8 ; j++) {
                        if(validarMovimiento(pos[j])){
                            cont++;
                        }
                    }
                    if(minSiguientes >= cont){
                        minSiguientes= cont;
                        sigMov=aux[i];
                    }
                }
            }
            this.setPos(sigMov);
            if(salto)
                numMovimientos++;
            this.tablero[this.pos.getX()][this.pos.getY()]=numMovimientos;
        }
        return numMovimientos;
    }

    public int[][] getTablero() {
        return tablero;
    }

    public void setTablero(int[][] tablero) {
        this.tablero = tablero;
    }

    public Coordenada getPos() {
        return pos;
    }

    public void setPos(Coordenada pos) {
        this.pos = pos;
    }
}
