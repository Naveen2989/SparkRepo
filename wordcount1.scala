import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark._

object SparkWordCount {
   def main(args: Array[String]) {

    val sc = new SparkContext( "local", "Word Count", "/usr/local/spark", Nil, Map(), Map())           
      val input = sc.textFile("hdfs://localhost:8020//user/cloudera/inputdir/input")             
      Val count = input.flatMap(line ⇒ line.split(" "))
      .map(word ⇒ (word, 1))
      .reduceByKey(_ + _)       
      count.saveAsTextFile("hdfs://localhost:8020//user/cloudera/inputdir/scalaoutput")
      System.out.println("OK");
   }
}
