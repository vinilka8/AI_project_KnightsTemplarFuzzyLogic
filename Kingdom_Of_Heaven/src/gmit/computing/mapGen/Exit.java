package gmit.computing.mapGen;

import java.util.ArrayList;
import java.util.List;

public class Exit {
	private List<Exit> exit = new ArrayList<Exit>();
	private Location location;
	private Direction direction;
	private int cost;
	private int danger;
	private float difficult;
	private String nextLocation;
	
	public Exit(Location location, int cost, int danger, float difficult, Direction direction) {
		super();
		this.location = location;
		this.cost = cost;
		this.danger = danger;
		this.difficult = difficult;
		this.direction = direction;
	}
	
	public String getNextLocation()
	{
		return this.nextLocation;
	}
	
	public void setNextLocation(String nextlocation)//new Description
	{
		this.nextLocation = nextlocation;
	}
	
	
	//
	
	
	public Exit()
	{
		
	}

	/*public List<Exit> getExits() {
		return exit;
	}

	public void setExits(List<Exit> exit) {
		this.exit = exit;
	}*/
	
	public void addExit(Exit ex)
	{
		exit.add(ex);
	}

	///////rechacke
	public String getDescription()
	{
		return this.location.getDescription();
	}
	/*public String getExit()
	{
		return this.location.getExit();
	}*/
	/*
	public int getDestination()
	{
		return this.location.getDestination();
	}
	public String getDir() 
	{
		return this.location.getParent();
	}
*/
	/////////////////////////////////////////
	public Location getLocation() {
		return location;
	}

	public void setLocation(Location newlocation) {
		this.location = newlocation;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction newdirection) {
		this.direction = newdirection;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int newcost) {
		this.cost = newcost;
	}

	public int getDanger() {
		return danger;
	}

	public void setDanger(int newdanger) {
		this.danger = newdanger;
	}

	public float getDifficult() {
		return difficult;
	}

	public void setDificult(float newdifficult) {
		this.difficult = newdifficult;
	}
}
