package com.celexus.application;

import static org.junit.Assert.fail;

import org.junit.Test;

import com.celexus.conniption.application.ApplicationException;
import com.celexus.conniption.application.CertificateInstallerApplication;

public class CertificateInstallerApplicationTest {

    @Test
    public void test() {
        try {
            CertificateInstallerApplication.main(null);
        } catch (ApplicationException e) {
            fail("Error thrown");
        }
    }

}
