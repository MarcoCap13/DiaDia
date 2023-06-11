package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza {
    private String attrezzoChiave;

    public StanzaBuia(String nome, String attrezzoChiave) {
        super(nome);
        this.attrezzoChiave = attrezzoChiave;
    }

    @Override
    public String getDescrizione(){
        if(this.hasAttrezzo(attrezzoChiave)){
            return super.getDescrizione();
        }else 
            return "dove mi trovo? Non vedo nulla...\n"
                    +"Questa stanza è diversa dalle altre, c'è un buio pazzesco...\n"
                    +"non si vede proprio nulla!"
                    +"Magari serve un attrezzo per illuminare la stanza..";
    }
}
