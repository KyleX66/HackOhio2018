import components.map.Map;
import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;

/**
 * Controller class.
 *
 * @author Jason Xu (xu.2460)
 */
public final class WPGController1 implements WPGController {

    /**
     * Model object.
     */
    private final WPGModel model;

    /**
     * View object.
     */
    private final WPGView view;

    /**
     * Useful constants.
     */
    private static final NaturalNumber TWO = new NaturalNumber2(2),
            INT_LIMIT = new NaturalNumber2(Integer.MAX_VALUE);

    @Override
    void processAddSubPage() {
        sssss
        Map<String, String> subPages = this.model.subPages();
        sss123
    }

}
