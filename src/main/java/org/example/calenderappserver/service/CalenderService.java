package org.example.calenderappserver.service;

import java.util.List;
import org.example.calenderappserver.dto.CalenderRequestDto;
import org.example.calenderappserver.dto.CalenderResponseDto;
import org.example.calenderappserver.dto.DeleteRequestDto;
import org.example.calenderappserver.entity.Calender;
import org.example.calenderappserver.repository.CalenderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CalenderService {

    private CalenderRepository calenderRepository;

    public CalenderService(CalenderRepository calenderRepository) {
        this.calenderRepository = calenderRepository;
    }

    public CalenderResponseDto createSchedule(CalenderRequestDto calenderRequestDto) {
        Calender calender = new Calender(calenderRequestDto);

        Calender saveCalender = calenderRepository.save(calender);

        CalenderResponseDto calenderResponseDto = new CalenderResponseDto(saveCalender);

        return calenderResponseDto;
    }

    public CalenderResponseDto readSchedule(Long scheduleId) {
        return calenderRepository.findById(scheduleId).map(CalenderResponseDto::new).orElse(null);
    }

    public List<CalenderResponseDto> readSchedules() {
        return calenderRepository.findAllByOrderByCreatedAtDesc().stream()
            .map(CalenderResponseDto::new).toList();
    }

    @Transactional
    public ResponseEntity<?> updateSchedule(Long scheduleId,
        CalenderRequestDto calenderRequestDto) {
        try {
            Calender calender = findCalender(scheduleId);

            checkPassword(calender, calenderRequestDto.getPassword());

            calender.setTitle(calenderRequestDto.getTitle());
            calender.setContent(calenderRequestDto.getContent());
            calender.setUsername(calenderRequestDto.getUsername());

            return ResponseEntity.ok(new CalenderResponseDto(calender));
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
            // http 반환 코드 확인 테스트
            // return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<String> deleteSchedule(Long scheduleId,
        DeleteRequestDto deleteRequestDto) {
        try {
            Calender calender = findCalender(scheduleId);

            checkPassword(calender, deleteRequestDto.getPassword());

            calenderRepository.delete(calender);

            return new ResponseEntity<>("Success!", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>("Invalid password", HttpStatus.UNAUTHORIZED);
        }
    }

    private Calender findCalender(Long scheduleId) {
        return calenderRepository.findById(scheduleId).orElseThrow(() ->
            new IllegalArgumentException("선택한 일정은 없습니다."));
    }

    private void checkPassword(Calender calender, String password) {
        if (!calender.getPassword().equals(password)) {
            throw new IllegalArgumentException("패스워드가 일치하지 않습니다.");
        }
    }
}
