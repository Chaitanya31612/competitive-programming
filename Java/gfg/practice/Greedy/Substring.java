import java.util.*;
import java.lang.*;

public class Substring {

    String concatSwaps(String s, int[] sizes) {
            int n=s.length();
            int len=sizes.length;
            String temp="";
            // 5
            // 0 1 2 3 
            List<String> strlist = new ArrayList<String>();
            int count=0;
            for(int i=0;i<len;i++){
                String str=s.substring(count,count+sizes[i]);
                strlist.add(str);
                count+=sizes[i];
                // if(len%2 != 0 && i==len-2){
                //     temp= temp+s.substring(sizes[i+1]);
                // }
                // else{
                //     String str1=s.substring(size[],i+sizes[i]);
                //     String str2=s.substring(sizes[i],sizes[i]+sizes[i+1]);
                //     temp= temp+str2+str1;
                // }
            }
            
            s=temp;
            // System.out.println(s);
            return s;
        }
    public static void main(String[] args) {
        String s = "descogail";
        int[] sizes = new int[] { 3, 2, 3, 1, 1 };
        
        int n=s.length();
            int len=sizes.length;
            String temp="";
            // 5
            // 0 1 2 3 
            List<String> strlist = new ArrayList<String>();
            int count=0;
            for(int i=0;i<len;i++){
                String str=s.substring(count,count+sizes[i]);
                strlist.add(str);
                count+=sizes[i];
                // if(len%2 != 0 && i==len-2){
                //     temp= temp+s.substring(sizes[i+1]);
                // }
                // else{
                //     String str1=s.substring(size[],i+sizes[i]);
                //     String str2=s.substring(sizes[i],sizes[i]+sizes[i+1]);
                //     temp= temp+str2+str1;
                // }
            }
            
            s=temp;
            System.out.println(s);
        // System.out.println(concatSwaps());
        
    }
}
             