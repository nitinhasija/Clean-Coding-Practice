/**
 * LinesFilter testing
 */

package com.epam.stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.epam.stream.filter.LinesFilter;

import java.io.IOException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * The Class LinesFilterTest.
 *
 * @author Nitin_Hasija
 */
class LinesFilterTest {

  /** The filter. */
  private static LinesFilter filter;

  /**
   * Inits the.
   */
  @BeforeAll
  public static void init() {
    filter = new LinesFilter();
  }

  /**
   * Check list.
   *
   * @throws IOException Signals that an I/O exception has occurred.
   */
  @Test
  @DisplayName("Checking the size of list")
  public void checkList() throws IOException {
    int expectedLines = 2;
    assertEquals(expectedLines, filter.getSpecificLines("textFile", "java").size());
  }
}
