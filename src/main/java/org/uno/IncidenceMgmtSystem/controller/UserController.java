package org.uno.IncidenceMgmtSystem.controller;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.uno.IncidenceMgmtSystem.model.User;
import org.uno.IncidenceMgmtSystem.model.UserLogin;
import org.uno.IncidenceMgmtSystem.service.UserService;


/**
 * This is the user controller.Any requests coming from the view by either GET or POST is directed here.
 * User Controller directs the requests to specific service layers.
 */

@Controller
@SessionAttributes("user")
public class UserController {
	
	@Autowired
	private UserService userService;

	/**
	 * As soon as user clicks on signup on view then
	 * controller's method signup runs.Since it is requesting for
	 * the signup page therefore the GET METHOD runs
	 * @param model
	 * @return signup
	 */
		
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public String signup(Model model) {
		User user = new User();		
		model.addAttribute("user", user);		
		return "signup";
	}

	/**
	 * As soon as user clicks on signup on view then
	 * controller's method signup runs.Since it is submitting data for
	 * the signup page therefore the POST METHOD runs
	 * @param model
	 * @return signup/login Invokes the signup.jsp if it has errors or user already exists OTHERWISE it redirects to login.jsp
	 */
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String signup(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {		
		if(result.hasErrors()) {
			return "signup";
		} else if(userService.findByUserName(user.getUserName())) {
			model.addAttribute("message", "User Name exists. Try another user name");
			return "signup";
		} else {
			userService.save(user);
			model.addAttribute("message", "Saved student details");
			return "redirect:login.html";
		}
	}

	/**
	 * As soon as user clicks on the login the page to put user name and password
	 * @param model
	 * @return login.jsp
	 */

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(Model model) {			
		UserLogin userLogin = new UserLogin();		
		model.addAttribute("userLogin", userLogin);
		return "login";
	}

	/**
	 * As soon as user submits the user name and password
	 * this method is invoked
	 * @param userLogin
	 * @param result
	 * @param session
	 * @return success.jsp or failure.jsp as a stringß
	 */
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@Valid @ModelAttribute("userLogin") UserLogin userLogin, BindingResult result,HttpSession session) {
		if (result.hasErrors()) {
			return "login";
		} else {
			boolean found = userService.findByLogin(userLogin.getUserName(), userLogin.getPassword());
			if (found) {	
				session.setAttribute("USER_DETAILS", userService.findUserDetails(userLogin.getUserName()));
				return "success";
			} else {				
				return "failure";
			}
		}
		
	}
}