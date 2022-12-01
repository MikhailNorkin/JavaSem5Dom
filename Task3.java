//На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга. И вывести Доску.
package Tasks;

public class Task3 {
    public static void main(String[] args) {
        int[] arr[] = new int[8][8];
        for (int n = 0; n < arr.length; n++) {
            for (int m = 0; m < arr.length; m++) {
                for (int i = 0; i < arr.length; i++) {
                    for (int j = 0; j < arr.length; j++) {
                        arr[i][j] = 0 ;
                    }    
                }
                arr[n][m] = 1;
                for (int i = 0; i < arr.length; i++) {
                    for (int j = 0; j < arr.length; j++) {
                        //проверм, если можно поставить ферзя, то поставим
                        //проверим есть ли ферзь справа-слева свеху-вниз
                        Integer flag = 0;
                        for (int x = 0; x < arr.length; x++) {
                            if (arr[i][x] == 1) {
                                if (x != j)  {
                                    flag = 1;
                                    break;
                                }    
                            }
                        }
                        for (int x = 0; x < arr.length; x++) {
                            if (arr[x][j] == 1) {
                                if (i != x){
                                    flag = 1;
                                    break;    
                                }
                            }                    
                        }
                        //проверим есть ли ферзь по диагоналям
                        for (int k = 1; k < arr.length; k++) {
                            if (((i-k)>=0) & ((j-k)>=0)){
                                if (arr[i-k][j-k]==1){
                                    flag = 1;
                                    break;
                                }    
                            }
                            if (((i+k)<=7) & ((j+k)<=7)){
                                if (arr[i+k][j+k]==1){
                                    flag = 1;
                                    break;
                                }    
                            }
                            if (((i-k)>=0) & ((j+k)<=7)){
                                if (arr[i-k][j+k]==1){
                                    flag = 1;
                                    break;
                                }    
                            }
                            if (((i+k)<=7) & ((j-k)>=0)){
                                if (arr[i+k][j-k]==1){
                                    flag = 1;
                                    break;
                                }    
                            }
                        }
                        if (flag == 0){
                            arr[i][j] = 1;
                        }
                    }    
                }
                Integer sum = 0;
                for (int i = 0; i < arr.length; i++) {
                    for (int j = 0; j < arr.length; j++) {
                        if (arr[i][j] == 1){
                            sum = sum + 1;
                        }
                    }
                }        
                if (sum == 8){
                    for (int i = 0; i < arr.length; i++) {
                        for (int j = 0; j < arr.length; j++) {
                            System.out.print(arr[i][j]+" ");
                        }    
                        System.out.println();
                    } System.out.println();
                }    
            }    
        } 
    }    
}
