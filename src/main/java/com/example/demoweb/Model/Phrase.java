package com.example.demoweb.Model;

import com.example.demoweb.Dto.LetterDto;
import com.example.demoweb.Dto.PhraseDto;
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
@Table(name = "phrase")
public class Phrase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String phraseName;

    @ManyToOne
    @JoinColumn(name = "picture_id")
    private Picture picture;

    @OneToMany(mappedBy = "phrase", cascade = CascadeType.ALL)
    private List<Letter> letters;

    public PhraseDto entityToDto(Phrase phrase){
        PhraseDto phraseDto = new PhraseDto();
        phraseDto.setCumleIsmi(phrase.getPhraseName());
        phraseDto.setPictureId(phrase.getPicture().getId());
        phraseDto.setKelimeList(phrase.getLetters().stream().map(p->p.entityToDto(p)).collect(Collectors.toList()));

        return phraseDto;
    }
}
