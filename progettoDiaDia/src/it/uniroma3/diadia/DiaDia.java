package it.uniroma3.diadia;
import it.uniroma3.diadia.comandi.*;
import java.util.Scanner;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {
	
	private Partita partita;

	public DiaDia() {
		this.partita = new Partita();
	}

	public void gioca() {
		String istruzione; 
		Scanner scannerDiLinee;

		System.out.println(this.partita.getLabirinto().getMessaggio_Benvenuto());
		scannerDiLinee = new Scanner(System.in);		
		do		
			istruzione = scannerDiLinee.nextLine();
		while (!processaIstruzione(istruzione));
		scannerDiLinee.close();
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire;

		FabbricaDiComandiFisarmonica fabbricaComando = new FabbricaDiComandiFisarmonica();
		comandoDaEseguire = fabbricaComando.costruisciComando(istruzione);
		comandoDaEseguire.esegui(partita);

		if(comandoDaEseguire.getErrore()  != null)
			System.out.println(comandoDaEseguire.getErrore());
		if(comandoDaEseguire.getMessaggio() != null)
			System.out.println(comandoDaEseguire.getMessaggio());
		if(this.partita.vinta())
			System.out.println("Hai vinto!");
		if(!this.partita.giocatoreIsVivo())
			System.out.println("Hai esaurito i CFU...");
		return this.partita.isFinita();
	}


	public static void main(String[] argc) {
		DiaDia gioco = new DiaDia();
		gioco.gioca();
	}
}