# IMDb Web Driver Challenge

**Selenium Web Driver**:<br />
I have used selenium v3.4.0 to implement automation coding challenge.

**Supported Browers**:   
a. Chrome  
-Browser v59  
-ChromeDriver v2.31    
b. Firefox   
-Browser v54.0.1  
-Geckodriver v0.18.0  
  
In this framework, I have implemented support for Chrome & Firefox only. 
'InitializeDriver' class takes care of it.  
Executables of Chrome & Firefox drivers are kept under: /src/test/resources/webdrivers  

**Page Object Model & Page Factory:**  
I have used Page Object Model which is a design pattern to create Object Repository for web UI elements. Under this model, for each web page in the application, there should be corresponding page class. I have created 'ImdbTopRankPage' and 'WesternGenrePage' classes for this task. These Page classes contain the WebElements of that web page and also contains Page methods which perform operations on those WebElements. Name of these methods are given as per the task they are performing.  

**Page Factory** is an inbuilt Page Object Model concept for Selenium WebDriver and it is very optimized. Here as well, I followed the concept of separation of Page Object Repository and Test Methods. Additionally, with the help of PageFactory class, I have used annotation @FindBy to find WebElement. I have used initElements method to initialize web elements.  

**Logging (log4j v1.2.17):**  
For logging purpose, we have used Log4j which is a fast, flexible and reliable logging framework (APIS) written in Java. With Log4j, we are storing the flow details of our Selenium Automation in a file and displaying the same on console. This way we can log all debug messages to console and log file. 'ConfigureLogLevel' class takes care of it.  
  
Path of log4j properties file: /src/main/resources/log4j.properties  
Path of Output log file: /target/logs/imdb_test.log  

**Conf file:**  
URL can be changed depending on the type of environment - UAT/stage/prodution etc.
Keeping such configurable fields in mind, I have created a conf file where user can change these values before running automation. This way one won't have to make changes in code directly.

Considering the scope of this coding challenge, I have kept only 2 fields in this file, i.e. url and browser.  
Example:  
url=http://www.imdb.com/chart/top  
browser=chrome  

Path: /IMBdChallenge/src/test/resources/run.conf  

**Screenshots:**
I have created a class named 'ScreenShotOnFailure' to take screenshot in case of test failure.
Here, apply() method of MethodRule is overwritten which intervene before Junit sends out the test results and insert the screenshot capturing code. 
Hence, screenshot is always captured ONLY in case of testcase failure.

Path of screenshots: /IMBdChallenge/target/screenshot
  
