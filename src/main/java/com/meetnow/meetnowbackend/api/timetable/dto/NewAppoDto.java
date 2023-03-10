package com.meetnow.meetnowbackend.api.timetable.dto;

import com.meetnow.meetnowbackend.domain.appointmentdate.AppointmentDate;
import com.meetnow.meetnowbackend.domain.timetable.TimeTable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Getter
@ApiModel(value = "시간표에 등록할 개별 날짜 정보를 포함하는 요청객체",
        description = "서버에서 List로 받으므로, 배열이나 그에 상응하는 자료형을 통해 보내야 합니다.")
public class NewAppoDto {

    @ApiModelProperty(value = "날짜", required = true, example = "01-23(목)")
    private String date;
    @ApiModelProperty(value = "약속시간. 24시간을 기준으로 함.", required = true, example = "20")
    private String time;


    // of() 는 파라미터를 받아가지고 객체 생성,
    public AppointmentDate toEntity(TimeTable timeTable){
        return AppointmentDate.builder()
                .date(date)
                .time(time)
                .timeTable(timeTable)
                .build();
    }


}
