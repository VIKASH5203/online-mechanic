package streamdemo;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class BasicStreamDemo {

	public static void main(String[] args) throws ParseException {
        // Create a Scanner object for reading input
        Scanner input = new Scanner(System.in);
 
        // Prompt the user to enter a date
        System.out.println("Enter a date (dd/MM/yyyy):");
        String dateString = input.next();
 
        
////        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
//        LocalDate date1 = LocalDate.parse(dateString);  
 
        // Print the Date object to the console
        System.out.println(dateString);
    }

}
