package sg.edu.nus.iss.vttp5a_day13l.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.nus.iss.vttp5a_day13l.model.Person;
import sg.edu.nus.iss.vttp5a_day13l.service.PersonService;

@Controller
@RequestMapping("/persons")
public class PersonController {
    
    @Autowired
    PersonService personService;

    @GetMapping()
    public String personListing(Model model){
        List<Person> persons = personService.findAll();
        model.addAttribute("persons",persons);
        return "personList";
    }

    @GetMapping(path = "/create")
    public String createForm(Model model){
        model.addAttribute("person", new Person());
        return "personcreateform";
    }
}
