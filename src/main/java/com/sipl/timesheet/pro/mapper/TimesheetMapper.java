package com.sipl.timesheet.pro.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import com.sipl.timesheet.pro.dao.entity.Timesheet;
import com.sipl.timesheet.pro.dtos.TimesheetDto;

@Mapper(componentModel = "spring")
public interface TimesheetMapper {

	Timesheet mapTimesheetDtoToTimesheet(TimesheetDto timesheetDto);

	TimesheetDto mapTimesheetToTimesheetDto(Timesheet timesheet);

	List<TimesheetDto> mapTimesheetListToTimesheetDtoList(Page<Timesheet> page);
}
