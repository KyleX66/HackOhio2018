import java.awt.event.ActionListener;

/**
 * @author Jason Xu & Tianyu Xiong
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

}
