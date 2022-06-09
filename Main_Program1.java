/* Talon Knowlton 
 * CSCI 4448 Summer 2022
 * Project 1 Program 1: Numerical Analysis
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Comparator;
import java.lang.Math;


class Reader {
    
    public ArrayList<Double> reader()
    {
    
    boolean quit=false;
    Scanner myobj = new Scanner(System.in);
    String input_value;
    ArrayList<Double> my_numbers = new ArrayList<Double>();

        //as long as quit is false we will keep inputting numbers
        while (quit!=true){
            
    
            System.out.println("Enter A Number or Enter Null Value to Quit:");
            input_value=myobj.nextLine(); //read in input

            //ending inputs functionality
            if (input_value.length()==0){
                System.out.println("Quit button pressed, ending input functionality.");    
                quit=true;
                break;
            }

            //Used for try-catch block
            //https://www.studytonight.com/java-examples/check-if-input-is-integer-in-java
            
            //if integer is inputed add to list
            try{    
                double int_value=Double.parseDouble(input_value);
                my_numbers.add(int_value);
                System.out.println("Current array: ");
                //print out array
                for (int i=0;  i<my_numbers.size(); i++){
                    System.out.print( my_numbers.get(i)+", ");
                }
                System.out.println(" ");
                System.out.println(" ");
            }

            //if integer is not inputed
            catch(Exception Not_Integer){
                System.out.println("ERROR: need to input a number");
                System.out.println(" ");
            }       
        }

    myobj.close(); 
    return (my_numbers);       
    }   

    
    
}   
   //////main starts here//////
public class Main_Program1{
   public static void main(String[] args)
  { 
    Reader r = new Reader();
    Analyzer a = new Analyzer();

    
    ArrayList <Double> mylist=r.reader();
    
    a.analyze(mylist);  

  }   
}

class Analyzer{

    public void analyze(ArrayList<Double> mylist)
    {
        mylist.sort(Comparator.naturalOrder());//sort Array
        
        //call all functions
        double list_sum=(sum(mylist));
        double median=(median(mylist));
        double mean=(mean(mylist));
        double minimum=(minimum(mylist));
        double maximum=(maximum(mylist));
        double standard_deviation=(standard_deviation(mylist));

        //output the resulting calculations
        System.out.println("The list sum is " + list_sum);
        System.out.println("The list median is " + median);
        System.out.print("The list mean is ");
        System.out.format("%.3f",  mean);
        System.out.println(" ");
        System.out.print("The list sample standard deviation is ");
        System.out.format("%.3f", standard_deviation);
        System.out.println(" ");
        System.out.println("The list minimum is " + minimum);
        System.out.println("The list maximum is " + maximum);
        System.out.println(" ");
        
    }

    //Sum function
    private double sum(ArrayList<Double> mylist)
    {           
        double total=0;
        for (int i=0; i<mylist.size(); i++){
            total = total + mylist.get(i);
        }
        return (total);
    }

    //Median function
    private double median(ArrayList <Double> mylist)
    {
        int midpoint = (mylist.size()/2);
        
        if (mylist.size()%2==0)//even sized arrays
        {   
            Double x=((mylist.get(midpoint-1)+mylist.get(midpoint))/2.0);
            return x;
        }
        else//odd sized arrays
        {
            return(mylist.get(midpoint));
        }
        
    }

    // Sample Standard Deviation function
    private double standard_deviation(ArrayList <Double> mylist)
    {
        double mean=mean(mylist);
        ArrayList <Double> numerator_list = new ArrayList<Double>();
        
        //The sum part of the numerator: (x-xhat)^2
        for (int i=0 ; i<mylist.size(); i++)
        {   
            double x=(mylist.get(i)-mean);
            numerator_list.add(x*x);
        }
        
        double total=0.0;
        //rest of numerator under square root
        for (int i=0; i<numerator_list.size(); i++)
        {
            total=numerator_list.get(i)+total;
        }

        // (numerator/denominator)
        total=((total)/(numerator_list.size()-1));

        total=Math.sqrt(total);
        return total;

    }

    //Mean function
    private double mean(ArrayList<Double> mylist)
    {
        double sum = sum(mylist);
        return (sum/mylist.size());
    }

    //Minimum function
    private double minimum(ArrayList<Double> mylist)
    {
        return (mylist.get(0));
    }

    //Maximum function
    private double maximum(ArrayList<Double> mylist)
    {
        return(mylist.get((mylist.size()-1)));
    }

    
}