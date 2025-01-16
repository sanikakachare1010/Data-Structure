class node
{
    public int data;
    public node next;
    public node prev;

    public node(int no)
    {
        data = no;
        next = null;
        prev = null;
    }
}
class DoublyLL
{
    public node head;
    public int  iCount;

   public DoublyLL()
    {
        head = null;
        iCount = 0;
    }

    public void InsertFirst(int no)
    {
         node newn = new node(no);

         if(head == null)
         {
            head = newn;
         }
         else
         {
            newn.next = head;
            head.prev = newn;
            head = newn;
         }
         iCount++;
    }
    public void InsertLast(int no)
    {
        
        node newn = new node(no);

        if(head == null)
        {
           head = newn;
        }
        else
        {
           node temp = head;

           while(temp.next != null)
           {
              temp = temp.next;
           }
           newn.prev = temp;
           temp.next = newn;
        }
        iCount++;

    }
    public void Display()
    {
        node temp = head;

        System.out.println("Elements of LinkedList are :");
        while(temp != null)
        {
            System.out.print("|"+temp.data+"|<=>");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public int Count()
    {
        return iCount;
    }
    public void DeleteFirst()
    {
        if(head == null)
        {
            return;
        }
        else if(head.next == null)
        {
            head = null;
            System.gc();
        }
        else
        {
            head = head.next;
            head.prev = null;
        }
        System.gc();
        iCount--;
    }
    public void DeleteLast()
    {
        if(head == null)
        {
            return;
        }
        else if(head.next == null)
        {
            head = null;
            System.gc();
        }
        else
        {
           node temp = head;

           while(temp.next.next != null)
           {
              temp = temp.next;
           }
           temp.next = null;
        }
        System.gc();
        iCount--;
    }
    public void InsertAtPos(int no,int ipos)
    {
        if((ipos<1)||(ipos>iCount+1))
        {
            System.out.println("Invalid Position");
            return;
        }

        if(ipos == 1)
        {
            InsertFirst(no);
        }
        else if(ipos == iCount +1)
        {
            InsertLast(no);
        }
        else
        {
            node newn = new node(no);
            node temp = head;
            int i = 0;

            for(i=1;i<ipos-1;i++)
            {
                temp = temp.next;
            }
            newn.next = temp.next;
            temp.next.prev = newn;

            newn.prev = temp;
            temp.next = newn;
        }
        iCount++;
    }
    public void DeleteAtPos(int ipos)
    {
        if((ipos<1)||(ipos>iCount))
        {
            System.out.println("Invalid Position");
            return;
        }

        if(ipos == 1)
        {
            DeleteFirst();
        }
        else if(ipos == iCount)
        {
            DeleteLast();
        }
        else
        {
            node temp = head;
            int i = 0;

            for(i=1;i<ipos-1;i++)
            {
                temp = temp.next;
            }
            temp.next = temp.next.next;
            temp.next.prev = temp;

            System.gc();

            iCount--;
        }
    }
}
class program517 
{
    public static void main(String Arg[])
    {
        DoublyLL dobj = new DoublyLL();
        int iRet = 0;

        dobj.InsertFirst(11);
        dobj.InsertFirst(21);
        dobj.InsertFirst(51);
        dobj.InsertFirst(101);

        dobj.InsertLast(121);
        dobj.InsertLast(151);
        dobj.InsertLast(175);

        dobj.Display();
        iRet = dobj.Count();
        System.out.println("Number of Elements in LinkedList is :"+iRet);

        dobj.DeleteFirst();

        dobj.Display();
        iRet = dobj.Count();
        System.out.println("Number of Elements in LinkedList is :"+iRet);

        dobj.DeleteLast();

        dobj.Display();
        iRet = dobj.Count();
        System.out.println("Number of Elements in LinkedList is :"+iRet);

        dobj.InsertAtPos(75,6);

        dobj.Display();
        iRet = dobj.Count();
        System.out.println("Number of Elements in LinkedList is :"+iRet);

        dobj.DeleteAtPos(3);

        dobj.Display();
        iRet = dobj.Count();
        System.out.println("Number of Elements in LinkedList is :"+iRet);


    }

}
