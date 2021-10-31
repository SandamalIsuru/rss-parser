# RSS Parser

This is a spring Boot application that polls RSS feeds within a configured time period from a configured url, and stores any items or updates in H2 database. For each item, it will store guid, title, description, and publication date in the table. The numbers of items need to be stored within a poll also can be configured.

Following apis has exposed to retrieve stored data in the database.

- Retrieving the 10 newest items.
	Example: GET http://localhost:8080/items
- Paginated, with direction based on a given field.
	Example: GET http://localhost:8080/items?page=1&size=2&sort=updated_date&direction=asc
	
## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Running the application locally

Running the application locally has very simple steps.

- Run following command to clone the code
	```shell
		git clone https://github.com/SandamalIsuru/rss-parser.git
	```
- Import the project using eclipse
- Open RssParserApplication.java file and run it as Java Application.

## Running tests locally

Right click on the RssParserTest.java file under test folder and run as JUnit Test

