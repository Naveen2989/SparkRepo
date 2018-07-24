val text = sc.textFile("/home/cloudera/Desktop/ClouderaBack/SparkExamples/Spark/SparkSQL/Customers.csv")
val counts = text.flatMap(line => line.split(" ")).map(word => (word,1)).reduceByKey(_+_)
counts.collect
