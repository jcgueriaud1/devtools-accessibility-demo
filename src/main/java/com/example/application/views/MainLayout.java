package com.example.application.views;

import com.example.application.views.about.AboutView;
import com.example.application.views.helloworld.HelloWorldView;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.dependency.JavaScript;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.theme.lumo.LumoUtility;
import org.vaadin.lineawesome.LineAwesomeIcon;

/**
 * The main view is a top-level placeholder for other views.
 */
@JavaScript("https://unpkg.com/accessibility-checker-engine@latest/ace.js")
public class MainLayout extends AppLayout {

    private H1 viewTitle;

    public MainLayout() {
        setPrimarySection(Section.DRAWER);
        addDrawerContent();
        addHeaderContent();
    }

    private void addHeaderContent() {
        DrawerToggle toggle = new DrawerToggle();
        toggle.setAriaLabel("Menu toggle");

        viewTitle = new H1();
        viewTitle.addClassNames(LumoUtility.FontSize.LARGE);

        Header header = new Header(toggle, viewTitle);
        header.addClassNames(LumoUtility.Display.FLEX, LumoUtility.AlignItems.CENTER);
        addToNavbar(true, header);
    }

    private void addDrawerContent() {
        Span appName = new Span("My App");
        appName.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.SMALL);

        Scroller scroller = new Scroller(createNavigation());

        addToDrawer(appName, scroller, createFooter());
    }

    private SideNav createNavigation() {
        // SideNav is a production-ready official component under a feature flag.
        // However, it has accessibility issues and is missing some features.
        // Both will be addressed in an upcoming minor version.
        // These changes are likely to cause some breaking change to the custom css
        // applied to the component.
        SideNav nav = new SideNav();

        nav.addItem(new SideNavItem("Hello World", HelloWorldView.class, LineAwesomeIcon.GLOBE_SOLID.create()));
        nav.addItem(new SideNavItem("About", AboutView.class, LineAwesomeIcon.FILE.create()));

        return nav;
    }

    private Footer createFooter() {
        Footer layout = new Footer();

        return layout;
    }

    @Override
    protected void afterNavigation() {
        super.afterNavigation();
        viewTitle.setText(getCurrentPageTitle());
    }

    private String getCurrentPageTitle() {
        PageTitle title = getContent().getClass().getAnnotation(PageTitle.class);
        return title == null ? "" : title.value();
    }
}
