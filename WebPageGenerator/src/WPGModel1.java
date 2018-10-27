import components.map.Map.Pair;
import components.sequence.Sequence;
import components.sequence.Sequence1L;

/**
 * Model class.
 *
 * @author Jason Xu (xu.2460)
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
