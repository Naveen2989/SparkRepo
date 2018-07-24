from pyspark import SparkContext, SparkConf
from pyspark.sql import*
#from pyspark.sql.session import SparkSession
#import sqlContext.implicits._
conf = SparkConf().setAppName('MyFirstStandaloneApp')
sc = SparkContext(conf=conf)
#spark = SparkSession(sc)

sqlcontext = SQLContext(sc)
# Creates a DataFrame based on a table named "people"
# stored in a MySQL database.
url1 = \
  "jdbc:mysql://localhost:3306/mysql?user=root&password=cloudera"
#df = sqlcontext.load(source = "jdbc",url=url1,dbtable ="Persons")
df = sqlcontext \
  .read \
  .format("jdbc") \
  .option("url", url1) \
  .option("dbtable", "Persons") \
  .load()
#df = sqlcontext.read.format("jdbc").option("url", url1).option("dbtable", "Persons").load()

#df = sqlContext.read.format("jdbc").option("dbtable","Persons").option("driver", 'com.mysql.jdbc.Driver').load()

# Looks the schema of this DataFrame.
df.printSchema()

# Counts people by age
countsByAge = df.groupBy("age").count()
countsByAge.show()

# Saves countsByAge to S3 in the JSON format.
#countsByAge.write.format("csv").save("hdfs://localhost:8020/user/cloudera/Spark/SQL/S3.csv")
countsByAge.repartition(1).write.csv("hdfs://localhost:8020/user/cloudera/Spark/SQL/S3.csv", sep=',')
countsByAge.coalesce(1).write.csv("/home/cloudera/Downloads/SparkOutput/S3Coal.csv",sep=',')   #coalesce makes 'shuffle=false' by default
countsByAge.coalesce(1).write.json("/home/cloudera/Downloads/SparkOutput/S3Coal.json")   #coalesce makes 'shuffle=false' by default

