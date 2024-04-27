package com.javarush.task.task37.task3709.connectors;

import com.javarush.task.task37.task3709.security.SecurityChecker;


public class SecurityProxyConnector implements Connector, SecurityChecker {
    SecurityChecker securityChecker;
    SimpleConnector simpleConnector;

    public SecurityProxyConnector(String a) {
        this.simpleConnector = new SimpleConnector(a);
    }

    @Override
    public void connect() {
    if(securityChecker.performSecurityCheck()){
        simpleConnector.connect();
    }
    }

    @Override
    public boolean performSecurityCheck() {
        return securityChecker.performSecurityCheck();
    }
}
