package com.automation.tests.day13;

import org.testng.annotations.Test;

public class SystemProperties {


    @Test
    public void test(){

     //   System.out.println(System.getProperties());//it is like a map
        //hepsini verir.
        System.out.println(System.getProperty("user.dir"));
        //  /Users/studio2/IdeaProjects/Fall2019SElenium/pom.xml
        //System.getProperty("user.dir")+ "/pom.xml"
        //ortak calisma yapiyoruz, herkesin ayni file i kullanmasi imkansiz. yukaridaki gibi yazarsak
        //sorun cikmaz.
        //it represent our Selenium project
        System.out.println(System.getProperty( "os.name" ));
        ////flexible path to downloads folder
        System.out.println(System.getProperty("user.home"));
        //for windows, use \\ instead of /
        // System.getProperty("user.home")+"/Downloads"
        //file in download edilip edilmedigini check edecegim, ama path sadece benim bilgisayarima
        //ozgu. yukaridaki download i herkesin computerina uygun bir sekilde gormesini saglar

        // bunu String e de cevirebiliriz

        String pathToDownloads=System.getProperty("user.home")+"/Downloads";
        System.out.println(pathToDownloads);
                //flexible, works for every computer
        //******interview Sorusu:   how to check that a file is downloaded in Selenium

        System.out.println(System.getProperty("os.arch"));
        //        //https://docs.oracle.com/javase/tutorial/essential/environment/sysprop.html
    }

}
