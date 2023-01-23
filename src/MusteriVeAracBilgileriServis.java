import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MusteriVeAracBilgileriServis {
/*
 	aracTalep() adında bir method oluşturunuz. Bu method’da alinacak sehir, teslim edilecek sehir,
    alinacak gun ve teslim edilecek gun ve teslim saati bilgilerini aliniz. Odenecek toplam gun sayisini yazdırın.
    Dikkat: Teslim gunu, alis gününden daha once olamaz.
 */

    public AracTalebi aracTalep() {


        Scanner inp = new Scanner(System.in);
        System.out.println("Araci hangi sehirden teslim almak istediginizi belirtiniz:");
        String cityTakeOn = inp.nextLine();
        System.out.println("Araci hangi sehirde teslim etmek istediginizi belirtiniz:");
        String cityDelivery = inp.nextLine();
        boolean isValid = false;
        LocalDate dateOfTake;
        LocalDate dateOfDelivery;
        LocalTime timeOfDelivery;

        do {
            isValid = false;
            System.out.println("Araci teslim almak istediginiz tarihi belirtiniz:\n" +
                    "Tarih formatini gun/ay/yil seklinde giriniz");
            dateOfTake = LocalDate.parse(inp.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            System.out.println("Araci teslim etmek istediginiz tarihi belirtiniz:\n" +
                    "Tarih formatini gun/ay/yil seklinde giriniz");
            dateOfDelivery = LocalDate.parse(inp.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            System.out.println("Araci teslim etmek istediginiz saati belirtiniz:\n" +
                    "Saati; ornegin 16:34 seklinde giriniz");
            timeOfDelivery = LocalTime.parse(inp.nextLine(), DateTimeFormatter.ofPattern("HH:mm"));
            long numberOfDaysToPay = ChronoUnit.DAYS.between(dateOfTake, dateOfDelivery);
            if (numberOfDaysToPay < 0) {
                System.out.println("Teslim gunu, alis gününden daha once olamaz!");
                isValid = true;

            } else if (numberOfDaysToPay == 0) {
                System.out.println("Ayni gun icerisinde alinip teslim edilen araclar icin bir gunluk ucret alinir!");
            }
            //boolean isBefore = dateOfTake.isBefore(dateOfDelivery);
        } while (isValid);
        return new AracTalebi(cityTakeOn, dateOfTake, dateOfDelivery, timeOfDelivery);
    }

    public static void main(String[] args) {
        createVehicle();
        showList();


    }
    /*
    -	arabalar() create ederek, tüm araç modellerini bir list’e atınız.
            (parametre olarak araç ile ilgili bilgileri alan <marka, model, yakıt tipi, vites, gunlukUcret> objeleri list’e atınız.)
    Bu list’i göstererek bir aracı kiralamasını sağlayın.

     */


    //    public void arabalar(){
//        //String marka, String model, String yakitTipi, String vites, double gunlukUcret
//        Scanner inp = new Scanner(System.in);
//        System.out.println("Aracin markasini giriniz");
//        String make = inp.nextLine();
//        System.out.println("Aracin modelini giriniz");
//        String model = inp.nextLine();
//        System.out.println("Aracin yakit tipini giriniz");
//        String fuelType = inp.nextLine();
//        System.out.println("Aracin vites tipini giriniz giriniz");
//        String gearType = inp.nextLine();
//        System.out.println("Aracin gunluk ucretini belirtiniz");
//        double dayPrice = inp.nextDouble();
//    }Marka Model Yakit Tipi VitesTipi Gunluk Ucret
    static List<Arac> aracList = new ArrayList<>();

    public static void createVehicle() {

        Arac arac1 = new Arac("Honda", "Civic", "Dizel", "Otomatik", 700.0);
        Arac arac2 = new Arac("Honda", "Accord", "Benzinli", "Manuel", 600.0);
        Arac arac3 = new Arac("Toyota", "Corolla", "Dizel", "Otomatik", 900.0);
        Arac arac4 = new Arac("Lamborgihini", "Aventador", "Benzinli", "Otomatik", 30000.0);
        Arac arac5 = new Arac("Mercedes", "E300", "Dizel", "Otomatik", 1250.0);

        aracList.add(arac1);
        aracList.add(arac2);
        aracList.add(arac3);
        aracList.add(arac4);
        aracList.add(arac5);
    }

    public static void showList() {
        System.out.println("*******************************ARAC LISTEMIZ***********************************************");
        System.out.printf("%-12s   %-9s   %-10s   %-10s   %-12s\n", "Marka", "Model", "Yakit Tipi", "Vites Tipi", "Gunluk Ucret");
        for (Arac w : aracList) {

            System.out.printf("%-12s   %-9s   %-10s   %-10s   %-12s\n",
                    w.getMarka(), w.getModel(), w.getYakitTipi(), w.getVites(), w.getGunlukUcret());
        }


    }
}