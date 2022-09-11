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


    public MyView2(){
        btnAddGood = new Button("Add Good Words");
        btnAddBad = new Button("Add Bad Words");
        btnAddSen = new Button("Add Sentence");
        btnShowSen = new Button("Show Sentence");
        tfAddWord = new TextField();
        tfAddSen = new TextField();
        tfShowGood = new TextField();
        tfShowBad = new TextField();
        labelComboBox1 = new ComboBox<>();
        labelComboBox2 = new ComboBox<>();

        tfAddWord.setLabel("Add word");
        tfAddSen.setLabel("Add Sentence");
        tfShowGood.setLabel("Good Sentences");
        tfShowBad.setLabel("Bad Sentences");
        labelComboBox1.setLabel("Good Words");
        labelComboBox2.setLabel("Bad Words");
    }
}
