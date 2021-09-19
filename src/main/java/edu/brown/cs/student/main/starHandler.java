package edu.brown.cs.student.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import com.google.common.collect.ImmutableMap;
import java.util.*;
import java.util.Collections;
import java.io.*;
import java.lang.*;
import java.util.Arrays;



public class starHandler {

  public starHandler() {

  }


    // loop through the csv file line by line, separate each thing by comma and store them inside an
    //array. Then build a star object from each of the arrays and store that inside the starmap
    //hashmap
  HashMap<Integer, Star> starMap = new HashMap<>();
  Double[] coordinates = new Double[3];
  ArrayList<Star> valueList = new ArrayList(starMap.values());


//store the data of stars
  public void stars (String filename) {
    starMap = new HashMap<>();
    try (BufferedReader br2 = new BufferedReader(new FileReader(filename))) {
      String line = br2.readLine();
      while ((line = br2.readLine()) != null) {
        String[] values = line.split(",");
        Star star = new Star(values[1], Double.parseDouble(values[2]),
            Double.parseDouble(values[3]), Double.parseDouble(values[4]), Integer.parseInt(values[0]));
        starMap.put(Integer.parseInt(values[0]), star);
      }
      System.out.println("Read " + starMap.size() + " stars from " + filename);
      valueList = new ArrayList(starMap.values());
      if (starMap.isEmpty()){
        System.out.println("ERROR: no file loading");
      }
      //check if the starMap is storing stars
//      for(Star value:valueList) {
//        System.out.println("a star!");
//      }
    }
    catch (Exception e){
      System.out.println("ERROR:File not found" + e);
    }
  }

  private class sortbyDist implements Comparator<Star> {
    public int compare(Star a, Star b){
      return Double.compare(a.getDist(coordinates), b.getDist(coordinates));
    }
  }

  public void naive_neighbors (int k, double x, double y, double z, int id) {
    coordinates[0] = x;
    coordinates[1] = y;
    coordinates[2] = z;
    if (k != 0) {
      Collections.sort(valueList, new sortbyDist());
      // System.out.println(valueList.toString());
      if (id != -1){
        k = k+1;
      }
      if(k > valueList.size()){
        k = valueList.size();
      }
      //fheck if k is greater than £, if it is, set k to num of stars
      if (!valueList.isEmpty()) {
        for (int i = 0; i < k; i++) {
    //      System.out.println("id of the lonely star is " + id);
          //find the star id of star at xyz, and don't print it
          if (((valueList.get(i)).getId()) != id) {
            System.out.println((valueList.get(i)).getId());
          }
        }
      } else {
        System.out.println("ERROR:");
      }
    }
  }


  public void naive_neighborsByName(int k, String name){
    double X = 0.0;
    double Y = 0.0;
    double Z = 0.0;
    int ID = -1;
    // find arguments[2] inside your valueList and
    for (Star star : starMap.values()) {
    //  System.out.println("the name of the star I'm look at is " + star.getName());
    //  System.out.println("the name of your input star is " + name);
      if ((star.getName()).equals(name)) {
        X = star.getX();
        Y = star.getY();
        Z = star.getZ();
        ID = star.getId();
      }
    }
    naive_neighbors(k, X, Y, Z, ID);
  }

    //then sort this distMap and then spit out k numbers of the list

//for every star inside starmap, perform the calculation to find the distance and store
    //this distance in the distMap, store the name as the key and the distance as the value
    //then sort this distMap and then spit out k numbers of the list
  }