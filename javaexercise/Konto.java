/**
 * Die Klasse Konto modelliert einfache Konton einer Bank.
 * Die Konten werden in Schweizerfranken gef�hrt,
 * man kann Kontoinformationen ausdrucken lassen, Zinsen verbuchen
 * lassen, Einzahlungen und Auszahlungen t�tigen.
 * 
 * @author Adrian Mrozowski
 * @version 2008.12.23
 */
public class Konto
{
   
    public String vorname;     // Der Vorname des Kontobesitzers. 
    public String nachname;    // Der Nachname des Kontobesitzers.    
    public final String kontonummer; // Die Kontonummer des Kontos.    
    public double kontostand;  // Der Kontostand des Kontos.    
    public double limit; // Der Kreditlimit des Kontos.    
    public boolean kontogesperrt; // Wenn wahr, ist eine Kontosperrung vorhanden.
    public String firma; // Die Firma des Gesch�ftskontos. Falls als Wert Privatperson eingegeben ist, so handelt es sich nicht um ein Gesch�ftskonto, sondern um ein Privatkonto.
    
    /**
     * Erstellt ein neues Konto. Der Anfangskontostand betr�gt 0.00, 
     * das Konto ist vorerst f�r Aus- und Einzahlungen nicht gesperrt. 
     * Bitte Limit als positive Zahl eingeben.
     */
    
    public Konto(String ihrvorname, String ihrnachname, String ihrekontonummer, String firma, double limit)
    {
        vorname = ihrvorname;
        nachname = ihrnachname;
        kontonummer = ihrekontonummer;
        this.firma = firma;
        this.limit = limit;
        kontostand = 0.00;
        kontogesperrt = false;

         
    }
        
    /**
    * Einzahlung: Falls das Konto nicht gesperrt ist, erh�ht
    * sich der Kontostand um den eingegeben Betrag. Ansonsten erscheint eine Fehlermeldung.
    * Die Einzahlungsbetr�ge sind in "CHF".
    */
    public void einzahlen (double einzahlungsbetrag)
    {
        if (kontogesperrt == true){
        System.out.println("Ihr Konto wurde gesperrt, bitte setzen Sie sich mit Ihrer Bank in Verbindung");
        }
        else {
        kontostand = kontostand + einzahlungsbetrag;         
        System.out.println("Sie haben " + einzahlungsbetrag + " CHF eingezahlt, der Kontostand Ihr betr�gt jetzt: " + kontostand + " CHF.");
        }
    }

     /**
     * Auszahlung: Falls das Konto nicht gesperrt ist, 
     * vermindert sich der Kontostand um den eingegeben Betrag. 
     * Ansonsten erscheint eine Fehlermeldung.
    * Die Einzahlungsbetr�ge sind in "CHF".
     */
    public void abheben (double abhebebetrag)
    {
        if (kontogesperrt == true){
        System.out.println("Ihr Konto wurde gesperrt, bitte setzen Sie sich mit Ihrer Bank in Verbindung");
        }
        else {
        kontostand = kontostand - abhebebetrag; 
        System.out.println("Sie haben " + abhebebetrag + " CHF abgehoben, Ihr Kontostand betr�gt jetzt: " + kontostand + " CHF.");
        }    
    }
    
     /**
     * @return Eine String-Darstellung aller Attribute dieses Kontos. 
     * Falls es sich nicht um eine Privatperson handelt, werden zus�tzlich die Attribute 
     * Firma und Limit angezeigt.
     */
    public String toString()       
    {
         String details =  "Vorname: " + vorname + "; Nachname: " + nachname + "; Kontonummer: " + kontonummer + "; Kontostand: "  + kontostand + " CHF" + "; Kontogesperrt: " + kontogesperrt;       
        
        if (firma != "Privatperson")
        {
        details +=  "; Firma: " + firma + "; Limit:" + limit + " CHF";
        }
        
        return details;
    }

     /**
     * @return Eine String-Darstellung des Kontoinhabers dieses Kontos.
      * Falls es sich nicht um eine Privatperson handelt, wird zus�tzlich die Firma angezeigt.
     */
    public String kontoinhaberAnzeigen()       
    {
        String details = vorname + " " + nachname;
        if (firma != "Privatperson")
        {
        details +=  " Firma: " + firma;
        }
        return details;
    }
    
    
     /**
     * Sperrt dieses Konto, falls bei einer Privatperson der Kontostand negativ ist 
     * oder falls bei einem Gesch�ftskunden der Kontostand unter dem festgesetzten Limit ist.
     */
    
     public void dieseskontoSperren()         
    {
        if (firma == "Privatperson")
        {
            if (kontostand < 0)
            {
            kontogesperrt = true;
            }
        }    
       else
       {
           if (kontostand < -limit)
           {
           kontogesperrt = true;
           }           
        }
    }
     
}
