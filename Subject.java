
package mainproject;

/*
 * This is the interface for the publisher class.Here we have defined the various methods which will be
 * used to deal with the observers and notifications related to them
 * */

public interface Subject {
    public void registerObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObservers();
    public void addObservers();
    public void remindObservers();
    public void paymentSuccess();
}

