package com.example.demo;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Route (value = "index1")
public class view01 extends FormLayout {
    private TextField n1, n2;
    private TextArea textArea;
    private Anchor link;
    private Button btnPlus;
    private Button btnMinus;
    private Button btnMulti;
    private Button btnDivide;
    private Button btnMod;
    private Button btnMax;

    public view01() {
        n1 = new TextField("Number 1");
        n2 = new TextField("Number 2");
        textArea = new TextArea("Answer");
        btnPlus = new Button("+");
        btnMinus = new Button("-");
        btnMulti = new Button("*");
        btnDivide = new Button("/");
        btnMod = new Button("Mod");
        btnMax = new Button("Max");
        Label label = new Label("Operator");
        n1.setWidth("510px");
        n2.setWidth("510px");
        textArea.setWidth("510px");
        textArea.getStyle().set("maxHeight", "250px");


        HorizontalLayout hl = new HorizontalLayout();
        VerticalLayout vl = new VerticalLayout();

        hl.add(btnPlus, btnMinus, btnMulti, btnDivide, btnMod, btnMax);
        vl.add(n1,n2, label,hl,textArea);
        this.add(vl);


        btnPlus.addClickListener(event ->{
            double num1 = Double.parseDouble(n1.getValue());
            double num2 = Double.parseDouble(n2.getValue());
            String out = WebClient.create().get().uri("http://localhost:8080/plus/"+num1+"/"+num2)
            .retrieve().bodyToMono(String.class).block();
            textArea.setValue(out);
        });
        btnMinus.addClickListener(event ->{
            double num1 = Double.parseDouble(n1.getValue());
            double num2 = Double.parseDouble(n2.getValue());
            String out = WebClient.create().get().uri("http://localhost:8080/minus/"+num1+"/"+num2)
                    .retrieve().bodyToMono(String.class).block();
            textArea.setValue(out);
        });
        btnMulti.addClickListener(event ->{
            double num1 = Double.parseDouble(n1.getValue());
            double num2 = Double.parseDouble(n2.getValue());
            String out = WebClient.create().get().uri("http://localhost:8080/multi/"+num1+"/"+num2)
                    .retrieve().bodyToMono(String.class).block();
            textArea.setValue(out);
        });
        btnDivide.addClickListener(event ->{
            double num1 = Double.parseDouble(n1.getValue());
            double num2 = Double.parseDouble(n2.getValue());
            String out = WebClient.create().get().uri("http://localhost:8080/divide/"+num1+"/"+num2)
                    .retrieve().bodyToMono(String.class).block();
            textArea.setValue(out);
        });
        btnMod.addClickListener(event ->{
            double num1 = Double.parseDouble(n1.getValue());
            double num2 = Double.parseDouble(n2.getValue());
            String out = WebClient.create().get().uri("http://localhost:8080/mod/"+num1+"/"+num2)
                    .retrieve().bodyToMono(String.class).block();
            textArea.setValue(out);
        });
        btnMax.addClickListener(event ->{
            MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
            formData.add("n1", n1.getValue());
            formData.add("n2", n2.getValue());
            String out = WebClient.create()
                    .post()
                    .uri("http://localhost:8080/max")
                    .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                    .body(BodyInserters.fromFormData(formData))
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            textArea.setValue(out);

        });
    }

}
