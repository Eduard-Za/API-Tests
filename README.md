# Tests (API)
Test Automation Engineer - API testing task.

<p>This project contains automation tests for testing the following web-services:

<b>http://services.groupkt.com/country/get/all</b></br>
 
 <b>http://services.groupkt.com/country/get/iso2code/{COUNTRY_ISO2CODE}</b>
 
<h3>Technology stack includes:</h3>
<ul>
<li>Java 8</li>
<li>Maven</li>
<li>REST Assured</li>
<li>JUnit</li>
<li>Lombok</li>
<li>Gson</li>
<li>Allure</li>
<li>SLF4J</li>
<li>Hamcrest</li>
</ul>
<hr/>

<h3>Description of project structure</h3>

Tests for API <b>(src\test\java\MainTest.java)</b> were written using REST Assured. 

Also, were created custom exceptions (<b>src\main\java\exceptions</b>).
Package <b>(src\main\java\utils)</b> contains <b>PropertiesLoader.class</b> 
that allows to load properties from properties files (<b>src\main\resources\test.properties</b>)
and contains <b>JsonReader.class</b> that contains method
<b>getDataFromJson(String path, Class className)</b> to convert json to Java class.

<h3>How to run tests</h3>

<p>Please open a terminal and run next commands:</p>
<code> git clone https://github.com/Eduard-Za/API-Tests.git</code><br/>
<code>cd API-Tests</code><br/>
<code> mvn clean test</code><br/>
<br> 
<h3> Allure report</h3>
<p>After executing previous commands, please run:</p>
<code>mvn allure:serve</code><br/>
</br>

Please send all questions to <b>eduardos1218@gmail.com</b>.
 
