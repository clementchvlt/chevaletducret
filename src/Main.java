

public class Main {
	public static void main(String[] args) {
		Heros h= new Heros("Jaina",15, "cyprine acide");
		System.out.println(h.toString());
		Heros g=new Heros("Rexxar",15, "coup de teub");
		System.out.println(g.toString());
		Serviteur s= new Serviteur ("clem",  69, 69, 69);
		System.out.println(s.toString());
		Serviteur z= new Serviteur ("clem",  69, 69, 69);
		System.out.println(z.toString());
		if (s.equals(z))
			System.out.println("c les mêmes");
		else
			System.out.println("c pas les mêmes");
	
		Sorts sort= new Sorts("superCaca", 70, "eclaboussure");
		System.out.println(sort.toString());
		
	
	}
}