package dayofbirth;
import java.util.*; 

public class user {
    private int birthMonth; 
    private int birthDay; 
    private int birthYear; 
    private String zodiac; 
    private String dayOfWeek; 
    
    public user(int month, int day, int year)
    {
        setAll(month, day, year);
        zodiac = ""; 
        dayOfWeek = ""; 
    }
    
    public void setAll(int month, int day, int year)
    {
        setBirthMonth(month); 
        setBirthDay(day);
        setBirthYear(year); 
    }
    public void setBirthMonth(int month)
    {
        birthMonth = month; 
    }
    
    public void setBirthDay(int day)
    {
        birthDay = day; 
    }
    
    public void setBirthYear(int year)
    {
        birthYear = year; 
    }
    
    public int getBirthMonth()
    {
        return birthMonth; 
    }
    
    public int getBirthDay()
    {
        return birthDay; 
    }
    
    public int getBirthYear()
    {
        return birthYear; 
    }
   
    public void calculateDayOfWeek()
    {
        int[] monthOffset  = {6, 2, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4};
        HashMap<Integer, Integer> decadeOffset = new HashMap<Integer, Integer>(); 
        
        decadeOffset.put(1900, 1);
        decadeOffset.put(1910, 6); 
        decadeOffset.put(1920, 5); 
        decadeOffset.put(1930, 3); 
        decadeOffset.put(1940, 2); 
        decadeOffset.put(1950, 0); 
        decadeOffset.put(1960, 6); 
        decadeOffset.put(1970, 4); 
        decadeOffset.put(1980, 3);
        decadeOffset.put(1990, 1); 
        decadeOffset.put(2000, 0);
        decadeOffset.put(1910, 5); 
        
        int[][] leapOffset = {{0, 0, 0, 0, 1, 1, 1, 1, 2, 2}, {0, 0, 1, 1, 1, 1, 2, 2, 2, 2}}; 
        
        //step 1: add day of year and month offset
        int offset = monthOffset[birthMonth-1];
        int weekOffset = offset + birthDay; 
        
        //step 2: add on decade offset 
        weekOffset += decadeOffset.get((birthYear/10)*10); 
        
        //step 3: add the ones place of the year
        int num2 = birthYear / 10;
        int onesPlace = birthYear - num2 * 10;
        weekOffset += onesPlace; 
        
        //step 4: add leap year offset 
        int decade = (birthYear/10)*10; 
        weekOffset += leapOffset[decade%2][onesPlace]; 
        
        //step 5: take the mod of 7 to find the day  
        int weekday = weekOffset % 7; 
        
        switch(weekday)
        {
            case 0:
                dayOfWeek = "Sunday"; 
                break; 
            case 1: 
                dayOfWeek = "Monday"; 
                break; 
            case 2: 
                dayOfWeek = "Tuesday"; 
                break; 
            case 3: 
                dayOfWeek = "Wednesday"; 
                break; 
            case 4: 
                dayOfWeek = "Thursday"; 
                break; 
            case 5: 
                dayOfWeek = "Friday";
                break; 
            default: 
                dayOfWeek = "Saturday"; 
                break;
        }
    }
    
    public void calculateZodiac()
    {
        if      ((birthMonth == 12 && birthDay >= 22 && birthDay <= 31) || (birthMonth ==  1 && birthDay >= 1 && birthDay <= 19))
            zodiac = "Capricorn";
        else if ((birthMonth ==  1 && birthDay >= 20 && birthDay <= 31) || (birthMonth ==  2 && birthDay >= 1 && birthDay <= 17))
            zodiac = "Aquarius";
        else if ((birthMonth ==  2 && birthDay >= 18 && birthDay <= 29) || (birthMonth ==  3 && birthDay >= 1 && birthDay <= 19))
            zodiac = "Pisces";
        else if ((birthMonth ==  3 && birthDay >= 20 && birthDay <= 31) || (birthMonth ==  4 && birthDay >= 1 && birthDay <= 19))
            zodiac = "Aries";
        else if ((birthMonth ==  4 && birthDay >= 20 && birthDay <= 30) || (birthMonth ==  5 && birthDay >= 1 && birthDay <= 20))
            zodiac = "Taurus";
        else if ((birthMonth ==  5 && birthDay >= 21 && birthDay <= 31) || (birthMonth ==  6 && birthDay >= 1 && birthDay <= 20))
            zodiac = "Gemini";
        else if ((birthMonth ==  6 && birthDay >= 21 && birthDay <= 30) || (birthMonth ==  7 && birthDay >= 1 && birthDay <= 22))
            zodiac = "Cancer";
        else if ((birthMonth ==  7 && birthDay >= 23 && birthDay <= 31) || (birthMonth ==  8 && birthDay >= 1 && birthDay <= 22))
            zodiac = "Leo";
        else if ((birthMonth ==  8 && birthDay >= 23 && birthDay <= 31) || (birthMonth ==  9 && birthDay >= 1 && birthDay <= 22))
            zodiac = "Virgo";
        else if ((birthMonth ==  9 && birthDay >= 23 && birthDay <= 30) || (birthMonth == 10 && birthDay >= 1 && birthDay <= 22))
            zodiac = "Libra";
        else if ((birthMonth == 10 && birthDay >= 23 && birthDay <= 31) || (birthMonth == 11 && birthDay >= 1 && birthDay <= 21))
            zodiac = "Scorpio";
        else if ((birthMonth == 11 && birthDay >= 22 && birthDay <= 30) || (birthMonth == 12 && birthDay >= 1 && birthDay <= 21))
            zodiac = "Sagittarius";
        else
            zodiac = ""; //invalid date 

    }

    
    @Override
    public String toString()
    {
        return "The day of the week you are born on is " + dayOfWeek + "\n" + " and your zodiac sign is " + zodiac + "."; 
    }
}
