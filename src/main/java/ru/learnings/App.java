package ru.learnings;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import ru.learnings.configs.HibernateConfig;
import ru.learnings.configs.WebConfig;

public class App extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class[] getRootConfigClasses() {
        return new Class[]{HibernateConfig.class};
    }

    @Override
    protected Class[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

}
