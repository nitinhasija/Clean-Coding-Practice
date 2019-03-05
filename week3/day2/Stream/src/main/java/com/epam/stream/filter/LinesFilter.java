/*
 * Stream implementation
 */

package com.epam.stream.filter;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * This class finds the lines having "java" in them.
 * 
 * @author Nitin_Hasija
 */
public class LinesFilter {

  /**
   * Gets the specific lines.
   *
   * @param fileName the file name
   * @param filter the filter
   * @return the specific lines
   * @throws IOException Signals that an I/O exception has occurred.
   */
  public List<String> getSpecificLines(String fileName, String filter) throws IOException {
    URL url = Thread.currentThread().getContextClassLoader().getResource("textFile");
    String path = URLDecoder.decode(url.getFile(), "UTF-8");
    File textFile = new File(path);

    try (Stream<String> allLine = Files.lines(textFile.toPath())) {
      return allLine.filter(str -> str.toLowerCase().contains(filter)).collect(Collectors.toList());
    }
  }
}
