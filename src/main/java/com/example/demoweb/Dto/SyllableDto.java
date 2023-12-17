package com.example.demoweb.Dto;

import com.example.demoweb.Model.Letter;
import com.example.demoweb.Model.Phrase;
import com.example.demoweb.Model.Syllable;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class SyllableDto {
    private String heceIsmi;
    List<PointDto> pointDtoList;
    List<LineDto> lineDtoList;

    public Syllable dtoToEntity(Letter letter, SyllableDto syllableDto){
        Syllable syllable = new Syllable();
        syllable.setHeceIsmi(syllableDto.getHeceIsmi());
        syllable.setLetter(letter);
        syllable.setPointList(syllableDto.getPointDtoList().stream().map(p->
                p.dtoToEntity(syllable,p)).collect(Collectors.toList()));
        syllable.setLineList(syllableDto.getLineDtoList().stream().map(l->
                l.dtoToEntity(syllable,l)).collect(Collectors.toList()));
        return syllable;
    }
}
