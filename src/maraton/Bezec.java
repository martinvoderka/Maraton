package maraton;

/**
 *
 * @author Martin
 */
public class Bezec {
    
    private int cisloBezce;
    private int hodiny;
    private int minuty;
    private int sekundy;
    
    public Bezec()
    {
        this.cisloBezce = 0;
        this.hodiny = 0;
        this.minuty = 0;
        this.sekundy = 0;       
    }
    
    public Bezec(int cislo, int h, int m, int s)
    {
        this.cisloBezce = cislo;
        this.hodiny = h;
        this.minuty = m;
        this.sekundy = s;        
    }
    
    public int getHodiny()
    {
        return this.hodiny;
    }
    
    public int getMinuty()
    {
        return this.minuty;
    }
    
    public int getSekundy()
    {
        return this.sekundy;
    }
    
    public int getCisloBezce()
    {
        return this.cisloBezce;
    }
    
}
