package mainproject;
/*
 * Interface used to implement the Observer Pattern
 * */
public interface Observer {
    public void add(String notification);
    public void update(String notification);
    public void remind(String notification);
    public void paysuccess(String notification);
}



