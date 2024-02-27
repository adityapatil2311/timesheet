package com.sipl.timesheet.pro.dto.response;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import com.sipl.timesheet.pro.dtos.TimesheetDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TimesheetApiResponse {

	private TimesheetDto timeSheetdto;
	private List<TimesheetDto> itmesheetDtoList;
	private Page<TimesheetDto> timesheetDtoPage;
	private HttpStatus status;
	private String message;
	private boolean error;

}
