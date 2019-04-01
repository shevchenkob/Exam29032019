***Instalation notes***

1. Google Chrome browser (latest version)
2. Download and install JDK 1.8
https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
3. Download and install Intellij IDEA (Community version)
https://www.jetbrains.com/idea/download/
4. Download chromedriver from http://chromedriver.chromium.org/downloads and unzip it to project folder
5. Put in pom.xml import for selenium java from https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/3.141.59
6. Download and install git from https://gitforwindows.org/
7. Put in pom.xml import for test tool "testng" from https://mvnrepository.com/artifact/org.testng/testng
8. Add DataProvider from https://www.mkyong.com/unittest/testng-parameter-testing-example/
9. Add to pom.xml import from https://mvnrepository.com/artifact/org.apache.commons/commons-lang3/3.8.1

***Structure of project***

Project consist of following:
1. BasePage class - page where we have methods and objects that will be used in all other page classes
2. GooglePage class - page where we appear during navigation to  google.com
3. SearchPage1 class - page with first 10 results during search by word "selenium"
4. SearchPage2 class - page with second 10 results during search by word "selenium"
5. BaseTest class - class that consist before and after methods.
6. GoogleSearchTest class - test that consist of all input parameters and checks.
7 gitignore file - file that consist information that shouldn't be pushed into github
8. pom.xml - file with all necessary libraries that imported and used in our test
9. README file - file with necessary information about following project

***How to run test**

1. Navigate to project -> src -> test -> java -> test -> GoogleSearchTest.
2. Click "Run test" button.
