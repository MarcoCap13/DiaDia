package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoPosa implements Comando{
    private String errore = null;
    private String messaggio = null;
    private String nomeAttrezzo;

    @Override
    public void setParametro(String parametro) {
        this.nomeAttrezzo = parametro;
    }

    @Override
    public void esegui(Partita partita) {
        if(partita.getGiocatore().getBorsa().hasAttrezzo(this.nomeAttrezzo)){
            partita.getLabirinto().getStanzaCorrente().addAttrezzo(partita.getGiocatore().getBorsa().getAttrezzo(this.nomeAttrezzo));
            //togliamolo dalla borsa
            partita.getGiocatore().getBorsa().removeAttrezzo(this.nomeAttrezzo);

            messaggio = ("Hai posato " +nomeAttrezzo+ "nella stanza");
        }
        else
            errore = ("Attrezzo non presente nella borsa");
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
