/**
 * 
 */
package com.hhtsoft.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author huoht
 *
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
    public void addViewControllers(ViewControllerRegistry registry){
		String indexUrl = "forward:index";
        registry.addViewController("").setViewName(indexUrl);
        registry.addViewController("/").setViewName(indexUrl);
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }

}
