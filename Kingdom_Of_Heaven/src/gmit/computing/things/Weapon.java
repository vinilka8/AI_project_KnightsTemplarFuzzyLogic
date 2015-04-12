package gmit.computing.things;

public class Weapon implements Items{
	private String name;
	private int damage;
	private int strenght;
	
	public Weapon(String name, int damage) {
		super();
		this.name = name;
		this.damage = damage;
	}
	
	@Override
	public int getStrennght() {
		// TODO Auto-generated method stub
		return strenght;
	}

	@Override
	public void setStrennght(int strenght) {
		// TODO Auto-generated method stub
		this.strenght = strenght;
		
	}

	public Weapon(){
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	//Structure-------------------------------------
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	//Structure-------------------------------------
	
	@Override
	public void use() {
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
	
	/*
	public int getPower(){
		return damage;
	}*/
}
