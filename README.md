# Test Automation Engineer testing task (API)
Test Automation Engineer - API testing task.

<p>This project contains automation tests for testing the following web-services:

 http://services.groupkt.com/country/get/all
 http://services.groupkt.com/country/get/iso2code/{COUNTRY_ISO2CODE} 
 
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
Package <b>src\main\java\utils</b> contains <b>PropertiesLoader.class</b> 
that allows to load properties from properties files (<b>src\main\resources\test.properties</b>)
and contains <b>JsonReader.class</b> that contains method
<b>getDataFromJson(String path, Class className)</b> to convert json to Java class.

<h3>How to run tests</h3>

<p>Please open a terminal and run next commands:</p>
<code></code><br/>
<code></code><br/>
<code></code><br/>
<br> 
<p></p>
</br>
Please send all questions to <b>eduardos1218@gmail.com</b>.
 
