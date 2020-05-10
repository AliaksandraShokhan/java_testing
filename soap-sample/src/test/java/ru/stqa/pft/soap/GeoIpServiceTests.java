package ru.stqa.pft.soap;

import com.lavasoft.GeoIPService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GeoIpServiceTests {

    @Test
    public void testMyIp() {
        String location = new GeoIPService().getGeoIPServiceSoap12().getIpLocation("37.214.73.211");
        Assert.assertEquals(location, "<GeoIP><Country>BY</Country><State>06</State></GeoIP>");
    }

    @Test
    public void testInvalidIp() {
        String location = new GeoIPService().getGeoIPServiceSoap12().getIpLocation("37.214.73.abc");
        Assert.assertNotEquals(location, "<GeoIP><Country>BY</Country><State>06</State></GeoIP>");
    }
}
