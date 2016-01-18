import java.util.Scanner;

public class Contacts {
    private Person[] database;
    private Scanner input;

    public Contacts() {
        database = new Person[0];
        input = new Scanner(System.in);
    }

    /** Add a new person to the database.
     *  @param name of the new person.
     *  @param number of the new person.
     */
    public void add(final String name, final String number) {
        Person[] temp = new Person[database.length + 1];
        Person person = new Person(name, number);
        System.arraycopy(database, 0, temp, 0, database.length);
        temp[database.length] = person;
        database = temp;
    }

    /** Search the database for a matching person.
     * Returns the index of the person, or -1 if not found.
     * @param name of the person to find.
     */
    public int search(final String name) {
        for (int i = 0; i < database.length; i++) {
            if (database[i].getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    /** Print all the People in the database.
     */
    public void displayAll() {
        for (int i = 0; i < database.length; i++) {
            System.out.println(database[i].toString());
        }
    }

    /** Remove a person from the database.
     * Return true if successful, false if not.
     * @param name of the person to find.
     */
    public boolean remove(final String name) {
        int pos = search(name);
        if (pos >= 0) {
            Person[] temp = new Person[database.length - 1];
            System.arraycopy(database, 0, temp, 0, pos);
            System.arraycopy(database, pos + 1, temp, pos, database.length - pos - 1);
            database = temp;
            return true;
        }
        return false;
    }

    /** Print out a basic menu.
     */
    public void displayMenu() {
        System.out.println("\n\n\n1) Add");
        System.out.println("2) Delete");
        System.out.println("3) Search");
        System.out.println("4) Display All");
        System.out.println("5) Exit\n");
    }

    /** Read in the user selection.
     * Return the users selection (1-5).
     */
    public int getChoice() {
        int choice = 4;// default
        boolean done = false;
        while (!done) {
            System.out.print("choice? ");
            try {
                choice = input.nextInt();
            } catch (Exception e) {
                ;
            }
            if (choice > 0 && choice <= 5) {
                done = true;
            } else {
                System.out.println("\nYour choice is incorrect, please try again");
            }
        }
        return choice;
    }

    /** Read in a name and a phone number to add a new person.
     */
    public void addPerson() {
        String name = "";
        String phone = "";
        //boolean done = false;
        try {
            System.out.print("Enter the persons name ");
            name = input.next();
            System.out.print("\nEnter the persons phone number ");
            phone = input.next();
            System.out.println("");
        } catch (Exception e) {
            ;
        }
        add(name, phone);
    }

    /** Read in a name of a person to delete.
     */
    public void deletePerson() {
        String name = "";
        try {
            System.out.print("Enter the persons name ");
            name = input.next();
            System.out.println("");
        } catch (Exception e) {
            ;
        }
        if (!remove(name)) {
            System.out.println("Could not delete " + name);
        } else {
            System.out.println(name + " was deleted successfully");
        }
    }

    /** Read in a name of a person to find.
     */
    public void findPerson() {
        String name = "";
        try {
            System.out.print("Enter the persons name ");
            name = input.next();
            System.out.println("");
        } catch (Exception e) {
            ;
        }
        int pos = search(name);
        if (pos >= 0) {
            System.out.println(database[pos].toString());
        } else {
            System.out.println("No such person");
        }
    }

    /** Call the correct method depending on user input.
     */
    public void run() {
        int choice = 0;
        do {
            displayMenu();
            choice = getChoice();
            switch (choice) {
              case 1:
                  addPerson();
                  break;
              case 2:
                  deletePerson();
                  break;
              case 3:
                  findPerson();
                  break;
              case 4:
                  displayAll();
                  break;
              default:
                  // should not get here
            }

        } while (choice != 5);
    }

    public static void main(String[] args) {
        new Contacts().run();
    }
}