package org.sid.web;

import javax.validation.Valid;

import org.sid.entites.User;
import org.sid.service.IUserService;
import org.sid.validation.EmailExistsException;
import org.sid.web.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController {
	
	@Autowired
	private IUserService service ;
	
	/**
	 * 
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/registration", method=RequestMethod.GET)
	public String register(Model model) {
		
		UserDto user = new UserDto();
		model.addAttribute("user", user);
		return "registration";
		
	}
	
	/**
	 * 
	 * @param accountDto
	 * @param result
	 * @param request
	 * @param errors
	 * @return
	 */
	@RequestMapping(value="/registration",method=RequestMethod.POST)
	public ModelAndView registerAccount(
			@ModelAttribute("user") @Valid UserDto accountDto,
			BindingResult result,
			WebRequest request,
			Errors errors
			) {
		
		User registred = new User();
		if( !result.hasErrors() ) {
			System.out.println(" no errors ");
			registred = createUserAccount(accountDto, result);
		} 
		if ( registred == null ) {
			System.out.println(" registred was null ");
			result.rejectValue("email", "errors"); // 			
		}
		if( result.hasErrors() ) {
			System.out.println(" has errors ");
			return new ModelAndView("registration","user",accountDto);
			//return "registration";
			
		}
		else {
			return new ModelAndView("successRegister","user",accountDto);
		}
		
					
	}
	
	/**
	 * create user 
	 * @param accountDto
	 * @param result
	 * @return
	 */
	private User createUserAccount(UserDto accountDto, BindingResult result) {
		
		User registred = null ;
		try {
			registred = service.registerNewAccount( accountDto );
			
		}catch(EmailExistsException e){
			
			return null ;
		}
		
		return registred ;
	}
}
