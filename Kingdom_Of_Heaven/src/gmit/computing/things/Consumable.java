package gmit.computing.things;

public class Consumable implements Items{
	private String name;
	private int health;
	private int strenght;
	
	public Consumable(String name, int health) {
		super();
		this.name = name;
		this.health = health;
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
	
	public Consumable(){
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	
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

}
