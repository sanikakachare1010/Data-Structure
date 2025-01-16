class node
{
    public int data;
    public node next;
   
    public node(int x)
    {
        data = x;
        next = null;
       
    }
}
class SinglyCL
{
    public node head;
    public node tail;
    public int iCount;

   public SinglyCL()
    {
        head = null;
        tail = null;
        iCount = 0;
    }

    public void InsertFirst(int no)
    {
        node newn = new node(no);

        if((head == null) && (tail == null))
        {
            head = newn;
            tail = newn;
        }
        else
        {
           newn.next = head;
           head = newn;
          
        }
        tail.next = head;
        iCount++;

    }
    public void InsertLast(int no)
    {
        node newn = new node(no);
        
        if((head == null) && (tail == null))
        {
            head = newn;
            tail = newn;
        }
        else
        {
            tail.next = newn;
            newn.next = head;
            tail = newn;
        }
        tail.next = head;
        iCount++;
    }
    public void Display()
    {
        node temp = head;

        System.out.println("Elements of LinkedList are :");


        do
        {
            System.out.print("|"+temp.data+"|->");
            temp = temp.next;

        }while(temp != tail.next);

        System.out.println();
    }
    public int Count()
    {
        return iCount;

    }
    public void DeleteFirst()
    {
        if((head == null) && (tail == null))
        {
             return;   
        }
        else if(head == tail)
        {
            head = null;
            tail = null;
        }
        else
        {
            head = head.next;
            tail.next = head;
        }
        System.gc();
        iCount--;
    }
    public void DeleteLast()
    {
        if((head == null) && (tail == null))
        {
             return;   
        }
        else if(head == tail)
        {
            head = null;
            tail = null;
        }
        else
        {
            node temp = head;

            while(temp.next.next != head)
            {
                temp = temp.next;
            }
            temp.next = head;
            tail= temp;
        }
        System.gc();
        iCount--;
    }
    public void InsertAtPos(int no,int ipos)
    {
        if((ipos < 1) || (ipos > iCount +1))
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
            temp.next = newn;
        }
        iCount++;
    }
    public void DeleteAtPos(int ipos)
    {
        if((ipos < 1) || (ipos > iCount))
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
        }
        System.gc();
        iCount--;

    }
}
class program516
{
     public static void main(String Arg[])
     {

         SinglyCL sobj = new SinglyCL();
         int iRet = 0;

         sobj.InsertFirst(11);
         sobj.InsertFirst(21);
         sobj.InsertFirst(51);

         sobj.InsertLast(101);
         sobj.InsertLast(111);
         sobj.InsertLast(121);

         sobj.Display();
         iRet = sobj.Count();
         System.out.println("Number Elements of LinkedList is : "+iRet);

         sobj.DeleteFirst();
         
         sobj.Display();
         iRet = sobj.Count();
         System.out.println("Number Elements of LinkedList is : "+iRet);

         sobj.DeleteLast();

         sobj.Display();
         iRet = sobj.Count();
         System.out.println("Number Elements of LinkedList is : "+iRet);
         
         sobj.InsertAtPos(75, 3);
         
         sobj.Display();
         iRet = sobj.Count();
         System.out.println("Number Elements of LinkedList is : "+iRet);

         sobj.DeleteAtPos(3);

         sobj.Display();
         iRet = sobj.Count();
         System.out.println("Number Elements of LinkedList is : "+iRet);


     }
}
