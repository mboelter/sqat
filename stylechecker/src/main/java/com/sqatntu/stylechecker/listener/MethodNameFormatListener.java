/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Andy Chong Chin Shin
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software
 * and associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software
 * is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING
 * BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 */

package com.sqatntu.stylechecker.listener;

import com.sqatntu.api.JavaBaseListener;
import com.sqatntu.api.JavaParser;
import com.sqatntu.stylechecker.StyleCheckerException;
import com.sqatntu.stylechecker.configuration.Configuration;
import com.sqatntu.stylechecker.configuration.StyleName;
import com.sqatntu.stylechecker.report.StyleReport;
import com.sqatntu.stylechecker.report.StyleReportContent;

/**
 * Check method name format of source codes
 * Two method name format is define in {@link StyleName}:
 * 1. {@link StyleName#METHOD_NAME_FORMAT_CAMEL_CASE}
 * 2. {@link StyleName#IGNORE_STYLE}
 *
 * @see StyleName#METHOD_NAME_FORMAT
 */
class MethodNameFormatListener extends JavaBaseListener {

  private Configuration configuration;
  private StyleReport report;

  public MethodNameFormatListener(Configuration configuration, StyleReport report) {
    this.configuration = configuration;
    this.report = report;
  }

  @Override
  public void enterMethodDeclaration(JavaParser.MethodDeclarationContext ctx) {
    // Determine regular expression by using configuration
    try {
      if (configuration
          .getAttribute(StyleName.METHOD_NAME_FORMAT)
          .equals(StyleName.IGNORE_STYLE)) {
        return;
      }
    } catch (StyleCheckerException e) {
      // This means that no configuration for method name format is set,
      // so we don't do any check.
      System.out.println(e.getMessage());
      return;
    }

    String methodNameFormatValue = StyleName.METHOD_NAME_FORMAT_CAMEL_CASE;
    String regex = "^([a-z])([a-zA-Z0-9])*";

    // Do matching and add new report
    String methodName = ctx.getChild(1).getText();

    // If there is no problem with the method name
    if (methodName.matches(regex)) {
      return;
    }

    String message;
    String suggestion;

    switch (methodNameFormatValue) {
      case StyleName.METHOD_NAME_FORMAT_CAMEL_CASE:
        message = "You should use camel case for method name";
        suggestion = "Change method name to " + toCamelCase(methodName);
        break;
      default:
        // This should never happens
        message = "";
        suggestion = "";
        break;
    }

    int line = ctx.getStart().getLine();
    int column = ctx.getStart().getCharPositionInLine() + ctx.getChild(0).getText().length() + 2;

    StyleReportContent reportContent = new StyleReportContent(line, column, message, suggestion);
    report.addReportContents(reportContent);
  }

  private String toCamelCase(String string) {
    return string.substring(0, 1).toLowerCase() + string.substring(1);
  }
}
