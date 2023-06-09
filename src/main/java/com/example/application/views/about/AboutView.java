package com.example.application.views.about;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;

@PageTitle("Accessibility Checker")
@Route(value = "about", layout = MainLayout.class)
public class AboutView extends Main {

    public AboutView() {
        TextField emailField = new TextField();
        emailField.setPlaceholder("Email");
        add(emailField);

        add(new Button("Subscribe to our newsletter", e -> Notification.show("Subscribed")));

        TextField textField = new TextField();
        add(textField);
    }

}
