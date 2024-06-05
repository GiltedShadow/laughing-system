/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package cPi;

import java.util.LinkedList;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Scanner;
        
/**
 *
 * @author Alex
 * 
 * this is created to calculate pi to the nth digit
 * then compare to see how many digits are accurate
 */
public class CalculatePi {
    public static int accurate;
    public static double elapsedTime;
    public static LinkedList<String> originalNumber = new LinkedList<String>();
    public static LinkedList<String> PiToCompare = new LinkedList<String>();
    
    private static BigDecimal useThisPi = new BigDecimal(3.1415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679);
    private static String stringUseThisPi = String.format("%.100f", 3.1415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679);
    
    public static String[] compare = "3.1415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679".split("");
    
    public static void main(String[] args) {
        // TODO: add time keeping, Java is already leagues ahead of Python so theres not much need
        // for it but it would be nice to be able to run it
        // TODO: complete compare and tack it to the end of the class
        // System.out.println("Hello World!");
        Scanner input = new Scanner(System.in);
        long userInputCycles;
        String userInputRun;
        while(true){
            System.out.println(""
                    + "1 - Calculate using doubles\n"
                    + "2 - Calculate using BigDecimal\n"
                    + "Please select which to use or quit, then how many cycles to run");
            userInputRun = input.nextLine();
            switch(userInputRun){
                case "1":
                    System.out.println("Selected double calulation, please enter the amount of cycles to run:");
                    userInputCycles = Long.parseLong(input.nextLine());
                    doubleCalcPi(userInputCycles);
                    break;
                case "2":
                    System.out.println("Selected Big Decimal calulation, please enter the amount of cycles to run:");
                    userInputCycles = Long.parseLong(input.nextLine());
                    break;
                default:
                    System.exit(0);
            }
            //int userInputRun = Integer.parseInt(input.nextLine());
            
            
        }
    }
    public static void doubleCalcPi(long amtOfRuns){
        long startTime = System.nanoTime();
        double k = 1;
        // initilize sum
        double s = 0.0;
        // init constants

        
        for (long i=0; i<amtOfRuns; i++) {
            //System.out.println("test");
            // even index elements are positive
            if (i%2==0){
                s+=(4/k);

            }
            // odd elements are negative
            else{
                s-=(4/k);

            }
            
            // denominator is odd

            k+=2;
        }
        
        System.out.println(s);
        long finishTime = System.nanoTime();
        elapsedTime = (finishTime-startTime)/1000000000;
        String timeTracking = String.format("Elapsed time is %s secconds", elapsedTime);
        System.out.println(timeTracking);
        compare(s);
    }
    public static void bigDecimalCalcPi(long amtOfRuns){
        long startTime = System.nanoTime();
        //double k = 1;
        BigDecimal k = new BigDecimal(1);
        // initilize sum
        //double s = 0.0;
        BigDecimal s = new BigDecimal(0.0);
        // init constants
        BigDecimal four = new BigDecimal(4);
        BigDecimal two = new BigDecimal(2);
        
        for (long i=0; i<amtOfRuns; i++) {
            //System.out.println("test");
            // even index elements are positive
            if (i%2==0){
                //s+=(4/k);
                s = s.add(four.divide(k, 100, RoundingMode.CEILING));
            }
            // odd elements are negative
            else{
                //s-=(4/k);
                s = s.subtract(four.divide(k, 100, RoundingMode.CEILING));
            }
            
            // denominator is odd
            k = k.add(two);
            //k+=2;
        }
        
        System.out.println(s);
        long finishTime = System.nanoTime();
        elapsedTime = (finishTime-startTime)/1000000000;
        String timeTracking = String.format("Elapsed time is %s secconds", elapsedTime);
        System.out.println(timeTracking);
        compareBigDecimal(s);
    }
    
