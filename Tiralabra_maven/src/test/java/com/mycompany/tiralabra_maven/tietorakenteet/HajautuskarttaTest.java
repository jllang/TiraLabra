
package com.mycompany.tiralabra_maven.tietorakenteet;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class HajautuskarttaTest {
    
    private Hajautuskartta hk;
    
    @Before
    public void setUp() {
        hk = new Hajautuskartta(3);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testEpakelpoKonstruktorinParametri1() {
        Hajautuskartta a = new Hajautuskartta(-3);
    }
    
    @Test
    public void testLisaaJaHae() {
        hk.lisaa('a', 1);
        hk.lisaa('b', 2);
        hk.lisaa('c', 3);
        hk.lisaa('d', 4);
        hk.lisaa('e', 5);
        hk.lisaa('f', 6);
        hk.lisaa('g', 7);
        hk.lisaa('h', 8);
        hk.lisaa('i', 9);
        hk.lisaa('j', 0);
        hk.lisaa('k', 1);
        hk.lisaa('l', 2);
        hk.lisaa(' ', 2);
        hk.lisaa(' ', 3);
        assertEquals(5, hk.haeEnsimmainen('e'));
        assertEquals(2, hk.haeEnsimmainen(' '));
    }
    
    @Test
    public void testToString() {
        String oikeaVastaus = "{(c\u21A63,f\u21A66,i\u21A69,l\u21A62),"
                + "{a\u21A61},\u2205}";
        hk.lisaa('a', 1);
        hk.lisaa('c', 3);
        hk.lisaa('f', 6);
        hk.lisaa('i', 9);
        hk.lisaa('l', 2);
        assertEquals(oikeaVastaus, hk.toString());
    }

}