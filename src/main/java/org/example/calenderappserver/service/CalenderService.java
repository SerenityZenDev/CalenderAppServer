package org.example.calenderappserver.service;

import java.util.List;
import org.example.calenderappserver.dto.CalenderRequestDto;
import org.example.calenderappserver.dto.CalenderResponseDto;
import org.example.calenderappserver.entity.Calender;
import org.example.calenderappserver.repository.CalenderRepository;
import org.springframework.stereotype.Service;

@Service
public class CalenderService {
    private CalenderRepository calenderRepository;

    public CalenderService(CalenderRepository calenderRepository) {
        this.calenderRepository = calenderRepository;
    }

    public CalenderResponseDto createSchedule(CalenderRequestDto calenderRequestDto) {
        // CalenderRequestDto로 받아온 값을 Calender 객체에 저장
        Calender calender = new Calender(calenderRequestDto);

        // Calender 객체에 저장된 값을 데이터베이스에 저장
        Calender saveCalender = calenderRepository.save(calender);

        // 데이터베이스에 저장된 값을 CalenderResponseDto로 변환하여 반환
        CalenderResponseDto calenderResponseDto = new CalenderResponseDto(saveCalender);

        return calenderResponseDto;
    }

    public CalenderResponseDto readSchedule(Long scheduleId) {
        return calenderRepository.findById(scheduleId).map(CalenderResponseDto::new).orElse(null);
    }

    public List<CalenderResponseDto> readSchedules() {
        return calenderRepository.findAllByOrderByCreatedAtDesc().stream().map(CalenderResponseDto::new).toList();
    }

    public CalenderResponseDto updateSchedule(Long scheduleId, CalenderRequestDto calenderRequestDto) {
        Calender calender = findCalender(scheduleId);
        String password = calenderRequestDto.getPassword();

        if (checkPassword(calender, password)){
            calender.setTitle(calenderRequestDto.getTitle());
            calender.setContext(calenderRequestDto.getContext());
            calender.setUserName(calenderRequestDto.getUserName());
        }
        CalenderResponseDto calenderResponseDto = new CalenderResponseDto(calender);
        return calenderResponseDto;
    }

    public CalenderResponseDto deleteSchedule(Long scheduleId, String password) {
        Calender calender = findCalender(scheduleId);
        if ( checkPassword(calender, password)){
            calenderRepository.delete(calender);
        }
        CalenderResponseDto calenderResponseDto = new CalenderResponseDto(calender);
        return calenderResponseDto;



    }

    private Calender findCalender(Long scheduleId){
        return calenderRepository.findById(scheduleId).orElseThrow(() ->
            new IllegalArgumentException("선택한 일정은 없습니다."));
    }

    private boolean checkPassword(Calender calender, String password){
        if (calender.getPassword().equals(password)){
            return true;
        }else{
            throw new IllegalArgumentException("패스워드가 일치하지 않습니다.");
        }

    }
}
