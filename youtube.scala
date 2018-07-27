Here, we will find out what are the top five categories with maximum number of videos uploaded.

val textFile = sc.textFile("hdfs://localhost:9000/youtubedata.txt")

#In line 1, we are creating an RDD with the existing dataset, which is inside HDFS.

val counts = textFile.map(line=>{
var YoutubeRecord = ""; 
val temp=line.split("\t"); 
if(temp.length >= 3) {
YoutubeRecord=temp(3)
};
YoutubeRecord
})

In line 2, we are taking each record as input using the map method and extracting the 4th column, which is the category of the video.

val test=counts.map ( x => (x,1) )

In line 3, we are creating a pair of category_name,1(count) which is used to calculate how many times that the category is present.


val res=test.reduceByKey(_+_).map(item => item.swap).sortByKey(false).take(5)

In line 4, we are using the reduceByKey method so that all the values of that key are aggregated.
Then we are swapping the category_name and its count, and sorting the result with 
this we will get the sorted records of category_name and its count in descending order. 
Finally, we are taking the top five from the list.

Output :  (908,Entertainment), (862,Music), (414,Comedy), (398,People & Blogs), (333,News & Politics)


Problem statement2: In this problem statement, we will find the top 10 rated videos in YouTube.

val textFile = sc.textFile("hdfs://localhost:9000/youtubedata.txt")

#In line 1, we are creating an RDD with the existing dataset, which is inside HDFS.

val counts = textFile.filter { x => {if(x.toString().split("\t").length >= 6) true else false} }.map(line=>{line.toString().split("\t")})

#In line2, we are first filtering the lines with more than six elements to avoid ArrayIndexOutOfBounds Exception
and then we are using map method to pass the split line as output to the next RDD.

val pairs = counts.map(x => {(x(0),x(6).toDouble)})

# In line 3, we are creating a pair of key and value by using the video id, which is the first column and 7th column 7 respectively.

val res=pairs.reduceByKey(_+_).map(item => item.swap).sortByKey(false).take(10)

# In line 4, we are using the reduceByKey method to find the ratings of the video, and to sort them by value, 
we are using the map method and swapping the key and value. Now, 
values become the keys and we are performing the sortByKey method and sorting the videos based on their rating and taking the top 10 videos.

Output: 

(5.0,ZzuGxkWLops), (5.0,O4GzZxcKmFU), (5.0,smGcj6vohLs), (5.0,_KVr7VOTwTQ), (5.0,6yuy9DEK114), (5.0,xd1kn2bFpSM), (5.0,wEQ54SUxtiI), (5.0,lbVnhaqP8F4), (5.0,3V0SjoaPx9A), (5.0,265li8v9m1k)





Travel Sector Dataset Description
Column 1: City pair (Combination of from and to): String

Column 2: From location: String

Column 3: To Location: String

Column 4: Product type: Integer (1=Air, 2=Car, 3 =Air+Car, 4 =Hotel, 5=Air+Hotel, 6=Hotel +Car, 7 =Air+Hotel+Car)

Column 5: Adults traveling: Integer

Column 6: Seniors traveling: Integer

Column 7: Children traveling: Integer

Column 8: Youth traveling: Integer

Column 9: Infant traveling: Integer

Column 10: Date of travel: String

Column 11: Time of travel: String

Column 12: Date of Return: String

Column 13: Time of Return: String

Column 14: Price of booking: Float

Column 15: Hotel name: String


Problem Statement 1
Top 20 destination people travel the most: Based on the given data, we can find the most popular destination that people travel frequently.
There are many destinations out of which we will find only first 20, based on trips booked for particular destinations.

val textFile = sc.textFile("hdfs://localhost:9000/TravelData.txt")

#Line 1: We are creating an RDD by loading a new dataset which is in HDFS.

Output

