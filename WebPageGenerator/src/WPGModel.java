import components.map.Map.Pair;
import components.sequence.Sequence;

/**
 * Model interface.
 *
 * The Natural Number Calculator model consists of the top and bottom operands
 * (which have only getter methods).
 *
 * @author Bruce W. Weide
 *
 * @mathmodel <pre>
 * type NNCalcModel is modeled by
 *   (top: NATURAL_NUMBER,
 *    bottom: NATURAL_NUMBER)
 * </pre>
 * @initially <pre>
 * ():
 *  ensures
 *   this = (0, 0)
 * </pre>
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
