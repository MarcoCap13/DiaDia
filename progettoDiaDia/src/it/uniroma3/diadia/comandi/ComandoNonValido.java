package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.Partita;

public class ComandoNonValido implements Comando {
    private String errore = null;
    private String messaggio = null;

    @Override
    public void esegui(Partita partita) {
        this.errore = ("Comando sconosciuto! \n");
    }

    public void setParametro(String parametro){
    }
    public String getErrore(){
        return this.errore;
    }
    public String getMessaggio(){
        return this.messaggio;
    }
   
}
