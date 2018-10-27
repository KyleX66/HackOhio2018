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
        this.model.setName(this.model.name());
        this.model.setOrganization(this.model.organization());
    }

    @Override
    public void processPublishEvent() {

    }

}
