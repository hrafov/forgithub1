
# TESTING TELESCOPE
> This is a internal project for UI, API and integration testing Testscope. All UI tests are running on Chrome browser.

---

## Start & watch tests

    $ mvn clean test

## Run Allure:

To Run Allure reporting, use following steps:
- Download zip file from site by link: [Bintray](https://bintray.com/qameta/generic/allure2)
- Go to the next path on your computer (Windows): control panel -> system and security -> system -> additional settings of system -> environment variables
   -> in table system variables find 'Path' -> edit -> paste path to the allure file destination like in example
   C:\Users\Nomad\allure-2.7.0\bin
- Restart your computer
- Go to compiler terminal
- After running test input
- Allure serve allure-results
- To terminate press Ctrl+C than Y

## Login

To login into the Telescope, use your own credentials.
This is a path to the credentials: TestProject-develop\src\main\resources

---

## Languages & tools

### Java

- [Java](https://www.java.com) 1.8.

### Maven

- [Maven](https://maven.apache.org/) 3.5.3.

### Selenium

- [Selenium](https://www.seleniumhq.org/) 3.14.0.

### Allure

- [Allure](http://allure.qatools.ru/) 2.0-BETA19

### Log4j

- [Log4j](http://logging.apache.org/log4j/1.2/) 1.2.17

