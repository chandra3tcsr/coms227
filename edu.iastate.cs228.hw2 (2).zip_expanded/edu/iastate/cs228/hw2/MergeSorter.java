package edu.iastate.cs228.hw2;


/**
 *  
 * @author Chandrashekar Tirunagiri 
 *
 */

/**
 * 
 * This class implements the mergesort algorithm.   
 *
 */

public class MergeSorter extends AbstractSorter
{
	// Other private instance variables if needed
	
	/** 
	 * Constructor takes an array of points.  It invokes the superclass constructor, and also 
	 * set the instance variables algorithm in the superclass.
	 *  
	 * @param pts   input array of integers
	 */
	public MergeSorter(Point[] pts) 
	{
		super(pts);
		algorithm = "mergesort";
		
	}


	/**
	 * Perform mergesort on the array points[] of the parent class AbstractSorter. 
	 * 
	 */
	@Override 
	public void sort()
	{
		mergeSortRec(points);
	}

	
	/**
	 * This is a recursive method that carries out mergesort on an array pts[] of points. One 
	 * way is to make copies of the two halves of pts[], recursively call mergeSort on them, 
	 * and merge the two sorted subarrays into pts[].   
	 * 
	 * @param pts	point array 
	 */
	private void mergeSortRec(Point[] pts)
	{
		if(pts.length <=1) {
			return;
		}
		Point[] left = new Point[pts.length/2];
		Point[] right = new Point[pts.length- (pts.length/2)];
		for (int i=0; i<left.length; i++) {
			left[i]= pts[i];
			
			
		}
		for (int j =0; j<right.length; j++) {
			right[j] = pts[left.length + j ];
			
		}
		mergeSortRec(left);
		mergeSortRec(right);
		merge(pts, left, right);

		
	}
	
	

	
	// Other private methods if needed ...
	/**
	 * Helper method for merge sort 
	 * 
	 * @param pts
	 * @param left
	 * @param right
	 */
	private void merge(Point[] pts, Point[] left, Point[] right) {
		int first_left_index = 0;
		int first_right_index = 0;
		int index = 0;
		while((first_left_index < left.length) && (first_right_index < right.length)) {
			if (pointComparator.compare(left[first_left_index], right[first_right_index])<0) {
				pts[index] = left[first_left_index ++];
				
			}
			else {
				pts[index] = right[first_right_index ++];
			}
			index++;
			
			
		}
		while(first_left_index < left.length) {
			pts[index ++] = left[first_left_index ++];
			
		}
		while(first_right_index < right.length) {
			pts[index ++] = right[first_right_index ++];
		}
	}

}
