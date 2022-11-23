package com.example.application.views.main;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.shared.Registration;

@PageTitle("Todo")
@Route(value = "")
public class MainView extends HorizontalLayout {
    private VerticalLayout todosList;
    private TextField taskField;
    private Button addButton;
    private Button removeAllbutton;
    private Registration registration;
    private Button goToHelloView;

    public MainView() {
        // styling
        //getStyle().set("background-color", "azure");

        setContent();
        setListeners();

        add(
                new H1("Vaadin Todo"),
                todosList,
                new HorizontalLayout(
                        taskField,
                        addButton,
                        removeAllbutton,
                        goToHelloView
                )
        );
    }

    private void setContent() {
        todosList = new VerticalLayout();
        taskField = new TextField();
        addButton = new Button("Add");
        removeAllbutton = new Button("Remove All");
        goToHelloView = new Button("Go to hello");
    }

    private void setListeners() {
        addButton.addClickListener(click -> addCheckBox());
        taskField.addFocusListener(focus -> registration = taskField.addKeyUpListener(Key.ENTER, keyUpEvent -> addCheckBox()));
        taskField.addFocusListener(focus -> taskField.setAutoselect(true));
        taskField.addBlurListener(blur -> registration.remove());
        removeAllbutton.addClickListener(click -> todosList.removeAll());
        goToHelloView.addClickListener(click -> UI.getCurrent().navigate("hello"));
    }

    private void addCheckBox() {
        Checkbox checkbox = new Checkbox(taskField.getValue());
        todosList.add(checkbox);
    }

}
