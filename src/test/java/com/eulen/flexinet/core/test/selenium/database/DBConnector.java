package com.eulen.flexinet.core.test.selenium.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.eulen.flexinet.core.test.selenium.steps.util.Hooks;

public class DBConnector {

    public static Connection getConnection() {
            Connection connection = null;
            System.out.println("@DEBUG retornando conexion");
            try {
                String url = "";
                String user = "";
                String password = "";
                switch (Hooks.getEnv()) {
                    case PRE:
                        url = "jdbc:as400://eulenpre.eulen.com/FLEXINET";
                        user = "USRFXWAS";
                        password = "PREFXWAS";
                        break;
                    case UAT:
                        url = "jdbc:as400://eulenuat.eulen.com/FLEXINET";
                        user = "USRFXWAS";
                        password = "a123456";
                        break;
                }
                connection = DriverManager.getConnection(url, user, password);

            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("ERROR: No se ha podido establecer conexión con la base de datos");
                //TODO: Parar a logger para registrarlo
            }
        return connection;
    }
}
