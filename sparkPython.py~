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
countsByAge.write.format("json").save("hdfs://localhost:8020/user/cloudera/Spark/S3.json")
