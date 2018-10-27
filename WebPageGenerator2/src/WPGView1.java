import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

/**
 * @author Jason Xu & Tianyu Xiong
 */
@SuppressWarnings("serial")
public final class WPGView1 extends JFrame implements WPGView {

    /**
     * Controller object registered with this view to observe user-interaction
     * events.
     */
    private WPGController controller;

    /**
     * State of user interaction: last event "seen".
     */
    private enum State {
        /**
         * Last event was clear, enter, another operator, or digit entry, resp.
         */
        SAW_CONFIRM, SAW_PUBLISH;
    }

    /**
     * State variable to keep track of which event happened last; needed to
     * prepare for digit to be added to bottom operand.
     */
    private State currentState;

    /**
     * Text areas.
     */
    private final JTextArea name, organization, subPagesName, subPagesText;

    /**
     * Operator and related buttons.
     */
    private final JButton bConfirm, bPublish;

    /**
     * Useful constants.
     */
    private static final int TEXT_AREA_HEIGHT = 10, TEXT_AREA_WIDTH = 20;

    /**
     * Default constructor.
     */
    public WPGView1() {
        // Create the JFrame being extended

        /*
         * Call the JFrame (superclass) constructor with a String parameter to
         * name the window in its title bar
         */
        super("WebPageGenerator");

        // Set up the GUI widgets --------------------------------------------

        /*
         * Set up initial state of GUI to behave like last event was "Clear";
         * currentState is not a GUI widget per se, but is needed to process
         * digit button events appropriately
         */
        this.currentState = State.SAW_CONFIRM;
        /*
         * Create widgets
         */
        this.name = new JTextArea("input your name here", TEXT_AREA_HEIGHT,
                TEXT_AREA_WIDTH);
        this.organization = new JTextArea("input your organization",
                TEXT_AREA_HEIGHT, TEXT_AREA_WIDTH);
        this.subPagesName = new JTextArea("input your subPagesName",
                TEXT_AREA_HEIGHT, TEXT_AREA_WIDTH);
        this.subPagesText = new JTextArea("input your subPagesText",
                TEXT_AREA_HEIGHT, TEXT_AREA_WIDTH);

        this.bConfirm = new JButton("Confirm");
        this.bPublish = new JButton("PUBLISH!");

        // Set up the GUI widgets --------------------------------------------

        /*
         * Text areas should wrap lines, and should be read-only; they cannot be
         * edited because allowing keyboard entry would require checking whether
         * entries are digits, which we don't want to have to do
         */
        this.name.setEditable(true);
        this.name.setLineWrap(true);
        this.name.setWrapStyleWord(true);

        this.organization.setEditable(true);
        this.organization.setLineWrap(true);
        this.organization.setWrapStyleWord(true);

        this.subPagesName.setEditable(true);
        this.subPagesName.setLineWrap(true);
        this.subPagesName.setWrapStyleWord(true);

        this.subPagesText.setEditable(true);
        this.subPagesText.setLineWrap(true);
        this.subPagesText.setWrapStyleWord(true);

        /*
         * Create scroll panes for the text areas in case number is long enough
         * to require scrolling
         */
        JScrollPane inputTextScrollPaneName = new JScrollPane(this.name);
        JScrollPane inputTextScrollPaneOrganization = new JScrollPane(
                this.organization);
        JScrollPane inputTextScrollPaneSubPagesName = new JScrollPane(
                this.subPagesName);
        JScrollPane inputTextScrollPaneSubPagesText = new JScrollPane(
                this.subPagesText);

        /*
         * Set up Layout
         */

        this.getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        JLabel heading = new JLabel("Heading Editor");
        JLabel subPages = new JLabel("SubPages Editor");

        heading.setBorder(new LineBorder(Color.gray, 2));
        subPages.setBorder(new LineBorder(Color.gray, 2));

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.insets = new Insets(5, 0, 0, 0);
        this.getContentPane().add(heading, constraints);

        constraints.fill = GridBagConstraints.VERTICAL;
        JPanel headingTextPanel = new JPanel(new FlowLayout());
        headingTextPanel.add(inputTextScrollPaneName);
        headingTextPanel.add(inputTextScrollPaneOrganization);
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        this.getContentPane().add(headingTextPanel, constraints);

        constraints.fill = GridBagConstraints.VERTICAL;
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        this.getContentPane().add(subPages, constraints);

        constraints.fill = GridBagConstraints.VERTICAL;
        JPanel subPagesTextPanel = new JPanel(new FlowLayout());
        subPagesTextPanel.add(inputTextScrollPaneSubPagesName);
        subPagesTextPanel.add(inputTextScrollPaneSubPagesText);
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        this.getContentPane().add(subPagesTextPanel, constraints);

        constraints.fill = GridBagConstraints.VERTICAL;
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(this.bConfirm);
        buttonPanel.add(this.bPublish);
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        this.getContentPane().add(buttonPanel, constraints);

        // Set up the observers ----------------------------------------------

        /*
         * Register this object as the observer for all GUI events
         */
        this.bConfirm.addActionListener(this);
        this.bPublish.addActionListener(this);

        // Set up the main application window --------------------------------

        /*
         * Make sure the main window is appropriately sized, exits this program
         * on close, and becomes visible to the user
         */
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        /*
         * Set cursor to indicate computation on-going; this matters only if
         * processing the event might take a noticeable amount of time as seen
         * by the user
         */
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        /*
         * Determine which event has occurred that we are being notified of by
         * this callback; in this case, the source of the event (i.e, the widget
         * calling actionPerformed) is all we need because only buttons are
         * involved here, so the event must be a button press; in each case,
         * tell the controller to do whatever is needed to update the model and
         * to refresh the view
         */
        Object source = event.getSource();
        if (source == this.bConfirm) {
            this.controller.processConfirmEvent(this.name.getText(),
                    this.organization.getText(), this.subPagesName.getText(),
                    this.subPagesText.getText());
            this.currentState = State.SAW_CONFIRM;
        } else if (source == this.bPublish) {
            this.controller.processPublishEvent();
            this.currentState = State.SAW_PUBLISH;
        }

        /*
         * Set the cursor back to normal (because we changed it at the beginning
         * of the method body)
         */
        this.setCursor(Cursor.getDefaultCursor());
    }

    @Override
    public void registerObserver(WPGController controller) {
        this.controller = controller;

    }
}
