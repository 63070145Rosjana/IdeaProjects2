package com.example.lab6;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Route(value = "mainPage.it")
public class MainWizardView extends FormLayout {
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;

    private TextField tfFn;
    private TextField tfDl;

    private ComboBox<String> labelComboBox1;
    private ComboBox<String> labelComboBox2;
    private ComboBox<String> labelComboBox3;
    private RadioButtonGroup<String> rd1;
    private Integer number=0;
    @Autowired
    private WizardService wizardService;


    public MainWizardView() {
        btn1 = new Button("<<");
        btn2 = new Button("Create");
        btn3 = new Button("Update");
        btn4 = new Button("Delete");
        btn5 = new Button(">>");

        tfFn = new TextField();
        tfDl = new TextField();
        tfFn.setPlaceholder("Fullname");
        tfDl.setPlaceholder("$");
        tfDl.setLabel("Dollars");

        labelComboBox1 = new ComboBox<>();
        labelComboBox2 = new ComboBox<>();
        labelComboBox3 = new ComboBox<>();
        labelComboBox1.setPlaceholder("Position");
        labelComboBox2.setPlaceholder("School");
        labelComboBox3.setPlaceholder("House");
        labelComboBox1.setItems("Student", "Teacher");
        labelComboBox2.setItems("Hogwarts", "Beauxbatons", "Durmstrang");
        labelComboBox3.setItems("Gryffindor", "Ravenclaw", "Hufflepuff", "Slyther");

        rd1 = new RadioButtonGroup<>();
        rd1.setLabel("Gender:");
        rd1.setItems("male", "female");
        HorizontalLayout hl = new HorizontalLayout();
        VerticalLayout vl1 = new VerticalLayout();
        hl.add(btn1, btn2, btn3, btn4, btn5);
        vl1.add(tfFn, rd1, labelComboBox1, tfDl, labelComboBox2,labelComboBox3, hl);
        this.add(vl1);

        btn1.addClickListener(event ->{
            List<Wizard> out = WebClient.create().get().uri("http://localhost:8080/wizards/")
                    .retrieve().bodyToMono(List.class).block();
            Integer n = wizardService.countWizard();

            ObjectMapper mapper = new ObjectMapper();
            Wizard wizard = mapper.convertValue(out.get(n-1-number), Wizard.class);
            this.number++;
            tfFn.setValue(wizard.getName());
        });
    }

}
