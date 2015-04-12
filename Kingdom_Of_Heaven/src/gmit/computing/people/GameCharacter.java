package gmit.computing.people;

import java.util.List;

import gmit.computing.mapGen.Location;
import gmit.computing.things.Items;
import gmit.computing.things.Weapon;


//no methods in interface

/*
 * interface class - is an abstract type that is used to specify an
 * interface that calsses must implement
 * 
 * cannot have a methdos {}, only public void variables
 */
public interface GameCharacter extends Runnable{
	public void move(String direction);
	
	public void setName(String name);
	public void setType(String type);
	public void setDescriptionChar(String descriptionchar);
	public String getDescriptionChar();
	public String getType();
	public String getName();

	public void take(String items);
	public void eat(String items);
	public void itemInBag();
	
	public void fight(Weapon weapon, EnemyCharacters ec);
	public void fight(Weapon weapon, MyHero mh);
	public int getStrength();
	public void setStrength(int strength);
	public void draw();
	
	public void look(Location l);
	public List<Items> getItems();
	public void setHealth(float health);
	public void setCharacterLocation(Location location);



	public void tell(String temp, FriendlyCharacters fc);
	
	
	
	//movements, actions, 
	//override those methods by classes that implements it 
	//don't need to use abstract after public and all methods has to be public for override 
	

}
