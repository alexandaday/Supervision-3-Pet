import java.util.Random;
import java.util.concurrent.TimeUnit;


public class Dog extends Pet implements Contestable{
	private int trickSkill;
	
	public Dog(String nameIn){
		super(nameIn);
		this.trickSkill = 1;
	}
	
	public int getSkill(){
		return trickSkill;
	}
	
	public void setSkill(int skillIn){
		this.trickSkill = skillIn;
	}
	
	public void teach(){
		if (this.trickSkill < 5){
			try{
				TimeUnit.SECONDS.sleep(2);
			}
			catch(InterruptedException e){
				//Will only occur is error with compiler, unlikely
				System.out.println("Your pet had trouble learning");
			}
			System.out.println(this.getName()+" worked hard and learnt a new skill");
			this.trickSkill = this.trickSkill + 1;
			this.Hunger = this.Hunger - 2;
		}
		else{
			System.out.println("Your pet is already an expert");
		}
	}
	
	public int entercontest(){
		System.out.println(this.getName()+" is working hard for you");
		try{
			TimeUnit.SECONDS.sleep(2);
		}
		catch(InterruptedException e){
			//Will only occur is error with compiler, unlikely
			System.out.println("Your pet got bored of waiting");
		}
		Random rnum = new Random();
		this.Tiredness = this.Tiredness -2;
		if (this.trickSkill > rnum.nextInt(6)){
			System.out.println("Congratulations you won the contest and earnt £1");
			return 1;
		}
		else{
			System.out.println("Better luck next time");
			return 0;
		}
	}
}
