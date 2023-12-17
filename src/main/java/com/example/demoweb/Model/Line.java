package com.example.demoweb.Model;

import com.example.demoweb.Dto.LineDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "line")
public class Line {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String lineId;
    private String pointId1;
    private String pointId2;

    @ManyToOne
    @JoinColumn(name = "syllable_id")
    private Syllable syllable;

    public LineDto entityToDto(Line line){
        LineDto lineDto = new LineDto();
        lineDto.setLineId(line.getLineId());
        lineDto.setPointId1(line.getPointId1());
        lineDto.setPointId2(line.getPointId2());
        return lineDto;
    }
}
