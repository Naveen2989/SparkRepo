import urllib
#f = urllib.urlopen("http://kdd.ics.uci.edu/databases/kddcup99/kddcup.data_10_percent.gz", "kddcup.data_10_percent.gz")

from pyspark.sql import *
from pyspark import *

from pyspark import  SparkContext
from pyspark import SparkConf
#spark conf
conf = ( SparkConf().setAppName('SparkApp'))
sc = SparkContext(conf=conf)

import urllib.request
with urllib.request.urlopen("http://kdd.ics.uci.edu/databases/kddcup99/kddcup.data_10_percent.gz") as url:
    s = url.read()

print(s)


#data_file = "./kddcup.data_10_percent.gz"
raw_data = sc.textFile(s).cache()
print(raw_data)


from pyspark.sql import SQLContext
sqlContext = SQLContext(sc)

from pyspark.sql import Row


csv_data = raw_data.map(lambda l: l.split(","))
row_data = csv_data.map(lambda p: Row(
    duration=int(p[0]), 
    protocol_type=p[1],
    service=p[2],
    flag=p[3],
    src_bytes=int(p[4]),
    dst_bytes=int(p[5])
    )
)


print(row_data)


interactions_df = sqlContext.createDataFrame(row_data)
interactions_df.registerTempTable("interactions1")

# Select tcp network interactions with more than 1 second duration and no transfer from destination
tcp_interactions = sqlContext.sql("""
    SELECT duration, dst_bytes FROM interactions WHERE protocol_type = 'tcp' AND duration > 1000 AND dst_bytes = 0
""")
tcp_interactions.show()
# Output duration together with dst_bytes
#tcp_interactions_out = tcp_interactions.map(lambda p: "Duration: {}, Dest. bytes: {}".format(p.duration, p.dst_bytes))
#for ti_out in tcp_interactions_out.collect():
 # print ti_out


#interactions_df.printSchema()
