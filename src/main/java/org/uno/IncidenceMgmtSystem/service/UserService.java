package org.uno.IncidenceMgmtSystem.service;

import org.uno.IncidenceMgmtSystem.model.*;

/**
 *
 */
public interface UserService {
	User save(User user);
	boolean findByLogin(String userName, String password);
	boolean findByUserName(String userName);
	User findUserDetails(String userName);
}
