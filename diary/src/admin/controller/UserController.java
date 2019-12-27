package admin.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import admin.po.User;
import admin.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	public ModelAndView login(User user, ModelAndView mv, HttpSession session)
			throws Exception {
		int res = userService.checkUser(user);
		if (res > 0) {
			session.setAttribute("username", user.getUsername());
			mv.setView(new RedirectView("/diary/diaryList.action"));
		} else {
			mv.setViewName("login");
		}
		return mv;
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession session,ModelAndView mv) throws Exception{
		session.setAttribute("username", null);
		mv.setViewName("login");
		
		return mv;
		
	}
}
