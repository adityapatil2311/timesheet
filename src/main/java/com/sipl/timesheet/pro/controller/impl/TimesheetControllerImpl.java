package com.sipl.timesheet.pro.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sipl.timesheet.pro.controllers.TimesheetController;
import com.sipl.timesheet.pro.dto.response.TimesheetApiResponse;
import com.sipl.timesheet.pro.dtos.TimesheetDto;
import com.sipl.timesheet.pro.service.impl.TimesheetServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TimesheetControllerImpl implements TimesheetController {

	@Autowired
	private TimesheetServiceImpl timesheetServiceImpl;

	@Override
	public TimesheetApiResponse addTimesheet(TimesheetDto timesheetDto) {
		log.error("Exception in addTimesheet controller");
		return timesheetServiceImpl.addTimesheetData(timesheetDto);
	}

	@Override
	public TimesheetApiResponse getAllTimesheet(int pageNumber, int pageSize) {
		log.error("Exception in getAllTimesheet controller");
		return timesheetServiceImpl.getTimesheetAllData(pageNumber, pageSize);
	}

	@Override
	public TimesheetApiResponse updateTimesheet(TimesheetDto timesheetDto, int id) {

		log.error("Exception in updateTimesheet controller");
		return timesheetServiceImpl.updateTimesheetData(timesheetDto, id);
	}

	@Override
	public TimesheetApiResponse getIdTimesheet(int id) {
		log.error("Exception in getIdTimesheet controller");
		return timesheetServiceImpl.getIdTimesheetData(id);
	}

	@Override
	public TimesheetApiResponse deleteTimesheet(int id) {
		log.error("Exception in deleteTimesheet controller");
		return timesheetServiceImpl.deleteTimesheetData(id);
	}

}
