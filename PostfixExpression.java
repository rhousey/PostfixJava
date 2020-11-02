// Rebecca Housey
// CSE 017 
// ALA #8 
import java.util.*; 
import java.util.EmptyStackException; 

public class PostfixExpression {
    public static void main(String[] args) throws EmptyStackException{ 
        Scanner scnr = new Scanner(System.in); 
        Stack<Integer> postfixStack = new Stack<Integer>(); 
        System.out.println("Enter a postfix expression with numbers and operators separated by a space"); 
        String input = scnr.nextLine(); 
        //using .split() to create a String array of the expression with operands and operators
        String[] tokens = input.split(" ");
           for(int i = 0; i < tokens.length; i++){ 
               //if the token is an operand push it into the postfixStack.
               if(isOperand(tokens[i])){
                   postfixStack.push(Integer.parseInt(tokens[i])); 
               }
               //if the token is an operator 
               else if(isOperator(tokens[i])){
                   try{
                       int op1 = postfixStack.pop(); 
                       int op2 = postfixStack.pop(); 
                       
        //case statements for each kind of operator
            switch(tokens[i]){
                case "-": 
                    postfixStack.push(op2-op1); 
                    break; 
                case "+": 
                    postfixStack.push(op2+op1); 
                    break; 
                case "/": 
                    postfixStack.push(op2/op1); 
                    break; 
                case "*": 
                    postfixStack.push(op2*op1); 
                    break; 
            }
             }
                   // catch block for emptystack 
                   catch(EmptyStackException e){ 
                 System.out.println("Postfix expression malformed."); 
                 System.exit(1); 
                    }
            }
           }
        
    //try-catch for printing out the result at the end 
     try{
     System.out.println(postfixStack.pop()); 
      }
      catch(EmptyStackException e){ 
          System.out.println("Postfix expression malformed."); 
          System.exit(1); 
      }
    }
   
    //boolean method to check if String is an operand
    public static boolean isOperand(String s){ 
      try{ 
          Integer.parseInt(s); 
      }
      catch(NumberFormatException e){ 
          return false; 
      }
      catch(NullPointerException e){ 
          return false; 
      } 
      return true; 
    }
      
    //boolean method to check if String is an operator
    public static boolean isOperator(String s){ 
        if(s.equals("*") || s.equals("-") || s.equals("/") || s.equals("+")){
            return true; 
        }
        return false; 
    }
}
