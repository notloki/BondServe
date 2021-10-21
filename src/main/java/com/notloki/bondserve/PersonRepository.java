package com.notloki.bondserve;

import java.util.List;

public interface PersonRepository extends BaseRepository<Person, Long> {

    List<Person> findTopByOrderByIdDesc();
}

