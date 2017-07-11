import java.util.Scanner;

/**
 * Created by Sarvajna on 11-07-2017.
 */
class Node2{
    Node2 next;
    int data;


    Node2(int d){
        data=d;
        next=null;
    }
}


public class MyLinkedList2 {
    static Node2 insert(int element, Node2 head){
        Node2 newNode,headCopy;
        headCopy=head;
        newNode=new Node2(element);
        if(head==null)
        {
            head=newNode;

        }else{
            while(headCopy.next!=null)
            {
                headCopy=headCopy.next;
            }
            headCopy.next=newNode;
        }

        return head;
    }

    public static void main(String[] args) {
        Node2 head = null;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of nodes to insert");

        int N=sc.nextInt();

        for(int i=0;i<N;i++)
        {
            int element=sc.nextInt();
            head=insert(element,head);
        }

        display(head);

        int choice=0;
        while (choice!=10)
        {
            System.out.println();
            System.out.println("1.Insert a node in front");
            System.out.println("2.Insert a node after ");
            System.out.println("3.Delete a node");
            System.out.println("4.Remove duplicate elements ");
            System.out.println("10.Exit");
            choice=sc.nextInt();
            switch (choice)
            {
                case 1:head=insertFront(head);
                        display(head);
                        break;
                case 2:head=insertAfter(head);
                        display(head);
                        break;
                case 3:head=delete(head);
                        display(head);
                        break;
                case 4:head=removeDuplicate(head);
                        System.out.println("Duplicate items removed");
                        display(head);
                        break;
                case 10:System.out.println("Finished");
                        break;
            }
        }
    }

    private static Node2 removeDuplicate(Node2 head) {
        Node2 ptr=head;
        Node2 prev=ptr;
        if(head==null)
            return head;
        ptr=ptr.next;
        while(prev.next!=null)
        {
            if(prev.data==ptr.data)
            {
                prev.next=ptr.next;
                ptr=ptr.next;
            }
            else
            {
                ptr=ptr.next;
                prev=prev.next;
            }
        }
        return head;
    }

    private static Node2 delete(Node2 head) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the node to delete");
        int delEle=sc.nextInt();

        Node2 ptr=head;
        Node2 prev=ptr;
        while (ptr.next!=null)
        {
            if(ptr.data==delEle)
            {

            }
            else
            {
                ptr=ptr.next;
            }

        }


        return head;
    }

    private static Node2 insertAfter(Node2 head) {
        Scanner sc=new Scanner(System.in);

        System.out.println("After which node ?");
        int n=sc.nextInt();
        Node2 check=head;
        int flag=0;
        //To check if the node exists
        while(check.next!=null)
        {
            if(check.data==n) {
                flag=1;
                break;
            }
            else{
                check=check.next;
            }

        }
        if(flag==0){
            System.out.println("No such element present in list");
            return head;
        }



        System.out.println("Enter the node to insert");
        int insertElement=sc.nextInt();

        Node2 afterNode=new Node2(insertElement);
        Node2 headCopy=head;

        while(head.next!=null)
        {
            if(headCopy.data==n)
            {
                break;
            }else
            {
                headCopy=headCopy.next;
            }

        }

        afterNode.next=headCopy.next;
        headCopy.next=afterNode;



        return head;
    }

    private static void display(Node2 head) {
        System.out.println("Your linked list is");
        Node2 start=head;
        while(start!=null)
        {
            System.out.print(start.data+"-");
            start=start.next;
        }
    }

    private static Node2 insertFront(Node2 head) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter node to insert at front");
        int frontElem=sc.nextInt();
        Node2 frontNode=new Node2(frontElem);
        frontNode.next=head;
        head=frontNode;
        return frontNode;
    }
}
