package com.example.demoweb.Repository;

import com.example.demoweb.Model.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoordinatesRepository extends JpaRepository<Point,Long> {
}
