package com.example.demo;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;



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
    }
}
