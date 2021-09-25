# README
###Description
This project uses a REPL to generate the closest k numbers of neighbours of a given star, or a given coordinate.

###Design & Implementation
There are two classes, Star and starHandler, that stores information about the stars and also handles the data.
A HashMap called starMap is instantiated inside the starHandler class to store the id of the star, and the newly created 
star object. A valueList is also instantiated to store a list of all the star objects inside the CSV. 
The star object is created in the star method inside starHandler when a BufferedReader is used to filter
and store the CSV data. While the starMap is created, a valueList is also populated. The two main methods are naive_neighbors 
and naive_neighborsByName. naive_neighbors checks if the number of output asked for (ie. k) is not 0 and if it isn't then 
it sorts the valueList by using a class that implements the Comparator Interface. Inside this class sortByDist there is 
a method called compare which calculates the distance between a star, and the given coordinate for two stars, and sorts 
all the stars inside valueList this way. 

The method naive_neighborsByName calls naive_neighbors because it simply takes in a name of a star and obtains this star's
coordinates and feeds that into the naive_neighbors method. That's why the naive_neighbors method also takes in an id.
When the coordinates naive_neighbors takes in aren't a star, or if the string naive_neighborsByName takes in isn't
the name of an actual star, the id would be -1 in which case wouldn't be used. 

###Errors
No known bugs and errors without further investigation.

###Tests
The less_stars_than_k.test is designed to test cases where the number of stars in the data is less than 
k. In the test case it is expected to return the number of stars present in the data.

There is a bad.csv file that has the wrong csv format, for which when the bad_csv.test file is run, 
an error would be thrown.

###How To
To build use:
`mvn package`

To run use:
`./run`

This will give you a barebones REPL, where you can enter text and you will be output at most 5 suggestions sorted alphabetically.

To start the server use:
`./run --gui [--port=<port>]`

To system test use:
`./cs32-test src/test/system/stars/*.test`

To Junit test use:
`mvn test`


