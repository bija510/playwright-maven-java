# playwright-maven-java

##Introduction:- This source code will provide this following features.
1. Demo for all the feature of playwright.
2. playwright **Base class** with before & after method.
3. **config.properties** file for Environment variable. from where we can do any browser execution like chrome, msedge, chromium, firefox, webkit.
4. **Headless or UI or BrowserType** can be control from config.properties file.
4. **Json** file for Test data.
5. **Screenshot on Failure** with this format Name monthDate_methodName_hourMinSec.png. which makes it easy to figure out.
6. Test suite can be customized in testng.xml file.
7. Report, one is **default testNG report** & another is **custom TestNG_Metrics_report.**

## How to create the testNG_Metrics report.
* TestNg Metrics is a custom report generated using TestNG Listener. 
  Which generate awesome html report without making any changes in your existing automation code
```
<!-- https://github.com/adiralashiva8/testng-metrics -->
	<dependency>
  		<groupId>com.github.adiralashiva8</groupId>
 	 	<artifactId>testng-metrics</artifactId>
  		<version>1.6</version>
	</dependency>
	
```
* Create a testng.xml file just put this 3 parameter after <suite & run that's all
```
  <parameter name="testng.metrics.report.logo" value = "https://i.ibb.co/FqtQyC5/rfh.png"/>
  <parameter name="testng.metrics.report.name" value = "sequential_tests_report.html"/>
  <parameter name="testng.metrics.report.appendTimestamp" value = "True"/>
  
```