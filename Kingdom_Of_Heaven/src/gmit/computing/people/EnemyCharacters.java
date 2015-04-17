package gmit.computing.people;
import gmit.computing.mapGen.InputClass;
import gmit.computing.mapGen.Location;
import gmit.computing.things.Items;
import gmit.computing.things.Weapon;

import java.util.ArrayList;
import java.util.List;

import net.sourceforge.jFuzzyLogic.FIS;


public class EnemyCharacters implements GameCharacter, Runnable{
	private int Strenght;
	private Location location;
	private String direction;
	private String name;
	private float Health;
	private String descriptionchar;
	private float lifeForce = 100.00f;
	private List<Items> items = new ArrayList<Items>();
	//private Weapon weapon;
	//private EnemyCharacters ec;
	//life force here
	public EnemyCharacters() {
		super();
		//asd();
		loadFuzzyFile();
	}

	FIS fis;

	public void loadFuzzyFile() {
		String fileName = "conf/rules.fcl";// contains all fuzzy sets
		fis = FIS.load(fileName, true); // Load and parse the FCL
		// Error while loading?
		if (fis == null) {
			System.err.println("Can't load file: '" + fileName + "'");
			return;
		}
		
	}
	
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
		
		//asd();
		
		
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
	public List<Items> getItems() {
		// TODO Auto-generated method stub
		return items;
	}

	@Override
	public void setCharacterLocation(Location location) {
		// TODO Auto-generated method stub
		this.location = location;
	}
	public Location getLocation(){
		return location;
		
	}

	@Override
	public void tell(String temp, FriendlyCharacters fc) {
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

	/*@Override
	public void fight(Weapon weapon, MyHero mh) {
		// TODO Auto-generated method stub
		
	}*/
	
	static boolean a = false;
	public void asd(){
		while(!a){
			for(GameCharacter l : location.getObservers()){
				System.out.println("i am here" + l.getName());
				if(location.getObservers() != null){
					//*************
					try{
						Weapon w = new Weapon();
						MyHero mh = location.getMyHero(getName());
						fight(w, mh);
					}catch (Exception e) {
						System.out.println("please write correct weapon");
						e.printStackTrace();
					}
					//*************
				}
			}
		}
		//serach a pleayr in observes in location
		//when you find him, get wapon .get 0  and pass it to fight (weapon and my hero)
	}

	@Override
	public void fight(Weapon weapon, MyHero mh) {
		// TODO Auto-generated method stub
		fis.setVariable("weapon", weapon.getStrennght());// weapon.getDamage()
		fis.setVariable("enemy", mh.getHp());// ec.getStrength()
		fis.evaluate();
		float victory = (float) fis.getVariable("victory").getValue();
		System.out.println("Enemy Health " + mh.getHp() +" HP");
		//MyHero me = location.getMyHero(mh);
		if (mh != null){
			while(mh.getHp() > 0) {
				mh.setHp((mh.getHp() - weapon.getStrennght()));// or Health is public
				if (mh.getHp() < 0) {
					System.out.println("removed");
					location.getObservers().remove(mh);
				}
				System.out.println("You hit Enemy with " + weapon.getStrennght() + " : New Enemy health :" + mh.getHp() + "HP");
				System.out.println();
			}
		}
		
		System.out.println(victory + "----- VICTORY !!! ----- ");
		
	}
}