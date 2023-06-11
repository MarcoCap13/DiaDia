package it.uniroma3.diadia;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.giocatore.giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

	private Labirinto labirinto;
	private boolean finita;
	private giocatore giocatore;

	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "posa", "prendi", "guarda"};


	
	public Partita(){
		this.finita = false;
		this.labirinto = new Labirinto();
		this.giocatore = new giocatore();
	}
	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.labirinto.getStanzaCorrente()== this.labirinto.getStanzaVincente();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || !this.giocatoreIsVivo();
	}

	/**
	 * Imposta la partita come finita
	 */
	public void setFinita() {
		this.finita = true;
	}

	public boolean giocatoreIsVivo(){
		return (this.giocatore.getCFU() != 0);
	}

	public Labirinto getLabirinto(){
		return this.labirinto;
	}

	public giocatore getGiocatore(){
		return this.giocatore;
	}
	
	public String[] getElencoComandi(){
		return elencoComandi;
	}
}
