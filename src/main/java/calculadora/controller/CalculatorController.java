package calculadora.controller;

import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class CalculatorController extends GenericForwardComposer<Window> {

    @Wire
    private Textbox resultTextbox;

    private StringBuilder currentInput = new StringBuilder();
    private String lastOperation = "";
    private double lastValue = 0;

    @Listen("onClick = button")
    public void onNumberClick(String number) {
        currentInput.append(number);
        resultTextbox.setValue(currentInput.toString());
    }

    @Listen("onClick = #operationButton")
    public void onOperationClick(String operation) {
        if (currentInput.length() > 0) {
            lastValue = Double.parseDouble(currentInput.toString());
            lastOperation = operation;
            currentInput.setLength(0); // Clear input for next number
        }
    }

    @Listen("onClick = #calculateButton")
    public void onCalculate() {
        if (currentInput.length() > 0 && !lastOperation.isEmpty()) {
            double currentValue = Double.parseDouble(currentInput.toString());
            double result = 0;

            switch (lastOperation) {
                case "+":
                    result = lastValue + currentValue;
                    break;
                case "-":
                    result = lastValue - currentValue;
                    break;
                case "*":
                    result = lastValue * currentValue;
                    break;
                case "/":
                    result = lastValue / currentValue;
                    break;
            }
            resultTextbox.setValue(String.valueOf(result));
            currentInput.setLength(0); // Clear input after calculation
            lastOperation = ""; // Clear last operation
        }
    }

    @Listen("onClick = #clearButton")
    public void onClear() {
        currentInput.setLength(0);
        resultTextbox.setValue("");
        lastOperation = "";
        lastValue = 0;
    }
}
