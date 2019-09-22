/**
 * 
 */
package com.hhtsoft.index;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author huoht
 *
 */
@Controller
@RequestMapping("/index")
public class IndexController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@RequestMapping
	public String index(ModelMap mm) {
		logger.debug("1232");
		mm.addAttribute("name", "霍海涛");
		return "index";
	}
}
