package com.example.application.views.hello;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Hello")
@Route("hello")
public class Hello extends VerticalLayout {

    public Hello() {
        add(new Span("Hello mannen!"), new Button("go back to main", click -> getUI().ifPresent(ui -> ui.navigate(""))));
    }
}
