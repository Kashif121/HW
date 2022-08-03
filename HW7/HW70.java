/*
 * Program 7 intends to simulate filling up the car with fuel and then proceeds into 
 *a loop that will increase the vehicle's odometer, while accelerating multiples of 5
 *and braking up until the point where car runs out of fuel. Each invocation of the 
 *brake method will have the current speed of the car and display it. 
 * 
 * Information: Output file on github repository is called "HW71.txt"
 */
package hw7.pkg0;

import java.util.Scanner;

public class HW70 {

    public static void main(String[] args) throws Exception {
       
        //declare appropriate varibles 
        String name;
        int year;
        double gallons = 0.0;
        int mileage = 0;
        
        //Scan in from the keyboard
        Scanner sc = new Scanner(System.in);

        //prompt user for the name of the car mode, and then read it assign it to the name variable. Do this again with year
        System.out.println("Input a name of specific car model");
        name = sc.nextLine();

        System.out.println("\nInput a year for" + " " + name);
        year = sc.nextInt();
        
        //Instantiating new objects
        Car obj1 = new Car(name, year);
        Car.FuelGauge obj2 = new Car.FuelGauge(gallons);
        Car.Odometer obj3 = new Car.Odometer(mileage, obj2);
        
        //Says the exact model of car and year 
        System.out.println("\n" + obj1.getyearModel() + " " + obj1.getMake());
        System.out.println("-----------------------");
        
        System.out.println("Fueling vehicle....");
        
        //Similate fueling up car to the max number of gallons 
        for (int x = 0; x < obj2.Maxgal; x++) {
            obj2.increaseGallons();
            System.out.println(obj2.getGallons());
        }
        //While loop makes sure this stops running when gallons equals 0
        while (obj2.getGallons() > 0) {
            
            System.out.println("\nAccelerating");
            
            //For loop to accelerate up to 30 
            for (int i = 0; i <= 5; i++) {
                //make sures gallons doesn't get negative 
                
                if (obj2.getGallons() <= 0) {
                    break;
                }
                
                //accleration method from obj 1.
                //Then get utilize the getSpeed method from the obj1 
                obj1.accelerate();
                System.out.println(obj1.getSpeed());
                //increase mileage 
                obj3.increaseMileage();
                //printing out the milage and then the fuel level remaining 
                System.out.println(obj3.getMileage() + " miles");
                System.out.println("The current fuel level is :" + " " + obj2.getGallons() + " gallons\n");
            }

            System.out.println();
            
            //Now we will use the brake method and focus on slowing down
            System.out.println("Decelerating");

            for (int k = 0; k <= 5; k++) {
                //Again make sure that the gallon output isn't negative
                if (obj2.getGallons() <= 0) {
                    break;
                }
                //Invoke brake method from obj1
                obj1.brake();
                
                //Prints speed from getSpeed method from obj1
                System.out.println(obj1.getSpeed());
                
                //Invoke increaseMileage method from obj3
                obj3.increaseMileage();
                
                 //Print mileage and the fuel level 
                System.out.println(obj3.getMileage() + " miles");
                System.out.println("The current fuel level is :" + " " + obj2.getGallons() + " gallons\n");

            }

        }
    }
}
//End of class

class Car {
    //Create fields 
    protected int year;
    protected int Speed;
    protected String Make;

    //Class constructor defines fields
    public Car() {
        Speed = 0;
        Make = "";
        year = 0;

    }
    //Class constructor defines fields
    public Car(String name, int year) {
        this.Make = name;
        this.year = year;
    }
    //returns year
    public int getyearModel() {
        return year;
    }
    //returns name of the vehicle 
    public String getMake() {
        return Make;
    }
    //returns speed 
    public int getSpeed() {
        return Speed;
    }
    //Increment speed by 5 when accelerate method is invoked
    public void accelerate() {

        Speed = Speed + 5;
    }
    
    //Decrease speed by 5 when deceleration method is invoked 
    public void brake() {
        if (Speed != 0) {
            Speed = Speed - 5;
        }

    }
    //Subclass for Car class through inheritence 
    static class FuelGauge extends Car {
        //Maximum number of gallons
        final int Maxgal = 15;
        
        //Create fields 
        private double gallons;
        private int year;
        private String name;
        
        //Makes sure that gallons will not exceed the maximum number of gallons
        public FuelGauge(double gal) {
            if (gallons <= Maxgal) {
                this.gallons = gal;
            } else {
                this.gallons = Maxgal;
            }
        }
        //Returns number of gallons 
        public double getGallons() {
            return gallons;
        }
        
        //Increment number of gallons as we will need later for fueling it up
        public void increaseGallons() {
            //Use if statement to make sure to increment gallons only if gallons is lower than max number of gallons
            if (gallons < Maxgal) {
                gallons++;
            } else {
                System.out.println("Too much fuel");
            }
        }
        //Decrements number of gallons by a random fractional value so that we can eventually get to 0 gallons left
        public void decreaseGallons() {
            //Use if statement to make sure to decrease gallons as long its higher than 0
            if (gallons > 0) {
                gallons -= 1 + Math.random();
            } else {
                System.out.println("Too little fuel");
            }
        }

    }
    //Inheritence and extends from the Car Class 
    static class Odometer extends Car {

        // Different fields that we will utilize later on except maxmileage
        private int startMileage;
        public final int maxMileage = 999999;
        private int mileage;

        //Utilize this to recongize FuelGauge object
        protected FuelGauge fuelGauge;
        
        //Assigning values to said fields 
        public Odometer(int mileage, FuelGauge fuelGauge) {
            this.startMileage = mileage;
            this.fuelGauge = fuelGauge;
            this.mileage = mileage;

        }
         
        //Returns Mileage
        public int getMileage() {
            return mileage;
        }
        //Makes sure to increase mileage accordingly 
        public void increaseMileage() {
            //if statement recognizing to increment mileage by 5
            if (mileage < maxMileage) {
                mileage += 5;
            } else {
                mileage = 0;
            }
            
            //Essentially always the difference bewteen the mileage and the inital milleage
            int difference = mileage - startMileage;
            
            //Recognizes one gallone per 24 miles
            //Once that occurs we will decrease the gallons 
            for (int i = 0; i < difference / 24; i++) {
                fuelGauge.decreaseGallons();
            }
            //Add the initial mileage to the difference and assign it to the start mileage
            startMileage += (difference / 24) * 24;
            
            //Essentially another if statement to make sure that gallons is not 0
            if (fuelGauge.getGallons() < 0) {
                fuelGauge.gallons = 0;
            }
        }
    }
}
