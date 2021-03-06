package Controller.Ajax;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AjaxController {
	@RequestMapping("/ajaxTest")
	public String ajaxTest() {
		return "ajax/AjaxTest";
	}
	
	@RequestMapping("/AjaxTest1")
	public String ajaxTest1() {
		return "ajax/AjaxTest1";
	}
	
	@RequestMapping("/AjaxTest2")
	public String ajaxTest1(@ModelAttribute(value="n") String n) {
		return "ajax/AjaxTest2";
	}
}
