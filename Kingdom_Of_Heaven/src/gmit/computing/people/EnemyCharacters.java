package gmit.computing.people;
import gmit.computing.mapGen.Location;
import gmit.computing.things.Items;
import gmit.computing.things.Weapon;

import java.util.ArrayList;
import java.util.List;


public class EnemyCharacters implements GameCharacter{
	private int Strenght;
	private Location locaton;
	private String direction;
	private String name;
	private float Health;
	private String descriptionchar;
	private float lifeForce = 100.00f;
	private List<Items> items = new ArrayList<Items>();
	//life force here
	public String getName() {
		return name;
	}
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


	public void setName(String name) {
		this.name = name;
	}
	
	public float getLifeForce(){
		return lifeForce;
	}
	public void setLifeForce(float lifeForce){
		this.lifeForce = lifeForce;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(getLifeForce() > 0.00f){
			//do some stuff
		}
		try{
			Thread.sleep(10000);
		} catch (InterruptedException e){
			e.printStackTrace();
		}
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
	public double getStrength() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void fight(Weapon weapon, EnemyCharacters ec) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Items> getItems() {
		// TODO Auto-generated method stub
		return items;
	}

	@Override
	public void setCharacterLocation(Location location) {
		// TODO Auto-generated method stub
		this.locaton = location;
	}
	public Location getLocation(){
		return locaton;
		
	}

	@Override
	public void tell(String temp, FriendlyCharacters fc) {
		// TODO Auto-generated method stub
		
	}
}