/* Talon Knowlton 
 * CSCI 4448 Summer 2022
 * Project 1 Program 2: Name Inputting
 */

import java.util.Scanner;
import java.util.Arrays;

//////Main//////
public class Main_Program2{
        public static void main(String[] args)
   { 
        Sorter s = new Sorter();
        s.sorter();
   }
}


class Sorter{

//////Start of sorter()////// 
    public void sorter()
    {   
        String mystring=read();
        
        mystring = sort(mystring);
        
        write(mystring);
    }


/////Start of read()////// 
    private String read()
    {
    boolean quit=false;
    Scanner myobj = new Scanner(System.in);
    String input_value;
    String stored_inputs="";

        //as long as quit is false we keep taking in inputs
        while (quit!=true){

            System.out.println("Enter String Input or Enter Null Value to Quit:");
            input_value=myobj.nextLine(); //read in input
            
            //ending input functionality
            if (input_value.length()==0){
                System.out.println("Quit button pressed, ending input functionality.");  
                System.out.println("");  
                quit=true;
                break;
            }
            else
            {
                stored_inputs=stored_inputs.concat(input_value);
                System.out.println("Currently stored string: " + stored_inputs);
                System.out.println("");
            }
        }
    myobj.close();
    return stored_inputs;
    }


//////Start of sort()////// 
    private String sort(String mystring){

        mystring = mystring.toUpperCase();
        mystring = mystring.replaceAll("\\s","");
        
        //change to char array, then sort by ABC order, and then change back to string
        char array[] = mystring.toCharArray();
        Arrays.sort(array);
        mystring = new String(array);

        return mystring;
    }

//////Start of write()////// 
    private void write(String mystring){
        System.out.println("Final output: " + mystring);
    }

}//end of Sorter class declaration

