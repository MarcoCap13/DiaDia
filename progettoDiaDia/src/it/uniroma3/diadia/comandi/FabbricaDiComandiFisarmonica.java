package it.uniroma3.diadia.comandi;
import java.util.Scanner;

public class FabbricaDiComandiFisarmonica implements FabbricaDiComandi {

    @Override
    public Comando costruisciComando(String istruzione) {
        // se l'istruzione è vuota, restituisce il comando non valido
        if(istruzione == null)
            return new ComandoNonValido();
        
        Scanner scannerDiParole = new Scanner(istruzione);
        String nomeComando = null;
        String parametro = null;
        Comando comando = null; //nomeComando + parametro
    

        if(scannerDiParole.hasNext())
            nomeComando = scannerDiParole.next();
        if(scannerDiParole.hasNext())
            parametro= scannerDiParole.next();
        scannerDiParole.close();

        //Se il nome del comando da noi inserito non esiste..
        if(nomeComando == null){
            comando = new ComandoNonValido();
            return comando;
        }
        //Serie di comandi da inserire
        if("vai".equals(nomeComando)){
            comando = new ComandoVai();
        }
        else if ("prendi".equals(nomeComando))
            comando = new ComandoPrendi();
        else if ("posa".equals(nomeComando))
            comando = new ComandoPosa();
        else if ("aiuto".equals(nomeComando))
            comando = new ComandoAiuto();        
        else if ("fine".equals(nomeComando))
            comando = new ComandoFine();
        else if ("guarda".equals(nomeComando))
            comando = new ComandoGuarda();     
        else
            comando = new ComandoNonValido();
        
        comando.setParametro(parametro);
        return comando;
    }

    
}
