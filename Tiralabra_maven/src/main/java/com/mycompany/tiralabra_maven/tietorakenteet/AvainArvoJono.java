
package com.mycompany.tiralabra_maven.tietorakenteet;

/**
 * Jono, jonka on tarkoitus toimia luokan <b>Hajautuskartta</b> komponenttina.
 * Alkuvaiheessa tällä luokalla on vain avain-arvoparien lisäys- ja
 * hakutoiminnot.
 *
 * @author John Lång
 */
final class AvainArvoJono<K, V> {
    
    private AvainArvoSolmu<K, V> ensimmainen, viimeinen;

    public AvainArvoJono() {
    }
    
    void lisaa(K avain, V arvo) {
        AvainArvoSolmu<K, V> solmu = new AvainArvoSolmu<K, V>(avain, arvo);
        if (ensimmainen == null) {
            ensimmainen = solmu;
            viimeinen = solmu;
        } else {
            viimeinen.seuraaja = solmu;
            viimeinen = solmu;
        }
    }
    
    V hae(K avain) {
        V paluuarvo = null;
        AvainArvoSolmu<K, V> solmu = ensimmainen;
        
        while (solmu != null) {            
            if (solmu.AVAIN.equals(avain)) {
                paluuarvo = solmu.ARVO;
                break;
            }
            // Teen tyyppimuunnoksen ilman tarkasteluja sillä kaikki solmut ovat
            // AvainArvoSolmuja (niitä ei voi ulkopuolelta lisäillä tänne):
            solmu = (AvainArvoSolmu) solmu.seuraaja;
        }
        
        return paluuarvo;
    }
    
}