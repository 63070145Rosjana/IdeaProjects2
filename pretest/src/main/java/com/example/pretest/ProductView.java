package com.example.pretest;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.web.reactive.function.client.WebClient;


@Route(value = "index2")
public class ProductView extends FormLayout {
    private Button add;
    private Button update;
    private Button del;
    private Button clear;

    private TextField pdn;
    private NumberField pdc;
    private NumberField pdprofit;
    private NumberField pdprice;


    private ComboBox cb;

    public ProductView() {
        add = new Button("Add Product");
        update = new Button("Update Product");
        del = new Button("Delete Product");
        clear = new Button("Clear Product");

        pdn = new TextField("Product Name:");
        pdc = new NumberField("Product Cost:");
        pdprofit = new NumberField("Product Profit:");
        pdprice = new NumberField("Product Price");

        cb = new ComboBox<>("Product List");

        pdn.setWidth("600px");
        pdc.setWidth("600px");
        pdprofit.setWidth("600px");
        pdprice.setWidth("600px");
        cb.setWidth("600px");

        pdc.setValue(0.0);
        pdprofit.setValue(0.0);
        pdn.setValue("");
        pdprice.setValue(0.0);
        pdprice.setEnabled(false);
        HorizontalLayout hl = new HorizontalLayout();
        VerticalLayout vl1 = new VerticalLayout();
        hl.add(add, update, del, clear);
        vl1.add(cb, pdn, pdc, pdprofit, pdprice, hl);
        this.add(vl1);

        pdc.addKeyPressListener(keyPressEvent ->{
            String keep = keyPressEvent.getCode().get().toString();
            Double num1 = pdc.getValue();
            Double num2 = pdprofit.getValue();
            if(keep.equals("Enter")){
                String out = WebClient.create().get().uri("http://localhost:8080/getPrice/"+num1+"/"+num2)
                        .retrieve().bodyToMono(String.class).block();
                pdprice.setValue(Double.valueOf(out));
            }

        });
        pdprofit.addKeyPressListener(keyPressEvent ->{
            String keep = keyPressEvent.getCode().get().toString();
            Double num1 = pdc.getValue();
            Double num2 = pdprofit.getValue();
            if(keep.equals("Enter")){
                String out = WebClient.create().get().uri("http://localhost:8080/getPrice/"+num1+"/"+num2)
                        .retrieve().bodyToMono(String.class).block();
                pdprice.setValue(Double.valueOf(out));
            }

        });


    }
}
