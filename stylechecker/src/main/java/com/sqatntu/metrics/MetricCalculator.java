package com.sqatntu.metrics;

import com.sqatntu.ThrowingErrorListener;
import com.sqatntu.api.JavaLexer;
import com.sqatntu.api.JavaParser;
import com.sqatntu.metrics.injection.MetricCalculatorModule;
import com.sqatntu.metrics.listener.NumberOfMethodsListeners;
import com.sqatntu.metrics.report.MetricReport;
import dagger.ObjectGraph;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import javax.inject.Inject;

/**
 * Created by andyccs on 25/10/15.
 */
public class MetricCalculator {

  @Inject
  MetricReport report;

  @Inject
  ThrowingErrorListener throwingErrorListener;

  public MetricCalculator() {
    ObjectGraph objectGraph = ObjectGraph.create(new MetricCalculatorModule());
    objectGraph.inject(this);
  }

  public MetricReport calculateMetrics(String sourceCode) {
    ANTLRInputStream stream = new ANTLRInputStream(sourceCode);

    JavaLexer lexer = new JavaLexer(stream);
    lexer.removeErrorListeners();
    lexer.addErrorListener(throwingErrorListener);

    CommonTokenStream tokens = new CommonTokenStream(lexer);

    JavaParser parser = new JavaParser(tokens);
    parser.removeErrorListeners();
    parser.addErrorListener(throwingErrorListener);

    JavaParser.CompilationUnitContext tree = parser.compilationUnit(); // parse 

    NumberOfMethodsListeners numberOfMethodsListeners = new NumberOfMethodsListeners(report);
    ParseTreeWalker walker = new ParseTreeWalker();
    walker.walk(numberOfMethodsListeners, tree);

    return report;
  }
}
