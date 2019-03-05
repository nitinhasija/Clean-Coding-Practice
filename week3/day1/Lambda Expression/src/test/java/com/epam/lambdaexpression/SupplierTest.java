/*
 * Test a supplier 
 */

// To Do
// 1. supplier test to check if its not null

package com.epam.lambdaexpression;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.epam.lambdaexpressions.supplier.Password;

import java.util.function.Supplier;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * The Class SupplierTest.
 *
 * @author Nitin_Hasija
 */
class SupplierTest {

  /**
   * Supplier testing.
   */
  @Test
  @DisplayName("Test supplier")
  public void supplierTest() {

    Supplier<Integer> supply = () -> {
      return new Password().getPassword();
    };

    assertNotNull(supply.get());
  }
}
