package edu.brown.cs.student.main;
import java.util.*;
import java.util.Collections;


public class Star {
  String properName;
  double x;
  double y;
  double z;
  int id;


  /**
   * Constructor for star
   */
  public Star(String name, double _x, double _y, double _z, int _id){
    properName = name;
    x = _x;
    y = _y;
    z = _z;
    id = _id;
  }

  public int getId(){
    return id;
  }

  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }

  public double getZ() {
    return z;
  }


  public String getName(){
    return properName;
  }


  public double getDist(Double[] coordinates){
    double result = 0.0;
    double squarex = Math.pow((this.x - coordinates[0]), 2);
    double squarey = Math.pow((this.y - coordinates[1]), 2);
    double squarez = Math.pow((this.z - coordinates[2]), 2);
    result = Math.sqrt(squarex + squarey + squarez);
    return result;
  }


}