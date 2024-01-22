package org.example.calenderappserver.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.calenderappserver.dto.CalenderRequestDto;

@Entity
@Getter
@Setter
@Table(name = "calender")
@NoArgsConstructor
public class Calender extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleId;
    @Column
    private String title;
    @Column
    private String content;
    @Column
    private String userName;
    @Column
    private String password;

    public Calender(CalenderRequestDto calenderRequestDto) {
         this.title = calenderRequestDto.getTitle();
         this.content = calenderRequestDto.getContent();
         this.userName = calenderRequestDto.getUserName();
         this.password = calenderRequestDto.getPassword();
    }
}
