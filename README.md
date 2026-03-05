This is a simple project demonstrating an issue we are seeing with Spring Boot 4 and an Entity object referencing itself using native image. This
used to work in Spring Boot 3.

Run the command :
mvn spring-boot:process-aot

This should programmatically generate all the bean definitions initially. You will get the following stack trace in the entity when it is mapped to an instance 
to itself with a join table. However, when the entity contains a self‑referencing relationship using a join table, the mapping process triggers the following stack trace.

```text
Caused by: java.lang.IllegalStateException: PostInitCallback queue could not be processed...
        - PostInitCallbackEntry - Entity(com.example.springbootissue.entity.EntityEntity) `sqmMultiTableInsertStrategy` interpretation

        at org.hibernate.metamodel.mapping.internal.MappingModelCreationProcess.executePostInitCallbacks(MappingModelCreationProcess.java:154)
        at org.hibernate.metamodel.mapping.internal.MappingModelCreationProcess.execute(MappingModelCreationProcess.java:98)
        at org.hibernate.metamodel.mapping.internal.MappingModelCreationProcess.process(MappingModelCreationProcess.java:43)
        at org.hibernate.metamodel.model.domain.internal.MappingMetamodelImpl.finishInitialization(MappingMetamodelImpl.java:167)
        at org.hibernate.internal.SessionFactoryImpl.<init>(SessionFactoryImpl.java:283)
        at org.hibernate.internal.SessionFactoryRegistry.instantiateSessionFactory(SessionFactoryRegistry.java:64)
        at org.hibernate.boot.internal.SessionFactoryBuilderImpl.build(SessionFactoryBuilderImpl.java:437)
        at org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl.build(EntityManagerFactoryBuilderImpl.java:1456)
        ... 30 more

