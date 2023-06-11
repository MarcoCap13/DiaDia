package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoPrendi implements Comando{
    private String errore = null;
    private String messaggio = null;
    private String nomeAttrezzo;

    @Override
    public void setParametro(String parametro) {
        this.nomeAttrezzo = parametro;
    }

    @Override
    public void esegui(Partita partita) {
        if(partita.getLabirinto().getStanzaCorrente().hasAttrezzo(nomeAttrezzo)){
            if(partita.getLabirinto().getStanzaCorrente().getAttrezzo(nomeAttrezzo).getPeso() < partita.getGiocatore().getBorsa().getPesoMax()){
                //lo aggiungo
                partita.getGiocatore().getBorsa().addAttrezzo(partita.getLabirinto().getStanzaCorrente().getAttrezzo(nomeAttrezzo));
                // lo elimino dalla stanza
                partita.getLabirinto().getStanzaCorrente().removeAttrezzo(partita.getLabirinto().getStanzaCorrente().getAttrezzo(nomeAttrezzo));
                //messaggio = ("hai preso " + nomeAttrezzo);
                System.out.println("Hai preso "+nomeAttrezzo);
            }
            else
                this.errore = ("Non hai spazio nella borsa!\n");
        }
        else
            errore = ("attrezzo non presente nella stanza!\n");
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
