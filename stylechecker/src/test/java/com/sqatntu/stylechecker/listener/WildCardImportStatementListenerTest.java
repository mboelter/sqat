/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Andy Chong Chin Shin
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

package com.sqatntu.stylechecker.listener;

import static org.junit.Assert.assertEquals;

import com.sqatntu.stylechecker.StyleChecker;
import com.sqatntu.stylechecker.StyleCheckerException;
import com.sqatntu.stylechecker.report.StyleReport;
import com.sqatntu.testutil.TestUtil;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by andyccs on 22/9/15.
 */
public class WildCardImportStatementListenerTest {

  @Test
  public void importStatementsWithoutWildCard() throws IOException, StyleCheckerException {
    StyleChecker checker = new StyleChecker();
    StyleReport report = checker.checkSourceCode(
        TestUtil.loadFile("src/test/resources/stylechecker/WildCardImportStatementNoWildCard.java"),
        TestUtil.loadFile("src/test/resources/stylechecker/WildCardNotAllow.json"));
    assertEquals(0, report.getReportContents().size());
  }

  @Test
  public void importStatementsHasWildCard() throws IOException, StyleCheckerException {
    StyleChecker checker = new StyleChecker();
    StyleReport report = checker.checkSourceCode(
        TestUtil.loadFile(
            "src/test/resources/stylechecker/WildCardImportStatementHasWildCard.java"),
        TestUtil.loadFile("src/test/resources/stylechecker/WildCardNotAllow.json"));
    assertEquals(2, report.getReportContents().size());
    assertEquals(3, report.getReportContents().get(0).getLineNumber());
    assertEquals(4, report.getReportContents().get(1).getLineNumber());
  }

  @Test
  public void importStatementsAllowWildCard() throws IOException, StyleCheckerException {
    StyleChecker checker = new StyleChecker();
    StyleReport report = checker.checkSourceCode(
        TestUtil.loadFile(
            "src/test/resources/stylechecker/WildCardImportStatementHasWildCard.java"),
        TestUtil.loadFile("src/test/resources/stylechecker/WildCardAllow.json"));
    assertEquals(0, report.getReportContents().size());
  }
}
