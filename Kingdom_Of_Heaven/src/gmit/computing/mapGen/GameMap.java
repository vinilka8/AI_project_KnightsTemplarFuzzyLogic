package gmit.computing.mapGen;

import java.util.List;

import gmit.computing.mapGen.Location;
import gmit.computing.people.MyHero;

public class GameMap {
	public static List<gmit.computing.mapGen.Location> locations;
	public List<Location> getLocation(){
		return locations;
	}
	
	 public GameMap(){
			Parser p = new Parser();
			p.nazovikakhochew();
			
			//GameMap gm = new GameMap();
			//MyHero myHero = new MyHero();

			/*for(Location loc : gm.getLocation()){
				if(loc.getName().equalsIgnoreCase("Antioch"))
					myHero.setLocation(loc);			
			}*/
		
			locations = p.getLocation();
			for(Location location :  locations ){
				if(location.getName().equalsIgnoreCase("Antioch")){
					location.setGoalLocation(true);
					
				}
				for(Location exit : location.getExits()){
					String exitName = exit.getName();
					String direction = exit.getDirect();
					Location child = GameMap.getLocation(exitName);
					location.addChildNode(child, direction);
					
				}
			}
		 }
		/*public Location getStartNode(){
			return GameMap.getLocation("tiberias");
		}*/
		
		public static Location getLocation(String location){
			for(Location loc : locations){
				if(loc.getName().equalsIgnoreCase(location)){
					return loc;
				}
			}
			return null;
		}
		
		public static Location getLocation(Location location){
			for(Location loc : locations){
				if(loc.equals(location)){
					return loc;
				}
			}
			return null;
		}
}
