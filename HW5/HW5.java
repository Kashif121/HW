/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hw5;

import java.util.Scanner;
import java.io.PrintStream;
import java.io.File;

public class HW5 {

    public static void main(String[] args) throws Exception {
        //Reading in from file with data
        Scanner sc = new Scanner(new File("HW5.txt"));

        //standard declaration of variables
        String vehicle;
        int speed;
        int time;
        int distance;

        //while loop is necessary to read in numbers from input txt file
        while (sc.hasNext()) {
            vehicle = sc.next();
            speed = sc.nextInt();
            time = sc.nextInt();

            distance = speed * time;

            saveAsFile(vehicle, speed, time);
            //invoke important method to change name of the text file we print to for each depending on vehicle

        }

    }

    //String method helps effecitvely format the output more effectively bc it will return a statment for input validation
    public static String distance(int speed, int time) {

        int distance;
        distance = 0;

        String firstLine;
        String dashedLine;
        String hourToString;
        String distanceToString;

        //first line of the formatted input is the Hour and Distance Traveled
        //dashed line is a second string 
        //hourtoString and distanceToString variables respresent hour and distance respectively but will be converting to string in a way we can represent the number
        //all string variables are initialized
        firstLine = "";
        dashedLine = "";
        hourToString = "";
        distanceToString = "";

        //if statment is necessary here to make sure invalid inputs aren't utitlized for time and speed
        if (time >= 1 && speed >= 0) {

            //first line and dashed line are assigned the appropriate values according to the format of the output
            firstLine = "Hour\t\t\t\t\t Distance Traveled";
            dashedLine = "----------------------------------------------------------";

            //for loop is necessary to calculate distance for each input while giving the proper calculation needed to
            //increment to the proper number of hours and then assign proper values that will hold the hour and the distance as it increments
            for (int i = 1; i <= time; i++) {

                distance = speed * i;

                hourToString = Integer.toString(i);
                distanceToString += hourToString + "\t\t\t\t\t" + Integer.toString(distance) + "\n";
            }
            //the else statement is returning a statement that will go occur when time is lower then 1 and speed is lower than 0

        } else {
            return "Inputting a zero for speed and inputting a negative quantity for time is prohibited.";

        }
        return firstLine + "\n" + dashedLine + "\n" + distanceToString;
        //This method is returning a string that first prints the title, and then
        //the next line being the dashed line and the next few lines being the quantity of hours and the distance
    }

    public static void saveAsFile(String vehicle, int speed, int time) throws Exception {
        //need throws Exception because of the PrintStream class
        //Printing to output txt file that will receive specific vehicle name and add to the extention of txt file
        PrintStream ps = new PrintStream(vehicle.concat(".txt"));

        //prints out Vehicle type at the top of file we are printing to
        //Invoking the distance method and printing the distance calculations for each vehicle
        ps.println("Vehicle Type: " + vehicle);
        ps.println();
        ps.println(distance(speed, time));
    }

}
