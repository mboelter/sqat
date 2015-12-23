[![Build Status](https://travis-ci.org/Andyccs/sqat.svg?branch=develop)](https://travis-ci.org/Andyccs/sqat)

[![Coverage Status](https://coveralls.io/repos/Andyccs/sqat/badge.svg?branch=develop&service=github)](https://coveralls.io/github/Andyccs/sqat?branch=develop)

[![Gitter](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/Andyccs/sqat?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge)

# Software Quality Analysis Tool

Software Quality Analysis Tool (SQAT) allows you to:

1. Check the style of your Java source code

2. Analyze your Java source code and get object-oriented metric reports

This tool is still under active development.

# How To Run This Project

This project is organized as:

```
root
|
|-- stylechecker
|
|-- website
|---- backend
|---- frontend
```

Stylechecker folder contains ANTLR and java codes to check and analyze your source code. 

Backend folder contatins a Node.js server that communicate with Stylechecker service and provides an API for clients.

Frontend folder contains a React.js web application that communicate with Backend Node.js server and render webpage for users. 

To run this project, first we need to run the stylechecker service:

```
cd stylechecker
gradlew run
```

Second, we need to run backend server:

```
cd webiste
npm run dev
```

Finally, open your browser and go to `http://localhost:8080`. You should see a nice React application in your browser. 

# License

The MIT License (MIT)

Copyright (c) 2015 Andy Chong Chin Shin

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
