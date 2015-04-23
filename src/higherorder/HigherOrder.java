/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package higherorder;
    import iterators.*;
    import java.util.*;
/**
 *
 * @author uralfrkn
 */
public class HigherOrder {
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        
        for(int i=0; i<= 8 ; i++)
        {
            list.add(i);
        }
        //map denemesi
        Collection<Double> squareRoots = Iterators.map(new MapStrategy<Integer, Double>() {
            public Double transform(Integer i) {
                return Math.sqrt(i);
            }
        }, list);
        
        System.out.println(squareRoots);
        
        Collection<String> stringReps = Iterators.map(new MapStrategy<Integer, String>() {
            public String transform(Integer i) {
                return i + " ";
            }
        }, list);
        
        System.out.println(stringReps);
        
        //filter denemesi
        Collection<Integer> evens = Iterators.filter(new FilterStrategy<Integer>() {
            public boolean accept(Integer i) {
                return i % 2 == 0 ;
            }
        }, list);
        
        System.out.println(evens);
        
        //reduce denemesi
        int sum = Iterators.reduce(0, new ReduceStrategy<Integer>(){
        public Integer combine(Integer first, Integer second){
            return first + second;
        } }, list);
        
        System.out.println(sum);
        
    }
    
}
