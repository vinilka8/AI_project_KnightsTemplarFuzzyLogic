package gmit.computing.calculation;

import gmit.computing.mapGen.Location;

import java.util.*;

public class HeuristicLocationComparator implements Comparator<Location>{

	@Override
	public int compare(Location l1, Location l2) {
		// TODO Auto-generated method stub
		if(l1.getApproximateDistanceFromGoal() > l2.getApproximateDistanceFromGoal()){
			return 1;
		}else if(l1.getApproximateDistanceFromGoal() < l2.getApproximateDistanceFromGoal()){
			return -1;
		}else{
			return 0;
		}
	}
}
