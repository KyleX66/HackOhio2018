/**
 * @author Jason Xu & Tianyu Xiong
 */
public interface WPGController {

    void processConfirmEvent(String name, String organization,
            String subPagesName, String subPagesText);

    void processPublishEvent();

}
