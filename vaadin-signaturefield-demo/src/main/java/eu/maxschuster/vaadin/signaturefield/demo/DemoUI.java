package eu.maxschuster.vaadin.signaturefield.demo;

import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.BrowserWindowOpener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;

import javax.servlet.annotation.WebServlet;

@Theme("demo")
@PreserveOnRefresh
public class DemoUI extends UI {

    private static final long serialVersionUID = 1L;

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(
            productionMode = true,
            ui = DemoUI.class,
            widgetset = "com.adms.signaturefield.demo.DemoWidgetSet"
    )
    public static class Servlet extends VaadinServlet {

        private static final long serialVersionUID = 1L;

    }

    private final DemoUILayout l = new DemoUILayout();

    @Override
    protected void init(VaadinRequest request) {
        setContent(l);
        l.signatureField.setBackgroundColor("rgba(255,255,255, 1)");
        l.signatureField.setPenColor("rgba(18, 10, 143, 1)");
        l.clearButton.addClickListener(e -> l.signatureField.clear());

        final BrowserWindowOpener saveOpener = new BrowserWindowOpener("");
        saveOpener.setWindowName("_blank");
        saveOpener.extend(l.saveButton);
    }
}
