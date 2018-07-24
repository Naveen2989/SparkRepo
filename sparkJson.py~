
import json
import requests
from pyspark.sql import *
from pyspark import *
from pyspark.sql import SQLContext
from pyspark.sql import Row
from pyspark import  SparkContext
from pyspark import SparkConf
import urllib3



#spark conf
conf = ( SparkConf().setAppName('SparkApp'))
sc = SparkContext(conf=conf)
sqlContext = SQLContext(sc)


#df = sqlContext.jsonFile('/user/cloudera/sample.json')
df = sqlContext.read.json('/home/cloudera/Desktop/ClouderaBack/SparkExamples/Spark/SparkSQL/sample.json')
df.first()
df.collect()



# Output duration together with dst_bytes
#tcp_interactions_out = tcp_interactions.map(lambda p: "Duration: {}, Dest. bytes: {}".format(p.duration, p.dst_bytes))
#for ti_out in tcp_interactions_out.collect():
 # print ti_out







