package Controller.Servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import Common.AbstractServletController;

@Controller
public class MainController extends AbstractServletController{
	@RequestMapping(value = "/main.html")
	public String index(ModelMap modelmap, HttpSession session, HttpServletRequest req, HttpServletResponse res) {
		modelmap.addAttribute("test", "hello world");
		return "main";
	}
}
