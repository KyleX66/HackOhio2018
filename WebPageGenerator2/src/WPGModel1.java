
import components.sequence.Sequence;
import components.sequence.Sequence1L;
import javafx.util.Pair;

/**
 * @author Jason Xu & Tianyu Xiong
 */
public final class WPGModel1 implements WPGModel {

    private String name, organization;
    private Sequence<Pair<String, String>> subPages;

    /**
     * Default constructor.
     */
    public WPGModel1() {
        this.name = "";
        this.organization = "";

        this.subPages = new Sequence1L<Pair<String, String>>();
    }

    @Override
    public String name() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String organization() {
        return this.organization;
    }

    @Override
    public void setOrganization(String organization) {
        this.organization = organization;
    }

    @Override
    public Sequence<Pair<String, String>> subPages() {
        return this.subPages;
    }

    @Override
    public void addSubPages(Pair<String, String> subPairs) {
        this.subPages.add(this.subPages.length(), subPairs);
    }
}
