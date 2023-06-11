package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai implements Comando {
    private String errore = null;
    private String messaggio = null;
    private String direzione;

    @Override
    public void setParametro(String parametro) {
        this.direzione = parametro;
    }

    @Override
    public void esegui(Partita partita) {    
        Stanza prossimaStanza = null;
       
        if(this.direzione== null){
			System.out.println("Dove vuoi andare ?");
            return;
        }else
		
        prossimaStanza = partita.getLabirinto().getStanzaCorrente().getStanzaAdiacente(this.direzione);    

		if (prossimaStanza == null){
			System.out.println("Direzione inesistente");
            return;
        }
		partita.getLabirinto().setStanzaCorrente(prossimaStanza);
		partita.getGiocatore().setCfu(partita.getGiocatore().getCFU()-1);
		
		System.out.println("CFU rimanenti "+ partita.getGiocatore().getCFU());			
		System.out.println(partita.getLabirinto().getStanzaCorrente().getDescrizione());
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
