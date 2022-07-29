/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw6.pkg2;

//import scanner class to scan from keyboard

import java.util.Scanner;

//main class 
public class HW62 {

    public static void main(String[] args) throws Exception {
    //main method 
        
        //declare basic variables needed in the process 
        int year;
        
        int month;

        int day;

        String monthName;

        //Scanning from keyboard
        Scanner sc = new Scanner(System.in);

       
        System.out.println("Enter a Month # (1-12): ");
        //Format our program introduction to user 
        
        month = sc.nextInt();
        //assigning next int inputted from keyboard as the value of month

        System.out.println("Enter a Year #: ");
       
        year = sc.nextInt();

        //create a new month object
        Month obj = new Month();

        //invoke the monthNumberString method on the moName object to the get the name of the month
        monthName = obj.monthNumberString(month);

        //create a new Monthdays object
        Month.MonthDays obj2 = new Month.MonthDays(month, year);

        //initialize the days variable 
        day = obj2.getNumberOfDays(month);

        //create a new Monthdays object that will be later used to display the output
        Month.MonthDays obj3 = new Month.MonthDays(month, year);
        
        //display method used to display output 
        obj3.display(monthName, year, day);
        
    }
}

//Month class starts from here 
class Month {

    //We will need both the monthname and the monthnumber in this class so we declare the fields here
   
    private String monthName;

    private int monthNumber;

    public Month() {
        monthNumber = 1;
    }
    //This is the constructor and we use the try and catch to mae sure quality input is used
    public Month(int monthNumber) {

        try {

            if (monthNumber >= 1 && monthNumber <= 12) {
                this.monthNumber = monthNumber;

            } else {
                monthNumber = 1;
             

            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    
    public Month(String monthName) {

        this.monthName = monthName;

        //constructor for class takes monthname and pairs it with the corresponding number 
        try {
            if (this.monthName.equalsIgnoreCase("January")) {
                this.monthNumber = 1;
            
            } else if (this.monthName.equalsIgnoreCase("February")) {
                this.monthNumber = 2;
            
            } else if (this.monthName.equalsIgnoreCase("March")) {
                this.monthNumber = 3;
            
            } else if (this.monthName.equalsIgnoreCase("April")) {
                this.monthNumber = 4;
            
            } else if (this.monthName.equalsIgnoreCase("May")) {
                this.monthNumber = 5;
            
            } else if (this.monthName.equalsIgnoreCase("June")) {
                this.monthNumber = 6;
            
            } else if (this.monthName.equalsIgnoreCase("July")) {
                this.monthNumber = 7;
            
            } else if (this.monthName.equalsIgnoreCase("August")) {
                this.monthNumber = 8;
            
            } else if (this.monthName.equalsIgnoreCase("September")) {
                this.monthNumber = 9;
            
            } else if (this.monthName.equalsIgnoreCase("October")) {
                this.monthNumber = 10;
            
            } else if (this.monthName.equalsIgnoreCase("November")) {
                this.monthNumber = 11;
            
            } else if (this.monthName.equalsIgnoreCase("December")) {
                this.monthNumber = 12;
            
            } else {
                //Proving wrong and right input
                throw new TheExcept("Incorrect Month Name");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void startMonthNumber(int monthNumber) {
        //making sure that the month number is within a certain number standard
        if (monthNumber >= 1 && monthNumber <= 12) {
            this.monthNumber = monthNumber;
        } else {
            monthNumber = 1;
           //acts as a default
        }
    }

    //method that simply returns month number
    public int getMonthNumber() {
        return monthNumber;
    }

    //method that pairs month name with corresponding number used in main method 
    public String getMonthName(int monthNumber) {
        switch (monthNumber) {

            case 1:
                return "January";
            case 2:
                return "February";
            case 3:
                return "March";
            case 4:
                return "April";
            case 5:
                return "May";
            case 6:
                return "June";
            case 7:
                return "July";
            case 8:
                return "August";
            case 9:
                return "September";
            case 10:
                return "October";
            case 11:
                return "November";
            case 12:
                return "December";
            default:
                return "January";

        }
    }

    //method returns string based on numbers
    public String monthNumberString(int monthNumber) {
        return getMonthName(monthNumber);
    }
    
    //essentially returns checks if month numbers match up
    public boolean equivalent(Month Numb) {

        if (this.getMonthNumber() == Numb.getMonthNumber()) {
            return true;
        
        } else {
            return false;
        
        }
    }

    //inheritence extending from previous class
    static class MonthDays extends Month {
        //declaring fields we will use once again
        private int year;
        
        private int daysNumb;
        
        private int monthNumber;
       
        
        //constructor assigning the month number and the year
        public MonthDays(int monthNumb, int yearNumb) {

            monthNumber = monthNumb;
            year = yearNumb;
        }

        //method will return correct number of days in month 
        public int getNumberOfDays(int monthNumb) {
            //concerned with month of Feburary in leap years
            if (monthNumb == 2) {
                //if year meets conditions it is a leap year and Feb has 29 days 
                if ((year % 100 == 0) && (year % 400 == 0) ) {
                    daysNumb = 29;
                }
                  if(!(year % 100 == 0) && (year % 4 == 0)) {
                      daysNumb=29;
                  }
                 //if the year doesn't meet conditions it is a normal year and thus Feb has 28 days
                  else {
                    daysNumb = 28;
                }
             // January, March, and May have 31 days in a year 
            } else if (monthNumb == 1 || monthNumb == 3 || monthNumb == 5) {
                
                daysNumb = 31;
            
            }
            //July, August, October, and December have 31 days in a year as well
            
            else if (monthNumb == 7
                    || monthNumb == 8 || monthNumb == 10 || monthNumb == 12) {
                daysNumb=31;
            }
            //For all other months we will return 30 days 
            else {
                daysNumb = 30;
            
            }
            return daysNumb;
        }
        
    }
    //display method that will be invoked in the main 
    protected void display(String monthName, int year, int day)
    {
        //All components of output are printed 
        System.out.println(monthName + " " + year + " has " + day + " days ");
    }
}

//this is the exception class that will be invoked in other methods during trying and catching invalid input 
class TheExcept extends Exception {

    public TheExcept(String errorString) {
        //refers to parent class objects
        super(errorString);
    }

    public TheExcept(Throwable error, String errorString) {
        //refers to parent class objects
        super(errorString, error);
    }
}
