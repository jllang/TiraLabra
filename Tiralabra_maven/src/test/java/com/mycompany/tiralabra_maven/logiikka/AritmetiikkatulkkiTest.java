
package com.mycompany.tiralabra_maven.logiikka;

import com.mycompany.tiralabra_maven.tietorakenteet.Jono;
import java.util.Random;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AritmetiikkatulkkiTest {
    
    private static final Random ARPOJA = new Random();
    
    private static Aritmetiikkatulkki       tulkki;
    private Jono<String>        odotusarvo, saatuArvo;
    
    @BeforeClass
    public static void setUpClass() {
        tulkki = new Aritmetiikkatulkki();
    }
    
    @Before
    public void setUp() {
        odotusarvo  = new Jono<>();
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testEpakelpoKaava1() {
        tulkki.tulkitseMerkkijono("7 ^ 3 * 5");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testEpakelpoKaava2() {
        tulkki.tulkitseMerkkijono("(7 + 3)) + 5");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testEpakelpoKaava3() {
        tulkki.tulkitseMerkkijono("((7 + 3) + 5");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testEpakelpoKaava4() {
        tulkki.tulkitseMerkkijono("(a7 + 3) + 5");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testLiianIsoLuku() {
        tulkki.tulkitseMerkkijono("486547367356354364356 + 1");
    }

    @Test
    public void testKelvollinenKaava1() {
        odotusarvo.lisaa("7");
        odotusarvo.lisaa("3");
        odotusarvo.lisaa("+");
        odotusarvo.lisaa("5");
        odotusarvo.lisaa("*");
        
        saatuArvo = tulkki.tulkitseMerkkijono("(7 + 3) * 5");
        
        vertaileJonoja();
    }
    
    @Test
    public void testKelvollinenKaava2() {
        odotusarvo.lisaa("7");
        odotusarvo.lisaa("3");
        odotusarvo.lisaa("5");
        odotusarvo.lisaa("*");
        odotusarvo.lisaa("+");
        
        saatuArvo = tulkki.tulkitseMerkkijono("7 + 3 * 5");
        
        vertaileJonoja();
    }
    
    @Test
    public void testKelvollinenKaava3() {
        odotusarvo.lisaa("7");
        odotusarvo.lisaa("3");
        odotusarvo.lisaa("/");
        odotusarvo.lisaa("5");
        odotusarvo.lisaa("*");
        
        saatuArvo = tulkki.tulkitseMerkkijono("7 / 3 * 5");
        
        vertaileJonoja();
    }
    
    @Test
    public void testKelvollinenKaava4() {
        odotusarvo.lisaa("7");
        odotusarvo.lisaa("3");
        odotusarvo.lisaa("%");
        odotusarvo.lisaa("5");
        odotusarvo.lisaa("/");
        
        saatuArvo = tulkki.tulkitseMerkkijono("7 % 3 / 5");
        
        vertaileJonoja();
    }
    
    @Test
    public void testKelvollinenKaava5() {
        int n = ARPOJA.nextInt(Integer.MAX_VALUE / 2),
                m = ARPOJA.nextInt(Integer.MAX_VALUE / 2);
        String a = String.valueOf(n), b = String.valueOf(m);
        
        odotusarvo.lisaa(a);
        odotusarvo.lisaa(b);
        odotusarvo.lisaa("+");
        
        saatuArvo = tulkki.tulkitseMerkkijono(a + " + " + b);
        
        vertaileJonoja();
    }
    
    @Test
    public void testKelvollinenKaava6() {
        odotusarvo.lisaa("4");
        odotusarvo.lisaa("2");
        odotusarvo.lisaa("2");
        odotusarvo.lisaa("*");
        odotusarvo.lisaa("2");
        odotusarvo.lisaa("*");
        odotusarvo.lisaa("5");
        odotusarvo.lisaa("*");
        odotusarvo.lisaa("+");
        
        saatuArvo = tulkki.tulkitseMerkkijono("4+2^3*5");
        
        vertaileJonoja();
    }
    
    private void vertaileJonoja() {
        String a, b;
        while (!odotusarvo.onTyhja()) {
            a = odotusarvo.poista();
            b = saatuArvo.poista();
            if (!a.equals(b)) {
                fail("Tulkki palautti virheellisen RPN-kaavan!");
            }
        }
    }
}