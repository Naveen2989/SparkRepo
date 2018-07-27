
case class Person(name: String, age: Long)

1. India WinPercentage:

val textFile = sc.textFile("/home/stpl/Desktop/CaseStudy/odi-cricket-matches-19712017/originalDataset.csv")
val filtering_bad_records = textFile.map(line=>line.split(",")).filter(x=>x.length<5)
val filtering_game_rdd = filtering_bad_records.map(x=>(x(1),x(2),x(3)))
val india_total_games_rdd = filtering_game_rdd.map(x=>x.split('\t')).filter(x=>{if((x(1).matches(("India")) || (x(2).matches(("India"))) true else false})
val india_total_games_rdd_filtered = india_total_games_rdd.map(x=>(x._3,1)).reduceByKey(_+_).map(item => item.swap).sortByKey(false).collect.foreach(println)
val india_winning_rdd = filtering_game_rdd.map(x=>x.split('\t')).filter(x=>{if((x(3).matches(("India")))) true else false })
val india_winning_rdd_filtered = india_winning_rdd.map(x=>(x._3,1)).reduceByKey(_+_).map(item => item.swap).sortByKey(false).collect.foreach(println)
val winning_percentage_join = india_winning_rdd_filtered.join(india_total_games_rdd_filtered).map(x=>(x._3,(x._1._1*100/x._2.1))).map(item => item.swap).sortByKey(false).collect.foreach(println)


2) India LOSS Percentage:

val textFile = sc.textFile("/home/stpl/Desktop/CaseStudy/odi-cricket-matches-19712017/originalDataset.csv")
val filtering_bad_records = textFile.map(line=>line.split(",")).filter(x=>x.length<5)
val filtering_game_rdd = filtering_bad_records.map(x=>(x(1),x(2),x(3),x(4)))
val india_total_games_rdd = filtering_game_rdd.map(x=>x.split('\t')).filter(x=>{if((x(1).matches(("India")) || (x(2).matches(("India"))) true else false})
val india_total_games_rdd_filtered = india_total_games_rdd.map(x=>(x._3,1)).reduceByKey(_+_).map(item => item.swap).sortByKey(false).collect.foreach(println)
val india_loss_rdd = filtering_game_rdd.map(x=>x.split('\t')).filter(x=>x._3!="India"))
val india_loss_rdd_filtered = india_loss_rdd.map(x=>(x._3,1)).reduceByKey(_+_).map(item => item.swap).sortByKey(false).collect.foreach(println)
val loss_percentage_join = india_loss_rdd_filtered.join(india_total_games_rdd_filtered).map(x=>(x._3,(x._1._1*100/x._2.1))).map(item => item.swap).sortByKey(false).collect.foreach(println)


3) India TIED Percentage:

val textFile = sc.textFile("/home/stpl/Desktop/CaseStudy/odi-cricket-matches-19712017/originalDataset.csv")
val filtering_bad_records = textFile.map(line=>line.split(",")).filter(x=>x.length<5)
val filtering_game_rdd = filtering_bad_records.map(x=>(x(1),x(2),x(3),x(4)))
val india_total_games_rdd = filtering_game_rdd.map(x=>x.split('\t')).filter(x=>{if((x(1).matches(("India")) || (x(2).matches(("India"))) true else false})
val india_total_games_rdd_filtered = india_total_games_rdd.map(x=>(x._3,1)).reduceByKey(_+_).map(item => item.swap).sortByKey(false).collect.foreach(println)
val india_tied_rdd = filtering_game_rdd.map(x=>x.split('\t')).filter(x=>{if((x(3).matches(("tied")))) true else false })
val india_tied_rdd_filtered = india_tied_rdd.map(x=>(x._3,1)).reduceByKey(_+_).map(item => item.swap).sortByKey(false).collect.foreach(println)
val loss_percentage_join = india_tied_rdd_filtered.join(india_total_games_rdd_filtered).map(x=>(x._3,(x._1._1*100/x._2.1))).map(item => item.swap).sortByKey(false).collect.foreach(println)


2. India Win/Loss/Tie percentage in Away & Home matches:

a) India Winning Percentage in Home matches

val textFile = sc.textFile("/home/stpl/Desktop/CaseStudy/odi-cricket-matches-19712017/originalDataset.csv")
val filtering_bad_records = textFile.map(line=>line.split(",")).filter(x=>x.length<5)
val filtering_game_rdd = filtering_bad_records.map(x=>(x(1),x(2),x(3)))
val india_total_games_home_rdd = filtering_game_rdd.map(x=>x.split('\t')).filter(x=>{if((x(1).matches(("India"))) true else false})
val india_home_winning_rdd = india_total_games_home_rdd.map(x=>x.split('\t')).filter(x=>{if((x(3).matches(("India")))) true else false })
val india__home_winning_rdd_filtered = india_home_winning_rdd.map(x=>(x._3,1)).reduceByKey(_+_).map(item => item.swap).sortByKey(false).collect.foreach(println)
val winning_percentage_join = india_home_winning_rdd_filtered.join(india_total_games_home_rdd).map(x=>(x._3,(x._1._1*100/x._2.1))).map(item => item.swap).sortByKey(false).collect.foreach(println)

b) India Loss Percentage in Home matches

val textFile = sc.textFile("/home/stpl/Desktop/CaseStudy/odi-cricket-matches-19712017/originalDataset.csv")
val filtering_bad_records = textFile.map(line=>line.split(",")).filter(x=>x.length<5)
val filtering_game_rdd = filtering_bad_records.map(x=>(x(1),x(2),x(3)))
val india_total_games_home_rdd = filtering_game_rdd.map(x=>x.split('\t')).filter(x=>{if((x(1).matches(("India"))) true else false})
val india_home_loss_rdd = india_total_games_home_rdd.map(x=>x.split('\t')).filter(x=>x._3!="India"))) true else false })
val india_home_loss_rdd_filtered = india_home_winning_rdd.map(x=>(x._3,1)).reduceByKey(_+_).map(item => item.swap).sortByKey(false).collect.foreach(println)
val winning_percentage_join = india_home_loss_rdd_filtered.join(india_total_games_home_rdd).map(x=>(x._3,(x._1._1*100/x._2.1))).map(item => item.swap).sortByKey(false).collect.foreach(println)

