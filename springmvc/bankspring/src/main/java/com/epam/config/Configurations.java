package com.epam.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * The Class Configurations.
 *
 * @author Nitin_Hasija
 */
@Configuration
@ComponentScan("com.epam")
public class Configurations {

  public static final String SUFFIX = ".jsp";

  /**
   * View rosolver.
   *
   * @return the internal resource view resolver
   */
  @Bean
  public InternalResourceViewResolver viewRosolver() {
    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
    viewResolver.setSuffix(SUFFIX);
    return viewResolver;
  }
}
