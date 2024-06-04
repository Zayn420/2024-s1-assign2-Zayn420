package construction;

import java.io.Serializable;

public abstract class Component implements Serializable {
    private static final long serialVersionUID = 1L;

    public abstract void displayDetails();
    public abstract int getDaysRequired();
    public abstract double getCost();
    public abstract String getSummary();
}
