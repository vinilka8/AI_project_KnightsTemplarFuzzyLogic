package gmit.computing.things;

public class QuestItem implements Items{
	private String name;
	private String type;
	
	public QuestItem(String name){
		this.name = name;
	}
	
	public QuestItem(){
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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

	@Override
	public int getStrennght() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setStrennght(int Strenght) {
		// TODO Auto-generated method stub
		
	}
}
