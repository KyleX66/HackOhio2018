/**
 * Controller interface.
 *
 * @author Bruce W. Weide
 *
 * @mathmodel <pre>
 * type NNCalcController is modeled by
 *   (model: NNCalcModel,
 *    view: NNCalcView)
 * </pre>
 * @initially <pre>
 * (NNCalcModel model, NNCalcView view):
 *   ensures
 *     this.model = model  and
 *     this.view = view
 * </pre>
 */
public interface WPGController {

    void processNameEvent();

    void processOrganizationEvent();

    void processSubPagesNameEvent();

    void processSubPagesTextEvent();

}
