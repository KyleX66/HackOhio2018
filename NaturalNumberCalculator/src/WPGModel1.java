import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;

/**
 * Model class.
 *
 * @author Jason Xu (xu.2460)
 */
public final class WPGModel1 implements WPGModel {

    /**
     * Model variables.
     */
    private final NaturalNumber top, bottom;

    /**
     * Default constructor.
     */
    public WPGModel1() {
        this.top = new NaturalNumber2();
        this.bottom = new NaturalNumber2();
    }

    @Override
    public NaturalNumber top() {
        return this.top;
    }

    @Override
    public NaturalNumber bottom() {
        return this.bottom;
    }

}
