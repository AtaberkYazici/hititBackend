package com.example.demoweb.Dto;

import com.example.demoweb.Model.Letter;
import com.example.demoweb.Model.Line;
import com.example.demoweb.Model.Picture;
import com.example.demoweb.Model.Syllable;
import lombok.Data;

import java.util.stream.Collectors;

@Data
public class LineDto {
    private String lineId;
    private String pointId1;
    private String pointId2;


    public Line dtoToEntity(Syllable syllable, LineDto lineDto){
        Line line = new Line();
        line.setLineId(lineDto.getLineId());
        line.setPointId1(lineDto.getPointId1());
        line.setPointId2(lineDto.getPointId2());
        line.setSyllable(syllable);
        return line;
    }
}
