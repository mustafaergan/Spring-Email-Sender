package com.mustafaergan.conf;

/**
 * 
 *	 gmail
 *   setHost("smtp.gmail.com");
 *   setPort(587);
 *   setUsername("gmail-username");
 *   setPassword("gmail-password");
 *
 */

public enum MainConfEnum {
	SERVER(1,"127.0.0.1"),
	PORT(2,"25"),
	USER(3,"user"),
	PASSWORD(4,"password"),
    TRANSPORT_PROTOCOL(5,"smtp"),
    SMTP_AUTH(6,"true"),
    SMTP_STARTTLS_ENABLE(7,"true"),
	MAIL_DEBUG(8,"true");
    
    private int id;
    private String value;

    private MainConfEnum(int id, String type) {
        this.id = id;
        this.value = type;
    }

    public String getValue() {
        return value;
    }
}
