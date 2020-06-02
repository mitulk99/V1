package com.amazon;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.amazon.util.Backend;
import com.amazon.util.Requirements;  

@Controller 
public class HelloController {
	
	@RequestMapping("/hello")
	public String display(HttpServletRequest req,Model m)
	{
		String pincode=req.getParameter("pincode");
		String radius=req.getParameter("radius");
		String category=req.getParameter("category");
		Backend be=new Backend();
		String str=be.Back(pincode, radius, category);
		if(str=="")
			str="Ooops !!!No items retrived";
		m.addAttribute("message", str);
		return "viewpage";
	}
}
