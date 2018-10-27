import components.sequence.Sequence;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import javafx.util.Pair;

/**
 * @author Jason Xu & Tianyu Xiong
 */
public final class WPGController1 implements WPGController {

    /**
     * Model object.
     */
    private final WPGModel model;

    public WPGController1(WPGModel model, WPGView view) {
        this.model = model;
        /*
         * Update view to reflect initial value of model
         */
    }

    public static void webPageGenerator(String name, String organizaition,
            Sequence<Pair<String, String>> subPages) {
        SimpleWriter output = new SimpleWriter1L(name + ".html");
        output.println("<!DOCTYPE html>");
        output.println("<html lang=\"en\">");
        output.println("<head>");
        output.println("<meta charset=\"UTF-8\">");
        output.println("<title>" + name + "</title>");
        output.println("<style>");
        output.println(
                "#header {\n padding: 1ex 0ex 1ex 3ex;\n  background: #3B6EBF;\n color: #ffffff;\n }");
        output.println(
                "#sidebar {\n line-height:80px;\n background-color:#eeeeee;\n height:1300px;\n width:170px;\n float:left;\n padding:5px;\n font-family: \"sans serif\";\n }");
        output.println(
                "#footer {\n  background-color:yellow;\n color:purple;\n clear:both;\n text-align:center;\n padding:5px;\n }");
        output.println(
                "#maincol {\n  float: right;\n width: 75%;\n padding: 30px 7% 10px 3%;\n border-left: dotted 1px #000099;\n }");
        output.println(" img.bio {\n  float: right;\n  margin: 2ex;/n }");
        output.println("</style>");
        output.println("<script>");
        output.println(
                "function myFunction(){\n  document.getElementById(\"greetings1\").innerHTML=\"Thanks for visiting\";\n}");
        output.println(
                "function clickme() {\n    var obj = document.getElementById(\"bio\");\n  var x = obj.offsetLeft;\n var y = obj.offsetTop;\n x += 10;\n y += 10;\n obj.style.left = x;\n obj.style.top = y;\n }");
        output.println(
                "function show(){\n   setInterval(\"clickme()\",500);\n  }");
        output.println(
                "function disp_alert()\n   {   alert(\"This site is currently under maintenance!\")\n     document.querySelector(\"#out\").addEventListener(\"click\", function(event){\n   event.preventDefault();},false);\n   document.querySelector(\"#out1\").addEventListener(\"click\", function(event){event.preventDefault();},false);\n return;\n}");
        output.println("</script>");
        output.println("</head>");
        output.println("<body onbeforeunload=\"return myFunction1()\">");
        output.println("<div id = \"header\">\n <h1 class = \"title\">" + name
                + "</h1>");
        output.println("<h2 class = \"title\">");
        output.println(organizaition);
        output.println("</h2>");
        output.close();
    }

    @Override
    public void processConfirmEvent(String name, String organization,
            String subPagesName, String subPagesText) {
        this.model.setName(name);
        this.model.setOrganization(organization);
        Pair<String, String> subPagePairs = new Pair<String, String>(
                subPagesName, subPagesText);
        this.model.addSubPages(subPagePairs);
    }

    @Override
    public void processPublishEvent() {
        webPageGenerator(this.model.name(), this.model.organization(),
                this.model.subPages());
    }

}
