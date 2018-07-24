
val textFile = sc.textFile("hdfs://localhost:8020//user/cloudera/inputdir/input")
val counts = textFile.flatMap(line => line.split(" ")).map(word => (word, 1)).reduceByKey(_ + _)
counts.saveAsTextFile("hdfs://localhost:8020//user/cloudera/inputdir/scalaoutput")
