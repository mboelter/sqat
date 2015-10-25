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
