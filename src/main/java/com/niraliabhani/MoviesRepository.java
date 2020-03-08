package com.niraliabhani;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MoviesRepository extends JpaRepository<Movies,Integer> {


    // custom query to search to movies by title or content
    List<Movies> findByTitleContainingOrContentContaining(String text, String textAgain);
}
