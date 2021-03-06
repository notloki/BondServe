package com.notloki.bondserve;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface BaseRepository<T, Long> extends JpaRepository< T, Long> {

    List<T> findTopByOrderByIdDesc();

}
