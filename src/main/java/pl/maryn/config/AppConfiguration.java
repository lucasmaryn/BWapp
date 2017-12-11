package pl.maryn.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.format.FormatterRegistry;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import pl.maryn.converter.ExerciseConverter;
import pl.maryn.converter.SingleTrainingDayConverter;
import pl.maryn.converter.TrainingConverter;
import pl.maryn.converter.UserConverter;
import pl.maryn.repository.UserRepository;

import javax.persistence.EntityManagerFactory;

@ComponentScan(basePackages = {"pl.maryn"})
@EnableTransactionManagement
@EnableWebMvc
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
@Configuration
public class AppConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean("entityManagerFactory")//kiedy? -> springdata to wykorzystuje
    public LocalEntityManagerFactoryBean entityManagerFactoryBean() {
        LocalEntityManagerFactoryBean emfb = new LocalEntityManagerFactoryBean();
        emfb.setPersistenceUnitName("bwappPersistenceUnit");
        return emfb;
    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager tm = new JpaTransactionManager(emf);
        return tm;
    }

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver =
                new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(getExerciseConverter());
        registry.addConverter(getSingleTrainingDayConverter());
        registry.addConverter(getUserConverter());
        registry.addConverter(getTrainingConverter());

    }

    @Bean
    public ExerciseConverter getExerciseConverter() {
        return new ExerciseConverter();
    }

    @Bean
    public SingleTrainingDayConverter getSingleTrainingDayConverter() {
        return new SingleTrainingDayConverter();
    }

    @Bean
    public UserConverter getUserConverter() {
        return new UserConverter();
    }

    @Bean
    public TrainingConverter getTrainingConverter() {
        return new TrainingConverter();
    }


}
