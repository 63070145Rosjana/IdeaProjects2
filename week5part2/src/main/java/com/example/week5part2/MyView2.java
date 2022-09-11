package com.example.week5part2;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route(value = "index2")
public class MyView2 extends FormLayout {
    private Button btnAddGood;
    private Button btnAddBad;
    private Button btnAddSen;
    private Button btnShowSen;

    private TextField tfAddWord;
    private TextField tfAddSen;
    private TextField tfShowGood;
    private TextField tfShowBad;

    //คอมโบสามารถsetlabelได้
    private ComboBox<String> labelComboBox1;
    private ComboBox<String> labelComboBox2;

    private TextField tfOne;
    private TextField tfTwo;
    private TextField tfThree;
    private TextField tfFour;
}
