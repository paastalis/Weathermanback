Weatherman task solution overview and reflection

How to deploy/run the solution

To run the backend (Spring Boot):

1. The project must be cloned from https://github.com/paastalis/Weatherman_backend
2. The program must be executed
3. The app can be accessed from localhost:8080

To run the frontend (Angular):

1. The project must be cloned from https://github.com/paastalis/Weatherman_frontend
2. Using the command line, navigate to the project folder
3. In the project folder, execute the command “npm install”. This installs the node_modules folder
4. In the project folder, execute the command "ng serve". This runs the Angular project.


The following is a description of the development process split into four main parts. I have brought out the amount of days each part took me to create/implement. On most days I worked on the project for 2-6 hours.

I created an application that allows users to enter the latitude and longitude of any location on Earth and compare two different weather forecasts for that location.

Part 1: 3 days  
I started off by creating the Spring Boot backend- I had to request weather data from two APIs and map this data into objects. The first challenge was to find the suitable APIs. Some of the ones that I tried to use, had authentication issues with the key or did not offer the data I needed for free. At one point, however, I reached the stage where I could read in the location data reliably by entering the coordinates into the API request link and mapping this data into Weather objects with two fields - temperature and precipitation.

Part 2: 5 days  
Then it was time for the front-end. Having used Angular before, I mostly knew what and how I wanted to do and it was just a question of making it happen. I started the front-end by creating the form into which the user can enter the coordinates and the amount of days for which they want to view the forecasts. After I had the form wired to make the requests to the backend on a click of the submit-button, I needed to display the data. Getting the table set up right was challenging, as I had anticipated. I am not too well-versed in HTML yet so that part gave me some good experience on displaying data dynamically on a webpage. I had to change my idea of the table design a couple of times, as the initial vision was too complex to execute reliably. However, I am quite satisfied with how the table turned out. It has two content rows, one for each API’s forecasts. The forecast dates can be seen in the table header. 

Part 3: 5 days  
I now had the core part of the application ready. I started to work on additional features. Firstly, I made the program notify the user with push messages upon trying to submit invalid inputs. Then I started implementing the map feature. I used Google Maps for this and the implementation took me less time than I had anticipated. The hardest part was getting the pointer to appear on the right location on the map, but eventually I got that to work. One of the most difficult and least intuitive parts of the project for me was the implementation of the “save” function. I decided to settle with a mechanism that would allow the user to save the forecasts of one location at a time. This time around creating the data table was easy, as I used the same design and functionality as I had used previously when displaying the request data. However, now I had to save the data somewhere. Had I had more time, I would have implemented a SQL database which would have made it more convenient to also save multiple forecasts at a time. I opted for using the Local Storage of the web application to hold the weather forecasts. From the storage, the app could read the data upon the press of the “Save forecasts” button and display it in the second table. Implementing this was one of the more time-consuming elements of the project and took me quite a bit of trial and error to get to work properly, but I managed to overcome the challenges.

Part 4: 1 day  
I also scheduled the automatic “Saving” of the forecasts hourly in the backend. I would have fully implemented this feature, if I had used a database, because it would have been possible to save the weather data in there every hour. Right now, the back-end simply prints out the weather data for Tallinn, Estonia into the console every hour.

What I learned from implementing the project   

This project gave me some valuable experience especially with the front-end. It honed my skills with HTML and CSS. It was also a good lesson when it comes to using different APIs and mapping JSON data. The project solidified my understanding of the fact that all planning has to be flexible, because the way you intend to implement a feature may not always be possible or the most convenient, therefore one should always have some backup ideas or alternative solutions to nevertheless achieve the objectives.

Talis Paas  
Paastalis@gmail.com
