from pyspark import SparkContext, HiveContext
sc = SparkContext(appName = "test")
sqlContext = HiveContext(sc)


# Import data types

from pyspark.sql.types import *

# Create a RDD from `people.txt`

# then convert each line to a tuple.

lines = sc.textFile("/home/cloudera/Desktop/ClouderaBack/SparkExamples/Spark/SparkSQL/people")

parts = lines.map(lambda l: l.split(","))
people = parts.map(lambda p: (p[0], p[1].strip()))

# encode the schema in a string.
schemaString = "name age"

# Create a type fields
fields = [StructField(field_name, StringType(), True) \
            for field_name in schemaString.split()]

# Create the schema
schema = StructType(fields)

# Apply the schema to the RDD.
schemaPeople = sqlContext.createDataFrame(people, schema)

# In order to query data you need
# to register the DataFrame as a table.
schemaPeople.registerTempTable("people")

# Using sql query all the name from the table
results = sqlContext.sql("SELECT name FROM people")

# The results of SQL queries are RDDs
# and support all the normal RDD operations.
names = results.map(lambda p: "Name: " + p.name)
for name in names.collect():
  print (name)
