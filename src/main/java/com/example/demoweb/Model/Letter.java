package com.example.demoweb.Model;


import com.example.demoweb.Dto.LetterDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "letter")
public class Letter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String letter;
    private String selectedRadioValue;

    @ManyToOne
    @JoinColumn(name = "phrase_id")
    private Phrase phrase;

    @OneToMany(mappedBy = "letter", cascade = CascadeType.ALL)
    private List<Syllable> syllables;

    public LetterDto entityToDto(Letter letter){
        LetterDto letterDto = new LetterDto();
        letterDto.setKelime(letter.getLetter());
        letterDto.setSelectedRadioValue(letter.getSelectedRadioValue());
        letterDto.setSyllableDtoList(letter.getSyllables().stream().map(s->s.entityToDto(s)).collect(Collectors.toList()));
        return letterDto;
    }
}
