/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hf.pack;

import java.math.BigInteger;

/**
 * This class serves to calculate the formulations passed in.
 * @author Fuhao
 */
public class CalculatorModel {
    BigInteger num1;
    BigInteger num2;
    
    /**
     * 
     * @param s1 the first number
     * @param s2 the second number
     * @param operation the operator
     * @return the result
     */
    public String calculate(String s1, String s2, String operation) {
        String response = "";
        try {
            num1 = BigInteger.valueOf(Long.parseLong(s1));
            num2 = BigInteger.valueOf(Long.parseLong(s2));
            String prefix = num1 + " " +operation + " " + num2 + " result :";
            switch (operation) {
                case "add" :
                    response += prefix + (num1.add(num2));
                    break;
                case "multiply" :
                    response += prefix + (num1.multiply(num2));
                    break;
                case "relativelyPrime" :
                    response += prefix + ((num1.gcd(num2).equals(1)) ? "true" : "false");
                    break;
                case "mod" :
                    response += prefix + (num1.mod(num2));
                    break;
                case "modInverse" :
                    response += prefix + (num1.modInverse(num2));
                    break;
                case "power" :
                    response += prefix + (num1.pow(num2.intValue()));
                    break;
                default:
                    response += "Operation Format Error!";
            }
        }catch(NumberFormatException e) {
            response += "Number Format Error!";
            return response;
        }catch(ArithmeticException e) {
            response += "Calculation Error";
            return response;
        }
        return response;
    }
    
}
