package com.example.demoweb.Repository;

import com.example.demoweb.Model.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface PictureRepository extends JpaRepository<Picture,Long> {
}
