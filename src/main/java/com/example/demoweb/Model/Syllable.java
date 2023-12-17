package com.example.demoweb.Model;

import com.example.demoweb.Dto.LetterDto;
import com.example.demoweb.Dto.SyllableDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "syllable")
public class Syllable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String heceIsmi;

    @ManyToOne
    @JoinColumn(name = "letter_id")
    private Letter letter;

    @OneToMany(mappedBy = "syllable", cascade = CascadeType.ALL)
    private List<Point> pointList;

    @OneToMany(mappedBy = "syllable", cascade = CascadeType.ALL)
    private List<Line> lineList;

    public SyllableDto entityToDto(Syllable syllable){
        SyllableDto syllableDto = new SyllableDto();
        syllableDto.setHeceIsmi(syllable.getHeceIsmi());
        syllableDto.setLineDtoList(syllable.getLineList().stream().map(l->l.entityToDto(l)).collect(Collectors.toList()));
        syllableDto.setPointDtoList(syllable.getPointList().stream().map(p->p.entityToDto(p)).collect(Collectors.toList()));
        return syllableDto;
    }
}
