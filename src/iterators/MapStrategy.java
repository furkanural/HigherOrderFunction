/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iterators;

/**
 *
 * @author uralfrkn
 */
public interface MapStrategy<E, R> {
    public R transform(E element);
}
