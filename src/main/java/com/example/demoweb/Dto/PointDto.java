package com.example.demoweb.Dto;

import com.example.demoweb.Model.Letter;
import com.example.demoweb.Model.Line;
import com.example.demoweb.Model.Point;
import com.example.demoweb.Model.Syllable;
import lombok.Data;

@Data
public class PointDto {
    private String pointId;
    private Float x;
    private Float y;

    public Point dtoToEntity(Syllable syllable, PointDto pointDto){
        Point point = new Point();
        point.setPointId(pointDto.getPointId());
        point.setX(pointDto.getX());
        point.setY(pointDto.getY());
        point.setSyllable(syllable);
        return point;
    }
}
