# Rabbit QA Automation Test

Rabbit QA Automation Assignment Test

## Installation
- Clone the repository `https://github.com/aseeshr/rabbit-qa-automation.git`
- Change directory to the `rabbit-qa-automation`
- Run `maven clean install` in the command line. It should download all dependencies and execute the tests.
- After test is executed it will create `test-output` folder in the project root directory. And it
  contains test reports.
- cd into `test-output` and visit `index.html` to see the test results.
- `Maven` is used as dependency manager thus `pom.xml` contains depencies for this project.

## Configure Dependencies

#### Project Dependencies
- Apache Maven (https://maven.apache.org/)
- Junit4 (https://github.com/junit-team/junit4/wiki/Download-and-Install)
- Selenium web driver (http://www.seleniumhq.org/projects/webdriver/)
- Selenium server (http://www.seleniumhq.org/projects/webdriver/)
- TestNG (http://testng.org/doc/index.html) - Eclipse plugin

#### Add Dependencies
- Install the dependencies listed above.
- TestNG, Junit4 should be added as library to eclipse project.
- Selenium web driver (client, server) should be added as external jar file in
  eclipse project
- dependencies should be configured in the build path properly.

- Download selenium webdriver client from http://www.seleniumhq.org/download/.

- Download http://selenium-release.storage.googleapis.com/3.0/selenium-java-3.0.1.zip.
  Extract it and add client-combined-3.0.1-nnodeps.jar as referenced libraries into the eclipse project.

- Download geckodriver from https://github.com/mozilla/geckodriver/releases and extract it.
  Copy the path where geckodriver executable has been place. Add this path to the system environment.

- open console(terminal), and execute the following commands

## Execute Test

Test cases can be found in [Test
Cases Link](https://docs.google.com/spreadsheets/d/183QGHSFJ3-oap9B56TBpK3nceaGeI2LaHDPLDHlWC2o/edit?usp=sharing)

###### Execute Test From Command Line

- cd into the project root directory
- execute `mvn clean install` and wait for few minutes to complete it.
- When above command is executed, it will pull the dependencies for the project.
- once dependencies are completely pulled, the test is performed and output is written to `test-output`
  folder in the project root directory.

##### Execute Test From Eclipse Plugin

Run test suites defined in `testng.xml`.

- Right-click on `testng.xml` and choose `Run As` > `TestNG Suite`
- Once test suite is complete, the test report will be available in `test-output` folder.

## Reports

- Test reports are generated after executing the tests. These are generated and placed in `test-output` folder
  in the project root directory.


## Troubleshoot

- make sure that jdk has bee configured properly and is available on system environment.
- make sure that you have included selenium to your path
- make sure that selenium driver is setup properly and app can find it globally.
- make sure that you have followed the guidelines provided in
  http://www.seleniumhq.org/docs/appendix_installing_java_driver_Sel20_via_maven.jsp#importing-maven-into-eclipse-reference
