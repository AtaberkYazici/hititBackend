package com.example.demoweb.Dto;

import com.example.demoweb.Model.Picture;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class PictureDto {

    private Long pictureId;
    private String title;
    private String pictureUrl;
    List<PhraseDto> phraseDtoList;

    public Picture dtoToEntity(PictureDto pictureDto){
        Picture picture = new Picture();
        picture.setId(pictureDto.getPictureId());
        picture.setPictureName(pictureDto.getTitle());
        picture.setPictureUrl(pictureDto.getPictureUrl());
        picture.setPhraseList(pictureDto.getPhraseDtoList().stream().map(p->p.dtoToEntity(picture,p)).collect(Collectors.toList()));
        return picture;
    }

}
