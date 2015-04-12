package gmit.computing.people;

import java.util.ArrayList;
import java.util.List;

import gmit.computing.mapGen.Location;
import gmit.computing.things.Items;
import gmit.computing.things.Weapon;

public class FriendlyCharacters implements GameCharacter{
	private Location location;
	private int Strenght = 60;
	private int Army = 8800;
	private String direction;
	private String name;
	private float lifeForce = 100.00f;
	private float Health;
	private String descriptionchar;
	//list of items 
	private List<Items> items = new ArrayList<Items>();
	
	public void setDescriptionChar(String descriptionchar) {
		this.descriptionchar = descriptionchar;
	}
	
	public String getDescriptionChar()
	{
		return this.descriptionchar;
	}

	public float getHealth() {
		return Health;
	}
	public void setHealth(float health) {
		Health = health;
	}
	
	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public int getStrenght() {
		return Strenght;
	}

	public void setStrenght(int strenght) {
		Strenght = strenght;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public float getLifeForce() {
		return lifeForce;
	}

	public void setLifeForce(float lifeForce) {
		this.lifeForce = lifeForce;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void move(String direction) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void look(Location l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void take(String items) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void itemInBag() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setType(String type) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eat(String items) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fight(Weapon weapon, EnemyCharacters ec) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getStrength() {
		// TODO Auto-generated method stub
		return Strenght;
		
	}
	@Override
	public void setStrength(int strength) {
		// TODO Auto-generated method stub
		this.Strenght = strength;
	}

	@Override
	public List<Items> getItems() {
		// TODO Auto-generated method stub
		return items;
	}

	@Override
	public void setCharacterLocation(Location location) {
		// TODO Auto-generated method stub
		this.location = location;
	}
	@Override
	public void tell(String temp, FriendlyCharacters fc) {
		// TODO Auto-generated method stub
		
	}

	public int getArmy() {
		return Army;
	}

	public void setArmy(int army) {
		this.Army = army;
	}

	@Override
	public void fight(Weapon weapon, MyHero mh) {
		// TODO Auto-generated method stub
		
	}



}
