package com.sipl.timesheet.pro.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.sipl.timesheet.pro.dao.entity.Timesheet;
import com.sipl.timesheet.pro.dao.repository.TimesheetRepository;
import com.sipl.timesheet.pro.dto.response.TimesheetApiResponse;
import com.sipl.timesheet.pro.dtos.TimesheetDto;
import com.sipl.timesheet.pro.exception.TimesheetResourceNotFoundException;
import com.sipl.timesheet.pro.mapper.TimesheetMapper;
import com.sipl.timesheet.pro.services.TimesheetService;
@Service
@Component

public class TimesheetServiceImpl implements TimesheetService {

	@Autowired
	private TimesheetRepository timesheetRepository;

	@Autowired
	private TimesheetMapper timesheetMapper;

	@Override
	public TimesheetApiResponse addTimesheetData(TimesheetDto timesheetDto) {
	
		try {
			Timesheet timesheet = timesheetMapper.mapTimesheetDtoToTimesheet(timesheetDto);
			Timesheet timesheet2 = timesheetRepository.save(timesheet);
			TimesheetDto timesheetDto2 = timesheetMapper.mapTimesheetToTimesheetDto(timesheet2);
			return new TimesheetApiResponse(timesheetDto2, null, null, HttpStatus.CREATED,
					"Timesheet data add successfully", false);
		} catch (Exception e) {
			return new TimesheetApiResponse(null, null, null, HttpStatus.INTERNAL_SERVER_ERROR, " Server Error", false);
		}

	}

	@Override
	public TimesheetApiResponse getTimesheetAllData(int pageNumber, int pageSize) {
		try {
			Pageable pageable = PageRequest.of(pageNumber, pageSize);
			Page<Timesheet> page = timesheetRepository.findAll(pageable);
			List<TimesheetDto> timesheetDtos = timesheetMapper.mapTimesheetListToTimesheetDtoList(page);
			return new TimesheetApiResponse(null, timesheetDtos, null, HttpStatus.OK,
					"Timesheet All Data present Successfully", false);
		} catch (Exception e) {
			return new TimesheetApiResponse(null, null, null, HttpStatus.INTERNAL_SERVER_ERROR, "Server Error", false);
		}

	}

	@Override
	public TimesheetApiResponse updateTimesheetData(TimesheetDto timesheetDto, int id) {
		try {
			Optional<Timesheet> optional = timesheetRepository.findById(id);
			if (optional.isPresent()) {
				Timesheet existingTimesheet = optional.get();
				//timesheetMapper.mapTimesheetToTimesheetDto(existingTimesheet);

				
                 timesheetRepository.save(existingTimesheet);	
                 TimesheetDto updatedDto = timesheetMapper.mapTimesheetToTimesheetDto(existingTimesheet);
//				Timesheet existingTimesheet = optional.get();
//				timesheetRepository.save(existingTimesheet);
				return new TimesheetApiResponse(timesheetDto, null, null, HttpStatus.OK, "data updated successfully",
						false);
			} else {
				return new TimesheetApiResponse(null, null, null, HttpStatus.NOT_FOUND, "Timesheet Id Is Not Exists",
						false);
			}

		} catch (Exception e) {
			return new TimesheetApiResponse(null, null, null, HttpStatus.INTERNAL_SERVER_ERROR, "Server Error", false);
		}

	}

	@Override
	public TimesheetApiResponse getIdTimesheetData(int id) {
		try {
			Timesheet timesheet = timesheetRepository.findById(id)
					.orElseThrow(() -> new TimesheetResourceNotFoundException("Timesheet", "Id", id));
			TimesheetDto timesheetDto = timesheetMapper.mapTimesheetToTimesheetDto(timesheet);
			return new TimesheetApiResponse(timesheetDto, null, null, HttpStatus.OK,
					"timesheet Get id found successfully", false);
		} catch (Exception e) {
			return new TimesheetApiResponse(null, null, null, HttpStatus.INTERNAL_SERVER_ERROR, "Server Error", false);
		}

	}

	@Override
	public TimesheetApiResponse deleteTimesheetData(int id) {

		try {
			Timesheet present = timesheetRepository.findById(id)
					.orElseThrow(() -> new TimesheetResourceNotFoundException("Timesheet", "id", id));
			timesheetRepository.delete(present);
			return new TimesheetApiResponse(null, null, null, HttpStatus.OK, "Timesheet Data deleted successfully",
					false);
		} catch (Exception e) {
			return new TimesheetApiResponse(null, null, null, HttpStatus.INTERNAL_SERVER_ERROR, "Server Error", false);
		}

	}

}
