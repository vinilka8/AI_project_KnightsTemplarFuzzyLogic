package gmit.computing.calculation;

import gmit.computing.mapGen.Location;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BestFirstSearch {
	private LinkedList<Location> queue = new LinkedList<Location>();
	private List<Location> closed = new ArrayList<Location>();
	private HeuristicLocationComparator sorter = new HeuristicLocationComparator();

	public void search(Location location) {
		queue.addFirst(location);
		while (!queue.isEmpty()) {
			queue.removeFirst();
			closed.add(location);
			if (location.isGoalLocation()) {
				path(location);
				System.exit(0);
			} else {
				Location[] exit = location.exits();
				
				for (int i = 0; i < exit.length; i++) {
					if (!exit[i].isVisited()) {
						queue.addFirst(exit[i]);
						exit[i].setParent(location);
					}
				}
				
				Collections.sort(queue, sorter);
				location = queue.getFirst();
				location.setVisited(true);
			}
		}
	}

	private void path(Location location) {
		List<Location> path = new ArrayList<Location>();
		while (location.getParent() != null) {
			path.add(location);
			location = location.getParent();
		}
		path.add(location);
		Collections.reverse(path);
		System.out.println("Path: " + path);
	}

	/*private int distance(List<Location> path) {
		int distance = 0;
		for (int i = 0; i < path.size(); i++) {
			if (i + i <= path.size())
				distance += path.get(i).getDistance(path.get(i + 1));
		}
		return distance;
	}*/
}
