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
@Table(name = "CALENDER")
@NoArgsConstructor
public class Calender extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleId;
    @Column(name = "TITLE", length = 100)
    private String title;
    @Column(name = "CONTENT", length = 1024)
    private String content;
    @Column(name = "USERNAME", length = 16)
    private String username;
    @Column(name = "PASSWORD", length = 32)
    private String password;

    public Calender(CalenderRequestDto calenderRequestDto) {
        this.title = calenderRequestDto.getTitle();
        this.content = calenderRequestDto.getContent();
        this.username = calenderRequestDto.getUsername();
        this.password = calenderRequestDto.getPassword();
    }

    public void update(CalenderRequestDto calenderRequestDto) {
        this.title = calenderRequestDto.getTitle();
        this.content = calenderRequestDto.getContent();
        this.username = calenderRequestDto.getUsername();
    }
}
