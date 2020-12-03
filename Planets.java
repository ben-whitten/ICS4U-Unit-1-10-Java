/*
* The Planets program implements an application that
* allows the user to input the planets name and returns the position or vice
* versa.
*
* @author  Ben Whitten
* @version 1.0
* @since   2020-12-3 
*/

import java.util.Scanner;  // Import the Scanner class

///////////////////////////////////////////////////////////////////////////////

public class Planets {

  ///////////////////////////////////////////////////////////////////////////////

  // enum showing planet positions
  // NOTE: I made 2 seperate enums as it is more simple than figuring out how
  // to pass in a value at get the name.
  public enum PlanetPositions {
    Sun(0),
    Mercury(1),
    Venus(2),
    Earth(3),
    Mars(4),
    Jupiter(5),
    Saturn(6),
    Uranus(7),
    Neptune(8),
    Pluto(9);

    // Returning the value.
    private final int position;

    PlanetPositions(int position) {
      this.position = position;
    }

    public int getPosition() {
      return this.position;
    }
  }

  /////////////////////////////////////////////////////////////////////////////
  
  // enum showing planet names.
  // NOTE: I made 2 seperate enums as it is more simple than figuring out how
  // to pass in a value at get the name.
  public enum PlanetNames {
    Number0("Sun"),
    Number1("Mercury"),
    Number2("Venus"),
    Number3("Earth"),
    Number4("Mars"),
    Number5("Jupiter"),
    Number6("Saturn"),
    Number7("Uranus"),
    Number8("Neptune"),
    Number9("Pluto");

    // Returning the value.
    private final String name;

    PlanetNames(String name) {
      this.name = name;
    }

    public String getName() {
      return this.name;
    }
  }

  /////////////////////////////////////////////////////////////////////////////

  /**
   * This function takes the input from the user and passes it to one of the
   * enums above and returns the answer.
   */
  public static void main(String[] args) {
    // Trying and catching actual errors.
    try {

      // Creating a scanner.
      Scanner scan = new Scanner(System.in);

      // Getting the input from the user.
      System.out.println();
      System.out.println("Insert a planet's name (ex: Earth) or it's position"
                         + " (0-9):");
      String chosenP = scan.nextLine();

      // This try statement is so if the if cant change the value to an int
      // it doesn't go straight to the "ERROR: INVALID INPUT".
      try {

        // Trying to change the string to int.
        int intChosenP = Integer.parseInt(chosenP);

        // Making sure the Int is in the set bounds.
        if ((intChosenP >= 0) && (intChosenP <= 9)) {

          // Adding "Number" to the variables name as you can't just have a
          // number as the title for a value in an enum.
          String stringChosenP = ("Number" + chosenP);

          // Passing that value to one of the enums and picking out the answer.
          PlanetNames n = PlanetNames.valueOf(stringChosenP);
          System.out.println("Planet Position: " + chosenP);
          System.out.println("Planet Name: " + n.getName());

        // If the value isnt in the bounds set.
        } else {
          System.out.println("ERROR: INVALID INPUT");
        }

      // catching the program if the string -> int doesnt work.
      } catch (Exception e) {
        // Passing that value to one of the enums and picking out the answer.
        PlanetPositions p = PlanetPositions.valueOf(chosenP);
        System.out.println("Planet Name: " + chosenP);
        System.out.println("Planet Position: " + p.getPosition());
      }

    // Catchign any actual errors.
    } catch (Exception e) {
      System.out.println("ERROR: INVALID INPUT");
    }
  }
  /////////////////////////////////////////////////////////////////////////////
}
