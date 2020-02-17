package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
	@RequestMapping("/hello")
	//무조건 반환형은 string
	public String helloTest(Model model, @RequestParam(value="name",required=false) int a) {
		model.addAttribute("test", a);
		return "hello";	
		//spring-context.xml에서 잡아놧기때문에 .jsp를 안써도 된다.
	}
}
