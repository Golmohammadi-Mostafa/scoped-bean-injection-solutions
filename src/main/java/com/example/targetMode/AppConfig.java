package com.example.targetMode;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

@Configuration
public class AppConfig {


    @Bean
 //   @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public MyPrototypeBean prototypeBean() {
        return new MyPrototypeBean();
    }

    @Bean
    public MySingletonBean singletonBean() {
        return new MySingletonBean();
    }

    public static void main(String[] args) throws InterruptedException {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MySingletonBean bean1 = context.getBean(MySingletonBean.class);
        MySingletonBean bean2 = context.getBean(MySingletonBean.class);
        MySingletonBean bean3 = context.getBean(MySingletonBean.class);
        MyPrototypeBean myPrototypeBean = context.getBean(MyPrototypeBean.class);
        Thread.sleep(500);
        bean1.showMessage();
        Thread.sleep(500);
        bean2.showMessage();   // or  bean1.showMessage();
        Thread.sleep(500);
        bean3.showMessage();  //  or  bean1.showMessage();
        Thread.sleep(500);
        System.out.println(myPrototypeBean.getDateTime());
    }
}