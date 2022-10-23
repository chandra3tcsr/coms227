package edu.iastate.cs228.hw2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;

/**
* @author Oskar Niesen
* Here is a really simple random test for each of your sorting methods.
* This is more of a general test and is not meant to test any edge cases.
* Note: The random value is not limited from -50 to 50.
*/
public class RandomSorterTests
{
 Point[] points;

 @Before
 public void SetupPoints()
 {
  Random rand = new Random();
  points = new Point[rand.nextInt(41)+10];
  for (int i = 0; i < points.length; i++)
  {
   points[i] = new Point(rand.nextInt(101)-50, rand.nextInt(101)-50);
  }
 }

 @Test
 public void SelectionSortTestX()
 {
  Point.xORy = true;
  SelectionSorter selectionSorter = new SelectionSorter(points);
  selectionSorter.sort();
  boolean sorted = true;
  
  for (int i = 1; i < selectionSorter.points.length; i++)
  {
   if (selectionSorter.points[i - 1].compareTo(selectionSorter.points[i]) > 0) 
   {
    sorted = false;
   }  
  }
  
  assertEquals(true, sorted);
 }

 @Test
 public void SelectionSortTestY()
 {
  Point.xORy = false;
  SelectionSorter selectionSorter = new SelectionSorter(points);
  selectionSorter.sort();
  boolean sorted = true;
  
  for (int i = 1; i < selectionSorter.points.length; i++)
  {
   if (selectionSorter.points[i - 1].compareTo(selectionSorter.points[i]) > 0) 
   {
    sorted = false;
   }  
  }
  
  assertEquals(true, sorted);
 }

 @Test
 public void InsertionSortTestX()
 {
  Point.xORy = true;
  InsertionSorter insertionSorter = new InsertionSorter(points);
  insertionSorter.sort();
  boolean sorted = true;
  
  for (int i = 1; i < insertionSorter.points.length; i++)
  {
   if (insertionSorter.points[i - 1].compareTo(insertionSorter.points[i]) > 0) 
   {
    sorted = false;
   }  
  }
  
  assertEquals(true, sorted);
 }

 @Test
 public void InsertionSortTestY()
 {
  Point.xORy = false;
  InsertionSorter insertionSorter = new InsertionSorter(points);
  insertionSorter.sort();
  boolean sorted = true;
  
  for (int i = 1; i < insertionSorter.points.length; i++)
  {
   if (insertionSorter.points[i - 1].compareTo(insertionSorter.points[i]) > 0) 
   {
    sorted = false;
   }  
  }
  
  assertEquals(true, sorted);
 }

 @Test
 public void MergeSortTestX()
 {
  Point.xORy = true;
  MergeSorter mergeSorter = new MergeSorter(points);
  mergeSorter.sort();
  boolean sorted = true;
  
  for (int i = 1; i < mergeSorter.points.length; i++)
  {
   if (mergeSorter.points[i - 1].compareTo(mergeSorter.points[i]) > 0) 
   {
    sorted = false;
   }  
  }
  
  assertEquals(true, sorted);
 }

 @Test
 public void MergeSortTestY()
 {
  Point.xORy = false;
  MergeSorter mergeSorter = new MergeSorter(points);
  mergeSorter.sort();
  boolean sorted = true;
  
  for (int i = 1; i < mergeSorter.points.length; i++)
  {
   if (mergeSorter.points[i - 1].compareTo(mergeSorter.points[i]) > 0) 
   {
    sorted = false;
   }  
  }
  
  assertEquals(true, sorted);
 }

 @Test
 public void QuickSortTestX()
 {
  Point.xORy = true;
  QuickSorter quickSorter = new QuickSorter(points);
  quickSorter.sort();
  boolean sorted = true;
  
  for (int i = 1; i < quickSorter.points.length; i++)
  {
   if (quickSorter.points[i - 1].compareTo(quickSorter.points[i]) > 0) 
   {
    sorted = false;
   }  
  }
  
  assertEquals(true, sorted);
 }

 @Test
 public void QuickSortTestY()
 {
  Point.xORy = false;
  QuickSorter quickSorter = new QuickSorter(points);
  quickSorter.sort();
  boolean sorted = true;
  
  for (int i = 1; i < quickSorter.points.length; i++)
  {
   if (quickSorter.points[i - 1].compareTo(quickSorter.points[i]) > 0) 
   {
    sorted = false;
   }  
  }
  
  assertEquals(true, sorted);
 }
}