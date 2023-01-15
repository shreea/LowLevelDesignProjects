package DesignPatterns.Decorator;

public class DatabaseService {
    public String getNameFromUsername(String userName){
        return userName + "@Mail";
    };

    public String getPhoneNumberFromUsername(String userName) {
        return "12344";
    }

}
