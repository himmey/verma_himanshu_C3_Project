/*This program will show demo on a simple calculator*/
<<<<<<< HEAD
/*This program will add two numbers */

=======
/*This comment will be available from branch2 merge*/
/*Option5 - Worng choice entered*/
>>>>>>> branch2
import java.util.Scanner;

 public class calculator
  {
    public static void main(String args[])
     {
       float a, b, res;
       char choice, ch;
       Scanner scan = new Scanner(System.in);
	      
      	do
         {
           System.out.print("1. Addition\n");
           System.out.print("2. Subtraction\n");
           System.out.print("3. Multiplication\n");
           System.out.print("4. Division\n");
           System.out.print("5. Exit\n\n");
           System.out.print("Enter Your Choice : ");
           choice = scan.next().charAt(0);
           switch(choice)
            {
              case '1' : System.out.print("Enter Two Number : ");
                         a = scan.nextFloat();
                         b = scan.nextFloat();
                         res = a + b;
                         System.out.print("Result = " + res);
	                 break;															                       
	      case '2' : System.out.print("Enter Two Number : ");
	                 a = scan.nextFloat();
	                 b = scan.nextFloat();
	                 res = a - b;
	                 System.out.print("Result = " + res);
	                 break;
	 
	      case '3' : System.out.print("Enter Two Number : ");
	                 a = scan.nextFloat();
	                 b = scan.nextFloat();
	                 res = a * b;
	                 System.out.print("Result = " + res);
	                 break;
	 
	      case '4' : System.out.print("Enter Two Number : ");
	                 a = scan.nextFloat();
	                 b = scan.nextFloat();
	                 res = a / b;
	                 System.out.print("Result = " + res);
	                 break;
	 
	      case '5' : System.exit(0);
	                 break;
	
	      default : System.out.print("Very Wrong Choice!!!");
	                break;
	   }
																	            System.out.print("\n---------------------------------------\n");
	}while(choice != 5);
    }
}
