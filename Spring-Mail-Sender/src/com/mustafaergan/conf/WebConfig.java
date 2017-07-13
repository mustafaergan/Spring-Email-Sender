package com.mustafaergan.conf;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@EnableWebMvc
@Configuration
@Import(ViewConfig.class)
@ComponentScan(basePackages = { "com.mustafaergan" })
public class WebConfig {
	
	@Bean
	public JavaMailSender javaMailService() {
		JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
		javaMailSender.setHost(MainConfEnum.SERVER.getValue());
		javaMailSender.setPort(Integer.parseInt(MainConfEnum.PORT.getValue()));
		javaMailSender.setUsername(MainConfEnum.USER.getValue());
		javaMailSender.setPassword(MainConfEnum.PASSWORD.getValue());
		javaMailSender.setJavaMailProperties(getMailProperties());
		return javaMailSender;
	}

	private Properties getMailProperties() {
		Properties properties = new Properties();
		properties.setProperty("mail.transport.protocol", MainConfEnum.TRANSPORT_PROTOCOL.getValue());
		properties.setProperty("mail.smtp.auth", MainConfEnum.SMTP_AUTH.getValue());
		properties.setProperty("mail.smtp.starttls.enable", MainConfEnum.SMTP_STARTTLS_ENABLE.getValue());
		properties.setProperty("mail.debug", MainConfEnum.MAIL_DEBUG.getValue());
		return properties;
	}

}