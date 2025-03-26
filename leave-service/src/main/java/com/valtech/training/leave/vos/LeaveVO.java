package com.valtech.training.leave.vos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import com.valtech.training.leave.commons.LeaveStatus;
import com.valtech.training.leave.commons.LeaveType;
import com.valtech.training.leave.entities.Leave;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public record LeaveVO(long id,String fromDate,String toDate,String leaveType,String leaveStatus,String reason,String comments,long employeeId) {
	public static DateTimeFormatter FORMATTER=DateTimeFormatter.ofPattern("dd-MM-yyyy");
	public void updateTo(Leave leave) {
		LocalDate from= LocalDate.parse(fromDate,FORMATTER);
		LocalDate to= LocalDate.parse(toDate,FORMATTER);
		LeaveType ltype=LeaveType.valueOf(leaveType);
		LeaveStatus lstatus=LeaveStatus.valueOf(leaveStatus);
		leave.setFromDate(from);
		leave.setToDate(to);
		leave.setLeaveType(ltype);
		leave.setLeaveStatus(lstatus);
		leave.setReason(reason);
		leave.setComments(comments);
		
	}
	
	
	
	public static LeaveVO from(Leave leave) {
		String from=leave.getFromDate().format(FORMATTER);
		String to=leave.getToDate().format(FORMATTER);
		String ltype=leave.getLeaveType().name();
		String lstatus=leave.getLeaveStatus().name();
		return new LeaveVO(leave.getId(), from, to, ltype, lstatus, leave.getReason(), leave.getComments(), leave.getEmployeeId());

	}
	
	public static List<LeaveVO> to(List<Leave> leaves){
		return leaves.stream().map(l->from(l)).collect(Collectors.toList());
	}
	
	public Leave to(){
		LocalDate from= LocalDate.parse(fromDate,FORMATTER);
		LocalDate to= LocalDate.parse(toDate,FORMATTER);
		LeaveType ltype=LeaveType.valueOf(leaveType);
		LeaveStatus lstatus=LeaveStatus.valueOf(leaveStatus);

		return new Leave(id,from,to,ltype,lstatus,reason,comments,employeeId);
	}
}
