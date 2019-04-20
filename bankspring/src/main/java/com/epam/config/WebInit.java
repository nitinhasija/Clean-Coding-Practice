/**
 * 
 */

package com.epam.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * The Class WebInit.
 *
 * @author Nitin_Hasija
 */
public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer {

  /*
   * (non-Javadoc)
   * 
   * @see org.springframework.web.servlet.support.
   * AbstractAnnotationConfigDispatcherServletInitializer#getRootConfigClasses()
   */
  @Override
  protected Class<?>[] getRootConfigClasses() {
    return new Class[0];
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.springframework.web.servlet.support.
   * AbstractAnnotationConfigDispatcherServletInitializer#getServletConfigClasses(
   * )
   */
  @Override
  protected Class<?>[] getServletConfigClasses() {
    return new Class[] { Configurations.class };
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.springframework.web.servlet.support.AbstractDispatcherServletInitializer#
   * getServletMappings()
   */
  @Override
  protected String[] getServletMappings() {
    return new String[] { "/" };
  }

}
