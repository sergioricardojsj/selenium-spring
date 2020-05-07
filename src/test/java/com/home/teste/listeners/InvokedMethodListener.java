package com.home.teste.listeners;

import com.home.teste.configuration.Config;
import com.home.teste.configuration.Log;
import com.home.teste.configuration.TLDriverFactory;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class InvokedMethodListener implements IInvokedMethodListener {

    @Override
    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
        if (iInvokedMethod.isTestMethod()) {
            TLDriverFactory.setDriver("CHROME");
            Log.logInfo("Iniciando o teste: " + iInvokedMethod.getTestMethod().getMethodName());
            TLDriverFactory.getDriver().navigate().to(new Config().getUrl());
        }
    }

    @Override
    public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
        if (iInvokedMethod.isTestMethod()) {
            if (iTestResult.getStatus() == 1) {
                Log.logInfo("Finalizando o teste: " + iInvokedMethod.getTestMethod().getMethodName() + " => passou!");
            } else if (iTestResult.getStatus() == 2) {
                Log.logInfo("Finalizando o teste: " + iInvokedMethod.getTestMethod().getMethodName() + " => falhou!");
            }

            if (TLDriverFactory.getDriver() != null) {
                TLDriverFactory.endDriver();
            }
        }
    }
}
