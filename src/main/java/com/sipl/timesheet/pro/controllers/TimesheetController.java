package com.sipl.timesheet.pro.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sipl.timesheet.pro.dto.response.TimesheetApiResponse;
import com.sipl.timesheet.pro.dtos.TimesheetDto;

@RestController
@RequestMapping("/timesheetapi")
public interface TimesheetController {

	@PostMapping("post")
	public TimesheetApiResponse addTimesheet(@RequestBody TimesheetDto timesheetDto);

	@GetMapping("/getAll")
	public TimesheetApiResponse getAllTimesheet(
			@RequestParam(value = "pageNumber", defaultValue = "0", required = false) int pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "3", required = false) int pageSize);

	@PutMapping("/update/{id}")
	public TimesheetApiResponse updateTimesheet(@RequestBody TimesheetDto timesheetDto, @PathVariable("id") int id);

	@GetMapping("/getId/{id}")
	public TimesheetApiResponse getIdTimesheet(@PathVariable("id") int id);

	@DeleteMapping("/delete/{id}")
	public TimesheetApiResponse deleteTimesheet(@PathVariable("id") int id);
}
