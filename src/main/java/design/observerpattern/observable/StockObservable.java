package src.main.java.design.observerpattern.observable;

import src.main.java.design.observerpattern.observer.NotificationAlertObserver;

public interface StockObservable {

    void add(NotificationAlertObserver notificationAlertObserver);

    void remove(NotificationAlertObserver notificationAlertObserver);

    void notifySubscriber();

    void setStockCount(int newStockAdded);

    int getStockCount();
}
