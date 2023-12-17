package com.example.demoweb.Controller;


import com.example.demoweb.Dto.PhraseDto;
import com.example.demoweb.Dto.PictureDto;
import com.example.demoweb.Service.PhraseService;
import com.example.demoweb.Service.PictureService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class HititController {

    private final PictureService pictureService;
    private final PhraseService phraseService;

    //picture controller
    @GetMapping("/pictures/{id}")
    public PictureDto getPicture(@PathVariable(value = "id") Long pictureId) {
        return pictureService.getPictureById(pictureId);
    }
    @GetMapping("/pictures")
    public List<PictureDto> getAllPicture() {
        return pictureService.getAllPictures();
    }

    @GetMapping("/pictures/url")
    public List<String> getAllPicturesUrl(){
        return pictureService.getAllPicturesUrl();
    }

    @GetMapping("/picture/{id}/url")
    public String getAllPicturesUrl(@PathVariable(value = "id") Long pictureId){
        return pictureService.getPictureUrlById(pictureId);
    }

    @PutMapping("/picture/{id}")
    public void updatePicture(@RequestBody PictureDto pictureDto, @PathVariable(value = "id") Long pictureId) {
        pictureService.updatePicture(pictureDto,pictureId);
    }
    @PostMapping("/picture")
    public void savePicture(@RequestBody PictureDto pictureDto){
        pictureService.savePicture(pictureDto);
    }

    //phrase controller
    @GetMapping("/phrase/{id}")
    public PhraseDto getPhrase(@PathVariable(value = "id") Long phraseId) {
        return phraseService.getPhraseById(phraseId);
    }
    @GetMapping("/phrases")
    public List<PhraseDto> getAllPhrases() {
        return phraseService.getAllPhrases();
    }

    @PutMapping("/phrase/{id}")
    public void updatePhrase(@RequestBody PhraseDto phraseDto, @PathVariable(value = "id") Long phraseId) {
        phraseService.updatePhrase(phraseDto,phraseId);
    }
    @PostMapping("/phrase")
    public void savePhrase(@RequestBody PhraseDto phraseDto){
        phraseService.createPhrase(phraseDto);
    }

}
