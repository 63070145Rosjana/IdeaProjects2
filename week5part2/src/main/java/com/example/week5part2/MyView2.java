package com.example.week5part2;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;

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
    protected  Word words = new Word();
    protected WordPublisher wp = new WordPublisher();

    public MyView2() {

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

        tfAddWord.setWidth("500px");
        tfAddSen.setWidth("500px");
        tfShowGood.setWidth("500px");
        tfShowBad.setWidth("500px");
        labelComboBox1.setWidth("500px");
        labelComboBox2.setWidth("500px");
        btnAddGood.setWidth("500px");
        btnAddBad.setWidth("500px");
        btnAddSen.setWidth("500px");
        btnShowSen.setWidth("500px");

        HorizontalLayout hl = new HorizontalLayout();
        VerticalLayout vl1 = new VerticalLayout();
        VerticalLayout vl2 = new VerticalLayout();
        vl1.add(tfAddWord, btnAddGood, btnAddBad, labelComboBox1, labelComboBox2);
        vl2.add(tfAddSen, btnAddSen, tfShowGood, tfShowBad, btnShowSen);
        hl.add(vl1, vl2);
        this.add(hl);

        btnAddGood.addClickListener(event ->{
            String good = tfAddWord.getValue();
            ArrayList<String> out = WebClient.create().get().uri("http://localhost:8080/addGood/"+good)
                    .retrieve().bodyToMono(ArrayList.class).block();
            labelComboBox1.setItems(out);
        });
        btnAddBad.addClickListener(event ->{
            String bad= tfAddWord.getValue();
            ArrayList<String> out = WebClient.create().get().uri("http://localhost:8080/addBad/"+bad)
                    .retrieve().bodyToMono(ArrayList.class).block();
            labelComboBox2.setItems(out);
            System.out.println(bad);
        });
        btnAddSen.addClickListener(event ->{
            String sentence = tfAddSen.getValue();
            System.out.println(sentence);
        });
        btnShowSen.addClickListener(event ->{

            System.out.println("good");
        });

        labelComboBox1.setItems(words.goodWords);
        labelComboBox2.setItems(words.badWords);

    }
}
