package com.niraliabhani;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class BlogController {

    //Use if hard code data
    //BlogMockedData blogMockedData = BlogMockedData.getInstance();
    @Autowired
    MoviesRepository moviesRepository;

    @GetMapping("/moviesList")
    public List<Movies> index(){
        //return blogMockedData.fetchMovies();
        return moviesRepository.findAll();
    }

    @GetMapping("/moviesList/{id}")
    public Movies show(@PathVariable String id) {
        int movieId = Integer.parseInt(id);
        //return blogMockedData.getMovieById(movieId);
        return moviesRepository.findOne(movieId);
    }

    @PostMapping("/moviesList/search")
    public List<Movies> search(@RequestBody Map<String, String> body ) {
        String searchTerm = body.get("text");
        //return blogMockedData.searchMovies(searchTerm);
        return moviesRepository.findByTitleContainingOrContentContaining(searchTerm, searchTerm);
    }

    @PostMapping("/moviesList")
    public Movies create(@RequestBody Map<String, String> body) {
        int id = Integer.parseInt(body.get("id"));
        String title = body.get("title");
        String content = body.get("content");
        //return blogMockedData.addNewMovie(id, title, content);
        return moviesRepository.save(new Movies(title, content));
    }

    @PutMapping("/moviesList/{id}")
    public Movies update(@PathVariable String id, @RequestBody Map<String, String> body) {
        int movieId = Integer.parseInt(id);
        Movies movie = moviesRepository.findOne(movieId);
        movie.setTitle(body.get("title"));
        movie.setContent(body.get("content"));
        //return blogMockedData.updateMovie(movieId,title,content);
        return moviesRepository.save(movie);
    }

    @DeleteMapping("moviesList/{id}")
    public boolean delete(@PathVariable String id) {
        int movieId = Integer.parseInt(id);
        //return blogMockedData.deleteMovie(movieId);
        moviesRepository.delete(movieId);
        return true;
    }

}
