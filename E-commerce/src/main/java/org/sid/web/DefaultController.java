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
public class DefaultController {
	
	@Autowired
	private IUserService service ;
	
	/**
	 * page home
	 * 
	 * @return string 
	 */
	@RequestMapping(value="/")
	public String defaultPage() {
		
		return "home";
	}
	/**
	 * page home
	 * 
	 * @return string 
	 */
	@RequestMapping(value="/home")
	public String home() {
		
		return "home";
	}
	/**
	 * page category
	 * 
	 * @return string 
	 */
	@RequestMapping(value="/category")
	public String category() {
		
		return "category";
	}
	
	/**
	 * page details product
	 * 
	 * @return string 
	 */
	@RequestMapping(value="/single-product")
	public String singleProduct() {
		
		return "single-product";
	}
	
	/**
	 * page shopping cart
	 * 
	 * @return string 
	 */
	@RequestMapping(value="/cart")
	public String cart() {
		
		return "cart";
	}

	/**
	 * System auth change controller
	 * 
	 *  
	 */
	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value="/logout")
	public String logout() {
		return "redirect:/home";
	}
	
	@RequestMapping(value="/registration", method=RequestMethod.GET)
	public String register(Model model) {
		//User user = new User();
		UserDto user = new UserDto();
		model.addAttribute("user", user);
		return "registration";
	}
	
	/*
	 * Persisting data 
	 * 
	 */
	@RequestMapping(value="/registration",method=RequestMethod.POST)
	public ModelAndView registerAccount(
			@ModelAttribute("user") @Valid UserDto accountDto,
			BindingResult result,
			WebRequest request,
			Errors errors
			) {		
		User registred = new User();
		// System.out.println(accountDto.getEmail());
		// System.out.println(result);
		if( !result.hasErrors() ) {
			System.out.println(" no errors ");
			registred = createUserAccount(accountDto, result);
		} 
		if ( registred == null ) {
			System.out.println(" registred was null ");
			result.rejectValue("email", "message.regError"); // 
		}
		if( result.hasErrors() ) {
			System.out.println(" has errors ");
			return new ModelAndView("registration","user",accountDto);
		}
		else {
			return new ModelAndView("successRegister","user",accountDto);
		}
		
					
	}
	
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
