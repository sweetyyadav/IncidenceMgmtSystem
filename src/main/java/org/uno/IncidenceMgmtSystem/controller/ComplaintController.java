package org.uno.IncidenceMgmtSystem.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.uno.IncidenceMgmtSystem.model.Complaint;
import org.uno.IncidenceMgmtSystem.model.ComplaintForm;
import org.uno.IncidenceMgmtSystem.model.ComplaintType;
import org.uno.IncidenceMgmtSystem.model.User;
import org.uno.IncidenceMgmtSystem.service.ComplaintService;

@Controller
public class ComplaintController {

	@Autowired
	private  ComplaintService complaintService;

	/**
	 * For a logged in user in to the incident management system
	 * he can register a complaint anytime he wants he just needs to click
	 * add complaint on the User Interface
	 * @param form
	 * @param model
	 * @param request
	 * @param session
	 * @return addcomplaint.jsp or failure.jsp as a string
	 */
	
	@RequestMapping(value="complaint",method=RequestMethod.GET)
	public String addComplaintGet(@ModelAttribute("complaintForm") ComplaintForm form,Model model,HttpServletRequest request,HttpSession session){
		
		try{
			
			List<ComplaintType>  complaintTypeList= complaintService.findComplaintTypeList();
			User user =(User) session.getAttribute("USER_DETAILS");
			model.addAttribute("complaintTypeList", complaintTypeList);
			model.addAttribute("tenant", complaintService.findTenantDetails(user.getId().intValue()));
			
			return "addcomplaint";
		}catch(Exception e){
			e.printStackTrace();
			return "failure";
		}
	}

	/**
	 * Once the user enters the complaint details and tries to submit it
	 * @param form
	 * @param model
	 * @param request
	 * @param session
	 * @return complaint.jsp or failure.jsp
	 */

	@RequestMapping(value="complaint",method=RequestMethod.POST)
	public String addComplaintPost(@ModelAttribute("complaintForm") ComplaintForm form,Model model,HttpServletRequest request,HttpSession session){
		
		try{
			User user =(User) session.getAttribute("USER_DETAILS");
			form.setUserId(user.getId().intValue());
			Integer id =complaintService.saveComplaint(form);
			model.addAttribute("message", "Your complaint has been logged successfully. Complaint Id for your reference is-"+id);
			
			return "redirect:complaint.html";
		}catch(Exception e){
			e.printStackTrace();
			return "failure";
		}
	}


	/**
	 * Once the user clicks on the manage complaint on the User Interface.
	 * This Gets the manage complaint page from the server.
	 *
	 * @param form
	 * @param model
	 * @param request
	 * @param session
	 * @return managecomplaint.jsp or failure.jsp
	 */
	@RequestMapping(value="managecomplaint",method=RequestMethod.GET)
	public String manageComplaintGet(@ModelAttribute("complaintForm") ComplaintForm form,Model model,HttpServletRequest request,HttpSession session){
		
		try{
			
			User user =(User) session.getAttribute("USER_DETAILS");
			List<Complaint> list = complaintService.findComplaintList(user.getId().intValue());
			model.addAttribute("COMPLAINT_LIST", list);
			
			return "managecomplaint";
		}catch(Exception e){
			e.printStackTrace();
			return "failure";
		}
	}

	/**
	 * Once the user clicks on the update complaint page.This fetches the update complaint page
	 * @param form
	 * @param id
	 * @param model
	 * @param request
	 * @param session
	 * @return updatecomplaint.jsp or failure.jsp
	 */
	@RequestMapping(value="updatecomplaint",method=RequestMethod.GET)
	public String updateComplaintGet(@ModelAttribute("complaintForm") ComplaintForm form,
									@RequestParam(value="id",required=false) Integer id,Model model,HttpServletRequest request,HttpSession session){
		
		try{
			
			List<ComplaintType>  complaintTypeList= complaintService.findComplaintTypeList();
			User user =(User) session.getAttribute("USER_DETAILS");
			model.addAttribute("complaintTypeList", complaintTypeList);
			model.addAttribute("tenant", complaintService.findTenantDetails(user.getId().intValue()));
			model.addAttribute("complaintForm", complaintService.findeComplaint(id));
			return "updatecomplaint";
		}catch(Exception e){
			e.printStackTrace();
			return "failure";
		}
	}

	/**
	 * When user updates the complaint details on the form and tries to submit it
	 * @param form
	 * @param model
	 * @param request
	 * @param session
	 * @return managecomplaint.html or failure.jsp
	 */

	@RequestMapping(value="updatecomplaint",method=RequestMethod.POST)
	public String updateComplaintPost(@ModelAttribute("complaintForm") ComplaintForm form,Model model,HttpServletRequest request,HttpSession session){
		
		try{
			User user =(User) session.getAttribute("USER_DETAILS");
			form.setUserId(user.getId().intValue());
			complaintService.updateComplaint(form);
			model.addAttribute("message", "Your complaint has been  successfully update.");
			
			return "redirect:managecomplaint.html";
		}catch(Exception e){
			e.printStackTrace();
			return "failure";
		}
	}
	
}
