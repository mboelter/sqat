package com.sqatntu.stylechecker.listener;

import com.sqatntu.stylechecker.injection.Dagger;
import com.sqatntu.stylechecker.api.JavaBaseListener;
import com.sqatntu.stylechecker.api.JavaParser;
import com.sqatntu.stylechecker.StyleCheckerException;
import com.sqatntu.stylechecker.configuration.Configuration;
import com.sqatntu.stylechecker.configuration.StyleName;
import com.sqatntu.stylechecker.report.ReportContent;
import com.sqatntu.stylechecker.report.StyleReport;

import javax.inject.Inject;

/**
 * Created by andyccs on 6/9/15.
 */
public class MethodNameFormatListener extends JavaBaseListener {

    @Inject
    Configuration configuration;

    @Inject
    StyleReport report;

    public MethodNameFormatListener() {
        Dagger.inject(this);
    }

    @Override
    public void enterMethodDeclaration(JavaParser.MethodDeclarationContext ctx) {
        String regex = "";
        String methodNameFormatValue = StyleName.IGNORE_STYLE;
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine() + ctx.getChild(0).getText().length() + 2;

        // Determine regular expression by using configuration
        try {
            if (configuration
                    .getAttribute(StyleName.METHOD_NAME_FORMAT)
                    .equals(StyleName.METHOD_NAME_FORMAT_CAMEL_CASE)) {
                regex = "^([a-z])([a-zA-Z0-9])*";
                methodNameFormatValue = StyleName.METHOD_NAME_FORMAT_CAMEL_CASE;
            }
        } catch (StyleCheckerException e) {
            // This means that no configuration for method name format is set,
            // so we don't do any check.
            return;
        }

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

        ReportContent reportContent = new ReportContent(line, column, message, suggestion);
        report.addReportContents(reportContent);
    }

    private String toCamelCase(String s) {
        return s.substring(0,1) + s.substring(1);
    }
}