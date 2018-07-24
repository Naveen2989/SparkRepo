from pyspark.sql import *
from pyspark import *

from pyspark import  SparkContext
from pyspark import SparkConf
#spark conf
conf = ( SparkConf().setAppName('SparkApp'))
sc = SparkContext(conf=conf)

from pyspark.sql import SQLContext
sqlContext = SQLContext(sc)
from pyspark.sql import Row


lines =sc.textFile("/home/cloudera/Desktop/ClouderaBack/SparkExamples/Spark/SparkSQL/Customers.csv")

#Split the lines based on the delimiter
parts = lines.map(lambda l: l.split(","))

customer = parts.map(lambda p:Row(id=p[0],name=p[1],city=p[2]))

#Inferring the schema and registering the DataFrame as a table.
schemaCustomer=sqlContext.createDataFrame(customer)

schemaCustomer.registerTempTable("customer")

result=sqlContext.sql("select id from customer")
 
print(result)
