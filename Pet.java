import java.util.Random;

public abstract class Pet {
	protected String name;
	protected int Hunger;
	protected int Boredom;
	protected int Tiredness;
	protected int Cleanliness;
	
	public Pet(String nameIn){
		this.name = nameIn;
		this.Hunger = 10;
		this.Boredom = 10;
		this.Tiredness = 10;
		this.Cleanliness = 10;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String valIn){
		this.name = valIn;
	}
	
	public int getInfo(int attribute){
		switch (attribute) {
			case 1: return Hunger;
			case 2: return Boredom;
			case 3: return Tiredness;
			case 4: return Cleanliness;
		}
		return 0;
	}
	
	public void setInfo(int newVal, int attribute){
		switch (attribute) {
			case 1: this.Hunger = newVal;
				break;
			case 2: this.Boredom = newVal;
				break;
			case 3: this.Tiredness = newVal;
				break;
			case 4: this.Cleanliness = newVal;
				break;
		}
	}
	
	public void updatePet(){
		Random rnum = new Random();
		this.Hunger = this.Hunger - rnum.nextInt(3);
		this.Boredom = this.Boredom - rnum.nextInt(2);
		this.Tiredness = this.Tiredness - rnum.nextInt(2);
		this.Cleanliness = this.Cleanliness - rnum.nextInt(2);
	}
	
}
