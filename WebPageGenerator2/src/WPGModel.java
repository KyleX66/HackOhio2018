
import components.sequence.Sequence;
import javafx.util.Pair;

/**
 * @author Jason Xu & Tianyu Xiong
 */
public interface WPGModel {

    /* Title */
    String name();

    void setName(String name);

    String organization();

    void setOrganization(String organization);

    /* Sub */
    Sequence<Pair<String, String>> subPages();

    void addSubPages(Pair<String, String> subPairs);

}
