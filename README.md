# Learning Spring Core/Context
    
There are three ways to configure Spring:

    1) XML config file (a little deprecated)
    2) Java com.fastjack.annotations and some XML
    3) Only Java code

The first thing is to create three dependencies (spring-core (depends on jcl (logging)),
spring-context (depends on core, beans, aop (aspect oriented programming), expressions)) in pom.xml.
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

