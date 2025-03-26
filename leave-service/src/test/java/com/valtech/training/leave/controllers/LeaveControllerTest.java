package com.valtech.training.leave.controllers;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.valtech.training.leave.commons.LeaveStatus;
import com.valtech.training.leave.commons.LeaveType;
import com.valtech.training.leave.entities.Leave;
import com.valtech.training.leave.vos.ApproveLeaveVO;
import com.valtech.training.leave.vos.LeaveVO;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class LeaveControllerTest {

	@LocalServerPort
	private Integer port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	void testApplyAndApprove(){
		String url="http://localhost:"+port+"/api/v1/leaves/";
		LeaveVO vo=restTemplate.postForObject(url+"apply",new LeaveVO(0,"08-03-2025","09-03-2025",LeaveType.CASUAL.name(),LeaveStatus.APPLIED.name(),"Going to Employee"," ",2), LeaveVO.class);
		assertTrue(vo.id()!=0);
		assertEquals(vo.leaveStatus(),LeaveStatus.APPLIED.name());
		ApproveLeaveVO avo=new ApproveLeaveVO(vo.id(), "Your Leave is approved", 1);
		vo=restTemplate.patchForObject(url+"approve", avo, LeaveVO.class);
	}
	@Test
	void test() {
		String url="http://localhost:"+port+"/api/v1/leaves/";
		List leaves=restTemplate.getForObject(url, List.class);
		if(leaves.size()==0) {
			//1,2,3,4,5 are valid employees
			restTemplate.postForObject(url,new LeaveVO(0,"08-03-2025","09-03-2025",LeaveType.CASUAL.name(),LeaveStatus.APPLIED.name(),"Going to Employee"," ",1), LeaveVO.class);
			restTemplate.postForObject(url,new LeaveVO(0,"12-03-2025","13-03-2025",LeaveType.SICK.name(),LeaveStatus.APPLIED.name(),"Have Fewer"," ",1), LeaveVO.class);
			restTemplate.postForObject(url,new LeaveVO(0,"12-03-2025","13-03-2025",LeaveType.CASUAL.name(),LeaveStatus.APPLIED.name(),"Going to Employees"," ",2), LeaveVO.class);

		}
	}

}
