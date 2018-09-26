/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dfa1;

public class DFAScanner {
    
    public static String number = "";
    public static int currentIndex = 0;
    public static char currentChar;
    
    public DFAScanner(String n){                     
        number = n;
        currentChar = number.charAt(currentIndex);
        if(currentChar == '$')
            mainLoop();
        else
            System.out.println("Invalid $");
    }   
    static void mainLoop(){
        checkEnd(false);
        inc();
        while(currentChar  == '*'){     
            checkEnd(false);
            inc();
        }
        if(currentChar == '0')
        {
            checkEnd(true);  
            inc();
            decimalPoint(); 
        }
        
        for(int i = 0; i < 2; i++){
            if(isDigit() == true){
                checkEnd(true);
                inc();               
            }
            if(currentChar == '.' && i != 0){                              
                decimalPoint();
            }
            if(currentChar == ',' && i != 0){
                checkEnd(false);
                commaLoop();     
            }            
        }  
        checkEnd(true);  
        inc();
        if(currentChar == ','){            
            commaLoop();            
        }
        if(currentChar == '.')
            decimalPoint();
        else{
            System.out.println("Invalid");
            System.exit(0);
        }
    }
                  
    static void commaLoop(){        
        checkEnd(false);
        if(currentChar == ','){
            inc();           
            for(int i = 0; i < 2; i++){
                if(isDigit() == true){
                    checkEnd(false);
                    inc();
                }
                else{
                    System.out.println("Invalid1");
                    System.exit(0);
                }
            }
            checkEnd(true);
            inc();
            if(currentChar == ',')
                commaLoop();
            else if(currentChar == '.')
                decimalPoint();
            else{
                System.out.println("Invalid2");
                System.exit(0);
            }                
        }
        else{
            System.out.println("Invalid3");
            System.exit(0);
        }
    } 
    
    static void decimalPoint(){                
        checkEnd(false);
        if(currentChar == '.'){
            checkEnd(false);
            inc();
            for(int i = 0; i < 2; i++){                 
                if(isDigit() != true){
                    System.out.println("Invalid2");
                    System.exit(0);
                }
                if(i==0)
                    checkEnd(false); 
                if(i==1)
                    checkEnd(true);
                inc();
            }             
            System.out.println("Invalid6");
            System.exit(0);
        }
        else{
            System.out.println("Invalid3");
            System.exit(0);                
        }                    
    }
    
    static void inc(){
        currentIndex++;
        currentChar = number.charAt(currentIndex);
    }   
    
    static void checkEnd(boolean b){
        if((currentIndex == number.length()-1) && b == false)
        {
            System.out.println("Invalid4");
            System.exit(0);
        }
        else if((currentIndex == number.length()-1) && b == true){
            System.out.println("Valid");
            System.exit(0);
        }
            
    }
    
    static boolean isDigit(){
        switch(currentChar){
            case'0':case '1':case '2':case '3':case '4':
            case '5':case '6':case '7':case '8':case '9': 
                return true;
            default:
                return false;
        } 
    }
    
}
