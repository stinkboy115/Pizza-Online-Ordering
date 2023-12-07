public class Cart
{
    public Node head, tail;

    //constructor method to create a list of object with head, tail, and size.
    public Cart()
    {
        head = null;//first item at top of cart
        tail = null;//last item in cart
    }

    //method add Node to end of list
    public void addLastNode(Item CartItem)//adds item to bottom of cart
    {
        if (tail == null)
            head = tail = new Node(CartItem); //empty list
        else
        {
            tail.next = new Node(CartItem); //link new Node as last Node
            tail = tail.next; //make tail pointer points to last Node
        }
    }

    public void addFirstNode(Item CartItem)
    {
        Node temp = new Node(CartItem);//temp Node for
        if (head==null)
            head=tail=temp;//if head is empty then the list would be empty and initial pointers for head/tail point to temp.
        else
        {
            temp.next=head;// makes temp point to the old head's value
            head=temp;// head now points to temp as the new first Node.
        }
    }
    public void addAtIndex(int index, Item CartItem){

        if(index==0){//if index is 0 uses addFirstNode to add CartItem to Node.
            addFirstNode(CartItem);
        }
        else if(index==(countNodes())){//uses count method to determine if new Node should be added at end.
            addLastNode(CartItem);
        }
        else{
            Node pointer =head;//create pointer value.
            Node temp = head.next;//value ahead of pointer so that new Node can be inserted between the two.
            for(int x=1;x<index;x++){
                pointer=pointer.next;
                temp=temp.next;//both pointer & temp are shifted in the list enough times to be at the correct indices for the new Node.
            }
            pointer.next=new Node(CartItem);//inserts new Node after current index
            pointer.next.next=temp;//links new Node up to the Node in next index

        }
    }
    public void removeFirstNode()
    {
        head=head.next;//makes first Node point at second Node
    }

    public void removeLastNode()
    {
        Node current=head;
        while(current.next!=tail){//loops until the next Node after current is tail
            current=current.next;
        }
        current.next=null;//removes the pointer to tail
        tail=current;//changes the tail pointer to point to current
    }
    public void removeAtIndex(int index)
    {
        if(index==0){
            removeFirstNode();//calls first node method to remove first
        }
        else if(index==(countNodes()-1)){
            removeLastNode();//calls last node to remove last
        }
        else{
            Node current=head;//creates a Node at head

            for(int x=1;x<index;x++){
                current=current.next;//loops through until before the index value sent
            }
            Node temp=current.next;//temp takes the value after current
            current.next=temp.next;//removes the old current.next value and replaces it with the index after
        }
    }
    public int countNodes()//can be used to find total items in cart
    {
        int listSize= 0;
        Node pointer=head;
        while(pointer!=null){//every time it loops list size counts a new Node, until pointer reaches tail.next which is
            listSize++;      //null and it gets set to it.
            pointer=pointer.next;
        }
        return listSize;

    }
    public void printList()
    {
        Node temp;
        temp = head;
        while (temp != null)
        {
            System.out.print(temp.CartItem + "   ");
            temp = temp.next;
        }
    }
    public String returnReceipt()
    {
        Node temp;
        temp = head;
        String fullList="";
        while(temp!=null) {
            fullList=(fullList+temp.CartItem.itemName+" \t\t$"+ temp.CartItem.getPrice()+" \n");
            temp=temp.next;

        }

        return fullList;//creates a list of all the items
    }
    public double totalPrice(){
        Node temp;
        temp=head;
        double total=0;
        while(temp!=null){

            total+=temp.CartItem.getPrice();
            temp=temp.next;
        }
        return total;
    }
    public void emptyCart(){
        Node temp;
        temp=head;
        while(temp!=null){
            removeFirstNode();
            temp=temp.next;
        }

    }

    //class to create Nodes as objects
    private class Node// nodes hold the item data
    {
        private Item CartItem;  //CartItem field
        private Node next; //link field

        public Node(Item menuItem) //constructor method
        {
            CartItem = menuItem;
            next = null;
        }
    }
}

