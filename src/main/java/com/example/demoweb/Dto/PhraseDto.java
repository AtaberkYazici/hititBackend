package com.example.demoweb.Dto;

import com.example.demoweb.Model.Letter;
import com.example.demoweb.Model.Phrase;
import com.example.demoweb.Model.Picture;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class PhraseDto {

    private String cumleIsmi;
    private Long pictureId;
    List<LetterDto> kelimeList;

    public Phrase dtoToEntity(Picture picture, PhraseDto phraseDto){
        Phrase phrase = new Phrase();
        phrase.setPhraseName(phraseDto.getCumleIsmi());
        phrase.setPicture(picture);
        phrase.setLetters(phraseDto.getKelimeList().stream().map(p->
                p.dtoToEntity(phrase,p)).collect(Collectors.toList()));

        return phrase;
    }
}
