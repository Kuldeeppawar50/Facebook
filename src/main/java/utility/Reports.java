package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {
    public static ExtentReports configureReports()
    {
        ExtentSparkReporter esrobj=new ExtentSparkReporter("extendsReports.html");
        ExtentReports erobj=new  ExtentReports();
        erobj.attachReporter(esrobj);
        erobj.setSystemInfo("TestType", "Regression");
        erobj.setSystemInfo("Application", "SwagLab");
        erobj.setSystemInfo("Author", "Kuldeep");


        return erobj;
    }

}


