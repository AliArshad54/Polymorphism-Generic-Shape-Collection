import java.util.Random;

abstract class Shape {
    public abstract void draw();
}

class Square extends Shape {
    public void draw() {
        System.out.println("Drawing a square");
    }
}

class Rectangle extends Shape {
    public void draw() {
        System.out.println("Drawing a rectangle");
    }
}

class Triangle extends Shape {
    public void draw() {
        System.out.println("Drawing a triangle");
    }
}

class Node {
    private Shape shape;
    private Node next;

    public Node(Shape shape) {
        this.shape = shape;
        this.next = null;
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "shape=" + shape +
                '}';
    }
}

class LinkedList {
    private Node head;

    public LinkedList() {
        this.head = null;
    }

    public LinkedList(Node head) {
        this.head = head;
    }

    public void addNode(Node node) {
        if (head == null) {
            head = node;
            return;
        }
        Node current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(node);
    }

    public void addNode(Shape shape) {
        addNode(new Node(shape));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LinkedList{");
        Node current = head;
        while (current != null) {
            sb.append(current.toString());
            current = current.getNext();
            if (current != null) sb.append(", ");
        }
        sb.append("}");
        return sb.toString();
    }
}

public class Main {

    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        int count = 0;

        while (count < 33) {
            list.addNode(new Square());
            count++;
        }

        count = 0;

        while (count < 33) {
            list.addNode(new Rectangle());
            count++;
        }

        count = 0;

        while (count < 34) {
            list.addNode(new Triangle());
            count++;
        }

        System.out.println(list);

    }
}

