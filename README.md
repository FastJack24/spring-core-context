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
* This process can be automated: @Autowiring annotation

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
* No parameters, any name, any return value, but useless, any access modifier for these methods
* With prototype beans spring doesn't call destroy methods and of course call init on every object created
* Factory method parameter is used for creating objects using your oun factory method (value-method name) +
  (private constructor), there also works singleton or prototype as you specified

###  With annotations:
You already know that there are three types of annotations:
1) Pre-compiling time (Code analyze before compilation)
2) Compiling time (for compiler)
3) For passing metadata to your application (reflection) or to other applications or frameworks

Why to use in Spring?
1) Shorter than xml
2) More convenient than xml
3) More readable than in xml
   Spring scans all your classes and creates beans according to them.

* @Component annotation. That means creation of a bean from this class
  (this is the annotation that Spring is looking for). There you can also create the id for
  your bean (or your class starting with little case character by default).

* @Autowired annotation.
  Spring is looking for dependency (bean) to inject and does it by itself. Constructor, setter (any name)
  or field (even private with no setters or constructor, does it with Java Reflection API, but it's a bad
  practice) with dependency must be marked! Even if there are two parameters,
  one annotation and everything is done.
1) If Spring finds a bean of the desired type it is injected
2) If no bean was found - error
3) If there are several beans - uncertainty (can be dealt with)

* @Qualifier annotation.
  As a value uses bean id that must be injected.
  In constructor must be entered before! the parameter declaration.

* @Value("${musicPlayer.name}") annotation.
  private String name;
  Placeholder in XML and property file are the same, also accepts simple values.

* @Scope annotation.
  Singleton or Prototype. Used with component annotation.

* @PostConstruct and @PreDestroy annotation are used instead of init-method and destroy-method.
  These methods are marked.

### Bare Java code configuration:
* @Configuration annotation.
  To mark that this is the class with Spring Application configuration.

The following annotations is used to configure this file like in XML:
* @ComponentScan("com.fastjack");
* @PropertySource("classpath:com.fastjack");
* @Bean annotation. This thing is used on methods (return value - needed CLASS, method name - bean ID),
  just returns NEW object (spring doesn't always call it though with singleton).
  In constructor, we call another bean method to inject a dependency.

In main, we are going to have:
1) AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class)
2) Then getBean() as usual
3) On @Bean, we also can have @Scope and other bean annotations
