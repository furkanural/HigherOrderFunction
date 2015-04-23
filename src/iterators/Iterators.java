/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iterators;

import java.util.Collection;

/**
 *
 * @author uralfrkn
 */
public class Iterators {
    public static<E> E reduce(E baseElement, ReduceStrategy<E> strategy, Collection<E> c  )
    {
        for(E element : c )
            baseElement = strategy.combine(baseElement, element);
        return baseElement;
    }
    
    public static<E,R> Collection<R> map(MapStrategy<E,R> strategy, Collection<E> c)
    {
        try {
            Collection<R> results = c.getClass().newInstance();
            for( E element : c )
                results.add(strategy.transform(element));
            return results;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    
    public static<E> Collection<E> filter(FilterStrategy<E> strategy, Collection<E> c )
    {
        try {
            Collection<E> results = c.getClass().newInstance();
        for(E element : c)
        {
            if(strategy.accept(element) == true)
                results.add(element);
        }
        return results;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        
    }
}
