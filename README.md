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

Bean scope is the way spring creates beans (id, class and scope when we create beans). 
Singleton is the default scope. (Only one object, the bean is stateless). Prototype is the one that 
creates new value anytime getBean() method is called (When a bean is stateful). We have also request, 
session, global-session (Spring MVC).

Bean lifecycle:

.0) Opening an application

1) Spring IoC container is starting
2) Beans are created
3) Dependency Injection (DI)
4) Init-method is called (Logic for bean creation is done)
for bean initialization (resource initialization, calling files, opening databases)
5) Bean is ready to be used!!!
6) Do something with the bean
7) Destroy-method is called (Logic for bean destruction is done) 

.00) An application is closed

These methods are in your bean class, can be mentioned (full name) in id, class, scope block.
* No parameters, any name, any return value, but useless, any access modifier for these methods.
* With prototype beans spring doesn't call destroy methods and of course call init on every object created.
* Factory method parameter is used for creating objects using your oun factory method (value-method name) +
(private constructor), there also works singleton or prototype as you specified.