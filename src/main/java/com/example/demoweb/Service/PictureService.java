package com.example.demoweb.Service;


import com.example.demoweb.Model.Picture;
import com.example.demoweb.Dto.PictureDto;
import com.example.demoweb.Repository.PictureRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class PictureService {

    @Autowired
    private PictureRepository pictureRepository;

    public List<PictureDto> getAllPictures(){
       return pictureRepository.findAll().stream().map(p->p.entityToDto(p)).collect(Collectors.toList());
    }

    public List<String> getAllPicturesUrl(){
        return pictureRepository.findAll().stream().map(p->p.entityToDto(p).getPictureUrl()).collect(Collectors.toList());
    }

    public PictureDto getPictureById(Long id){
        Picture picture = pictureRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("There is no picture that have this id"));
        return picture.entityToDto(picture);
    }

    public String getPictureUrlById(Long id){
        Picture picture = pictureRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("There is no picture that have this id"));
        return picture.entityToDto(picture).getPictureUrl();
    }


    public void updatePicture(PictureDto pictureDto, Long pictureId) {
        Picture picture = pictureRepository.findById(pictureId).orElseThrow(() ->
                new EntityNotFoundException("There is no picture that have this id"));
        Picture pictureFromDto = pictureDto.dtoToEntity(pictureDto);
        picture.setPictureUrl(pictureFromDto.getPictureUrl());
        picture.setPictureName(pictureFromDto.getPictureName());
        picture.setPhraseList(pictureFromDto.getPhraseList());
        pictureRepository.save(picture);
    }

    public void savePicture(PictureDto pictureDto){
        Picture picture = pictureDto.dtoToEntity(pictureDto);
        pictureRepository.save(picture);
    }


}
