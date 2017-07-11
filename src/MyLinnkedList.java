/**
 * Created by Sarvajna on 11-07-2017.
 */

//Creating a new node without taking user input
class Node{
    Node next;
    int data;


    Node(int d){
        data=d;
        next=null;
    }
}
public class MyLinnkedList {
    public static void main(String[] args) {

        Node head;
        head=new Node(10);

        Node second=new Node(20);
        Node third=new Node(30);

        head.next=second;
        second.next=third;

        Node start=head;
        while(start!=null)
        {
            System.out.print(start.data+"-");
            start=start.next;
        }


    }
}
