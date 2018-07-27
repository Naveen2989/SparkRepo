val dataset = sc.textFile("/home/kiran/Desktop/uber")
# we are loading the dataset

val header = dataset.first()
#first line of dataset means our header

val format = new java.text.SimpleDateFormat("MM/dd/yyyy")
#simple date format declaration

var days =Array("Sun","Mon","Tue","Wed","Thu","Fri","Sat")
#Declaring the array holds days of the week

val eliminate = dataset.filter(line => line != header)
# eliminate header from dataset

val split = eliminate.map(line => line.split(",")).map { x => (x(0),format.parse(x(1)),x(3)) }

#In line 6, we are splitting the dataset using the delimiter as coma and taking out the three columns; 
dispatching_base_number, which is in the 1st column, date which is in the second column and the number of trips,
which is in the fourth column. While extracting the columns, we are parsing the date, which is in string format to date format.

After this step, we will get the records as B02512, Thu Jan 01 00:00:00 IST 2015, 1132.

val combine = split.map(x => (x._1+" "+days(x._2.getDay),x._3.toInt))

# In line 7, we are adding the two columns, dispatching_base_number and formatted date. 
To get the day from the formatted date, we need to use the getDay method of java.util.Date package. 
Here, we will get the day number of the week and pass the day number into the array consisting of the names of the days.
 Finally, we will get the combination of dispatching_base_number and day of the week and the number of weeks. These are like keys and values.

val arrange = combine.reduceByKey(_+_).map(item => item.swap).sortByKey(false).collect.foreach(println)

# In line 8, we are using the reduceByKey RDD to combine all the values for each unique key, 
where key is the combination of dispatching_base_number and day of the week. 
After this, we are swapping the keys and values and then perform sortByKey action on the RDD, 
which will sort the records by values in the descending order. 
Finally, we are printing the result using the collect action.
