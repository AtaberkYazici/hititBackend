package com.example.demoweb.Service;


import com.example.demoweb.Dto.LetterDto;
import com.example.demoweb.Dto.PhraseDto;
import com.example.demoweb.Model.Letter;
import com.example.demoweb.Model.Phrase;
import com.example.demoweb.Model.Picture;
import com.example.demoweb.Repository.LetterRepository;
import com.example.demoweb.Repository.PhraseRepository;
import com.example.demoweb.Repository.PictureRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PhraseService {

    private final PhraseRepository phraseRepository;
    private final LetterRepository letterRepository;
    private final PictureRepository pictureRepository;

    public List<PhraseDto> getAllPhrases(){
        return phraseRepository.findAll().stream().map(l->l.entityToDto(l)).collect(Collectors.toList());
    }

    public PhraseDto getPhraseById(Long id){
        Phrase phrase = phraseRepository.findById(id).orElseThrow(() -> {
            throw new EntityNotFoundException("There is no Letter check the id");
        });
        return phrase.entityToDto(phrase);
    }

    @Transactional
    public void createPhrase(PhraseDto phraseDto) {
        Optional<Picture> picture = pictureRepository.findById(phraseDto.getPictureId());
        if(picture.isEmpty())
        {
            throw new EntityNotFoundException("Picture must be indicate");
        }
        Phrase phrase = phraseDto.dtoToEntity(picture.get(), phraseDto);
        phraseRepository.save(phrase);
    }


    public void updatePhrase(PhraseDto phraseDto, Long phraseId){
        Optional<Picture> pictureByIdOptional = pictureRepository.findById(phraseDto.getPictureId());
        if (pictureByIdOptional.isPresent()) {
            Picture picture = pictureByIdOptional.get();
            Phrase phrase = phraseDto.dtoToEntity(picture, phraseDto);
            phraseRepository.save(phrase);
        }
        else {
            throw new EntityNotFoundException("Picture must be indicate");
        }
    }

}
