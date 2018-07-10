/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// scalastyle:off println
package org.apache.spark.examples
import org.apache.spark.SparkContext
import org.apache.spark.sql.SparkSession
import org.apache.commons.io.FileUtils
import java.io.File

/** */
object SparkHbase {
  def main(args: Array[String]) {

    val spark = SparkSession
      .builder
      .appName("Spark hbase app")
      .getOrCreate()
     
        import spark.implicits._

    val groundDF = spark.read.format("com.databricks.spark.csv").option("header", "true").option("inferSchema", "true").load("/home/samriddhi/Desktop/Spark/scala/sparkhbase/resources1/ground.csv")

    val matchDF = spark.read.format("com.databricks.spark.csv").option("header", "true").option("inferSchema", "true").load("/home/samriddhi/Desktop/Spark/scala/sparkhbase/resources1/match.csv")

    val playerDF = spark.read.format("com.databricks.spark.csv").option("header", "true").option("inferSchema", "true").load("/home/samriddhi/Desktop/Spark/scala/sparkhbase/resources1/player.csv")

    val roleDF = spark.read.format("com.databricks.spark.csv").option("header", "true").option("inferSchema", "true").load("/home/samriddhi/Desktop/Spark/scala/sparkhbase/resources1/role.csv")    
     
        
        groundDF.registerTempTable("ground_table")
	matchDF.registerTempTable("match_table")
	playerDF.registerTempTable("player_table")
	roleDF.registerTempTable("role_table")

	// Delete Files
    	FileUtils.deleteQuietly(new File("20runs.csv"))
	FileUtils.deleteQuietly(new File("fiftyAtHomeGround.csv"))
	FileUtils.deleteQuietly(new File("notplayedanymatch.csv"))
	FileUtils.deleteQuietly(new File("oldguycentury.csv"))
	FileUtils.deleteQuietly(new File("leadingwickettaker.csv"))
	FileUtils.deleteQuietly(new File("leadingrunscore.csv"))


        // Score greater than 20	
	val scoregreater20 = spark.sql("select distinct(m.player_number), r.role, p.player_name from match_table m, role_table r, player_table p where m.player_number = r.player_number AND m.player_number = p.player_number  AND r.role in ('Batsman', 'Allrounder') AND m.player_number not in ( select distinct(player_number) from match_table where runs < 20 OR runs IS NULL) order by player_number")              
        	
        scoregreater20.write.csv("20runs.csv")
	scoregreater20.show(30)

	// Guy who scored 50+ in home ground
	val fiftyAtHomeground = spark.sql("select m.match_no, m.player_number, m.runs, m.ground_no, g.place matchground, p.town homeground, p.player_name, p.team from match_table m, player_table p, ground_table g where m.player_number = p.player_number AND m.ground_no = g.ground_no  AND g.place = p.town AND m.runs > 50 order by m.player_number")

	fiftyAtHomeground.write.csv("fiftyAtHomeGround.csv")
	fiftyAtHomeground.show(30)
    

	//Players who did not play even a single match	
	val notplayedanymatch = spark.sql("select * from player_table where player_number not in (select distinct(p.player_number) from player_table p, match_table m where p.player_number = m.player_number order by player_number)")

	notplayedanymatch.write.csv("notplayedanymatch.csv")
	notplayedanymatch.show(30)


	// oldest Guy who sco­red a century	
	val oldguycentury = spark.sql("select m.*, p.player_name, p.dob from match_table m, player_table p where m.player_number = p.player_number AND m.runs > 99 order by TO_DATE(CAST(UNIX_TIMESTAMP(dob, 'dd-MM-yyyy') AS TIMESTAMP)) limit 1")

	oldguycentury.write.csv("oldguycentury.csv")
	oldguycentury.show(30)


	// leading wicket taker	
	val leadingwickettaker = spark.sql("select p.player_name, m.player_number, sum(m.wickets) totalwicket from match_table m, player_table p where m.player_number = p.player_number  group by p.player_name, m.player_number order by totalwicket desc limit 1")

	leadingwickettaker.write.csv("leadingwickettaker.csv")
	leadingwickettaker.show(30)


	// Leading run scorer	
	val leadingrunscore = spark.sql("select p.player_name, m.player_number, sum(m.runs) totalrun from match_table m, player_table p where m.player_number = p.player_number  group by p.player_name, m.player_number order by totalrun desc limit 1")

	leadingrunscore.write.csv("leadingrunscore.csv")
	leadingrunscore.show(30)

  
    spark.stop()
  }
}
// scalastyle:on println
