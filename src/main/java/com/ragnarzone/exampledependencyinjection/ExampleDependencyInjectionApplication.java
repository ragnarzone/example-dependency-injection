package com.ragnarzone.exampledependencyinjection;

import com.ragnarzone.exampledependencyinjection.config.RagnarzoneConfiguration;
import com.ragnarzone.exampledependencyinjection.config.RagnarzoneConstructorConfig;
import com.ragnarzone.exampledependencyinjection.controllers.*;
import com.ragnarzone.exampledependencyinjection.datasource.FakeDataSource;
import com.ragnarzone.exampledependencyinjection.services.PrototypeBean;
import com.ragnarzone.exampledependencyinjection.services.SingletonBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class ExampleDependencyInjectionApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(ExampleDependencyInjectionApplication.class, args);

		PetController petController = ctx.getBean("petController", PetController.class);
		System.out.println("--- The Best Pet is ---");
		System.out.println(petController.whichPetIsTheBest());

		I18nController i18nController = (I18nController) ctx.getBean("i18nController");
		System.out.println(i18nController.sayHello());

		MyController myController = (MyController) ctx.getBean("myController");


		System.out.println("--------- Primary Bean");
		System.out.println(myController.sayHello());

		System.out.println("------ Property");

		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
		System.out.println(propertyInjectedController.getGreeting());

		System.out.println("--------- Setter");

		SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");
		System.out.println(setterInjectedController.getGreeting());

		System.out.println("-------- Constructor");

		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
		System.out.println(constructorInjectedController.getGreeting());

		System.out.println("------ Bean Scopes --------");
		SingletonBean singletonBean1 = ctx.getBean(SingletonBean.class);
		System.out.println(singletonBean1.getMyScrope());
		SingletonBean singletonBean2 = ctx.getBean(SingletonBean.class);
		System.out.println(singletonBean2.getMyScrope());

		PrototypeBean prototypeBean1 = ctx.getBean(PrototypeBean.class);
		System.out.println(prototypeBean1.getMyScope());
		PrototypeBean prototypeBean2 = ctx.getBean(PrototypeBean.class);
		System.out.println(prototypeBean2.getMyScope());

		System.out.println("---------- Fake Data Source:");
		FakeDataSource fakeDataSource = ctx.getBean(FakeDataSource.class);
		System.out.println(fakeDataSource.getUsername());
		System.out.println(fakeDataSource.getPassword());
		System.out.println(fakeDataSource.getJdbcurl());

		System.out.println("--------- Config Props Bean");
		RagnarzoneConfiguration ragnarzoneConfiguration = ctx.getBean(RagnarzoneConfiguration.class);
		System.out.println(ragnarzoneConfiguration.getUsername());
		System.out.println(ragnarzoneConfiguration.getPassword());
		System.out.println(ragnarzoneConfiguration.getJdbcurl());

		System.out.println("----------- Constructor Binding");
		RagnarzoneConstructorConfig ragnarzoneConstructorConfig = ctx.getBean(RagnarzoneConstructorConfig.class);
		System.out.println(ragnarzoneConstructorConfig.getUsername());
		System.out.println(ragnarzoneConstructorConfig.getPassword());
		System.out.println(ragnarzoneConfiguration.getJdbcurl());
	}

}
