package com.kirosys;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
public class IndexController {
    
	@GetMapping("/")
	public String home() {
		return "index";
	}
	  
	  @ModelAttribute("systemipaddress")
	  public String getClientIpAddressIfServletRequestExist(Model model) throws UnknownHostException {
		    InetAddress localhost = InetAddress.getLocalHost();
	        model.addAttribute("ipaddress", localhost.getHostAddress());
	        model.addAttribute("serverTime", new Date());
			return localhost.getHostAddress();

	    }
}