(396,MIA), (290,SFO), (202,LAS), (162,LAX), (102,DFW), 
(64,DEN), (57,ORD), (54,PHL), (50,IAH), (45,JFK), (44,PHX), 
(40,FLL), (36,ATL), (31,BOS), (31,MCO), (27,SAN), (25,WAS), (24,CUN), (22,AUS), (22,LON)

val split = textFile.map(lines=>lines.split('\t')).map(x=>(x(2),1)).reduceByKey(_+_).map(item => item.swap).sortByKey(false).take(20)

# Line 2: We have split each record by taking the delimiter as tab because the data is tab separated. We are creating the key-value pair, 
where key is the destination that is in 3rd column and the value is 1. Since we need to count the cities which are popular, we are using
the reduceByKey method to count them. After counting the destinations, we are swapping the key-value pairs. The sortByKey method sorts
the data with keys and false stands for descending order. Once the sorting is complete, we are considering the top 20 destinations.


Problem Statement 2

Top 20 locations from where people travel the most: We can find the places from where most of the trips are undertaken,
based on the booked trip count.

val textFile = sc.textFile("hdfs://localhost:9000/TravelData.txt")

#Line 1: We are creating an RDD by loading a new dataset which is in HDFS.

val split = textFile.map(lines=>lines.split('\t')).map(x=>(x(1),1)).reduceByKey(_+_).map(item => item.swap).sortByKey(false).take(20)

Line 2: We have split each record by taking the delimiter as tab since the data is tab separated.
We are creating the key-value pair, where key is the location from where people start, 
that is in the 2nd column and the value is 1. Since we need to count the cities which are popular locations 
from where people undertake the trips, we are using the reduceByKey method to count them.
After counting the locations, we are swapping the key-value pairs. 
We are using the sortByKey method which sorts the data with keys where false stands for descending order. 
Once the sorting is complete, we are taking the top 20 locations from where people undertake the trips.

Output

(504,DFW), (293,MIA), (272,LAS), (167,BOM), (131,SFO), (101,ORD), (72,LAX), (55,DEN), (41,PHL), (37,IAH), (35,FLL), (33,PHX), 
(31,JFK), (24,WAS), (19,HOU), (19,ATL), (18,DXB), (17,SAN), (17,BOS), (17,BCN)


Problem Statement 3
Top 20 cities that generate high airline revenues for travel, 
so that the site can concentrate on offering discount on booking, to those cities to attract more bookings.

val textFile = sc.textFile("hdfs://localhost:9000/TravelData.txt")
val fil = textFile.map(x=>x.split('\t')).filter(x=>{if((x(3).matches(("1")))) true else false })
val cnt = fil.map(x=>(x(2),1)).reduceByKey(_+_).map(item => item.swap).sortByKey(false).take(20)

Description of the above code
Line 1: We are creating an RDD by loading a new dataset which is in HDFS.

Line 2: We are splitting each record based on the delimiter tab as the data is tab separated. From this, 
we are filtering the records based on the mode of travel. 
Here, we need the count of people who travelled by flight which is denoted by 1
 (1=Air, 2=Car, 3 =Air+Car, 4 =Hotel, 5=Air+Hotel, 6=Hotel +Car, 7 =Air+Hotel+Car).

Line 3: We are creating the key-value pairs for those people who traveled by air, 
where key is the destination which is in 3rd column and value is 1. 
Since we need to count the popular cities, we are counting them by using the reduceByKey method. 
After counting the destinations, we are swapping the key-value pairs.
 We are using the sortByKey method to sort the data with keys where false 
stands for descending order. 
Once sorting is completed, we are considering top 20 cities that generate high airline revenues for travel.


Output:

(84,MIA), (68,SFO), (54,LAS), (42,LAX), (24,IAH), (23,DFW), (18,PHX), (17,BOS), (15,ORD),
 (13,NYC), (9,DCA), (8,WAS), (8,AUS), (7,DEN), (7,MEM), (7,JFK), (6,SYD), (6,PHL), (6,ATL), (5,RIC)




