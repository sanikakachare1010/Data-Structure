#include<iostream>
using namespace std;

struct node
{
    int data;
    struct node *next;
    struct node *prev;
};

typedef struct node NODE;
typedef struct node* PNODE;

class DoublyLL
{
    public : 
             PNODE head;
             int iCount;

             DoublyLL()
             {
                head = NULL;
                iCount = 0;
             }
    void InsertFirst(int no)
    {
        PNODE newn = NULL;

        newn = new NODE;
        newn->data = no;
        newn->next = NULL;
        newn->prev = NULL;

        if(head == NULL)
        {
            head = newn;

        }
        else
        {
            newn->next = head;
            head->prev = newn;
            head = newn;
        }
        iCount++;
    } 
    void InsertLast(int no)
    {
         PNODE newn = NULL;
         PNODE temp = NULL;

        newn = new NODE;
        newn->data = no;
        newn->next = NULL;
        newn->prev = NULL;

        if(head == NULL)
        {
            head = newn;
        }
        else
        {
            temp = head;
            while (temp->next != NULL)
            {
                temp = temp->next;
            }
            temp->next = newn;
            newn->prev = temp;
            
        }
        iCount++;
    }

    void DeleteFirst()
    {
        if(head == NULL)
        {
            return;
        }
        else if (head->next == NULL)
        {
            delete(head);
            head = NULL;
        }
        else
        {
            head = head->next;
            delete(head->prev);
            head->prev = NULL;
        }
        iCount--;
    }  
    void DeleteLast()
    {
        if(head == NULL)
        {
            return;
        }
        else if (head->next == NULL)
        {
            delete(head);
            head = NULL;
        }
        else
        {
            PNODE temp = NULL;
            
            temp = head;
            while (temp->next->next != NULL)
            {
                temp = temp->next;
            }
            delete(temp->next);
            temp->next = NULL; 
        }
        iCount--;
    } 
    void Display()
    {
        PNODE temp = NULL;

        temp = head;

        while (temp!= NULL)
        {
            cout<<" |"<<temp->data<<"| <=>";
            temp = temp->next;
        }
        cout<<"NULL"<<"\n";
        
    }    
    int Count()
    {
        return iCount;
    }

    void InsertAtPos(int no,int ipos)
    {
        int  i = 0;

        PNODE newn = NULL;
        PNODE temp = NULL;

        newn = new NODE;
        newn->data = no;
        newn->next = NULL;
        newn->prev = NULL;
        
        if((ipos < 1) ||(ipos>iCount + 1))
        {
            cout<<"Invalid position"<<"\n";
            return;
        }

        if(ipos == 1)
        {
            InsertFirst(no);
        }
        else if (ipos == iCount +1)
        {
            InsertLast(no);
        }
        else
        {
            temp = head;
            for ( i = 1; i < ipos-1; i++)
            {
                temp = temp->next;
            }
            newn->next=temp->next;
            temp->next->prev = newn;
            temp->next = newn;
            newn->prev = temp;
            
        }
        iCount++;
    }
    void DeleteAtPos(int ipos)
    {
        int i = 0;

        PNODE temp = NULL;
        PNODE target = NULL;

        if(head == NULL)
        {
            return;
        }
        else if (head->next == NULL)
        {
            delete(head);
            head = NULL;
        }
        else
        {
            temp = head;
            
            for ( i = 1; i < ipos -1; i++)
            {
                temp = temp->next;
            }
            target = temp->next;
            target->prev = temp;
            temp->next = target->next;
            delete(target);

        }
        iCount--;
    }
};
int main()
{
    DoublyLL dobj;
    int iRet = 0;

    dobj.InsertFirst(11);
    dobj.InsertFirst(21);
    dobj.InsertFirst(51);

    dobj.InsertLast(101);
    dobj.InsertLast(111);
    dobj.InsertLast(121);

    dobj.Display();
    iRet = dobj.Count();
    cout<<"Numbers of Elements in LinkedList are : "<<iRet<<"\n";

     dobj.DeleteFirst();

    dobj.Display();
    iRet = dobj.Count();
    cout<<"Numbers of Elements in LinkedList are : "<<iRet<<"\n";

    dobj.DeleteLast();

    dobj.Display();
    iRet = dobj.Count();
    cout<<"Numbers of Elements in LinkedList are : "<<iRet<<"\n";

    dobj.InsertAtPos(45,3);

    dobj.Display();
    iRet = dobj.Count();
    cout<<"Numbers of Elements in LinkedList are : "<<iRet<<"\n";

    dobj.DeleteAtPos(3);

    dobj.Display();
    iRet = dobj.Count();
    cout<<"Numbers of Elements in LinkedList are : "<<iRet<<"\n";
}
