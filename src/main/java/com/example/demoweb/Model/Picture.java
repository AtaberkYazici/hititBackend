package com.example.demoweb.Model;

import com.example.demoweb.Dto.PictureDto;


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
@Table(name = "picture")
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pictureName;
    private String pictureUrl;

    @OneToMany(mappedBy = "picture", cascade = CascadeType.ALL)
    public List<Phrase> phraseList;

    public PictureDto entityToDto(Picture picture){
        PictureDto pictureDto = new PictureDto();
        pictureDto.setPictureId(picture.getId());
        pictureDto.setTitle(picture.getPictureName());
        pictureDto.setPictureUrl(picture.getPictureUrl());
        pictureDto.setPhraseDtoList(picture.getPhraseList().stream().map(l->l.entityToDto(l)).collect(Collectors.toList()));
        return pictureDto;
    }
}
