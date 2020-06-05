SignatureField
==============
Forked from Max Schuster

A Vaadin Field&lt;String&gt; to capture signatures.
Its value is the data url from the html canvas as simple String.
[signature_pad](https://github.com/szimek/signature_pad) by Szymon Nowak is used
to capture the signature at the client-side.

## Requirements
* Vaadin 8.8+

## Usage
### Simple
``` java
import com.adms.core.signaturefield.SignatureField;
import com.vaadin.ui.Button;
import com.vaadin.ui.VerticalLayout;

public class TestSignatureField extends VerticalLayout {
    private final SignatureField sign;
    private String currentSign = null;

    public TestSignatureField() {
        sign = new SignatureField();
        sign.setWidth(300, Unit.PIXELS);
        sign.setHeight(200, Unit.PIXELS);
        sign.setCaption("New signature");
        sign.addValueChangeListener(event -> currentSign = event.getValue());
        Button clear = new Button("refresh");
        clear.addClickListener(onClick -> sign.clear());
        addComponents(sign, clear);
    }
}
```

## Licence
* SignatureField Add-on: Apache License Version 2.0
* [signature_pad](https://github.com/szimek/signature_pad): MIT License
