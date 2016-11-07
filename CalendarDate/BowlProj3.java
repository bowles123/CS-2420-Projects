// This program demonstrates the CalenderDate class.
// Brian Bowles, September 15, 2014.
package bowlproj3;
import java.util.Scanner;

// Main class.
public class BowlProj3 {

    /**
     * @param args the command line arguments
     */
    // Main function, carries out function calls to demonstrate CalenderDate class.
    public static void main(String[] args) {
        // Variables.
        int month = 0, day = 0, year = 0;
        CalenderDate date = new CalenderDate(month, day, year);
        Scanner input = new Scanner(System.in);
        
        // Greeting.
        System.out.println("Hello this program demonstrates the CalenderDate class");
        
        // Get the date from the user.
        System.out.print("Enter the date in the form Month Day Year.");
        month = input.nextInt();
        day = input.nextInt();
        year = input.nextInt();
        
        // Assign those values to the data fields of the CalenderDate class.
        date.setDate(month, day, year);
        
        // Output the current date, in both forms, and tomorrow's date.
        date.displayDate1();
        date.displayDate2();
        System.out.println("There are " + date.AmountOfDays (month, year) 
                + " days this month.");
        date.advanceDate();
        System.out.print("Tomorrow is: ");
        date.displayDate2();
    }
}

// CalenderDate class, represents a given date on the calender.
class CalenderDate {

       final int JANUARY = 01, FEBRUARY = 02, MARCH = 03, APRIL = 04, MAY = 05, 
       JUNE = 06, JULY = 07, AUGUST = 8, SEPTEMBER = 9, OCTOBER = 10,
       NOVEMBER = 11, DECEMBER = 12;
    
    // Data fields.
    private int month;
    private int day;
    private int year;
    
    // Constructor, initializes data fields through the given parameters.
    public CalenderDate (int tempMonth, int tempDay, int tempYear) {
        month = tempMonth;
        day = tempDay;
        year = tempYear;
    }
    
    //  Gets the current value for month.
    public int getMonth () {
        return month;
    }
    
    // Gets the curren value for day.
    public int getDay () {
        return day;
    }
    
    // Gets the current value for year.
    public int getYear () {
        return year;
    }
    
    // Sets the date given through the parameters.
    public void setDate (int Month, int Day, int Year) {
        month = Month;
        day = Day;
        year = Year;
    }
    
    // Displays the date in the form Month/Day/Year.
    public void displayDate1 () {
        System.out.println ("The date is " + month + "/" + day + "/" + year);
    }
    
    // Displays the day in the form Month Day, Year.
    public void displayDate2 () {
        switch (month) {
            case JANUARY: 
                System.out.println ("The date is January " + day + ", " + year + ".");
                break;
            case FEBRUARY:
                System.out.println ("The date is February " + day + ", " + year + ".");
                break;
            case MARCH:
                System.out.println ("The date is March " + day + ", " + year + ".");
                break;
            case APRIL:
                System.out.println ("The date is April " + day + ", " + year + ".");
                break;
            case MAY:
                System.out.println ("The date is May " + day + ", " + year + ".");
                break;
            case JUNE:
                System.out.println ("The date is June " + day + ", " + year + ".");
                break;
            case JULY:
                System.out.println ("The date is July " + day + ", " + year + ".");
                break;
            case AUGUST:
                System.out.println ("The date is August " + day + ", " + year + ".");
                break;
            case SEPTEMBER:
                System.out.println ("The date is September " + day + ", " + year + ".");
                break;
            case OCTOBER:
                System.out.println ("The date is October " + day + ", " + year + ".");
                break;
            case NOVEMBER:
                System.out.println ("The date is November " + day + ", " + year + ".");
                break;
            default: 
                System.out.println ("The date is December " + day + ", " + year + ".");
                break;
        }
    }
    
    // Finds the amount of days in a given month.
    public int AmountOfDays (int tempMonth, int tempYear) {
        switch (tempMonth) {
            case JANUARY: 
                return 31;
            case FEBRUARY:
                // If year is a leap year return 29 days for February.
                if (tempYear % 4 == 0 && tempYear % 100 != 0)
                    return 29;
                else 
                    return 28;
            case MARCH:
                return 31;
            case APRIL:
                return 30;
            case MAY:
                return 31;
            case JUNE:
                return 30;
            case JULY:
                return 31;
            case AUGUST:
                return 31;
            case SEPTEMBER:
               return 30;
            case OCTOBER:
                return 31;
            case NOVEMBER:
                return 30;
            default: 
                return 31;
        }
    }
    
    // Returns tomorrow's date based off of the given date.
    public void advanceDate () {
        switch (AmountOfDays(month, year)) {
            case 28:
                // If the given day was the last day of February advance month as well.
                if (day == 28) {
                    month++;
                    day = 01;
                }
                else
                    day++;
                break;
            case 29:
                // If the given day was the last day of February, and its a
                // leap year,advance month as well.
                if (day == 29) {
                    month++;
                    day = 01;
                }
                else
                    day++;
                break;
            case 30:
                // If the given day was the last day of a month with 30 days
                // advance month as well.
                if (day == 30) {
                    month++;
                    day = 01;
                }
                else
                    day++;
                break;
            default:
                // If the given day was the last day of a month with 31 days
                // advance month as well.
                if (day == 31 && month == 12) {
                    year++;
                    month = 01;
                    day = 01;
                }
                else {
                    if (day == 31) {
                        month++;
                        day = 01;
                    }
                    else 
                        day++;
                }
                break;
        }
    }
}


