package maven;

public class MavenTest {

	public static void main(String[] args) {
		
		new MavenTest().test();
		

	}
	
	public void test() {
		String version = getClass().getPackage().getImplementationVersion();
		System.out.println(version);
	}

}
