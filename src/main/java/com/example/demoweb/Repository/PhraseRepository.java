package com.example.demoweb.Repository;


import com.example.demoweb.Model.Phrase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhraseRepository extends JpaRepository<Phrase,Long> {

}
