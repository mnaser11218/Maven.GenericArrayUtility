package com.zipcodewilmington.arrayutility;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility <T>{
    T[] inputArray;
    public int numberOfOccurrences;

    public ArrayUtility(T[] inputArray) {
        this.inputArray = inputArray;
    }

    public int countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        int results = 0;
        int a1 = this.inputArray.length;
        int b1 = arrayToMerge.length;
        int c1 = a1+b1;

        final T[] c = (T[]) new Object[c1];
        System.arraycopy(this.inputArray, 0, c, 0, a1);
        System.arraycopy(arrayToMerge, 0, c, a1, b1);

        for(T ele: c){
            if(ele.equals(valueToEvaluate)){
                results++;
            }
        }
        System.out.println(c.length);
        return results;

    }

    public int getNumberOfOccurrences(T valueToEvaluate) {
        int results = 0;
        for(T ele : inputArray){
            if(ele.equals(valueToEvaluate)){
                results++;
            }
        }
        return results;
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {

        T mostCommon = null;
        int mostCommonNumber = 0;
        int a1 = this.inputArray.length;
        int b1 = arrayToMerge.length;
        int c1 = a1+b1;

        final T[] c = (T[]) new Object[c1];
        System.arraycopy(this.inputArray, 0, c, 0, a1);
        System.arraycopy(arrayToMerge, 0, c, a1, b1);

        for(int i= 0; i < c.length; i++){
            int count = 0;
            for(int j =0; j< c.length; j++){
                if(c[i].equals(c[j])){
                    count++;
                }
            }
            if(count > mostCommonNumber){
                mostCommonNumber = count;
                mostCommon = c[i];
            }
        }
        return mostCommon;
    }

    public T[] removeValue(T valueToRemove) {
       int numberOfOccurances = this.getNumberOfOccurrences(valueToRemove);
        @SuppressWarnings("unchecked")
        final T[] resultArray = (T[]) java.lang.reflect.Array.newInstance(
                inputArray.getClass().getComponentType(),
                inputArray.length - this.getNumberOfOccurrences(valueToRemove)
        );    //System.arraycopy(c, 0,c,0, c.length);
        int count = 0;

        for(T element: inputArray){
            if(!element.equals(valueToRemove)){
                resultArray[count] = element;
                count++;
            }
        }

        return resultArray;
    }
}
