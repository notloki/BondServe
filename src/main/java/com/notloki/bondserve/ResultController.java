package com.notloki.bondserve;
/*

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import static com.notloki.bondserve.Ref.debug;

@Controller
@RestController
@RequestMapping(path="/bond")
class ResultController {

    @Autowired
    BondApi bondApi;

    @Autowired
    ScheduledTasks scheduledTasks;
    @Autowired
    private ResultRepository resultRepository;
    // TODO: Use a logger like this instead of sout.

    private static final Logger log = LoggerFactory.getLogger(ResultController.class);

    ResultController() {}

    ResultController(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    public ResultRepository getRepository() { return resultRepository; }

    @GetMapping("/all")
    List<Result> getAll() {
        return resultRepository.findAll();
    }

    @GetMapping("/latest/int")
    int getInt() {
        // Result resu = new Result();
        Result resu = resultRepository.findById(resultRepository.count())
                .orElseThrow(() -> new ResultNotFoundException(resultRepository.count()));
    return resu.getRequired_test();
    }

//    @GetMapping("/latest")
//    String  getLatest() {
//
//        if(debug) {
//
//            System.out.println(resultRepository.count());
//
//        }
//
//        return resultRepository.
//                findById(resultRepository.count()).toString();
//
//    }

    @PostMapping("/results")
    Result newResult(@RequestBody Result newResult) {
        return resultRepository.save(newResult);

    }

    @GetMapping("/find/{id}")
    Result one(@PathVariable Long id) {
        return resultRepository.findById(id)
                .orElseThrow(() -> new ResultNotFoundException(id));
        }


    @GetMapping("/new")
    String getNew() {

        scheduledTasks.scheduledStart();

    }

    // TODO: checkIfBondHasBeenCheckedToday -- Check if it has been checked on boot & when pulling anything.
    final void checkIfBondHasBeenCheckedToday() {

        Ref.hasBondsBeenCheckedToday = (new SimpleDateFormat(
                "MMddyyyy")
                .format(
                        Calendar.getInstance().getTimeInMillis()).equalsIgnoreCase(
                        resultRepository.getOne(resultRepository.count()).getLocalDate()));

    }
}

*/
