package com.notloki.bondserve;



import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import org.slf4j.Logger;

import static com.notloki.bondserve.Ref.debug;


@SuppressWarnings("ALL")
public class BondLauncher {

    private static final Logger log = LoggerFactory.getLogger(BondLauncher.class);

    @Autowired
    PersonRepository personRepository;

    @Autowired
    ResultRepository resultRepository;


    public BondLauncher() {}

    public List<Result> startBond() {
        log.info("startBond()... Starting");
        List<Person> personList =
                personRepository.findAll();
        log.info("created personList --");

        List<Result> resultList = null;
        while (personList.listIterator().hasNext()) {
            for (Person person : personList) {
                try {
                    if(null != resultList)
                    resultList.add(getBondFromServer(person));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        if (resultList == null) {

            resultList.add(
                    new Result("Error -- resultList",
                            0,
                            "string",
                            "date"));
        }
        return resultList;

    }

        private Result getBondFromServer(Person person) {
        log.info("Starting getBondFromServer()");

        Result newResultObj = new Result();
        String newResultText = "error";
BondCheck bondCheck = new BondCheck();
        try {
            newResultObj  = bondCheck.checkBond(person);

        } catch (Exception e) {
            e.printStackTrace();
            log.error("BondCheck.checkBond() failed");
        }


        if (!(newResultObj.getText().contains("test"))) {
            if (debug) {
                log.info("newResultText contains \"error\"" + "\n" + newResultText);

                System.out.println(newResultObj);
            }
        } else {

            log.info("newResultText does not contain \"error\"");
            resultRepository.save(newResultObj.toObj(newResultText));

        }
            return newResultObj;
        }
    }

