/**
 *
 * @author Jason Xu & Tianyu Xiong
 *
 */
public final class WebPageGenerator {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private WebPageGenerator() {
    }

    /**
     * Main program that sets up main application window and starts user
     * interaction.
     *
     * @param args
     *            command-line arguments; not used
     */
    public static void main(String[] args) {
        /*
         * Create instances of the model, view, and controller objects;
         * controller needs to know about model and view, and view needs to know
         * about controller
         */
        WPGModel model = new WPGModel1();
        WPGView view = new WPGView1();
        WPGController controller = new WPGController1(model, view);

        view.registerObserver(controller);
    }

}
