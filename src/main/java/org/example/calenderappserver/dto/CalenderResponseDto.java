package org.example.calenderappserver.dto;

import java.time.LocalDateTime;
import lombok.Getter;
import org.example.calenderappserver.entity.Calender;

@Getter
public class CalenderResponseDto {
    private Long scheduleId;
    private String title;
    private String context;
    private String userName;
    private LocalDateTime createdAt;

    public CalenderResponseDto(Calender calender) {
        this.scheduleId = calender.getScheduleId();
        this.title = calender.getTitle();
        this.context = calender.getContext();
        this.userName = calender.getUserName();
        this.createdAt = calender.getCreatedAt();
    }
}
