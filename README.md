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
- **On local machine**
#### Allure results will appear in "target/allure-results" folder. To generate html report and automatically open it in a web browser, run the following command:
> allure serve target/allure-results
- **On Azure DevOps**
#### 1 - Go to the latest build detail of pipeline
#### 2 - Click on button "xx published"
![image](https://user-images.githubusercontent.com/76104139/210324427-06aeb143-6b38-43f3-b738-887488646657.png)
#### 3 - Download the folder "Allure report", then extract the zip file on local machine
#### 4 - Open CMD and Enter the command:
> allure open "<path_of_extract_folder>"
