package org.junit.tests.assertion;

import java.util.Comparator;

public class C1 implements Comparator{
    
    public C1(){
        super();
    }
    
    public int compare(Object arg0, Object arg1){
        if((Integer)arg0 > (Integer)arg1){
            return 1;
        }
        return 0;
    }

}