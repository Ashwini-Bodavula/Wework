### _About_
The project demonstrates a smart automation infrastructure. It is built in hierarchy order of modules. The modules contain number of classes with methods.
There are main/common/helpers/actions/page_object modules.
In this way, the tests can be created in very simple way with a minimum lines of code.
And the infrastructure allows us to work with different kinds of applications.
**Big advantage of the infrastructure is that it can be easily maintained!**

### _Project Overview_

The project is an example of infrastructure for automation testing of different kinds of applications:
* Web based application
* Mobile application
* Web API
* Electron application
* Desktop application

### **_Infrastructure project includes using of:_**
* Page object design pattern
* Project layers (Extensions, Work Flows, Test Cases etc.)
* Support of different clients and browsers
* Failure mechanism
* Common functionality
* External files support
* Reporting system (including screenshots)
* Visual testing
* DB support
* CI support  

***

### _List of applications were used in this project:_
* Grafana webpage - Web based application
* MyDoge - Mobile application
* Grafana API - Web API
* Electron application (Todolist)
* Windows calculator - Desktop application

### _Tools & Frameworks used in the project:_
* TestNG - Testing framework
* Listeners - Interface used to generate logs and customize the TestNG reports
* MySQL Free Online DB - Used for login to Grafana web page
* [Jenkins](https://www.jenkins.io/) - For tests execution
* REST Assured - For API testing
* [Allure Reports](http://allure.qatools.ru/) - As the main reporting system:

![This is an image](/allure-results/Report-Failure.png)
