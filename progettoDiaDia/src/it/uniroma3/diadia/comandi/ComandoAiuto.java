package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.Partita;


public class ComandoAiuto implements Comando {
    private String errore = null;
    private String messaggio = null;

    @Override
    public void esegui(Partita partita){
        this.messaggio ="";
        for(int i=0; i< partita.getElencoComandi().length; i++) 
            this.messaggio += partita.getElencoComandi()[i] + " ";
        this.messaggio +="\n";
    }

    @Override
    public void setParametro(String parametro) {
    }

    @Override
    public String getErrore() {
        return this.errore;
    }

    @Override
    public String getMessaggio() {
        return this.messaggio;
    }
}
