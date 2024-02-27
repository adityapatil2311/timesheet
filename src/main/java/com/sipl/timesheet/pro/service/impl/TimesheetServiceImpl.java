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

import lombok.extern.slf4j.Slf4j;

@Service
@Component
@Slf4j
public class TimesheetServiceImpl implements TimesheetService {

	@Autowired
	private TimesheetRepository timesheetRepository;

	@Autowired
	private TimesheetMapper timesheetMapper;

	@Override
	public TimesheetApiResponse addTimesheetData(TimesheetDto timesheetDto) {

		log.info("<<START>> addTimesheetData called <<START>>");
		try {
			Timesheet timesheet = timesheetMapper.mapTimesheetDtoToTimesheet(timesheetDto);
			Timesheet timesheet2 = timesheetRepository.save(timesheet);
			TimesheetDto timesheetDto2 = timesheetMapper.mapTimesheetToTimesheetDto(timesheet2);
			log.info("<<End>> addTimesheetData called <<End>>");
			return new TimesheetApiResponse(timesheetDto2, null, null, HttpStatus.CREATED,
					"Timesheet data add successfully", false);

		} catch (Exception e) {
			log.error("Exception in addTimesheet Server",e);

			return new TimesheetApiResponse(null, null, null, HttpStatus.INTERNAL_SERVER_ERROR, " Server Error", false);
		}

	}

	@Override
	public TimesheetApiResponse getTimesheetAllData(int pageNumber, int pageSize) {
		try {
			log.info("<<START>> getAllTimesheetData called <<START>>");
			Pageable pageable = PageRequest.of(pageNumber, pageSize);
			Page<Timesheet> page = timesheetRepository.findAll(pageable);
			log.info("<<END>> getAllTimesheetData called <<END>>");
			List<TimesheetDto> timesheetDtos = timesheetMapper.mapTimesheetListToTimesheetDtoList(page);
			return new TimesheetApiResponse(null, timesheetDtos, null, HttpStatus.OK,
					"Timesheet All Data present Successfully", false);

		} catch (Exception e) {
			log.error("Exception in getAllTimesheet Server",e);
			return new TimesheetApiResponse(null, null, null, HttpStatus.INTERNAL_SERVER_ERROR, "Server Error", false);
		}

	}

	@Override
	public TimesheetApiResponse updateTimesheetData(TimesheetDto timesheetDto, int id) {
		try {
			log.info("<<Start>> updateTimesheetData called <<Start>>");

			Optional<Timesheet> timesheetOptional = timesheetRepository.findById(id);

			if (!timesheetOptional.isPresent()) {

				return new TimesheetApiResponse(timesheetDto, null, null, HttpStatus.NOT_FOUND,
						"Timesheet does not exist in our system, and unfortunately, you can't update it", false);
			} else {
				Timesheet existingTimesheet = timesheetMapper.mapTimesheetDtoToTimesheet(timesheetDto);
				existingTimesheet.setTimesheetid(timesheetOptional.get().getTimesheetid());

				timesheetRepository.save(existingTimesheet);

				log.info(" save TimesheetData ");

				TimesheetDto updatedDto = timesheetMapper.mapTimesheetToTimesheetDto(existingTimesheet);

				log.info("<<Start>> updateTimesheetData called <<Start>>");

				return new TimesheetApiResponse(updatedDto, null, null, HttpStatus.OK, "Data updated successfully",
						false);

			}

		} catch (Exception e) {
			log.error("Exception in updateTimesheet Server", e);
			return new TimesheetApiResponse(null, null, null, HttpStatus.INTERNAL_SERVER_ERROR, "Server Error", false);
		}
	}

	@Override
	public TimesheetApiResponse getIdTimesheetData(int id) {
		try {
			log.info("<<START>> getIdTimesheetData called <<START>>");
			Timesheet timesheet = timesheetRepository.findById(id)
					.orElseThrow(() -> new TimesheetResourceNotFoundException("Timesheet", "Id", id));
			TimesheetDto timesheetDto = timesheetMapper.mapTimesheetToTimesheetDto(timesheet);
			log.info("<<END>> getIdTimesheetData called <<END>>");
			return new TimesheetApiResponse(timesheetDto, null, null, HttpStatus.OK,
					"timesheet GetId found successfully", false);
		} catch (Exception e) {
			log.error("Exception in getIdTimesheet Server",e);
			return new TimesheetApiResponse(null, null, null, HttpStatus.INTERNAL_SERVER_ERROR, "Server Error", false);
		}

	}

	@Override
	public TimesheetApiResponse deleteTimesheetData(int id) {

		try {
			log.info("<<START>> deleteTimesheetData called <<START>>");

			Timesheet present = timesheetRepository.findById(id)
					.orElseThrow(() -> new TimesheetResourceNotFoundException("Timesheet", "id", id));
			timesheetRepository.delete(present);
			log.info("<<End>> deleteTimesheetData called <<End>>");
			return new TimesheetApiResponse(null, null, null, HttpStatus.OK, "Timesheet Data deleted successfully",
					false);
		} catch (Exception e) {
			log.error("Exception in deleteTimesheet Server",e);
			return new TimesheetApiResponse(null, null, null, HttpStatus.INTERNAL_SERVER_ERROR, "Server Error", false);
		}

	}

}
