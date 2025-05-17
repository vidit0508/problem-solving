package src.main.java.design.observerpattern.observer;

import src.main.java.design.observerpattern.observable.StockObservable;

public class MobileNotificationAlertObserver implements NotificationAlertObserver {

    StockObservable observable;
    String userName;

    public MobileNotificationAlertObserver(String emailId, StockObservable observable) {
        String userName = emailId;
        this.observable = observable;
    }

    @Override
    public void update() {
        sendMessageOnMobile(userName, "product is in stock hurry up!!");
    }

    private void sendMessageOnMobile(String userName, String s) {
        System.out.println("message sent to: " + userName);
    }
}
