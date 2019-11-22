[![Build Status](https://travis-ci.org/ChrisSkov/ca3back.svg?branch=master)](https://travis-ci.org/ChrisSkov/ca3back)
Back end code for to use as start code for future shitty projects. 

To makes this work follow these steps:

step one: clone project</br>
step two: set up own remote repo</br>
step three: hook up travis</br>
step four: create databases</brX
step five: makes sure droplet exports correct databases</br>
step 5.1: ssh into droplet</br>
step 5.2: cd /opt/tomcat/bin</br>
step 5.3: (sudo) nano setenv.sh</br>
step 5.4: edit to include new databases. connection str X</br>
step 5.5: edit EMF_Creator.java line 121 to point to new connection string</br>
step 5.6: restart that shit</br>
step six: try not to cry.</br>
step seven: cry a lot.</br>
step eight: edit pom.xml to point to your domain</br>
step nine: ????</br>
step ten: profit</br>

