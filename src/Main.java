import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Değişkenleri tanımlayalım.
        int mesafe, yas, yolTip;
        double perKm = 0.10, indOrani = 0, topTutar, yasIndMiktari, yasIndliTutar, normTutar, tipIndTutar;
        //Kullanıcıdan girdi alalım.
        Scanner input = new Scanner(System.in);
        System.out.print("Lütfen gideceğiniz mesafeyi km cinsinden giriniz :");
        mesafe = input.nextInt();
        System.out.print("Lütfen yaşınızı giriniz :");
        yas = input.nextInt();
        System.out.print("1-Tek Yön\n2-Gidiş-Dönüş\n" + "Lütfen bilet tipini seçiniz :");
        yolTip = input.nextInt();
        //girdilerin geçerli değerde olup olmadığını kontrol edelim.
        normTutar = (mesafe * perKm);
        if (mesafe <= 0 || yas <= 0 || yolTip > 2 || yolTip < 1) {
            System.out.print("Hatalı veri girdiniz!");
        } else {
            if (yas < 12) {                             //Yaş aralıklarına göre indirim oranını belirleyelim.
                indOrani = 0.5;
            } else if (yas < 24) {
                indOrani = 0.1;
            } else if (yas > 64) {
                indOrani = 0.3;
            }
            yasIndMiktari = (normTutar * indOrani);     //indirim oranlarına göre ödeme tutarını belirleyelim.
            yasIndliTutar = (normTutar - yasIndMiktari);

            if (yolTip == 1) {                          //Yolculuk tipine ödeme tutarını belirleyelim.
                System.out.println(yasIndliTutar);

            } else {
                tipIndTutar = (yasIndliTutar * 0.20);
                topTutar = (yasIndliTutar - tipIndTutar) * 2;
                System.out.println(topTutar);

            }
        }
    }
}