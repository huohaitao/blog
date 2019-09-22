package com.hhtsoft;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author huoht
 *
 */
@SpringBootApplication
@MapperScan("com.hhtsoft.**.dao")
public class AppStarter {

	public static void main(String[] args) {
		SpringApplication.run(AppStarter.class, args);
	}
	
}
