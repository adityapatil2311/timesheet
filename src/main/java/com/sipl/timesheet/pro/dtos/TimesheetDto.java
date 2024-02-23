package com.sipl.timesheet.pro.dtos;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimesheetDto {

	private int timesheetid;
	private int userId;
	private int employeeId;
	private int projectId;
	private LocalDateTime timesheetDate;
	private int activityId;
	private int hrsSpent;
	private String comment;
	private boolean isDeleted;
	private int createdBy;
	private LocalDateTime createdDate;
	private int modifiedBy;
	private LocalDateTime modifiedDate;
}
