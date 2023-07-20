package com.naveen.bookmyshow.webcontrollers;

import com.naveen.bookmyshow.pojo.MovieList;
import com.naveen.bookmyshow.services.FileService;
import com.naveen.bookmyshow.services.MovieListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/bookmyshow")

public class MovieListController {

    @Autowired
    private MovieListService movieListService;



    @PostMapping("/addMovie")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) throws IOException {



            PostDto post  = this.movieListService.addMovie(postDto);
        return new ResponseEntity<>(post, HttpStatus.CREATED);
    }

    @GetMapping("allMovies")
    public ResponseEntity<List<PostDto>> getAllMovieDetails()
    {
        List<PostDto> allPosts = this.movieListService.getMovieDetails();
        return new ResponseEntity<>(allPosts, HttpStatus.OK);
    }
    @GetMapping("movieDetails/{id}")
    public ResponseEntity<PostDto> getMovieDetailsById(@PathVariable Long id)
    {
        PostDto post = this.movieListService.getMovieDetailsById(id);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @PutMapping("updateMovie/{id}")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable Long id)
    {
        PostDto updatePost = this.movieListService.updateMovie(postDto,id);
        return new ResponseEntity<PostDto>(updatePost,HttpStatus.OK);
    }
    @DeleteMapping("/deleteMovie/{id}")
    public  ResponseEntity<?> deleteMovie(@PathVariable Long id)
    {

        return new ResponseEntity<>(movieListService.deleteMovie(id),HttpStatus.OK);
    }

}
