package dayofbirth;
import static java.lang.System.exit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer; 
        
public class DayOfBirth {

    public static void main(String[] args) 
    {
        int month = 0;
        int day = 0; 
        int year = 0; 
        boolean validInput = false;
        String userInput = ""; 
        String inputLine = ""; 
        String delim = "/"; 
        
        
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Welcome to the Zodiac Program");
        System.out.println("Please type in your date of birth in the following format: MM/DD/YYYY" + "\n" + "or exit the program by typing: exit");
        
        do{
            userInput = keyboard.nextLine(); 
            
            if("exit".equals(userInput))
                exit(0); 
            else
                validInput = checkDate(userInput); 
            
        }while(validInput == false); 
        
        StringTokenizer dateFactory = new StringTokenizer(userInput, delim);
        month = Integer.parseInt(dateFactory.nextToken()); 
        day = Integer.parseInt(dateFactory.nextToken());
        year = Integer.parseInt(dateFactory.nextToken());
        
        user user1 = new user(month, day, year); 
        
        user1.calculateDayOfWeek();
        user1.calculateZodiac();
        
        //print results to user 
        System.out.println(user1.toString()); 
        
    }
    
    static boolean checkDate(String userDate)
    {
        try{
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        dateFormat.setLenient(false);

        Date javaDate = null;
        
        javaDate = dateFormat.parse(userDate);
        }
        
        catch(ParseException e)
        {
            System.out.println("The date you provided is not in the valid"
                    + "format. Please try again or exit the program by typing: exit" + "\n");
            return false; 
        }
        
        System.out.println("Thank you, the date provided is valid.\n" );
        return true; 
    }
}

