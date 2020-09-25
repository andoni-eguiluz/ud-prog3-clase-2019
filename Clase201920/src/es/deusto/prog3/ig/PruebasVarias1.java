package es.deusto.prog3.ig;

public class PruebasVarias1 {
	// STATIC
	static int miVariableG;
	public static void main(String[] args) {
		b();
		PruebasVarias1 ob1 = new PruebasVarias1();
		ob1.a();
		ob1.c();
		System.out.println( Math.PI * Math.sin( Math.E ) );
	}
	public static void b() {
		
	}
	
	// NO STATIC
	
	int miVariable;
	public void a() {
		PruebasVarias1.b();
	}
	public void c() {
		miVariable = 5;
	}
}
