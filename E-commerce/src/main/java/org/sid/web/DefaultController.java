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
	
	
	@RequestMapping(value="/logout")
	public String logout() {
		return "redirect:/home";
	}
	
	
	
}
