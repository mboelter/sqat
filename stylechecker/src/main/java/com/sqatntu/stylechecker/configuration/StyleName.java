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

package com.sqatntu.stylechecker.configuration;

/**
 * All the style names and their values.
 */
public class StyleName {

  public static final String IGNORE_STYLE = "ignore";

  public static final String METHOD_NAME_FORMAT = "methodNameFormat";
  public static final String METHOD_NAME_FORMAT_CAMEL_CASE = "camelCase";

  public static final String WILD_CARD_IMPORT = "wildCardImport";
  public static final String WILD_CARD_IMPORT_OK = "wildCard";
  public static final String WILD_CARD_IMPORT_NO = "noWildCard";

  public static final String BRACE_STYLE = "braceStyle";
  public static final String BRACE_STYLE_KR = "kr";
  public static final String BRACE_STYLE_NON_KR = "nonKr";

  public static final String[] ALL_STYLE_NAMES = {
      METHOD_NAME_FORMAT,
      WILD_CARD_IMPORT,
      BRACE_STYLE,
  };
}
