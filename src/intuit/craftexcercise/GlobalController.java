package intuit.craftexcercise;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GlobalController {
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView getHome(){		
		ModelAndView mv = new ModelAndView("index1");
		return mv;
	}	
	
	/**
	 * get Login page
	 * @return
	 */
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public ModelAndView getLoginPage(HttpServletRequest request){
		ModelAndView mv = new ModelAndView("login");
		
		return mv;
	}
	
	

}
