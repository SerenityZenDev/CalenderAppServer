package org.example.calenderappserver.dto;

import java.time.LocalDateTime;
import lombok.Getter;
import org.example.calenderappserver.entity.Calender;

@Getter
public class CalenderResponseDto {
    private Long scheduleId;
    private String title;
    private String content;
    private String userName;
    private LocalDateTime createdAt;

    public CalenderResponseDto(Calender calender) {
        this.scheduleId = calender.getScheduleId();
        this.title = calender.getTitle();
        this.content = calender.getContent();
        this.userName = calender.getUserName();
        this.createdAt = calender.getCreatedAt();
    }
}
