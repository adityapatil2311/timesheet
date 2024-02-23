package com.sipl.timesheet.pro.dao.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "timesheet")
public class Timesheet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "timesheet_id")
	private int timesheetid;
	@Column(name = "user_id")
	private int userId;
	@Column(name = "employee_id")
	private int employeeId;
	@Column(name = "project_id")
	private int projectId;
	@Column(name = "timesheet_date")
	private LocalDateTime timesheetDate;
	@Column(name = "activity_id")
	private int activityId;
	@Column(name = "hrs_spent")
	private int hrsSpent;
	@Column(name = "comment")
	private String comment;
	@Column(name = "is_deleted")
	private boolean isDeleted;
	@Column(name = "created_by")
	private int createdBy;
	@Column(name = "created_date")
	private LocalDateTime createdDate;
	@Column(name = "modified_by")
	private int modifiedBy;
	@Column(name = "modified_date")
	private LocalDateTime modifiedDate;
}
