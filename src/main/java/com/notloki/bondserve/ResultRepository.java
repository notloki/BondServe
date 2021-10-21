package com.notloki.bondserve;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@Controller
@RestController
interface ResultRepository extends BaseRepository<Result, Long> {

    List<Result> findTopByOrderByIdDesc();


    @Override
    @NonNull
    <S extends Result> S save(@NonNull S entity);
}

