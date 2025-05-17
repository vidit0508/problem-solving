package src.main.java.design.observerpattern;

import src.main.java.design.observerpattern.observable.ProductsObservableImpl;
import src.main.java.design.observerpattern.observable.StockObservable;
import src.main.java.design.observerpattern.observer.EmailNotificationAlertObserver;
import src.main.java.design.observerpattern.observer.MobileNotificationAlertObserver;
import src.main.java.design.observerpattern.observer.NotificationAlertObserver;

public class Store {

    public static void main(String[] args) {
        StockObservable productStockObservable = new ProductsObservableImpl();
        NotificationAlertObserver observer1 = new EmailNotificationAlertObserver("abc@g.com", productStockObservable);
        NotificationAlertObserver observer2 = new EmailNotificationAlertObserver("abc@g.com", productStockObservable);
        NotificationAlertObserver observer3 = new MobileNotificationAlertObserver("abc@g.com", productStockObservable);

        productStockObservable.add(observer1);
        productStockObservable.add(observer2);
        productStockObservable.add(observer3);

        productStockObservable.setStockCount(10);

    }
}
