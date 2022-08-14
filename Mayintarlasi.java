import java.util.Random;
import java.util.Scanner;

public class Mayintarlasi {
    int rownumber;
    int colnumber;
    boolean game=true;
    int[][] map;
    int [][]broad;
    int n;
    int win=0;
    Random random=new Random();
    Scanner scr=new Scanner(System.in);
    Mayintarlasi(int rownumber,int colnumber) {
        this.rownumber = rownumber;
        this.colnumber = colnumber;
        this.map = new int[rownumber][colnumber];
        this.broad = new int[rownumber][colnumber];
    }
    public void run(){

        System.out.println("zorluk duzey sec\n1-kolay\n2-orta\n3-zor");
        int x= scr.nextByte();

        switch (x){
            case 1:n=4;
            break;
            case 2:n=3;
            break;
            case 3:n=2;
            break;
            default:
                System.out.println("yanlis secenek sectigin icin oyun orta duzeyde calisacaktir");
                n=3;
        }
        prepare(n);
        print(map);
        System.out.println("oyun basladi !!!");

        while (game){
            wiin();
            if (wiin()){
                System.out.println("TEBRİKLER KAZANDINIZ !!");
                break;
            }
            print(broad);
        System.out.print("satir :");
        int krow= scr.nextInt();
        System.out.print("sutun :");
        int kcoul= scr.nextInt();

            boolean b = kcoul <= 0 || kcoul > colnumber;
            if ((krow<=0 || krow>rownumber)||(b)) {
                System.out.println("hatali giris yaptiniz");
            }else {
                if (map[krow - 1][kcoul - 1] != -1) {
                    chek(krow - 1, kcoul - 1);
                    win++;
                } else {
                    System.out.println("GAME OVER !!");
                    game = false;
                }
            }
        }
    }
    public boolean wiin(){
        if ((colnumber * rownumber) - win == (colnumber * rownumber) / n){
            return true;
        }
        return false;
    }
    public void chek(int r, int c){
        if (c<colnumber-1 && map[r][c+1]==-1){
            broad[r][c]++;
        }
        if (c>0 && map[r][c-1]==-1){
            broad[r][c]++;
        }
        if (r<rownumber-1 && c<colnumber-1){
            if( map[r+1][c+1]==-1){
            broad[r][c]++;
            }
        }
        if (r>0 && c>0){
            if(map[r-1][c-1]==-1){
                broad[r][c]++;
            }
        }
        if (r<rownumber-1) {
            if (map[r + 1][c] == -1) {
                broad[r][c]++;
            }
        }
        if (r>0&&map[r-1][c]==-1){
            broad[r][c]++;
        }
        if (r>0&&c<colnumber-1) {
            if (map[r - 1][c + 1] == -1) {
                broad[r][c]++;
            }
        }
        if (r<rownumber-1 && c > 0) {
            if (  map[r + 1][c - 1] == -1) {
                broad[r][c]++;
            }
        }

    }
public void prepare(int n){
        int randrow,randcol,count=0;
    int size=(rownumber)*(colnumber);
        while (count!=size/n) {
            randrow = random.nextInt(rownumber);
            randcol = random.nextInt(colnumber);
            if (map[randrow][randcol]!=-1){
                map[randrow][randcol]=-1;
                count++;
            }
        }
}
public void print(int[][]array){
    for (int i=0;i< array.length;i++){
        for (int j=0;j< array[0].length;j++){
            if (array[i][j]>=0){
                System.out.print(" ");
            }
            System.out.print(array[i][j]+" ");
        }
        System.out.println();
    }
}

}
