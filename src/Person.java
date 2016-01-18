/**
 *  This Class represents a Person with a name and a number.
 */
public class Person {

    /** Name of Person. */
    private String name;
    
    /** Phone number. */
    private String number;

    Person(String name, String number) {

        this.name = name;
        this.number = number;

    }

    /**
     *  Returns string representation of the Person.
     *  Divides the name and the numbers by a number of spaces.
     *  Less spaces are used for longer names.
     */
    public String toString() {

        int spaces = 20 - name.length();

        String print = name;
        for (int i = 0; i < spaces; i++) {
            print += " ";
        }
        print += number;

        return print;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

}
