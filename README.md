# POC-Project-Automation

## How to run:
#### 1 - Clone the Project
#### 2 - Open CMD in Project folder
#### 3 - Enter the commands:
> mvn clean test
- **Or**
#### 1 - Navigate to folder: src/test/resources
#### 2 - Right-click on the file "runXXXXTest.xml"
#### 3 - Choose option "Run '..."
![image](https://user-images.githubusercontent.com/76104139/209756047-33f2415b-f8a0-48f6-839f-058dbb138f3b.png)


## Allure Report:
Allure results will appear in "target/allure-results" folder. To generate html report and automatically open it in a web browser, run the following command:
> allure serve target/allure-results
