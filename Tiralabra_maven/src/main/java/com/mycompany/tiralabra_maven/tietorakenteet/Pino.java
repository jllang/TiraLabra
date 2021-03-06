
package com.mycompany.tiralabra_maven.tietorakenteet;

import java.util.EmptyStackException;

/**
 * Linkitetty tietorakenne, joka tarjoaa saman perustoiminnallisuuden kuin
 * Javan <b>Stack</b>. Perustoiminnallisuus tarkoittaa tässä operaatioita
 * <tt>onTyhja</tt>, <tt>lisaa</tt>, <tt>kurkista</tt>, <tt>poista</tt> ja
 * <tt>koko</tt>. Pino on toteutettu sillä oletuksella, ettei siihen yritetä
 * lisätä yli <i>2 147 483 647</i> alkiota. Pinon lisaa-metodi sallii
 * duplikaatit, mukaanlukien useamman <i>null</i>-arvon lisäys.
 * 
 * @author John Lång <jllang@cs.helsinki.fi>
 * @param <T> Pinoon säilöttävien tietoalkioiden tyyppi.
 */
public final class Pino<T> {

    private Solmu<T> ylin;
    private int korkeus;
    
    /**
     * Palauttaa luokan uuden instanssin.
     */
    public Pino() {
        this.korkeus = 0;
    }
    
    /**
     * Ilmoittaa onko pino tyhjä.
     *
     * @return Tosi jos pino on tyhjä; epätosi muuten.
     */
    public boolean onTyhja() {
        return korkeus == 0;
    }
    
    /**
     * Poistaa pinosta kaikki alkiot.
     */
    public void tyhjenna() {
        ylin = null;
        korkeus = 0;
    }
    
    /**
     * Vastaa Javan <b>Stack</b>-tietorakenteen <tt>push</tt> operaatiota sillä 
     * erotuksella ettei <b>Pino</b>n <tt>lisaa</tt>-metodilla ole paluuarvoa.
     * @param arvo Pinoon lisättävä alkio.
     */
    public void lisaa(T arvo) {
        Solmu<T> uusiSolmu = new Solmu<>(arvo);
        uusiSolmu.seuraaja = ylin;
        ylin = uusiSolmu;
        korkeus++;
    }
    
    /**
     * Palauttaa pinon päällimmäisen alkion.
     *
     * @return Pinon ylin alkio.
     * @throws EmptyStackException Jos pino on tyhjä.
     */
    public T kurkista() throws EmptyStackException {
        if (ylin == null) {
            throw new EmptyStackException();
        }
        return ylin.ARVO;
    }
    
    /**
     * Poistaa ja palauttaa pinon päällimmäisen alkion.
     *
     * @return Pinon ylin alkio.
     * @throws EmptyStackException Jos pino on tyhjä.
     */
    public T poista() throws EmptyStackException {
        if (ylin == null) {
            throw new EmptyStackException();
        }
        T paluuarvo = ylin.ARVO;
        ylin = ylin.seuraaja;
        korkeus--;
        return paluuarvo;
    }
    
    /**
     * Ilmoittaa pinon alkioiden määrän.
     * 
     * @return Pinon alkioiden määrä.
     */
    public int korkeus() {
        return korkeus;
    }
    
}
