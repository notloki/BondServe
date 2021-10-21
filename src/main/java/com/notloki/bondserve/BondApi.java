package com.notloki.bondserve;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RestController
@RequestMapping(path="/api")
public class BondApi<T extends Result> {

    @Autowired
    ResultRepository resultRepository;

    @Autowired
    PersonRepository personRepository;

    List<Result> resultList = new ArrayList<>();

    private static final Logger log = LoggerFactory.getLogger(BondApi.class);

    BondApi() {
    }

    BondApi(ResultRepository resultRepository, PersonRepository personRepository) {
        this.resultRepository = resultRepository;
        this.personRepository = personRepository;
    }

    @GetMapping(path = "/person/all")
    List<Person> personList() {
        log.info("running /api/person/personList()");
        return personRepository.findAll();
    }

    @ResponseBody
    @PostMapping(path = "/person/add")
    Person addPerson(@RequestBody Person person) {
        log.info("running /api/person/addPerson()");
        personRepository.save(person);
        return person;
    }

    @GetMapping(path = "/person/find/{id}")
    Person findPerson(@PathVariable Long id) {

        return personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }

    @GetMapping(path = "/result/all")
    List<Result> resultList() {
        log.info("running /api/result/findPerson()");
        return resultRepository.findAll();
    }

    @GetMapping(path = "/result/find/{id}")
    Result findResult(@PathVariable Long id) {
        return resultRepository.findById(id)
                .orElseThrow(() -> new ResultNotFoundException(id));
    }

    @GetMapping(path = "/result/latest")
    List<Result> getLatest() {
        // TODO: latest: get date
        // check if today is the date on the latest
        // if not run getBondFromServer()

        return resultRepository.findTopByOrderByIdDesc();
    }

    @GetMapping(path = "/result/new")
    public List<Result> getNew() {
        BondLauncher bl = new BondLauncher();

        return bl.startBond();

    }




    public List<Result> bondLauncher() {

        List<Person> personList = personRepository.findAll();

        while (personList.listIterator().hasNext()) {
            Result rst =  getBondFromServer(personList.listIterator().next());

                resultList.add(rst);

        }
        return resultList;
    }


    public Result getBondFromServer(Person person) {
        log.info("Starting getBondFromServer()");

        Result newResultObj = new Result();
        String newResultText = "error";
        BondCheck bondCheck = new BondCheck();
        try {
            newResultObj = bondCheck.checkBond(person);

        } catch (Exception e) {
            e.printStackTrace();
            log.error("BondCheck.BondCheck failed");
        }


       if(newResultObj.getText() == null) {
            return new Result("Error",-1,"error","error");
        } else {

            log.info("newResultText does not contain \"error\"");
            resultRepository.save(newResultObj.toObj(newResultText));

            return newResultObj;

        }
    }

}