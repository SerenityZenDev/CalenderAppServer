package org.example.calenderappserver.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class CalenderRequestDto {
    private String title;
    private String context;
    private String userName;
    private String password;
}
