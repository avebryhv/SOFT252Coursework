/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

/**
 *
 * @author ahoughton-vowles
 */
public interface ISubject {
    
    /**
     *
     * @param o
     * @return
     */
    Boolean registerObserver(IObserver o);

    /**
     *
     * @param o
     * @return
     */
    Boolean removeObserver(IObserver o);

    /**
     *
     */
    void notifyObservers();
    
}
