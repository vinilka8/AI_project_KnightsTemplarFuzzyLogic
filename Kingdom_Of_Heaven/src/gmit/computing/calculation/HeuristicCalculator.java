package gmit.computing.calculation;

public class HeuristicCalculator {
	public static float getHeuristicValue(int distanceTravelled, int approxGoalDistance, float terrain, float danger){
		return distanceTravelled + approxGoalDistance + (approxGoalDistance * terrain) + (approxGoalDistance * danger);
	}
}
