package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoGuarda implements Comando{
    private String errore;
    private String messaggio;

    @Override
    public void setParametro(String parametro) {
    }

    @Override
    public void esegui(Partita partita) {
        this.messaggio = "";
        /**
         * Stampa: 1. Aula,
         *         2. Uscite (direzioni)
         *         3. Attrezzi (se ce ne sono)
         */
        this.messaggio += partita.getLabirinto().getStanzaCorrente().getDescrizione() + "\n";
        //stampa la borsa
        this.messaggio += partita.getGiocatore().getBorsa().toString() + "\n";
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
