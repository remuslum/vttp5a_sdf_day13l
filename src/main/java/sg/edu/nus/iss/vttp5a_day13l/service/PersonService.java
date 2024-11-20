package sg.edu.nus.iss.vttp5a_day13l.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.vttp5a_day13l.model.Person;
import sg.edu.nus.iss.vttp5a_day13l.repo.PersonRepo;

@Service
public class PersonService {

    @Autowired
    PersonRepo personRepo;

    public List<Person> findAll(){
        return personRepo.listAll();
    }

    public boolean create(Person person){
        return personRepo.create(person);
    }

    public boolean update(Person person){
        return personRepo.update(person);
    }

    public boolean delete(Person person){
        return personRepo.delete(person);
    }

    public Person findById(String personId){
        return personRepo.findById(personId);
    }
}
