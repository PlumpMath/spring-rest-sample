spring-rest-sample
==================

Every time I start a new Spring project, I always spend a bunch of
time trying to get Spring wired up with the servlet.  Along with
getting logging and basic configuration setup.  

For future reference I have created this project as a starting point.

Logging
-------

- configured in src/main/resources log4j.properties 
- added to webapp/WEB-INF/web.xml
  - settings:
  
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

Configuration properties are autowired using `@Configuration` and
setting the properties with `@Value` see: com.haleenenterprise.web.config.Config
  
The properties files are added in the src/resources/servlet.xml 

The setup allows for overriding configuration, by adding the
web.properties in the src/resources/ this puts it on the classpath and
defaults all of the configuration values. 

The first override is pointing to a location on the file system and
overrides any properties from the classpath properties.  This is
useful because you can set the properties file on a production server
and do not need to touch it for re-deployments.

The second override is by using the CATALINA_OPTS and setting a -D
property to a property file.  This is useful for development mode or
to change properties for testing without modifying the environment. 

`export CATALINA_OPTS="-Dprops=/opt/props/web.properties "`





To run  `mvn clean install tomcat7:run`



