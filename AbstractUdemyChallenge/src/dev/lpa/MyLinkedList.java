package dev.lpa;

public class MyLinkedList implements NodeList {
    private ListItem root;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return root;
    }

    @Override
    public boolean addItem(ListItem node) {
        if(root == null){
            root = node;
            return true;
        }

        ListItem current = root;

        while(true){
            if(current.compareTo(node) == 0){ // items are the same
                return false;
            }
            if(current.compareTo(node) == 1){ // current node is larger than new node
                root = node;
                root.setNext(current);
                current.setPrevious(root);
                return true;
            }

            if(current.compareTo(node) == -1){ // current node is smaller than new node
                // traverse right
                if(current.next() == null){
                    root.setNext(node);
                    node.setNext(root);
                    return true;
                }
            }
            current = current.next();
        }
    }

    @Override
    public boolean removeItem(ListItem node) {
        if(root == null || node == null){
            return false;
        }

        ListItem current = root;

        while(true){
            // If the item to be removed is the root, set to null
            if(node.compareTo(root) == 0){
                if(current == root){
                    root = (current.next() == null) ? null : current.next();
                    return true;
                }
                else if(current.next() == null){
                    current.previous().setNext(null);
                    return true;
                }

                current.previous().setNext(current.next());
                current.next().setPrevious(current.previous());
                return true;
            } else if (current.compareTo(node) == 1) {
                return false;
            }
            current = current.next();
            if(current == null){
                return false;
            }
        }
    }

    @Override
    public void traverse(ListItem root) {
        if(root == null){
            System.out.print("The list is empty");
        }

        while(root != null){
            System.out.println(root.getValue());
            root = root.next();
        }

    }
}
