package gmit.computing.mapGen;
import gmit.computing.people.EnemyCharacters;
import gmit.computing.people.FriendlyCharacters;
import gmit.computing.people.GameCharacter;
import gmit.computing.people.MyHero;
import gmit.computing.people.NeutralCharacters;
import gmit.computing.things.Items;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Location implements Lookable{
	private List<GameCharacter> observers = new ArrayList<GameCharacter>();//observing the items, and observ is it become a new value.
	private List<Location> exits = new ArrayList<Location>();//set a exits as a location as well
	private List<Items> items = new ArrayList<Items>(); // list of StringsS
	private Map<Location, String > children = new HashMap<Location, String>();
		
	public String getCharacter() {
		return character;
	}
	
	public EnemyCharacters getEnemy(String enemyname){
		for(GameCharacter g : observers){
			if(g.getClass() == gmit.computing.people.EnemyCharacters.class & g.getName().equalsIgnoreCase(enemyname)){
				return (EnemyCharacters) g;
			}
		}
		return null;
	}
	
	public MyHero getMyHero(String myhero){
		for(GameCharacter g : observers){
			if(g.getClass() == gmit.computing.people.EnemyCharacters.class & g.getName().equalsIgnoreCase(myhero)){
				return (MyHero) g;
			}
		}
		return null;
	}
	
	
	
	public FriendlyCharacters getFriend(String friendname){
		for(GameCharacter g : observers){
			if(g.getClass() == gmit.computing.people.FriendlyCharacters.class & g.getName().equalsIgnoreCase(friendname)){
				return (FriendlyCharacters) g;
			}
		}
		return null;
	}
	
	public NeutralCharacters getNeutral(String neutralname){
		for(GameCharacter g : observers){
			if(g.getClass() == gmit.computing.people.NeutralCharacters.class & g.getName().equalsIgnoreCase(neutralname)){
				return (NeutralCharacters) g;
			}
		}
		return null;
	}

	public void setCharacter(String character) {
		this.character = character;
	}

	public void setChildren(Map<Location, String> children) {
		this.children = children;
	}

	public Map<Location, String > getChildren(){
		return children;
	}
	
	public void addChildNode(Location child, String direction) {
		// TODO Auto-generated method stub
		children.put(child, direction);
	}
	
	private String character;
	private String name;
	private String exit;
	private String item;
	private Direction dir;
	private String direct;
	
	private String description;
	private int id;

	
	public Location(String name, String description){
		super();
		this.name = name;
		this.description = description;
	}
	
	public Location(String description){
		super();
		this.description = description;
	}
	
	public Location(Direction direction, String direct){
		this.dir = dir;
		this.direct = direct;
	}
	
	public Location()
	{
		super();
	}
	
	//private List<Exit> exit = new ArrayList<Exit>(); //list of Exits 
	//private Map<Location, String> children = new HashMap<Location, String>(); // hashmap of location and Strings
	
	
	
	
	//----------------------- Direction from Enum list ----------------------
	
	public Direction getDir() {
		return dir;
	}

	public void setDir(Direction dir) {
		this.dir = dir;
	}
	
	public String getDirect() {
		return direct;
	}

	public void setDirect(String direct) {
		this.direct = direct;
	}

	// ----------------------------------------------------
	// ---------------------- Location / Exit ---------------------------
	public void getLocation(List<Location> locations){
		this.exits = exits;
	}

	public void setLocation(List<Location> locations) {
		this.exits = locations;
	}

	public List<Location> getExits(){
		return exits;
	}
	
	public void getExits(List<Location> exits){
		this.exits = exits;
	}
	
	public void setExits(List<Location> exits) {
		this.exits = exits;
	}
	
	public void setExits(String exit){
		this.exit = exit;
	}
	public void addLocation(Location loc){
		exits.add(loc);
	}
	
	public boolean add(Location e) {
		return exits.add(e);
	}
	
	
	
	public String getExit() {
		return exit;
	}

	public void setExit(String exit) {
		this.exit = exit;
	}

	// -------------------------------------------------------------------
	
	public static Location getLocation(Location location){
	for(Location loc:Runner.locations){
		if(loc.equals(location)){
			return loc;
			}
		}
		return null;
	}
	
	public static Location getItem(Location location){
		for(Location loc:Runner.locations){
			if(loc.equals(location)){
				return loc;
				}
			}
			return null;
		}
	// ------------ ID -------------
	
	
	public int getId() {
		return id;
	}
	

	public void setId(int id) {
		this.id = id;
	}
	// -----------------------------

	// ----------- Chracters ------------
	public List<GameCharacter> getObservers() {
		return observers;
	}

	public void setObservers(List<GameCharacter> observers) {
		this.observers = observers;
	}
	
	public static Location getObservers(Location location){
		for(Location loc:Runner.locations){
			if(loc.equals(location)){
				return loc;
				}
			}
			return null;
		}
	
	public void getObservers(List<GameCharacter> observers){
		this.observers = observers;
	}
	
	public void setObservers(String character){
		this.character = character;
	}
	
	public String getObserver() {
		return character;
	}

	public void setObserver(String character) {
		this.character = character;
	}
	
	
	
	public void enter(GameCharacter gc){
		observers.add(gc);
	}
	
	public void exit(GameCharacter gc){
		observers.remove(gc);
	}
	// ----------------------------------
	
	// ----------- Items ----------------
	
	public List<Items> getItems() {
		return items;
	}
	

	public void setItems(List<Items> items) {
		this.items = items;
	}
	
	public void getItems(List<Items> items){
		this.items = items;
	}
	
	public void setItems(String item){
		this.item = item;
	}
	
	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	// ----------------------------------

	
	// ---------- Name ---------------
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	// -------------------------------
	
	// ----- NEED or NOT -----
	public List<Location> getNextLocation() {
		return exits;
	}

	public void setNextLocation(List<Location> nextLocation) {
		this.exits = nextLocation;
	}
	// -----------------------------

	// --------- Description ---------------------
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription()
	{
		return this.description;
	}
	
	public void setDescriprion(String newdescription)//new Description
	{
		this.description = newdescription;
	}
	// ---------------------------

	
	@Override
	public void look() {
		// TODO Auto-generated method stub
		
		
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Location other = (Location) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equalsIgnoreCase(other.name))
			return false;
		return true;
	}



	
	//-------------------------- HEURISTIC CALCULATION STRUCTURE ---------------------------
	
	private boolean goal = false;
	private boolean visited = false;
	private boolean goalLocation;
	private int traveledDistance = 0;
	private int goalDistance = 0;
	private int approximateDistanceFromGoal = 0;
	private Location parent;
	
	
	public Location(String name, int approximateDistanceFromGoal){
		this.name = name;
		this.approximateDistanceFromGoal = approximateDistanceFromGoal;
	}
		
	public Location[] exits() {
		Location[] locArray = exits.toArray(new Location[exits.size()]);
		return locArray;
	}
	public int getExitCound() {
		return exits.size();
	}
	
	public int getApproximateDistanceFromGoal() {
		return approximateDistanceFromGoal;
	}

	public void setApproximateDistanceFromGoal(int approximateDistanceFromGoal) {
		this.approximateDistanceFromGoal = approximateDistanceFromGoal;
	}
	
	public boolean isGoalLocation() {
		return goalLocation;
	}

	public void setGoalLocation(boolean goalLocation) {
		this.goalLocation = goalLocation;
	}
	
	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	
	public Location getParent() {
		return parent;
	}

	public void setParent(Location parent) {
		this.parent = parent;
	}

	
	/*public void addChildNode(Location child, int distance, int difficult) {
		children.put(child, new Integer(distance));
	}*/
	
	/*public void addChildNode(Location child, String exit) {
		children.put(child, exit);
	}

	public void removeChild(Location child) {
		children.remove(child);
	}

	public String getNodeName() {
		return name;
	}

	public void setNodeName(String nodeName) {
		this.name = nodeName;
	}
	
	public String toString() {
		return this.name;
	}
	
	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	public boolean isGoalNode() {
		return goalNode;
	}

	public void setGoalNode(boolean goalNode) {
		this.goalNode = goalNode;
	}
	
	public int getGoalDistance() {
		return traveledDistance;
	}

	public void setGoalDistance(int goalDistance) {
		this.traveledDistance = goalDistance;
	}
	@Override
	public void look() {
		// TODO Auto-generated method stub
		
	}	
	// DATA STRUCTURE ====================================
	/*@Override
	public void look() {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("==========" + this.name + " blaaah");
		sb.append(this.description);
		
		sb.append("\nYou see: \n" + location);
		for(GameCharacter gc : observers){
			sb.append(((AbstractGameCharacter) gc).getName());
		}
		
		//you also see objects....
		
		sb.append("\nVisible exits are: \n");
		for(Exit e : exits){
			sb.append(e.getDirection());
		}
	}
*/
}










