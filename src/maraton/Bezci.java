package maraton;

/**
 *
 * @author Martin
 */
public class Bezci {
    private Bezec[] maraton;
    private int nejrychlejsi;
    private int nejpomalejsi;
    
    public Bezci(int[][]bezci)
    {
        maraton = new Bezec[bezci.length];
        int cislo, hodiny, minuty, sekundy;
        Bezec b;
        for (int i = 0; i < bezci.length; i++) 
        {
            cislo = bezci[i][0];
            hodiny = bezci[i][1];
            minuty = bezci[i][2];
            sekundy = bezci[i][3];
            b = new Bezec(cislo, hodiny, minuty, sekundy);
            maraton[i] = b;
        }
        
    }
    
    
    private int casBehuSekundy (int i)
    {
        int cas, hh, mm, ss;
        hh = maraton[i].getHodiny() - 9;
        mm = maraton[i].getMinuty() - 15;
        ss = maraton[i].getSekundy();
        cas = ss + 60 * mm + 3600 * hh;
        return cas;
    }
    
    public int doCasu ()
    {
        int pocetBezcu = 0;
        for (int i = 0; i < maraton.length; i++) 
        {
            if (casBehuSekundy(i) < 7620) //7620s = 2h 7m
            {
                pocetBezcu++;
            }
        }
        return pocetBezcu;
    }
    
    public int nejrychlejsiBezec ()
    {
        int cisloNejrychlejsiho;
        this.nejrychlejsi = 0;
        for (int i = 1; i < maraton.length; i++) 
        {
            if(casBehuSekundy(i) < casBehuSekundy(nejrychlejsi))
            {
                this.nejrychlejsi = i;
            }
        }
        cisloNejrychlejsiho = maraton[nejrychlejsi].getCisloBezce();
        return cisloNejrychlejsiho;
    }
    
    private void nejpomalejsiBezec ()
    {
        this.nejpomalejsi = 0;
        for (int i = 1; i < maraton.length; i++) 
        {
            if(casBehuSekundy(i) > casBehuSekundy(nejpomalejsi))
            {
                this.nejpomalejsi = i;
            }
        }
    }
    
    public int ztrata ()
    {
        nejpomalejsiBezec();
        int ztrata = casBehuSekundy(this.nejpomalejsi) - casBehuSekundy(this.nejrychlejsi);
        int hodiny = ztrata /3600;
        ztrata -= hodiny * 3600;
        int minuty = ztrata / 60;
        ztrata -= minuty * 60;
        int vteriny = ztrata;        
        return vteriny + 100 * minuty + 10000 * hodiny; //vystup v intu HHMMSS pro snadny output
    }
    
    public int naKilometr ()
    {
        int casKilometru = (int) (casBehuSekundy(this.nejrychlejsi) / 42.195);
        int minuty = casKilometru / 60;
        int sekundy = casKilometru % 60;
        return minuty * 100 + sekundy; //vystup v intu MMSS pro snadny output
    }
    
    public double prumernaRychlost ()
    {
        return 42.195 / (casBehuSekundy(this.nejrychlejsi) / 3600);
    }
    
}
