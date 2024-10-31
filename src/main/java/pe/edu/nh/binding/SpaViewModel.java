package pe.edu.nh.binding;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Include;

public class SpaViewModel {

    @Wire("#dynamicContent")
    private Include dynamicContent;

    @Command
    public void navigate(@ContextParam(ContextType.TRIGGER_EVENT) org.zkoss.zk.ui.event.Event event) {
    	System.out.println("page");
        String page = (String) event.getData();
        System.out.println("page");
        if (dynamicContent != null) {
            dynamicContent.setSrc(page); // Carga la página seleccionada en el contenedor
        }
    }
}