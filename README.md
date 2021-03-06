##Spring Rest Sample


[![Build Status](https://secure.travis-ci.org/scotthaleen/spring-rest-sample.png?branch=master)](http://travis-ci.org/scotthaleen/spring-rest-sample)


Starting point for Spring projects that are mostly [REST-like](http://www.intridea.com/blog/2010/4/29/rest-isnt-what-you-think-it-is) services<br/>
with basic configuration and logging setup. 

For future reference I have created this project as a starting point.

Logging
-------

- configured in `src/main/resources/log4j.properties` 
- added to `webapp/WEB-INF/web.xml` settings:
  
  ```XML
   <context-param>
      <param-name>log4jConfigLocation</param-name>
      <param-value>classpath:log4j.properties</param-value>
   </context-param>
   
   <context-param>
      <param-name>log4jExposeWebAppRoot</param-name>
      <param-value>true</param-value>
   </context-param>
   
   <listener>
      <listener-class>org.springframework.web.util.Log4jConfigListener</listener-class>
    </listener>
   ```

Configuration
-------------

Configuration properties are autowired using `@Configuration` and<br/>
setting the properties with `@Value` see: com.haleenenterprise.web.config.Config
  
The properties files are added in the `src/resources/servlet.xml` 

The setup allows for overriding configuration, by adding the<br/>
`web.properties` in the `src/resources/` this puts it on the classpath and<br/>
defaults all of the configuration values.<br/>

The first override is pointing to a location on the file system and<br/>
overrides any properties from the classpath properties.  This is<br/>
useful because you can set the properties file on a production server<br/>
and do not need to touch it for re-deployments.<br/>

The second override is by using the CATALINA_OPTS and setting a -D<br/>
property to a property file.  This is useful for development mode or<br/>
to change properties for testing without modifying the environment. <br/>

`export CATALINA_OPTS="-Dprops=/opt/props/web.properties "`


Run
---
`mvn clean install tomcat7:run`


```
$ curl http://localhost:1337/services/sample/echo/what
{"result":"what"}
$ curl http://localhost:1337/services/sample/foo
bar
```