    public static void compare(double number){
        //int accurate = 0;
        //LinkedList<String> originalNumber = new LinkedList<String>();
        //LinkedList<String> PiToCompare = new LinkedList<String>();
        
        //String toChange = String.valueOf(number); // pulling passed arg into a compable setup
        //String compareThis = String.format("%.100f", useThisPi); // is this even used anymore?
        //String[] result = toChange.split(""); //  this and the previous line for toChange can be pulled into one line

        //String[] result = String.valueOf(number).split(""); // pulling number into comparible string[]
        //String[] compare = "3.1415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679".split("");
        originalNumber.clear();
        PiToCompare.clear();
        accurate = 0;
        for(String a : String.valueOf(number).split("")){
            //pulls each int in line from the resulting number from CalculatePi(@number)
            //then removes the .
            if (!".".equals(a)){
                originalNumber.add(a);
            }
        }
        for(String b : compare){
            //pulls each int in line from the resulting number from 100 digits of pi
            //then removes the .
            if (!".".equals(b)){
                PiToCompare.add(b);
            }
        }
        for(int x=0;x<originalNumber.size();x++){
            if(originalNumber.get(x).equals(PiToCompare.get(x))){
                accurate +=1;
            }
            else{
                break;
            }
        }
        System.out.println(useThisPi);
        System.out.println(stringUseThisPi);
        System.out.println(originalNumber);
        System.out.println(PiToCompare);
        System.out.println(String.format("This Pi is accruate up to %s digits", accurate));
        MainPage_calcPi.lblAccuracy.setText(String.format("This is accurate to %s digits and took %s seconds", accurate, elapsedTime));
    }
    
    public static void compareBigDecimal(BigDecimal number) {
        //int accurate = 0;      
        //LinkedList<String> originalNumber = new LinkedList<String>();
        //LinkedList<String> PiToCompare = new LinkedList<String>();
        originalNumber.clear();
        PiToCompare.clear();
        accurate = 0;
        //String toChange = String.valueOf(number);
        //String compareThis = String.format("%.100f", useThisPi);
        //String[] result = toChange.split("");
        //String[] compare = "3.1415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679".split("");
        for(String a : String.valueOf(number).split("")){
            //pulls each int in line from the resulting number from CalculatePi(@number)
            //then removes the .
            if (!".".equals(a)){
                originalNumber.add(a);
            }
        }
        for(String b : compare){
            //pulls each int in line from the resulting number from 100 digits of pi
            //then removes the .
            if (!".".equals(b)){
                PiToCompare.add(b);
            }
        }
        for(int x=0;x<originalNumber.size();x++){
            if(originalNumber.get(x).equals(PiToCompare.get(x))){
                accurate +=1;
            }
            else{
                break;
            }
        }
        System.out.println(useThisPi);
        System.out.println(stringUseThisPi);
        System.out.println(originalNumber);
        System.out.println(PiToCompare);
        System.out.println(String.format("This Pi is accruate up to %s digits", accurate));
        MainPage_calcPi.lblAccuracy.setText(String.format("This is accurate to %s digits and took %s seconds", accurate, elapsedTime));

        //LinkedList<Double> result = new LinkedList<>();
        //while (number>0){
        //    result.push(number%10);
        //    number/=10;
        //}
        //return result;
        
        /*
    def comparePi(x):
        listOne = list(format(x, '.50f'))
        listTwo = [_ for _ in format(math.pi, '.50f')]
        accurate = -2
        #print(listOne)
        #print(listTwo)
        for num in range(52):
            if listOne[num]==listTwo[num]:
                accurate+=1
        
            else:
                if accurate%10==1:
                    return f"This number is accurate to the {accurate}st digit"
                elif accurate%10==2:
                    return f"This number is accurate to the {accurate}nd digit"
                elif accurate%10==3:
                    return f"This number is accurate to the {accurate}st digit"
                else:
                    return f"This number is accurate to the {accurate}th digit"
        */
    }
        
    
}
