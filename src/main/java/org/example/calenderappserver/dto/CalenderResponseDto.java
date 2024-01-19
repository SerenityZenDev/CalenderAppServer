package org.example.calenderappserver.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

public class CalenderResponseDto {
    private Long scheduleId;
    private String title;
    private String context;
    private String userName;
    private LocalDateTime createdAt;
}
