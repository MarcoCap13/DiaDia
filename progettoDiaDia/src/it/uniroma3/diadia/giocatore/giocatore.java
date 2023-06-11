package it.uniroma3.diadia.giocatore;

public class giocatore {
    private int cfu;
    private static int CFU_INIZIALI = 20;
    private Borsa borsa;


    public giocatore(){
        this.cfu = CFU_INIZIALI;
        this.borsa = new Borsa();
    }

    public int getCFU(){
        return this.cfu;
    }
    public void setCfu(int cfu){
        this.cfu = cfu;
    }
    public Borsa getBorsa(){
        return this.borsa;
    }
    
}
