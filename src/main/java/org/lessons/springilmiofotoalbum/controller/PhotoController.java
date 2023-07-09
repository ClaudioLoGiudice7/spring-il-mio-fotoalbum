package org.lessons.springilmiofotoalbum.controller;

import org.lessons.springilmiofotoalbum.model.Photo;
import org.lessons.springilmiofotoalbum.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/photos")
public class PhotoController {
    // dipende da PhotoRepository
    @Autowired
    private PhotoRepository photoRepository;

    @GetMapping
    public String list(Model model) { // Model è la mappa di attributi che il controller passa alla view
        // recupero la lista di foto dal database
        List<Photo> photos = photoRepository.findAll();
        // passo la lista delle foto alla view
        model.addAttribute("photoList", photos);
        // restituisco il nome del template della view
        return "photos/list";
    }
}