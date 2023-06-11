package it.uniroma3.diadia.ambienti;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Introdurre la classe Labirinto
    – ha la responsabilità di creare il labirinto, di memorizzare la
    stanza iniziale (entrata) e quella finale (uscita)
    – aggiungere un riferimento ad un'istanza di Labirinto nella
    classe Partita (che ovviamente dovrà essere liberata dalle
    responsabilità spostate nella nuova classe)
 */

 public class Labirinto{

    private final String MESSAGGIO_BENVENUTO = ""+
    "Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
    "Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
    "I locali sono popolati da strani personaggi, " +
    "alcuni amici, altri... chissa!\n"+
    "Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
    "puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
    "o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
    "Per conoscere le istruzioni usa il comando 'aiuto'.";


    private Stanza stanzaCorrente;
    private Stanza stanzaVincente;

    /**
     * Costruiamo il Labirinto
     */

     public Labirinto(){
        creaLabirinto();
     }

     private void creaLabirinto(){
        /* crea gli attrezzi */
        Attrezzo lanterna = new Attrezzo("lanterna",3);
        Attrezzo osso = new Attrezzo("osso",1);
        Attrezzo chiave = new Attrezzo("chiave", 2);

        /* crea stanze del labirinto */
        Stanza atrio = new StanzaBloccata("Atrio", "nord", "chiave");
        Stanza aulaN11 = new Stanza("Aula N11");
        Stanza aulaN10 = new Stanza("Aula N10");
        Stanza laboratorio = new StanzaBuia("Laboratorio Campus", "lanterna");
        Stanza biblioteca = new Stanza("Biblioteca");
        //Stanza biblioteca = new Stanza("biblioteca");
        /* collega le stanze */
        atrio.impostaStanzaAdiacente("nord", biblioteca);
        atrio.impostaStanzaAdiacente("est", aulaN11);
        atrio.impostaStanzaAdiacente("sud", aulaN10);
        atrio.impostaStanzaAdiacente("ovest", laboratorio);
        aulaN11.impostaStanzaAdiacente("est", laboratorio);
        aulaN11.impostaStanzaAdiacente("ovest", atrio);
        aulaN10.impostaStanzaAdiacente("nord", atrio);
        aulaN10.impostaStanzaAdiacente("est", aulaN11);
        aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
        laboratorio.impostaStanzaAdiacente("est", atrio);
        laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
        biblioteca.impostaStanzaAdiacente("sud", atrio);

        /* pone gli attrezzi nelle stanze */
        aulaN10.addAttrezzo(lanterna);
        atrio.addAttrezzo(osso);
        aulaN11.addAttrezzo(chiave);

        // il gioco comincia nell'atrio
        stanzaCorrente = atrio;  
        stanzaVincente = biblioteca;
    }

    public String getMessaggio_Benvenuto(){
        return this.MESSAGGIO_BENVENUTO;
    }

    public Stanza getStanzaVincente(){
        return this.stanzaVincente;
    }

    public Stanza setStanzaCorrente(Stanza stanzaCorrente){
        return this.stanzaCorrente = stanzaCorrente;
    }
    public Stanza getStanzaCorrente(){
        return this.stanzaCorrente;
    }
}