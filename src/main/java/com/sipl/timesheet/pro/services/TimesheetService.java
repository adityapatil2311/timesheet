package com.sipl.timesheet.pro.services;

import org.springframework.stereotype.Service;

import com.sipl.timesheet.pro.dto.response.TimesheetApiResponse;
import com.sipl.timesheet.pro.dtos.TimesheetDto;

@Service
public interface TimesheetService {

	public TimesheetApiResponse addTimesheetData(TimesheetDto timesheetDto);

	public TimesheetApiResponse getTimesheetAllData(int pageNumber, int pageSize);

	public TimesheetApiResponse updateTimesheetData(TimesheetDto timesheetDto, int id);

	public TimesheetApiResponse getIdTimesheetData(int id);

	public TimesheetApiResponse deleteTimesheetData(int id);

}
