
package com.mycompany.tiralabra_maven.tietorakenteet;

import java.util.EmptyStackException;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class PinoTest {
    
    private Pino<Object>    pino;
    private Object          testiObjekti;
    
    /**
     *
     */
    @Before
    public void setUp() {
        pino            = new Pino<>();
        testiObjekti    = new Object();
    }
    
    @Test
    public void testOnTyhja() {
        pino.lisaa(testiObjekti);
        assertFalse(pino.onTyhja());
    }
    
    @Test
    public void testTyhjenna() {
        pino.lisaa(testiObjekti);
        pino.tyhjenna();
        assertEquals(0, pino.korkeus());
    }

    @Test
    public void testLisaa() {
        pino.lisaa(null);
        pino.lisaa(null);
        pino.lisaa(new Object());
        pino.lisaa(new Object());
        pino.lisaa(testiObjekti);
        assertEquals(testiObjekti, pino.poista());
        assertNotNull(pino.poista());
        assertNotNull(pino.poista());
        assertNull(pino.poista());
        assertNull(pino.poista());
    }

    @Test
    public void testKurkista1() {
        pino.lisaa(testiObjekti);
        assertEquals(pino.kurkista(), testiObjekti);
    }
    
    @Test(expected = EmptyStackException.class)
    public void testKurkista2() {
        pino.kurkista();
    }

    @Test
    public void testPoista() {
        pino.lisaa(testiObjekti);
        assertEquals(pino.poista(), testiObjekti);
    }

    @Test
    public void testKorkeus() {
        pino.lisaa(testiObjekti);
        pino.lisaa(new Object());
        pino.lisaa(new Object());
        pino.lisaa(null);
        pino.lisaa(null);
        pino.lisaa(new Object());
        pino.lisaa(null);
        pino.lisaa(new Object());
        pino.lisaa(null);
        pino.lisaa(new Object());
        pino.lisaa(testiObjekti);
        pino.lisaa(new Object());
        assertEquals(12, pino.korkeus());
    }
}