# Learning Spring Core/Context
    
There are three ways to configure Spring (beans, DI, etc.):

    1) XML config file (a little deprecated)
    2) Java com.fastjack.annotations and some XML
    3) Only Java code

The first thing is to create dependencies (spring-core (depends on jcl (logging)), spring-context 
(depends on core, beans, aop (aspect oriented programming), expressions)) in pom.xml. 
So you have to call only spring-context!
Maven web app archetype:

    src/
        main/
            java(source folder)/
                 com/
                     fastjack/
                         *.java(all your code)
            resources(source folder)/
                applicationContext.xml
                something.properties
                webapp(web resource folder)/
                    index.jsp
                    WEB-INF/
                        web.xml

Beans are just classes e.g. TestBean with a private field "name", getters, setters, a constructor.

### With xml files:
Create applicationContext.xml file, add your beans there, configure constructors, dependencies. 
In Main.java create ClassPathXmlApplicationContext object, call getBean("BeanId", *.class) 
creating reference and bean, do whatever you want with this bean.

There are several ways to inject dependencies:
1) Constructor
2) Setters
3) XML (Links, Simple values, .properties file), Annotations, Java code

There are a lot of configurations:
* scope, init-method, destroy-method, factory method, etc.
* This process can be automated:
* @Autowiring annotation
