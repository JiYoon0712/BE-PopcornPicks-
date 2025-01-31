package com.example.popcornpicks.movie.controller;

import com.example.popcornpicks.common.ApiResponse;
import com.example.popcornpicks.common.domain.Page;
import com.example.popcornpicks.movie.domain.DailyBoxOfficeMovieDto;
import com.example.popcornpicks.movie.domain.MovieListDto;
import com.example.popcornpicks.movie.feign.domain.MovieInfo;
import com.example.popcornpicks.movie.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    // 일별 박스오피스
    @GetMapping("/daily_box/list")
    public ApiResponse<List<DailyBoxOfficeMovieDto>> getDailyBoxList() {
        return ApiResponse.createOk(movieService.getDailyBoxOfficeList());
    }

    // 영화 목록
    @GetMapping("/movie_list")
    public ApiResponse<MovieListDto.Response> getMovieList(
            @RequestParam("size") int size,
            @RequestParam("page") int page) {
        return ApiResponse.createOk(movieService.getMovieList(new Page(page, size)));
    }
    
    // 영화 상세 정보
    @GetMapping("/movie_info")
    public ApiResponse<MovieInfo.Response> getMovieInfo(
            @RequestParam("movieCd") String movieCd){
        return ApiResponse.createOk(movieService.getMovieInfo(movieCd));
    }


}
