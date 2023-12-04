# How to run this application
* Clone the repository
* Navigate to the project directory
* Build the application jar using the command
  > gradlew clean build
* To start the application, execute the command
  > java -jar build\libs\countries-info-0.0.1-SNAPSHOT.jar
* For countries sorted by population density, open the API http://localhost:8080/v1/pdsorted
* For the country bordering maximum number of regions not in Asia, open the API http://localhost:8080/v1/mdfbordering 
