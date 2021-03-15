#include<stdio.h>
#include<conio.h>
#include<math.h>
main()
{
    int a, b, c;
    char op;
    //clrscr();
    printf("Enter a and b:");
    scanf("%d%d",&a,&b);
    do
    {
        printf("\n\nMENU\n");
        printf("+ Addition\n");
        printf("- Subtraction\n");
        printf("* Multiplication\n");
        printf("/ Division\n");
        printf("%% Remainder\n");
        printf("E Exit\n");
        printf("Enter your choice :");
        getchar();
        op=getchar();
        if(op=='E'||op=='e')
            exit(1);
        switch(op)
        {
        case '+':
            printf("Addition\n");
            c=a+b;
            printf("Sum=%d\n",c);
            break;
        case '-':
            printf("Subtraction\n");
            c=a-b;
            printf("Difference=%d\n",c);
            break;
        case '*':
            printf("Multiplication\n");
            c=a*b;
            printf("Product=%d\n",c);
            break;

        case '/':
            printf("Division\n");
            c=a/b;
            printf("Quotient=%d\n",c);
            break;
        case '%':
            printf("Remainder\n");
            c=a%b;
            printf("Remainder=%d\n",c);
            break;
        default:
            printf("Invalid Option\n");
            break;
        }   /*end of switch statement*/
    }
    while(1);   /*End of while*/

}/*End of main function*/
