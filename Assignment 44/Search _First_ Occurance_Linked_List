/*
     Write a program which search first occurrence of particular element from
     singly linear linked list.
     Function  Should return a position at which element is found.
*/
#include<stdio.h>
#include<stdlib.h>

struct node
{
    int data;
    struct node *next;
};

typedef struct node NODE;
typedef struct node* PNODE;
typedef struct node** PPNODE;

void InsertFirst(PPNODE head,int no)
{
     PNODE newn = NULL;

     newn = (PNODE)malloc(sizeof(NODE));
     newn->data = no;
     newn->next = NULL;
    
     if(*head == NULL)
     {
         *head = newn;
     }
     else
     {
         newn->next = *head;
         *head = newn;
     }

}
void InsertLast(PPNODE head,int no)
{
     PNODE newn = NULL;
     PNODE temp = NULL;
     newn = (PNODE)malloc(sizeof(NODE));
     newn->data = no;
     newn->next = NULL;
    
     if(*head == NULL)
     {
         *head = newn;
     }
     else
     {
         temp = *head;

         while (temp->next != NULL)
         {
            temp = temp->next;
         }
         temp ->next = newn;
         
         
     }
}
void Display(PNODE head)
{
    while (head != NULL)
    {
        printf("| %d |->",head->data);
        head = head->next;
    }
    printf("NULL \n");
}
int SearchFirstOcc(PNODE head,int no)
{
    int ipos = 1;

    PNODE temp = NULL;

    temp = head;
    while (temp->data != no)
    {
       ipos++;
       temp = temp->next;
    }
   return ipos; 
} 
int main()
{
    PNODE first = NULL;
    int iRet = 0;

    InsertFirst(&first,11);
    InsertFirst(&first,21);
    InsertFirst(&first,51);

    InsertLast(&first,101);
    InsertLast(&first,111);
    InsertLast(&first,121);

    Display(first);
    iRet = SearchFirstOcc(first,12);
    printf("Element Found At Position : %d",iRet);
    return 0;
}
