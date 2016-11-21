/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clickme;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author waltersanchez
 */
public class Person {
    
    private final StringProperty names;
    private final StringProperty email;
    private final StringProperty city;
    private final StringProperty age;
    


    public Person(String names, String email, String city, String age) {
        this.names = new SimpleStringProperty(names);
        this.email = new SimpleStringProperty(email);
        this.city = new SimpleStringProperty(city);
        this.age = new SimpleStringProperty(age);
    }

    public StringProperty namesProperty() {
        return names;
    }

    public StringProperty emailProperty() {
        return email;
    }

    public StringProperty cityProperty() {
        return city;
    }

    public StringProperty ageProperty() {
        return age;
    }
    
    
    
    
    

    public String getNames() {
        return names.get();
    }

    public String getEmail() {
        return email.get();
    }

    public String getCity() {
        return city.get();
    }

    public String getAge() {
        return age.get();
    }
    
    
    public void setNames(String names) {
        this.names.set(names);
    }
    public void setEmail(String email) {
        this.email.set(email);
    }
    public void setAge(String age) {
        this.age.set(age);
    }
    public void setCity(String city) {
        this.city.set(city);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
