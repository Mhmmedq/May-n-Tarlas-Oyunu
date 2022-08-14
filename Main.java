import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int row,col;
        System.out.println("MAYIN TARLASINA HOŞGELDİNİZ");
        Scanner scr=new Scanner(System.in);
        System.out.print("satir sayisi giriniz : ");
        int orow= scr.nextInt();
        System.out.print("sutun sayisi giriniz :");
        int ocol= scr.nextInt();
      Mayintarlasi mayin =new Mayintarlasi(orow,ocol);
      mayin.run();
    }
}
