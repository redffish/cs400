# CS400 Project Four Proposal
**TEAM: KA**
**TEAM FLIPGRID: http://flipgrid.com/cs400sid1**
<br>
**TA: Sid**
**TA EMAIL: smohan25@wisc.edu**
<br>
**TEAM EMAILS:** *1. ljogal@wisc.edu 2. nbennett3@wisc.edu 3. cwkolb@wisc.edu 4. gerkhardt@wisc.edu 5. lperalta@wisc.edu 6. jrreuss@wisc.edu 7. he279@wisc.edu 8. ohgraham@wisc.edu*

---

**Project Title:** Parking at UW-Madison

**Brief Project Description:** <br>
This app will allow users to search for a parking lot that they would like to park in or near, as the program will return open parking spots in the lot the user is searching for or spots in lots nearby. This app would be useful for students with cars, parents who are visiting their kids on campus, and teachers who commute to and from campus, so that they can quickly find an open parking spot without the hassle of driving around aimlessly.

**Four Chosen Requirements that this Project Fulfills:** <br>
1. CSV File: Holds the parking lot data to be loaded into the project.
2. Streams: Performs searches by filtering and sorting through every parking lot entry.
3. Regular Expressions: Helps the user search for different lots for parking.
4. HTML/CSS: Displays the application for the user, including a search bar and parking spots nearby after searching.

---

**Data Wranglers:** Adam Gerkhardt, Owen Graham

**Application Data:** <br>
The data provided for each lot will include address (`String`), lot number (`int`), capacity (`int`), occupied spots (`int`), and three nearby lots’ lot numbers (`int` x3).
This data will be inserted with a .csv file to be converted into the ParkingLot object.

**Data Format:** <br>
These components will be used to create a `ParkingLot` object.

---

**Back End Developers:** Liam Jogal, Lillian Peralta

**Data Processing:** <br>
The data from the provided CSV file will be loaded into our program into a ParkingLot object, with data including the address of the lot, lot number, the number of maximum capacity, the number of spots taken in the lot, and an array of nearby lots. The ParkingLot objects will be stored into a List. This list will interact with a class called SearchLots that returns a list of parking lots that contains a string to search for in the address of each parking lot. Each lot containing this string in the address will be contained in this list of parking lots. These lots are searched for by using regular expressions and streams.

**Front End Interface:** <br>
`public void inputData() {} ` <br>
`public boolean addLot(ParkingLot add) {} ` <br>
`public boolean removeLot(ParkingLot rem) {}` <br>
`public ParkingLot getLot(ParkingLot retrieve) {}` <br>
`public String toString() {}` <br>
`public List<ParkingLot> sort(String search) {}` <br>
`public String sortedPotLots(String search) {}` <br>

- Will have all the functionality of a List. Additionally the `toString` method will return a string of the parking lots and the `sortedPotLots` method will return a string of lots with an adress containing a specified string

---

**Front End Developers:** Nicole Bennett, Joseph Reuss

**User Commands:** <br>
The website will include a search bar where the user can input the street they’d like to park on or the lot they’d like to park in. When the user clicks the search button, the site will return a list of available parking spaces on their desired street/lot. If there are no available spaces around their desired location, the site will provide a list of nearby street/blocks that do have available parking spaces.

User commands will be sent to the server program as query strings. A search command’s query string will look like `?search=<search>`, where `<search>` is the URL-escaped search string.

**Error Messages:** <br>
If the user inputs a street/lot not contained in the data: “Sorry. That location wasn’t found. Please try a different street or lot name.”

---

**Test Engineers:** Connor Kolb, Jiaqi He

**Test Descriptions:** <br>
*All test implemented using a Junit test suite* <br>
`testAddLot()` - ensures `addLot()` method in backend code works properly <br>
`testRemoveLot()` - ensures `removeLot()` method in backend code works properly <br>
`testGetLot()` - ensures `getLot()` method in backend code works properly <br>
`testSort()` - ensures `sort()` and `sortedPotLots()` method in backend code works properly <br>

---

**Additional Responsibilities and Notes:** <br>

---

**Schedule:** <br>

| Date  | Role                 | Deliverables
| ----- | -------------------- | ------------
| 11/24 | Data Wranglers       | .csv file with the appropriate information (*parking.csv*)
|       | Back End Developers  | The names/details of methods to be implemented, along with the constructor for the object to be stored into Hashtable.
|       | Front End Developers | A template of the website with design elements completed.
|       | Test Engineers       | n/a
| 12/01 | Data Wranglers       | Object utilizing the .csv file to be created (*ParkingLot.java*)
|       | Back End Developers  | Rough draft of Java class titled ParkingBackEnd.java
|       | Front End Developers | A working search bar and button.
|       | Test Engineers       | n/a
| 12/08 | Data Wranglers       | Fix any issues in either previous files
|       | Back End Developers  | Fix any issues or preferences for ParkingBackEnd.java
|       | Front End Developers | Fully functional website compatible with backend implementation and the data file compiled by the Data Wranglers.
|       | Test Engineers       | `testAddLot()` <br> `testRemoveLot()` <br> `testGetLot()` <br> `testSort()` <br> Flipgrid video

---

**Signatures:** <br>
- Joseph Reuss - 11/17/20
- Owen Graham - 2020-11-17
- Nicole Bennett - 11/17/2020
- Adam Gerkhardt - 11/17/2020
- Liam Jogal - 11/17/2020
- Lillian peralta - Nov 17 2020
- Jiaqi He - 11/17/2020
- Connor Kolb - 11/17/2020

---

**End of Proposal**
