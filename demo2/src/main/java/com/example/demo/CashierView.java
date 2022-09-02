package com.example.demo;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.web.reactive.function.client.WebClient;


@Route(value = "index2")
public class CashierView extends FormLayout {
    private Button btnCal;
    private TextField tfMoney;
    private TextField tfOnetho;
    private TextField tfFivehun;
    private TextField tfOnehun;
    private TextField tfTwenty;
    private TextField tfTen;
    private TextField tFive;
    private TextField tfOne;

    public CashierView(){
        tfMoney = new TextField();
        tfOnetho = new TextField();
        tfFivehun = new TextField();
        tfOnehun = new TextField();
        tfTwenty = new TextField();
        tfTen = new TextField();
        tFive = new TextField();
        tfOne = new TextField();
        btnCal = new Button("คำนวณเงินทอน");

        tfMoney.setLabel("เงินทอน");
        tfMoney.setPlaceholder("$");
        tfOnetho.setPlaceholder("$1000:");
        tfFivehun.setPlaceholder("$500:");
        tfOnehun.setPlaceholder("$100:");
        tfTwenty.setPlaceholder("$20:");
        tfTen.setPlaceholder("$10:");
        tFive.setPlaceholder("$5:");
        tfOne.setPlaceholder("$1:");

        VerticalLayout vl = new VerticalLayout();
        vl.add(tfMoney, btnCal, tfOnetho, tfFivehun,tfOne, tfTwenty, tfTen, tFive, tfOne);
        this.add(vl);
        btnCal.addClickListener(event ->{
            Integer num1 = Integer.valueOf(tfMoney.getValue());

            String out = WebClient.create().get().uri("http://localhost:8080/getChange/"+num1)
                    .retrieve().bodyToMono(String.class).block();
            tfOnetho.setValue(out);
        });
    }
}
