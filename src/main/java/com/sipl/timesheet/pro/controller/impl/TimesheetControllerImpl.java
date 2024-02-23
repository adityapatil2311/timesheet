package com.sipl.timesheet.pro.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.sipl.timesheet.pro.controllers.TimesheetController;
import com.sipl.timesheet.pro.dto.response.TimesheetApiResponse;
import com.sipl.timesheet.pro.dtos.TimesheetDto;
import com.sipl.timesheet.pro.service.impl.TimesheetServiceImpl;

@Service
public class TimesheetControllerImpl implements TimesheetController {

	@Autowired
	private TimesheetServiceImpl timesheetServiceImpl;

	@Override
	public TimesheetApiResponse addTimesheet(TimesheetDto timesheetDto) {

		return timesheetServiceImpl.addTimesheetData(timesheetDto);
	}

	@Override
	public TimesheetApiResponse getAllTimesheet(int pageNumber, int pageSize) {
		return timesheetServiceImpl.getTimesheetAllData(pageNumber, pageSize);
	}

	@Override
	public TimesheetApiResponse updateTimesheet(TimesheetDto timesheetDto, int id) {

		return timesheetServiceImpl.updateTimesheetData(timesheetDto, id);
	}

	@Override
	public TimesheetApiResponse getIdTimesheet(int id) {
		return timesheetServiceImpl.getIdTimesheetData(id);
	}

	@Override
	public TimesheetApiResponse deleteTimesheet(int id) {
		return timesheetServiceImpl.deleteTimesheetData(id);
	}

}
