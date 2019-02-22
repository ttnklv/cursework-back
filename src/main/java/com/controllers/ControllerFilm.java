package com.controllers;
import com.service.ChatService;
import com.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerFilm {

    private final FilmService filmService;
    private final ChatService chatService;

    @Autowired
    public ControllerFilm(FilmService filmService, ChatService chatService1) {
        this.filmService = filmService;
        this.chatService = chatService1;
    }

    @GetMapping("/filmsSortByGenre")
    String filmOnGenre() {
       String a = filmService.filmsSortByGenre(1).get(0);
       if (a != null) return a;
       else return "bad sorting films";
    }

    @GetMapping("/ilmInfo")
    String[] filmInfo(){
        return filmService.filmInfo(1);
    }

    @GetMapping("/newsFeed")
    String newsFeedDate(){
        if( filmService.filmDate() != null) return filmService.filmDate();
        else return "no films for feed";


    }

//    @GetMapping("/tryToGenre")
//    String  filmGenre(){
//        return    filmService.selectGenre("ужасы");
//
//    }

    @GetMapping("/getFeedRecommendationForUser")
    String getFeedRecommendationForUser() {
        String info = filmService.getInfoForUserNewsFeed();
        if (info == null)
            return "DataBase mistake";
        else return info;
    }

    @GetMapping("/findTheMostInterestingAnnotation")
    String findTheMostInterestingAnnotation() {
        String info = filmService.findTheMostInterestingAnnotation();
        if (info == null)
            return "DataBase mistake";
        else return info;
    }

    @GetMapping("/getPopularFilms")
    String getFilms() {
        String info = filmService.getInfoForPopularFilms();
        if (info == null)
            return "DataBase mistake";
        else return info;
    }

    @GetMapping("/getChatForFilm")
    String getChatForFilm() {
        String chat = chatService.findChatForFilm();
        if (chat == null)
            return "DataBase mistake";
        else return chat;
    }

    @GetMapping("/getMainInfoOfTehFilm")
    String getInfoFilm() {
        String info = filmService.findMainInfoForTheFilm();
        if (info == null)
            return "DataBase mistake";
        else return info;
    }
}
