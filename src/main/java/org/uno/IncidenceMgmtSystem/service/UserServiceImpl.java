package org.uno.IncidenceMgmtSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.uno.IncidenceMgmtSystem.model.*;
import org.uno.IncidenceMgmtSystem.repository.*;;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	/**
	 * Ssaves the user details to the database by invoking the userRepository which uses JPA to
	 * interact with the database.
	 * This save is trasactional , Either all pass or All fail
	 * @param user
	 * @return User
	 */
	@Transactional
	public User save(User user) {
		return userRepository.save(user);
	}

	/**
	 * checks for particular user and passsword combinations in the database
	 * to fins out if they really exist or notß
	 *
	 * @param userName
	 * @param password
	 * @return true/false
	 */
	public boolean findByLogin(String userName, String password) {	
		User stud = userRepository.findByUserName(userName);
		
		if(stud != null && stud.getPassword().equals(password)) {
			return true;
		} 
		
		return false;		
	}

	/**
	 * Verify the username in the database exists
	 * @param userName
	 * @return true/false
	 */
	public boolean findByUserName(String userName) {
		User stud = userRepository.findByUserName(userName);
		
		if(stud != null) {
			return true;
		}
		
		return false;
	}


	/**
	 * Finds the details about a user in the database.
	 * @param userName
	 * @return  User
	 */
	public User findUserDetails(String userName) {
		return userRepository.findByUserName(userName);
	}

}
