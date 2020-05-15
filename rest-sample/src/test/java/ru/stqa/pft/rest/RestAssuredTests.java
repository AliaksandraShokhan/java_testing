package ru.stqa.pft.rest;

import com.jayway.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Set;

public class RestAssuredTests extends TestBase {

    @BeforeMethod
    public void init() {
        RestAssured.authentication = RestAssured.basic("288f44776e7bec4bf44fdfeb1e646490", "");
    }

    @Test
    public void testCreateIssue() throws IOException {
        Set<Issue> oldIssues = getIssues();
        Issue newIssue = new Issue().withSubject("Test issue").withDescription("New test issue");
        int issueId = createIssue(newIssue);
        Set<Issue> newIssues = getIssues();
        oldIssues.add(newIssue.withId(issueId));
        Assert.assertEquals(newIssues, oldIssues);
    }

    @Test
    public void testSkipIfOpen() throws Exception {
        int issueId = 80;
        skipIfNotFixed(issueId);
    }

    @Test
    public void testNotSkipIfNotOpen() throws Exception {
        int issueId = 88;
        skipIfNotFixed(issueId);
    }
}
