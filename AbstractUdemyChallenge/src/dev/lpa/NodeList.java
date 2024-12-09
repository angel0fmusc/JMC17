package dev.lpa;

public interface NodeList {

    abstract ListItem getRoot();
    abstract boolean addItem(ListItem node);
    abstract boolean removeItem(ListItem node);
    abstract void traverse(ListItem root);
}
