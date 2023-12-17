package com.example.demoweb.Model;


import com.example.demoweb.Dto.PointDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "point")
public class Point {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pointId;
    private Float x;
    private Float y;

    @ManyToOne
    @JoinColumn(name = "sylabble_id")
    private Syllable syllable;

    public PointDto entityToDto(Point point){
        PointDto pointDto = new PointDto();
        pointDto.setPointId(point.getPointId());
        pointDto.setX(point.getX());
        pointDto.setY(point.getY());
        return pointDto;
    }

}