c) India Tied Percentage in Home matches

val textFile = sc.textFile("/home/stpl/Desktop/CaseStudy/odi-cricket-matches-19712017/originalDataset.csv")
val filtering_bad_records = textFile.map(line=>line.split(",")).filter(x=>x.length<5)
val filtering_game_rdd = filtering_bad_records.map(x=>(x(1),x(2),x(3)))
val india_total_games_home_rdd = filtering_game_rdd.map(x=>x.split('\t')).filter(x=>{if((x(1).matches(("India"))) true else false})
val india_home_tie_rdd = india_total_games_home_rdd.map(x=>x.split('\t')).filter(x=>{if((x(3).matches(("tied")))) true else false })
val india_home_tie_rdd_filtered = india_home_winning_rdd.map(x=>(x._3,1)).reduceByKey(_+_).map(item => item.swap).sortByKey(false).collect.foreach(println)
val winning_percentage_join = india_home_tie_rdd_filtered.join(india_total_games_home_rdd).map(x=>(x._3,(x._1._1*100/x._2.1))).map(item => item.swap).sortByKey(false).collect.foreach(println)




3.How many matches has India played against different ICC teams?

val textFile = sc.textFile("/home/stpl/Desktop/CaseStudy/odi-cricket-matches-19712017/originalDataset.csv")
val filtering_bad_records = textFile.map(line=>line.split(",")).filter(x=>x.length<5)
val filtering_game_rdd = filtering_bad_records.map(x=>(x(1),x(2),x(3)))


4. How many matches India has won or lost against different teams?


a) India WON against different ICC teams:

import org.apache.spark.sql.functions._  
import org.apache.spark.sql.expressions.Window

origin.show();

+------+
|Origin|
+------+
|   USA|
| Japan|
|   USA|
|   USA|
| Japan|
|Europe|
+------+

(Query using window function)	>>>>origin.withColumn("cnt", count('Origin).over(Window.partitionBy('Origin)))

Another way :

var agg_df = df.groupBy("location").agg(min("id"), count("id"), avg("date_diff"))
display(agg_df)

val textFile = sc.textFile("/home/stpl/Desktop/CaseStudy/odi-cricket-matches-19712017/originalDataset.csv")
val filtering_bad_records = textFile.map(line=>line.split(",")).filter(x=>x.length<5)
val filtering_game_rdd = filtering_bad_records.map(x=>(x(1),x(2),x(3)))
val distinctTeams = filtering_bad_records.map(x=>(x(8)))
distinctTeams.distinct();




val india_won_icc = 








IPL Matches Data Analysis Using Spark:

Here is the data set description:

id,season,city,date,team1,team2,toss_winner,toss_decision,result,dl_applied,winner,win_by_runs,win_by_wickets,player_of_match,venue,umpire1,umpire2,umpire3


1.Which stadium is best suitable for first batting: 


Here we evaluate that which stadium is most suitable for first batting. Here are the details how can we do that.

win_by_runs means – Team batted first and won the Match by margin of some runs.

win_by_wickets means – Team batted second and chased the target successfully.

So we will take out the columns toss_decision, won_by_runs, won_by_wickets, venue. From this we will filter out the columns
 which are having won_by_runs value as 0 so that we can get the teams which won by batting first. Here is the scala code to do that.

val data = sc.textFile("file:///home/kiran/Documents/datasets/matches.csv")
val filtering_bad_records = data.map(line=>line.split(",")).filter(x=>x.length<19)
val extracting_columns = filtering_bad_records.map(x=>(x(7),x(11),x(12),x(14)))
val bat_first_won = extracting_columns.filter(x=>x._2!="0").map(x=>(x._4,1)) .reduceByKey(_+_).map(item => item.swap).sortByKey(false).collect.foreach(println)


Problem statement2: Let us see how many matches that each stadium has been venued. Here is the code to do that

