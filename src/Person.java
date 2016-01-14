
public class Person {

    private String name;
    
    private String number;
    
    Person(String name, String number){
        
        this.name = name;
        this.number = number;
        
    }
    
    
    public String toString(){
        
        int spaces = 20 - name.length();
        
        String print = name;
        for(int i = 0;i < spaces;i++){
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
