package com.example.demoweb.Dto;

import com.example.demoweb.Model.Letter;
import com.example.demoweb.Model.Phrase;
import com.example.demoweb.Model.Picture;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class LetterDto {
    private String kelime;
    private String selectedRadioValue;
    List<SyllableDto> syllableDtoList;

    public Letter dtoToEntity(Phrase phrase, LetterDto letterDto){
        Letter letter = new Letter();
        letter.setSelectedRadioValue(letterDto.getSelectedRadioValue());
        letter.setLetter(letterDto.getKelime());
        letter.setPhrase(phrase);
        letter.setSyllables(letterDto.getSyllableDtoList().stream().map(p->
                p.dtoToEntity(letter,p)).collect(Collectors.toList()));
        return letter;
    }


}

