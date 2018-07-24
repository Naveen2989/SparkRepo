from pyspark import SparkContext, HiveContext
sc = SparkContext(appName = "test")
sqlContext = HiveContext(sc)
import re
jsonRDD = sc.wholeTextFiles("/home/cloudera/Desktop/ClouderaBack/SparkExamples/Spark/SparkSQL/world-cup-players.json").map(lambda x: x[1])



js = jsonRDD.map(lambda x: re.sub(r"\s+", "", x, flags=re.UNICODE))

wc_players = sqlContext.read.json(js)
wc_players.registerTempTable("players")
sqlContext.sql("select distinct Team from players").show()


