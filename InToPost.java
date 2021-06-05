import java.util.Arrays;

public class InToPost {
    
    static String a = "";
    static int pointer = -1;
    static char value = ' ';
    static int size = 25;
    static String fix = "";
    
    static char[] stack = new char[size];
    

    public static void main(String[] args) {
        
        System.out.println("Brackets will be added around the input expression to make the conversion run smoothly if none are provided:");
        System.out.println("A Stack of fixed size 25 is used:");
        
        for(int i = 0; i < stack.length; i++) {
            stack[i] = ' ';
        }
        
        if (args.length < 1){System.out.println("Provide an expression to be converted."); System.exit(0);}
        
        if (args.length > 1){System.out.println("Only provide one expression to be converted."); System.exit(0);}
        
        String input = (args[0]);
        
        String infix = "";
        
        if (input.charAt(0) != '(' || input.charAt(input.length()-1) != ')'){
            
            infix = '(' + input + ')';
            
        }
        
        else{infix = input;}

        int i = 0;
        
        // Infix to Postfix conversion.       
        while (i < infix.length()) {
            
            char ch = infix.charAt(i);
            
            if (Character.isDigit(ch) == true) {
                
                fix = fix + ch;                
                
                i++;
            }
            else if (ch == '(') {
                push(stack, ch);
                
                a = Arrays.toString(stack);
                System.out.println(a);                    
                
                i++;
            }
                        
            else if (ch == ')') {
                
                int j = notEmpty(stack)-1;
                
                // Keep popping until we get to a '(' in the stack.
                while (stack[j] != '('){
            
                    pop(stack);
                    
                    a = Arrays.toString(stack);
                    System.out.println(a);                        
            
                    j--;  
                }
                
                i++;
            }

            else if (ch == '*' || ch == '/') {
                
                int j = notEmpty(stack)-1;
                
                if (j == -1){j = 0;}
                
                // Keep popping until we get to a '(' in the stack.
                while (stack[j] != '(' && notEmpty(stack) != 0){
            
                    pop(stack);
                    
                    a = Arrays.toString(stack);
                    System.out.println(a);                    
            
                    j--;
                    
                }

                push(stack, ch);
                
                a = Arrays.toString(stack);
                System.out.println(a);                  

                i++;
            }

            else if (ch == '+' || ch == '-'){
                
                int j = notEmpty(stack)-1;
                
                if (j == -1){j = 0;}
                
                // Keep popping until we get to a '(' in the stack.
                while (stack[j] != '(' && notEmpty(stack) != 0){
                    
                    pop(stack);
                    
                    j--;
                    
                }
                
                push(stack, ch);
                
                a = Arrays.toString(stack);
                System.out.println(a);                  

                i++;
            }
            else {i++;}
           
        }
        
        /*After considering all of the characters in the string
        pop any remaining items in the stack.*/
        int j = notEmpty(stack)-1;
       
        while (j != -1){
            
            pop(stack);
            
            a = Arrays.toString(stack);
            System.out.println(a);              
            
            j--;
                    
        }

        String postfix = fix.replaceAll("[(]", "");
        
        System.out.println("Postfix " + postfix);
        
    }
    
    /*A method to know when to stop popping from the stack
    based upon the number of elements currently in it.*/
    public static int notEmpty (char[] stack){
        
        int count = 0;
        
        for (int i = stack.length-1; i > -1; i--){
            
            if(stack[i] != ' '){
                
                count++;
            }
        }
           
      return count;      
           
    }
    
    
    public static char[] push (char[] stack, char value){
        
        pointer++;
        
        stack[pointer] = value;
        
        return stack;
    }
    
    public static char pop (char[] stack){

        value = stack[pointer];
        stack[pointer] = ' ';
        
        pointer--;
        
        fix = fix + value;
                
        return value;

    }
    
}
