package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza{
    private String direzioneBloccata;
    private String attrezzoChiave;

    public StanzaBloccata(String nome, String direzioneBloccata, String attrezzoChiave){
        super(nome);
        this.attrezzoChiave = attrezzoChiave;
        this.direzioneBloccata = direzioneBloccata;
    }

    @Override
    public String getDescrizione(){
        //se non ho l'attrezzo chiave..
        if(!this.hasAttrezzo(attrezzoChiave)){
            StringBuilder s = new StringBuilder();
            s.append("Ti trovi in una stanza bloccata: ");
            s.append(this.toString());
            s.append("\nLa direzione "+direzioneBloccata+ " è bloccata!");
            return s.toString();
        }
        return this.toString();
    }
/**
 * In questo modo vediamo se riusciamo ad entrare nella stanzaBloccata oppure
 * Non ci farò passare se non abbiamo l'attrezzo
 */
@Override
public Stanza getStanzaAdiacente(String direzione){
    if(direzione.equals(direzioneBloccata)){
        if(super.hasAttrezzo(attrezzoChiave)){
            return super.getStanzaAdiacente(direzioneBloccata);
        }else
            return this;
    }
    return super.getStanzaAdiacente(direzione);
}
    
}
