package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoFine implements Comando{
    private String errore = null;
    private String messaggio = null;

    @Override
    public void esegui(Partita partita){
        System.out.println("Grazie di aver giocato!");  // si desidera smettere
        partita.setFinita();
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
