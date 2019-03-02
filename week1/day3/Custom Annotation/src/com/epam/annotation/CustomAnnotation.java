/*
 * Custom annotation implementation
 */

package com.epam.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * custom annotation implementation
 * 
 * @author Nitin_Hasija
 *
 */

@Target(ElementType.TYPE) // defines the type for example class or interface
@Retention(RetentionPolicy.RUNTIME) // defines the scope of inteface
@interface Information {
  String author() default "Anonymous";

  double version() default 1.0;

  String creationDate() default "1/10/2019";
}