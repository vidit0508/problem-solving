package src.main.java.design.observerpattern.observer;

import src.main.java.design.observerpattern.observable.StockObservable;

public class EmailNotificationAlertObserver implements NotificationAlertObserver {

    StockObservable stockObservable;
    String userName;

    public EmailNotificationAlertObserver(String userName, StockObservable stockObservable) {
        this.stockObservable = stockObservable;
        this.userName = userName;
    }

    @Override
    public void update() {
        sendEmail(userName, "product is in stock hurry up!");
    }

    private void sendEmail(String userName, String s) {
        System.out.println("email has been sent:" +  userName);
    }
}
