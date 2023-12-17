package com.example.demoweb.Repository;

import com.example.demoweb.Model.Letter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LetterRepository extends JpaRepository<Letter,Long> {
}
