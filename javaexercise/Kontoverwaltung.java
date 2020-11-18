import java.util.ArrayList;
import java.util.HashSet;
import java.util. Iterator;

/**
 * Ein einfaches Modell einer Kontoverwaltung.
 * Ein Exemplar dieser Klasse h�lt eine Liste von Konten, 
 * sowie eine Menge von Kontoinhabern.
 * Beide k�nnen beliebig lang bzw. gross werden.
 * 
 * @author Adrian Mrozowski
 * @version 2008.12.23
 */


public class Kontoverwaltung
{
    // eine Liste der Konten dieser Kontoverwaltung.
    private ArrayList<Konto> postenliste;    
    
    // die Menge aller Kontoinhaber dieser Kontoverwaltung.
    private HashSet<String> mengeAllerKontoinhaber;

    
    /**
     * Erzeuge eine neue Kontoverwaltung.
     */
    public Kontoverwaltung()
    {
        postenliste = new ArrayList<Konto>();        
        mengeAllerKontoinhaber = new HashSet<String>();
    }

    
    /**
     * Erstelle ein neues Privatkonto f�r diese Kontoverwaltung. 
     * Da es ein Privatkonto ist, wird im Datenfeld firma "Privatperson" als Standard eingesetzt. 
     */
    public void kontoAnlegen(String ihrvorname, String ihrnachname, String ihrekontonummer)
    {
        postenliste.add(new Konto(ihrvorname, ihrnachname, ihrekontonummer, "Privatperson", 0));
        mengeAllerKontoinhaber.add(ihrvorname + " " + ihrnachname + " " + "Privatperson");    
    }
    /**
     * Erstelle ein neues Gesch�ftskonto f�r diese Kontoverwaltung. 
     * Im Gegensatz zum Privatkonto muss hier zus�tzlich die Firma angegeben werden, 
     * sowie ein Limit, das Limit muss als positive Zahl eingegeben werden.
     */
    public void gesch�ftskontoAnlegen(String ihrvorname, String ihrnachname, String ihrekontonummer, String firma, double limit)
    {
        postenliste.add(new Konto(ihrvorname, ihrnachname, ihrekontonummer, firma, limit));
        mengeAllerKontoinhaber.add(ihrvorname + " " + ihrnachname + " " + firma);
    }
    
    /**
    * Einzahlung: Falls ein Konto mit der eingegebenen Kontonummer �bereinstimmt und dieses nicht gesperrt ist,
    * erh�ht sich der Kontostand um den eingegeben Betrag. Falls es gesperrt ist, erscheint eine Fehlermeldung.
    * Die Einzahlungsbetr�ge sind in "CHF".
    */
   
    public void einzahlen(String kontonummer, double einzahlungsbetrag)
    {
        for (Konto konto : postenliste) {
           
           if (konto.kontonummer == kontonummer){
           konto.einzahlen(einzahlungsbetrag);
           }
        }
        
        
    }

    
    /**
    * Einzahlung: Falls ein Konto mit der eingegebenen Kontonummer �bereinstimmt und dieses nicht gesperrt ist,
    * vermindert sich der Kontostand um den eingegeben Betrag. Falls es gesperrt ist, erscheint eine Fehlermeldung.
    * Die Einzahlungsbetr�ge sind in "CHF".
    */

    public void abheben(String kontonummer, double abhebebetrag)
    {
        for (Konto konto : postenliste) {
           
           if (konto.kontonummer == kontonummer){
           konto.abheben(abhebebetrag);
           }
        }
        
    }


     /**
     * Alle Konten mit ihren jeweiligen Attributen werden aufgelistet.
     */

  public void kontenAuflisten()
    {
        for (Konto konto : postenliste) {
            System.out.println(konto.toString());
        }
    }    
    
      
    /**
     * Alle Konteninhaber werden aufgelistet.
     * Falls es sich nicht um eine Privatperson handelt, wird zus�tzlich die Firma angezeigt.
     * Eine Privatperson wird nur einmal angezeigt, unabh�ngig davon, wieviele Privatkonten sie besitzt.
     * Falls eine Person mehrere Konten f�r verschiedene Firmen besitzt, werden all diese Firmen angezeigt
     * sowie nochmals der Name des Kontobesitzers.
     */
             
           public void kontoinhaberAuflisten()
    {
            System.out.println(mengeAllerKontoinhaber);     
    }
       
    
     /**
     * Sperrt alle Konten, falls bei Privatperson der Kontostand negativ ist 
     * oder falls bei Gesch�ftskunden der Kontostand unter dem festgesetzten Limit ist.
     */
    
          public void kontoSperren()
    {
        for (Konto konto : postenliste) {
           konto.dieseskontoSperren();
        }
    }
    
 
}
