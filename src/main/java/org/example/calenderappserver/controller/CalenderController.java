package org.example.calenderappserver.controller;

import java.util.List;
import org.example.calenderappserver.dto.CalenderRequestDto;
import org.example.calenderappserver.dto.CalenderResponseDto;
import org.example.calenderappserver.dto.DeleteRequestDto;
import org.example.calenderappserver.service.CalenderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CalenderController {

    CalenderService calenderService;

    public CalenderController(CalenderService calenderService) {
        this.calenderService = calenderService;
    }

    @PostMapping("/schedules")
    public CalenderResponseDto createSchedule(@RequestBody CalenderRequestDto calenderRequestDto) {
        return calenderService.createSchedule(calenderRequestDto);
    }

    @GetMapping("/schedules/{scheduleId}")
    public CalenderResponseDto readSchedule(@PathVariable Long scheduleId) {
        System.out.println("동작중");
        return calenderService.readSchedule(scheduleId);
    }

    @GetMapping("/schedules")
    public List<CalenderResponseDto> readSchedules() {
        return calenderService.readSchedules();
    }

    @PatchMapping("/schedules/{scheduleId}")
    public ResponseEntity<?> updateSchedule(@PathVariable Long scheduleId,
        @RequestBody CalenderRequestDto calenderRequestDto) {
        return calenderService.updateSchedule(scheduleId, calenderRequestDto);
    }

    @DeleteMapping("schedules/{scheduleId}")
    public ResponseEntity<String> deleteSchedule(@PathVariable Long scheduleId,
        @RequestBody DeleteRequestDto deleteRequestDto) {
        return calenderService.deleteSchedule(scheduleId, deleteRequestDto);
    }

}
