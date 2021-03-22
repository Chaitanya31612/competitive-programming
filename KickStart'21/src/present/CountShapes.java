package present;

public class CountShapes{

    public static void main(String []args){

        int num[][]=
                {{1,1,0,0,1},
                 {1,0,0,1,0},
                 {1,1,0,1,0},
                 {0,0,1,0,0}};
        int counter=0,rCount=0,cCount=0;

        //Counting Coulmn Shapes
        for(int i=0;i<5;i++){
            counter=0;
            for(int j=0;j<4;j++){
                if(num[j][i]==1)
                    counter=counter+1;

                else{
                    if(counter>=2)
                        cCount=cCount+1;
                    counter=0;
                }
            }
            if(counter>=2)
                cCount=cCount+1;
        }

        //Counting Row Shapes
        for(int i=0;i<4;i++){
            counter=0;
            for(int j=0;j<5;j++){
                if(num[i][j]==1)
                    counter=counter+1;

                else{
                    if(counter>=2)
                        rCount=rCount+1;
                    counter=0;
                }
            }
            if(counter>=2)
                rCount=rCount+1;
        }


        System.out.println("Total Shapes:"+(rCount+cCount));
    }
}

