import java.util.*;

public class kmp2
{
    static int comparison_cnt = 0;

    public static int[] create_py_table(String pat){
        comparison_cnt=0;
        int m = pat.length();
        int[] py = new int[m];
        
        System.out.println("len : "+m);
        py[1] = 0;
        int k = 0;
        int q = 2;
        
        while(q < m){
            comparison_cnt++;
            if(pat.charAt(k+1)==pat.charAt(q)){
               
                k++;
                py[q] = k;
                q++;
            }
            else{
                if(k>0){
                    k=py[k];
                }
                else{
                    py[q] = 0;
                    q++;
                }
            }
        }
            
    
        //print py table
        System.out.println("comparison count in preprocessing : "+comparison_cnt);
        System.out.print("py table : ");
        for(int i = 1 ; i < m ; i++){
            System.out.print(py[i]+" ");
        }
        System.out.println("\n");

        return py;
    }
    
    public static void kmpalgo(String text, String pat){
        
        int n = text.length();
        pat = " "+ pat;
        int m = pat.length()-1;

        //pre-processing
        int[] py = create_py_table(pat);

        //matching
        comparison_cnt = 0;
        int q = 0;
        int i = 0;
        while(i<n){
            boolean t = pat.charAt(q+1)==text.charAt(i);
            comparison_cnt++;
            if(t){
                q++;
                if(q == m){
                    System.out.println("match "+(i-m+1));
                    q = py[q];
                }
                i++;
            }
            else{
                if(q>0){
                    q = py[q];
                }
                else{
                    i++;
                }
            }
            
        }
        System.out.println("comparison count in matching : "+comparison_cnt);
    }
    
    public static void main(String[] args){
        // String text = "aaaaaaaa";
        // String pat = "aaaa";
        
        String text = "acacacacac";
        String pat = "acac";
        
        kmpalgo(text,pat);
    }
    
}