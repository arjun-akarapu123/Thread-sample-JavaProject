1. Import the maven project in to your working project.
2. Build the project by updating the maven project.
3. If port 8080 is already occupied with any of your application then use application.properties file
to configure your desired port with key name as "server.port". 

Ex: server.port = 8181
4. If maven is installed and configured at the system level, then go to the application level
POM.xml file and run the following command.

ex : c:\> mvn spring-boot:run

this command will launch the application in the browser with following URL

	http://localhost:8181/

5. Here specify a file to upload.
6. By default the files will be uploaded to F://uploads// folder.
7. To view the specific file meta data use the following lin

	http://localhost:8181/fileName/hellosample.txt/
the output will be a json Object which has the following file details.

If the file is not available then it will have all null values.