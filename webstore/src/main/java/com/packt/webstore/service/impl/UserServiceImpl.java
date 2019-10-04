package com.packt.webstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Service;

import com.packt.webstore.domain.repository.UserRepository;
import com.packt.webstore.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public int getUserId(String userName) {
		// TODO Auto-generated method stub		
		return 1510;
	}
	

	@Override
	public String getViewFolderName(SecurityContextHolderAwareRequestWrapper request) {
		return getRole(request);
	}
    
	private String getRole(SecurityContextHolderAwareRequestWrapper request) {		
		String role = null;
		//finding out the user role and send hie to the respective page
		
		//any following pattern is accepted so far
		boolean isAdminisTrator = request.isUserInRole("ROLE_ADMIN");
		boolean isStudent = request.isUserInRole("STUDENT");
		boolean  isSuperVisor=request.isUserInRole("SUPERVISOR");
		
		if(isAdminisTrator==true) {
			role =  "admin" ;
		}else if(isSuperVisor==true){
			role ="supervisor" ;
		}else if(isStudent==true) {
			role = "student";
		}
		return role;
	}
	 
	
	@Override
	public int getUserId(String userName, SecurityContextHolderAwareRequestWrapper request) {
		String userRole = getRole(request);
		String databaseTableName = "students";
		String columnName ="student_id";
		int userId = userRepository.getUserId(databaseTableName,userName,columnName);
		System.out.println("userId "+userId);
		return userId;
	}

}
