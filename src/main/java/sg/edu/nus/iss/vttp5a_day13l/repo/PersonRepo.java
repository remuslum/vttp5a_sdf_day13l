package sg.edu.nus.iss.vttp5a_day13l.repo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.vttp5a_day13l.model.Person;

@Repository
public class PersonRepo {
    private List<Person> persons;

    public PersonRepo() throws ParseException{
        this.persons = new ArrayList<>();
        String birthDate = "1998-02-01";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        persons.add(new Person("Jack", "Daniel", 12000, "jackdaniel@gmail.com",formatter.parse(birthDate), "96557822", 668557));
    }

    public List<Person> listAll(){
        return this.persons;
    }

    public boolean create(Person person){
        return persons.add(person);
    }

    public boolean delete(Person person){
        if(persons.contains(person)){
            persons.remove(persons.indexOf(person));
            return true;
        } else {
            return false;
        }
    }

    public Person findById(String personId){
        return persons.stream().filter(p -> p.getId().equals(personId)).findFirst().get();
    }

    public boolean update(Person person){
        Person filteredPersons = findById(person.getId());
        if(filteredPersons != null){
            delete(filteredPersons);
            create(person);
            return true;
        }
        return false;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    
}
