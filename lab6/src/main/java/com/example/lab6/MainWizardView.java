package com.example.lab6;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

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
    private Integer keep=1;
    private Integer keep2=1;
    private Integer check = -1 ;
    private String nameold = "";
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

        rd1 = new RadioButtonGroup<String>();
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
            Integer n = wizardService.countWizard() - 1;
            if(this.number+1 > n+1) {
                this.number = 0;
            } else if (this.number < 0) {
                this.number = n;
            }
            else if(this.number == 0 && this.check != 0){
                this.number = n;
            }
            else if(this.check == 1 ){
                this.number -= 2;
            }
            if(this.number == n+1){
                this.number = 0;
            }
            else  if(this.number < 0){
                this.number = n;
            }
            this.check = 0;
            ObjectMapper mapper = new ObjectMapper();
            Wizard wizard = mapper.convertValue(out.get(this.number), Wizard.class);
            System.out.println("ลบ"+this.number);
            this.number = this.number-this.keep;
            this.nameold = wizard.getName();
            tfFn.setValue(wizard.getName());
            tfDl.setValue(String.valueOf(wizard.getMoney()));
            labelComboBox1.setValue(wizard.getPosition());
            labelComboBox2.setValue(wizard.getSchool());
            labelComboBox3.setValue(wizard.getHouse());
            if(wizard.getSex().equals("m")){
                rd1.setValue("male");
            }else{
                rd1.setValue("female");
            }
        });
        btn5.addClickListener(event ->{
            List<Wizard> out = WebClient.create().get().uri("http://localhost:8080/wizards/")
                    .retrieve().bodyToMono(List.class).block();
            Integer n = wizardService.countWizard()-1;


            ObjectMapper mapper = new ObjectMapper();
            if(this.number+1 > n+1){
                this.number = 0;
            } else if (this.number < 0) {
                this.number = n;

            }else if(this.number == 0){
                this.number = 0;
            } else if (this.check == 0) {
                this.number +=2;
            }
            if(this.number == n+1){
                this.number = 0;
            }
            else  if(this.number < 0){
                this.number = n;
            }
            this.check = 1;

            Wizard wizard = mapper.convertValue(out.get(this.number), Wizard.class);
            System.out.println("บวก" +this.number);
            this.number = this.number+this.keep2;

            this.nameold = wizard.getName();
            tfFn.setValue(wizard.getName());
            tfDl.setValue(String.valueOf(wizard.getMoney()));
            labelComboBox1.setValue(wizard.getPosition());
            labelComboBox2.setValue(wizard.getSchool());
            labelComboBox3.setValue(wizard.getHouse());
            if(wizard.getSex().equals("m")){
                rd1.setValue("male");
            }else{
                rd1.setValue("female");
            }
        });
        btn2.addClickListener(event ->{
            Wizard formData = new Wizard(null, rd1.getValue(), tfFn.getValue(), labelComboBox2.getValue(), labelComboBox3.getValue(), Integer.valueOf(tfDl.getValue()), labelComboBox1.getValue());

            Wizard out = WebClient.create()
                    .post()
                    .uri("http://localhost:8080/addWizard")
                    .body(Mono.just(formData), Wizard.class)
                    .retrieve()
                    .bodyToMono(Wizard.class)
                    .block();
            new Notification("Wizard has bee create", 5000).open();

        });
        btn3.addClickListener(event ->{
            System.out.println(this.nameold);
            MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
            formData.add("namenew", tfFn.getValue());
            formData.add("nameold", this.nameold);
            formData.add("money", tfDl.getValue());
            formData.add("sex", rd1.getValue());
            formData.add("position", labelComboBox1.getValue());
            formData.add("school", labelComboBox2.getValue());
            formData.add("house", labelComboBox3.getValue());

            Boolean out = WebClient.create()
                    .post()
                    .uri("http://localhost:8080/updateWizard")
                    .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                    .body(BodyInserters.fromFormData(formData))
                    .retrieve()
                    .bodyToMono(Boolean.class)
                    .block();

            new Notification("Wizard has bee update", 5000).open();

        });
        btn4.addClickListener(event ->{
            System.out.println(this.nameold);
            MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
            formData.add("name", tfFn.getValue());
            formData.add("money", tfDl.getValue());
            formData.add("sex", rd1.getValue());
            formData.add("position", labelComboBox1.getValue());
            formData.add("school", labelComboBox2.getValue());
            formData.add("house", labelComboBox3.getValue());

            Boolean out = WebClient.create()
                    .post()
                    .uri("http://localhost:8080/deleteWizard")
                    .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                    .body(BodyInserters.fromFormData(formData))
                    .retrieve()
                    .bodyToMono(Boolean.class)
                    .block();

            new Notification("Wizard has bee Delete", 5000).open();

        });
    }

}
