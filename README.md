## Local Build & Run for Windows 10

Project build & run was tested for Open-Jdk 11 only

Set JAVA_HOME with Jdk excutable and add jdk directory to PATH variable 

Temporary add project root-dir to the PATH env variable

From project root-dir run 

`mvnw spring-boot:run`

NPM tasks will log with error but complete correctly

Open browser on localhost:8080

User: admin

Pass: admin

If the project wont build & run correctly for any reason run

`mvnw clean install`

And repeat from step one

