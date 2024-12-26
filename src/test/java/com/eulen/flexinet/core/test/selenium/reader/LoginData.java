package com.eulen.flexinet.core.test.selenium.reader;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginData {

    String user;
    String password;

    public LoginData(
            String user,
            String password
    ) {
        this.user = user;
        this.password = password;
    }
}
