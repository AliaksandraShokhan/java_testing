package ru.stqa.pft.mantis.tests;

import org.testng.annotations.Test;

import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;

public class SkipIfNotFixedTest extends TestBase{

    @Test
    public void testSkipIfOpen() throws RemoteException, ServiceException, MalformedURLException {
        int issueId = 1;
        skipIfNotFixed(issueId);
    }

    @Test
    public void testNotSkipIfClosed() throws RemoteException, ServiceException, MalformedURLException {
        int issueId = 2;
        skipIfNotFixed(issueId);
    }
}
