
/**
 * MancalaTest Class to run the program
 */
public class MancalaTest {

    public static void main(String[] args) {
        Model model = new Model();
        View view = new View(model);
        Controller controller = new Controller(view, model);
    }

}
