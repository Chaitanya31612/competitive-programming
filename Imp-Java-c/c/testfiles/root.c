#include <stdio.h>
#include <math.h>
void main()
{
    float a , b , c , x1 , x2 , D;
    printf("Enter roots of equation ax2+bx+c");
    scanf("%f%f%f",&a,&b,&c);
    D = b*b - 4*a*c;
    if(D>0){
        x1 = (-b + sqrt(D))/(2*a);
        x2 = (-b - sqrt(D))/(2*a);
        printf("The roots are real and are %f and %f",x1,x2);
    }
    else if(D==0){
        x1 = -b/(2*a);
        printf("The roots are real and equal i.e %f",x1);
    }
    else
        printf("The roots are imaginary");

}
