import java.util.Random;
import java.util.concurrent.TimeUnit;


public class Fish extends Pet implements Showable{

	public Fish(String nameIn){
		super(nameIn);
		this.Cleanliness = 5;
	}
	
	public void admire(){
		System.out.println(this.getName()+" looks great");
	}
	
	public int doShow(){
		System.out.println(this.getName()+" is in its display tank for tips");
		try{
			TimeUnit.SECONDS.sleep(2);
		}
		catch(InterruptedException e){
			//Will only occur is error with compiler, unlikely
			System.out.println("Your pet got bored of waiting");
		}
		Random rnum = new Random();
		this.Hunger = this.Hunger -2;
		int tips = rnum.nextInt(2)*rnum.nextInt(3);
		System.out.println("You made £"+tips+" in tips");
		return tips;
	}
	
	//You can't and don't need to wash a fish
	@Override
	public void updatePet(){
		Random rnum = new Random();
		this.Hunger = this.Hunger - rnum.nextInt(3);
		this.Boredom = this.Boredom - rnum.nextInt(2);
		this.Tiredness = this.Tiredness - rnum.nextInt(2);
	}
}
