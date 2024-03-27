/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.calculatepi;

/**
 *
 * @author Alex
 * 
 * this is created to calculate pi to the nth digit
 * then compare to see how many digits are accurate
 */
public class CalculatePi {
    
    private double pi = 3.1415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679;
    
    public static void main(String[] args) {
        // TODO: add time keeping, Java is already leagues ahead of Python so theres not much need
        // for it but it would be nice to be able to run it
        // TODO: complete compare and tack it to the end of the class
        System.out.println("Hello World!");
        // initilize denominator
        double k = 1;
        // initilize sum
        double s = 0.0;
        
        for (long i=0; i<10000000000L; i++) {
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
        
        }
   
    public static void compare(String[] args) {
        
        
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
