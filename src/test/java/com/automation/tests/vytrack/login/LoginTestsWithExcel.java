package com.automation.tests.vytrack.login;

import com.automation.pages.LoginPage;
import com.automation.tests.vytrack.AbstractTestBase;
import com.automation.utilities.ExcelUtil;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
/*
main goal is :
1- getting all data from excel while testing login with different user,
2- then writing updated test status into excel file
3- if fails it will go to after method and there we would make a record to excel file as Fail
 */
public class LoginTestsWithExcel extends AbstractTestBase {


    @Test(dataProvider = "credentialsFromExcel")
    public void loginTestWithExcel2(String execute, String username, String password, String firstname, String lastname, String result) {

        String path = "VytrackTestUsers.xlsx";
        String spreadSheet = "QA3-short";
       excelUtil = new ExcelUtil(path, spreadSheet);

        test = report.createTest("Login test for username :: " + username);
        if (execute.equals("y")) {

            LoginPage loginPage = new LoginPage();
            loginPage.login(username, password);
            test.info("Login as " + username);//log some steps
            test.info(String.format("First name: %s, Last name: %s, Username: %s", firstname, lastname, username));
            test.pass("Successfully logged in as " + username);
            excelUtil.setCellData("PASSED", "result", row++);

        } else if (execute.equals("n")) {
            test.skip("Test was skipped for user: " + username);
            excelUtil.setCellData("SKIPPED", "result", row++);
            //to skip some test in testng
            throw new SkipException("Test was skipped for user: " + username);
        }
    }

    @DataProvider
    public Object[][] credentialsFromExcel() {
        String path = "VytrackTestUsers.xlsx";
        String spreadSheet = "QA3-short";
        ExcelUtil excelUtil = new ExcelUtil(path, spreadSheet);
        //execute	username	password	firstname	lastname	result
        return excelUtil.getDataArray();
    }
}