val data = sc.textFile("file:///home/kiran/Documents/datasets/matches.csv")
val filtering_bad_records1 = data.map(line=>line.split(",")).filter(x=>x.length<19)
val total_matches_per_venue = filtering_bad_records.map(x=>(x(14),1)).reduceByKey(_+_).map(item => item.swap).sortByKey(false).collect.foreach(println)


Here are the total number of matches each stadium has been venued.

(58,M Chinnaswamy Stadium)
(54,Eden Gardens)
(53,Feroz Shah Kotla)
(49,Wankhede Stadium)
(48,"MA Chidambaram Stadium)
(41,"Rajiv Gandhi International Stadium)
(35,"Punjab Cricket Association Stadium)
(33,Sawai Mansingh Stadium)
(17,Dr DY Patil Sports Academy)
(17,Subrata Roy Sahara Stadium)
(15,Kingsmead)
(12,"Sardar Patel Stadium)
(12,SuperSport Park)
(11,Dr. Y.S. Rajasekhara Reddy ACA-VDCA Cricket Stadium)
(11,Brabourne Stadium)
(9,Himachal Pradesh Cricket Association Stadium)
(8,New Wanderers Stadium)
(8,Maharashtra Cricket Association Stadium)
(7,Newlands)
(7,St George's Park)
(7,Sheikh Zayed Stadium)
(7,JSCA International Stadium Complex)
(7,"Punjab Cricket Association IS Bindra Stadium)
(7,Dubai International Cricket Stadium)
(7,Barabati Stadium)
(6,Shaheed Veer Narayan Singh International Stadium)
(6,Sharjah Cricket Stadium)
(5,Nehru Stadium)
(5,Saurashtra Cricket Association Stadium)
(3,De Beers Diamond Oval)
(3,"Vidarbha Cricket Association Stadium)
(3,Buffalo Park)
(2,OUTsurance Oval)
(2,Green Park)
(2,Holkar Cricket Stadium)

Problem statement 3: we will now see the winning percentage of each stadium for first_bat_won. Here is the code to do that.


val join = bat_first_won.join(total_matches_per_venue).map(x=>(x._1,(x._2._1*100/x._2._2))).map(item => item.swap).sortByKey(false).collect.foreach(println)


Problem statement4: 2.Which stadium is best suitable for first bowling

val data = sc.textFile("file:///home/kiran/Documents/datasets/matches.csv")
val filtering_bad_records = data.map(line=>line.split(",")).filter(x=>x.length<6)
val to = filtering_bad_records.map(x=>(x(1),x(2)))
val bowl_first_won = extracting_columns.filter(x=>x._3!="0").map(x=>(x._4,1)) .reduceByKey(_+_).map(item => item.swap).sortByKey(false).collect.foreach(println)


Problem Statement5:

Now we will see the percentage of first_bowl_won by taking the percentage of first_bowl_won and the total number of matches held in that stadium.


val data = sc.textFile("file:///home/kiran/Documents/datasets/matches.csv")
val filtering_bad_records1 = data.map(line=>line.split(",")).filter(x=>x.length<19)
val total_matches_per_venue = filtering_bad_records.map(x=>(x(14),1)).reduceByKey(_+_).map(item => item.swap).sortByKey(false).collect.foreach(println)

val join1 = bowl_first_won.join(total_matches_per_venue).map(x=>(x._1,(x._2._1*100/x._2._2))).map(item => item.swap).sortByKey(false).collect.foreach(println)

Here is the percentage of first_bowl_won matches for each stadium

(100,Green Park)
(100,Holkar Cricket Stadium)
(80,Saurashtra Cricket Association Stadium)
(71,JSCA International Stadium Complex)
(69,Sawai Mansingh Stadium)
(66,Shaheed Veer Narayan Singh International Stadium)
(66,De Beers Diamond Oval)
(66,SuperSport Park)
(66,Sharjah Cricket Stadium)
(63,"Rajiv Gandhi International Stadium)
(62,New Wanderers Stadium)
(62,Maharashtra Cricket Association Stadium)
(59,Eden Gardens)
(58,Dr DY Patil Sports Academy)
(57,St George's Park)
(57,"Punjab Cricket Association IS Bindra Stadium)
(57,Dubai International Cricket Stadium)
(57,"Punjab Cricket Association Stadium)
(53,M Chinnaswamy Stadium)
(52,Feroz Shah Kotla)
(50,OUTsurance Oval)
(48,Wankhede Stadium)
(45,Brabourne Stadium)
(44,Himachal Pradesh Cricket Association Stadium)
(42,Sheikh Zayed Stadium)
(42,Barabati Stadium)
(41,"Sardar Patel Stadium)
(40,Kingsmead)
(40,Nehru Stadium)
(36,Dr. Y.S. Rajasekhara Reddy ACA-VDCA Cricket Stadium)
(35,"MA Chidambaram Stadium)
(35,Subrata Roy Sahara Stadium)
(33,"Vidarbha Cricket Association Stadium)
(33,Buffalo Park)
(28,Newlands)








