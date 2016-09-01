package com.absurd

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by Administrator on 2016/9/1.
  */
class Hello {

}
object Hello{
  def main(args: Array[String]): Unit = {
    val a = (0/:( 0 to 100))(_+_)
    print(a)
    val logFile = "logger"
    val conf = new SparkConf().setAppName("Simple Application")
    val sc = new SparkContext(conf)
    val logData = sc.textFile(logFile, 2).cache()
    val numAs = logData.filter(line => line.contains("a")).count()
    val numBs = logData.filter(line => line.contains("b")).count()
    println("Lines with a: %s, Lines with b: %s".format(numAs, numBs))
  }


}
