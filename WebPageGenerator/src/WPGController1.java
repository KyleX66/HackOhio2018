import javafx.util.Pair;

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

    public WPGController1(WPGModel model, WPGView view) {
        this.model = model;
        /*
         * Update view to reflect initial value of model
         */
    }

    @Override
    public void processConfirmEvent(String name, String organization,
            String subPagesName, String subPagesText) {
        this.model.setName(name);
        this.model.setOrganization(organization);
        Pair<String, String> subPagePairs = new Pair<String, String>(
                subPagesName, subPagesText);
        this.model.addSubPages(subPagePairs);
    }

    @Override
    public void processPublishEvent() {
        System.out.println(this.model.name());
        System.out.println(this.model.organization());
        System.out.println(this.model.subPages());
    }

}
