package it.uniroma3.diadia.ambienti;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe Stanza - una stanza in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * 
 * @author docente di POO 
 * @see Attrezzo
 * @version base
*/

public class Stanza implements Comparable<Stanza>{
	
	
	private String nome;
//   private Stanza[] stanzeAdiacenti;
//	private String[] direzioni;

	private Set<Attrezzo> attrezzi;
	private Map<String, Stanza> stanzeAdiacenti;
    
    /**
     * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
     * @param nome il nome della stanza
     */
    public Stanza(String nome) {
        this.nome = nome;
        this.stanzeAdiacenti = new HashMap<String, Stanza>();
        this.attrezzi = new HashSet<Attrezzo>();
    }

    /**
     * Imposta una stanza adiacente.
     *
     * @param direzione direzione in cui sara' posta la stanza adiacente.
     * @param stanza stanza adiacente nella direzione indicata dal primo parametro.
     */
    public void impostaStanzaAdiacente(String direzione, Stanza stanza) {
        this.stanzeAdiacenti.put(direzione, stanza);
    }

	public int getNumeroAttrezzi(){
		return this.attrezzi.size();
		}

    /**
     * Restituisce la stanza adiacente nella direzione specificata
     * @param direzione
     */
	public Stanza getStanzaAdiacente(String direzione) {
      return this.stanzeAdiacenti.get(direzione);
	}

    /**
     * Restituisce la nome della stanza.
     * @return il nome della stanza
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Restituisce la descrizione della stanza.
     * @return la descrizione della stanza
     */
    public String getDescrizione() {
        return this.toString();
    }

    /**
     * Restituisce la collezione di attrezzi presenti nella stanza.
     * @return la collezione di attrezzi nella stanza.
     */
    public Set<Attrezzo> getAttrezzi() {
        return this.attrezzi;
    }
    /**
     * Mette un attrezzo nella stanza.
     * @param attrezzo l'attrezzo da mettere nella stanza.
     * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
     */
    public boolean addAttrezzo(Attrezzo attrezzo) {
        if (attrezzo == null){
			System.out.println("non ci sono attrezzi");
			return false;
		}
		else
			this.attrezzi.add(attrezzo);
			return true;
    }

   /**
	* Restituisce una rappresentazione stringa di questa stanza,
	* stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	* @return la rappresentazione stringa
	*/
	public String direzioniToString(){
		String s = new String();
		s += this.nome;
		s+="\nUscite: ";
		for (String direzione : this.getDirezioni())
    		if (direzione!=null)
    			s+= " " + direzione;
		return s;
	}

	public String attrezziToString(){
		String s = new String();
		s += "Attrezzi nella Stanza: ";
		for(Attrezzo attrezzi : this.attrezzi)
			s+= " "+attrezzi.toString();
		return s;
	}

	public String toString(){
		return "\n" + this.direzioniToString() + "\n" + this.attrezziToString() + "\n";
	}

    /**
	* Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	* @return true se l'attrezzo esiste nella stanza, false altrimenti.
	*/
	public boolean hasAttrezzo(String nomeAttrezzo) {
		//Iterator serve per vedere tutti gli attrezzi della collezione
		Iterator<Attrezzo> i = this.attrezzi.iterator();
		while(i.hasNext()){
			if(i.next().getNome().equals(nomeAttrezzo))
				return true;
		}
		return false;
	}



	/**
     * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza.
     * 		   null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Iterator<Attrezzo> i = this.attrezzi.iterator();
		while(i.hasNext()){
			Attrezzo attrezzo = i.next();
			if(attrezzo.getNome().equals(nomeAttrezzo))
				return attrezzo;
		}
		return null;
	}

	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(Attrezzo attrezzo) {
		if(attrezzo == null){
			System.out.println("Attrezzo non esistente");
			}
		return this.attrezzi.remove(attrezzo);
		}


	public Set<String> getDirezioni() {
		return this.stanzeAdiacenti.keySet();
    }

	@Override
	public int compareTo(Stanza o){
		return this.getNumeroAttrezzi() - o.getNumeroAttrezzi();
	}

}