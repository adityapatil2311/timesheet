package com.sipl.timesheet.pro.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sipl.timesheet.pro.dao.entity.Timesheet;

public interface TimesheetRepository extends JpaRepository<Timesheet, Integer> {

	
}
