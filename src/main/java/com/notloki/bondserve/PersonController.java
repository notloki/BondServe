package com.notloki.bondserve;
/*

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNullApi;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping(path="/user")
public class PersonController {

    @Autowired
    private final PersonRepository personRepository;

    PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public PersonRepository getPersonRepository() {
        return personRepository;
    }

    @GetMapping(path = "/all")
    List<Person> findAll() {
        return personRepository.findAll();
    }

    @ResponseBody
    @PostMapping("/add")
    Person addPerson(@RequestBody Person person) {
        personRepository.save(person);
        return person; }

    @PostMapping(path="/get")
    String getPerson(@RequestParam(value="id") Long id) {
        return personRepository.getOne(id).toString();
    }
}
*/
