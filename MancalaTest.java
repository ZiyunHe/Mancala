
public class MancalaTest {

	public static void main(String[] args) {
		
		Model model = new Model();

		new Controller(new View(model), model);

	}

}
