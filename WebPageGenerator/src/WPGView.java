import java.awt.event.ActionListener;

/**
 * View interface.
 *
 * @author Bruce W. Weide
 */
public interface WPGView extends ActionListener {

    /**
     * Register argument as observer/listener of this; this must be done first,
     * before any other methods of this class are called.
     *
     * @param controller
     *            controller to register
     */
    void registerObserver(WPGController controller);

    void getNameString(String name);

    void getOrganizationString(String organization);

    void getSubPagesNameString(String SubPagesName);

    void getSubPagesTextString(String SubPagesText);
}
