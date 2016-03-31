package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FrontendController {
	
	@RequestMapping("/")
    public String index(Model model) {
        return "index";
    }
	
	@RequestMapping("/docs/")
    public String docs(@RequestParam(value="url", required=false, defaultValue="member") String url, Model model) {
        return "forward:/docs/index.html?url"+url;
    }
	
	

}