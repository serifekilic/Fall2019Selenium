package com.automation.tests.day8;

import org.testng.Assert;
import org.testng.annotations.*;

public class BasicTestNGTests {


    //runs only once before @BeforeClass and @BeforeMethod
    @BeforeTest
    public void beforeTest(){
        System.out.println("Before test");
    }


    @AfterTest
    public void afterTest(){
        System.out.println("After Test");
    }
    //runs only once in the class before @BeforeMethod and before any test
    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("After Class");
    }
    @BeforeMethod
    public void setup(){
        System.out.println("Before Method");
    }
    //runs automatically after every test
    @AfterMethod
     public void teardown(){
        System.out.println("After Method");
    }
    @Test
    public void test1(){
        System.out.println("Test 1");
        String expected="apple";
        String actual="apple";
        Assert.assertEquals(actual,expected);
    }
    @Test
    public void test2(){
        System.out.println("Test 2");
        int num1=5;
        int num2=10;
        //it calls hard assertion
        //if assertion fails- it stops the execution (due to exception)
        Assert.assertTrue(num1<num2);
    }
}
