package org.example.calenderappserver.repository;

import java.util.List;
import org.example.calenderappserver.entity.Calender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalenderRepository extends JpaRepository<Calender, Long> {

    List<Calender> findAllByOrderByCreatedAtDesc();
}
