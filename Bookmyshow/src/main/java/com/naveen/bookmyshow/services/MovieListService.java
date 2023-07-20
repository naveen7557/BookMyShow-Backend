package com.naveen.bookmyshow.services;

import com.naveen.bookmyshow.DAO.MovieListRepository;
import com.naveen.bookmyshow.pojo.MovieList;
import com.naveen.bookmyshow.webcontrollers.PostDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieListService {
    @Autowired
    private MovieListRepository movieListRepository;

    @Autowired
    private ModelMapper modelMapper;


    public PostDto addMovie(PostDto postDto)
    {
        MovieList movieList = this.modelMapper.map(postDto, MovieList.class);

        this.movieListRepository.save(movieList);


        return this.modelMapper.map(movieList,PostDto.class);
    }

    public List<PostDto> getMovieDetails()
    {
        List<MovieList> allPosts = this.movieListRepository.findAll();

        return allPosts.stream().map((post)-> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());

    }


    public PostDto updateMovie(PostDto postDto, Long id)
    {
        MovieList movieList = this.movieListRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("id"));
        movieList.setMovieName(postDto.getMovieName());
        movieList.setImage(postDto.getImage());
        movieList.setLanguage(postDto.getLanguage());
        movieList.setGenre(postDto.getGenre());
        movieList.setRating(postDto.getRating());
        movieList.setDescription(postDto.getDescription());

         this.movieListRepository.save(movieList);

         return this.modelMapper.map(movieList,PostDto.class);
    }

    public PostDto getMovieDetailsById(Long id)
    {
        MovieList post = this.movieListRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("id"));

        return this.modelMapper.map(post,PostDto.class);

    }

    public String  deleteMovie(Long id)
    {
        MovieList deleteMovie = this.movieListRepository.findById(id).get();

        if(deleteMovie != null) {
            movieListRepository.delete(deleteMovie);
            return "Movie deleted successfully";
        }
        return "Something went wrong!!";
    }


}
