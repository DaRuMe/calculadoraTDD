package com.amaris;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private BigDecimal value = BigDecimal.ZERO;

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public int add(String numbers) {
        String [] spliced;
        List<Integer> negatives = new ArrayList <Integer>();
        String delimiter = ",";
        if(3 < numbers.length()){
            if(numbers.substring(0,2).matches("\\D\\n")){
                delimiter += "|"+numbers.charAt(0);
                numbers = numbers.substring(2);
            }
        }
        spliced = numbers.split(delimiter +"|\\n");
        int result = 0;
        if(spliced.length != 1 ){
            for (int i = 0; i < spliced.length; i++){
                if(spliced[i].equals("")||spliced[i].equals(" ")){
                    result = -1;
                    i = spliced.length;
                }else {
                    if(Integer.parseInt(spliced[i])<0){
                        negatives.add(Integer.parseInt(spliced[i]));
                    } else {
                        result += Integer.parseInt(spliced[i]);
                    }
                }
            }
        } else{
            if (!spliced[0].equals("")&&!spliced[0].equals(" ")){
                result = Integer.parseInt(spliced[0]);
            }
        }
        if(negatives.isEmpty()){
            return result;
        } else{
            System.out.print("Negatives not Allowed");
            System.out.print(negatives.toString());
            return -1;
        }
    }
}
