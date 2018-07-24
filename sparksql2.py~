from pyspark.sql import *
from pyspark import *

from pyspark import  SparkContext
from pyspark import SparkConf
#spark conf
conf = ( SparkConf().setAppName('SparkApp'))
sc = SparkContext(conf=conf)

#data_file = "./kddcup.data_10_percent.gz"
raw_data = sc.textFile("/user/cloudera/SacramentocrimeJanuary2006.csv")
print(raw_data)


from pyspark.sql import SQLContext
sqlContext = SQLContext(sc)

from pyspark.sql import Row


csv_data = raw_data.map(lambda l: l.split(","))
row_data = csv_data.map(lambda p: Row(
    address=(p[0]), 
    district=p[1],
    beat=p[2],
    grid=p[3],
    crimedescr=(p[4]),
    ucr_ncic_code=(p[5]),
    latitude=(p[6]),
    longitudev=(p[7]),



    )
)

print(row_data)


interactions_df = sqlContext.createDataFrame(row_data)
interactions_df.registerTempTable("interactions")

# Select tcp network interactions with more than 1 second duration and no transfer from destination
tcp_interactions = sqlContext.sql("""
    SELECT beat, grid, longitudev,latitude FROM interactions
""")
tcp_interactions.show()

# Output duration together with dst_bytes
#tcp_interactions_out = tcp_interactions.map(lambda p: "Duration: {}, Dest. bytes: {}".format(p.duration, p.dst_bytes))
#for ti_out in tcp_interactions_out.collect():
 # print ti_out


interactions_df.printSchema()
