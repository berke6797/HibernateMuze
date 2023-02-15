package Service;

import Entity.*;
import Repository.EserDao;

import java.util.Arrays;
import java.util.List;

public class EserService {

    static EserDao eserDao = new EserDao();

    public static void main(String[] args) {

        // save();
        //delete(7);
       //update(6);
        //getAll();
    }

    public static void save() {
        Muze muze1 = new Muze("Muze1", "İstanbul", "11:30");
        Muze muze2 = new Muze("Muze2", "Ankara", "10:30");
        Muze muze3 = new Muze("Muze3", "İzmir", "09:30");


        Sanatci sanatci1 = new Sanatci("Sanatçı1Ad", "1900", "1993");
        Sanatci sanatci2 = new Sanatci("Sanatçı2Ad", "1711", "1773");
        Sanatci sanatci3 = new Sanatci("Sanatçı3Ad", "1845", "1900");
        Sanatci sanatci4 = new Sanatci("Sanatçı4Ad", "1650", "1703");


        Ziyaretci ziyaretci1 = new Ziyaretci("Ziyaretçi1", 25, 05431231232l);
        Ziyaretci ziyaretci2 = new Ziyaretci("Ziyaretçi2", 30, 05412312312l);
        Ziyaretci ziyaretci3 = new Ziyaretci("Ziyaretçi3", 26, 12328394592l);
        Ziyaretci ziyaretci4 = new Ziyaretci("Ziyaretçi4", 22, 24309563143l);
        Ziyaretci ziyaretci5 = new Ziyaretci("Ziyaretçi5", 23, 05352352234l);
        Ziyaretci ziyaretci6 = new Ziyaretci("Ziyaretçi6", 29, 05321231265l);
        Ziyaretci ziyaretci7 = new Ziyaretci("Ziyaretçi7", 27, 05411231232l);
        Ziyaretci ziyaretci8 = new Ziyaretci("Ziyaretçi8", 30, 05441231232l);
        Ziyaretci ziyaretci9 = new Ziyaretci("Ziyaretçi9", 33, 05401231232l);
        Ziyaretci ziyaretci10 = new Ziyaretci("Ziyaretçi10", 45, 23381231232l);

        Sergi sergi1 = new Sergi("Sergi1", "22/03/2023", "27/04/2023", "Soyutlama", muze1, Arrays.asList(ziyaretci1, ziyaretci2, ziyaretci3, ziyaretci4));
        Sergi sergi2 = new Sergi("Sergi2", "20/04/2023", "25/04/2023", "Mutluluğun Resmi", muze2, Arrays.asList(ziyaretci2, ziyaretci3, ziyaretci4, ziyaretci5));
        Sergi sergi3 = new Sergi("Sergi3", "20/01/2023", "25/01/2023", "Aile", muze3, Arrays.asList(ziyaretci5, ziyaretci6, ziyaretci7, ziyaretci8, ziyaretci9, ziyaretci10));
        Sergi sergi4 = new Sergi("Sergi4", "20/07/2023", "25/07/2023", "Savaş", muze2, Arrays.asList(ziyaretci1, ziyaretci2, ziyaretci3, ziyaretci5, ziyaretci7, ziyaretci8, ziyaretci9, ziyaretci10));

        Eser eser1 = new Eser("Eser1", "1543", Arrays.asList(sanatci1, sanatci2), sergi1);
        Eser eser2 = new Eser("Eser2", "1441", Arrays.asList(sanatci3, sanatci4), sergi2);
        Eser eser3 = new Eser("Eser3", "1232", Arrays.asList(sanatci1), sergi2);
        Eser eser4 = new Eser("Eser4", "1100", Arrays.asList(sanatci2), sergi3);
        Eser eser5 = new Eser("Eser5", "1887", Arrays.asList(sanatci1, sanatci3), sergi4);
        Eser eser6 = new Eser("Eser6", "475", Arrays.asList(sanatci4), sergi4);

        eserDao.save(eser6);

    }

    public static void getAll() {
        try {
            List<Eser> list = eserDao.getAll();
            for (Eser item : list) {
                System.out.println(
                        "Müze Adı:" + item.getSergi().getSergilendigiMuze().getMuzeIsim() + "--" +
                                "Müze Açılış Saati: " + item.getSergi().getSergilendigiMuze().getMuzeAcilisSaat() + "\n" +
                                "Eser ID: " + item.getEserId() + "--" +
                                "Eser Adı: " + item.getEserAd() + "--" +
                                "Eser Yılı: " + item.getEserYili() + "\n" +
                                "Sergi Adı: " + item.getSergi().getSergiAd() + "--" +
                                "Sergi Konu: " + item.getSergi().getSergiKonu() + "--" +
                                "Sergi Başlangıç Tarihi: " + item.getSergi().getSergiBaslangicTarih() + "--" +
                                "Sergi Bitiş Tarihi: " + item.getSergi().getSergiBitisTarih()
                );
                for (Sanatci item2 : item.getSanatciList()) {
                    System.out.println(
                            "Sanatçı Adı: " + item2.getSanatciAd() + "--" +
                                    "Sanatçı Doğum Yılı: " + item2.getSanatciDogumYili() + "--" +
                                    "Sanatçı Ölüm Yılı: " + item2.getSanatciOlumYili()
                    );
                }
                System.out.println("------------- ZİYARETÇİ LİSTESİ --------------");

                for (Ziyaretci item3 : item.getSergi().getZiyaretciList()) {
                    System.out.println(
                            "Ziyaretçi Ad-Soyad: " + item3.getZiyaretciAdSoyad() + "--" +
                                    "Ziyaretçi Tel No: " + item3.getZiyaretciTelNo() + "--" +
                                    "Ziyaretçi Yaş: " + item3.getZiyaretciYas()
                    );
                }
                System.out.println("====================================================================================================");
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public static void delete(int id) {
        try {
            eserDao.delete(id);
            System.out.println(id + "id'li eser silinmiştir...");
            getAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void update(int id) {
        try {
            // Burada yeni müzeye yukarıda olan sanatçı haricinde yeni sanatçı eklenmiştir.
            // Bununla beraber başka bir yeni ziyaretçi ile diğer sergilere giden bir kaç ziyaretçi buradaki yeni sergiye de gelmiştir.

            Sanatci yeniSanatci = new Sanatci("YeniSanatçıAd", "1900", "1993");
            Sanatci sanatci4 = new Sanatci("Sanatçı4Ad", "1650", "1703");

            Ziyaretci yeniZiyaretci = new Ziyaretci("yeniZiyaretçi", 25, 05431231232l);
            Ziyaretci ziyaretci8 = new Ziyaretci("Ziyaretçi8", 30, 05441231232l);
            Ziyaretci ziyaretci9 = new Ziyaretci("Ziyaretçi9", 33, 05401231232l);
            Ziyaretci ziyaretci10 = new Ziyaretci("Ziyaretçi10", 45, 23381231232l);

            Sergi yeniSergi = new Sergi("yeniSergi", "11/06/2025", "27/06/2025", "Soyutlama", new Muze("YeniMüze", "Bursa", "12:30"), Arrays.asList(yeniZiyaretci, ziyaretci8, ziyaretci9, ziyaretci10));
            Eser yeniEser = new Eser(id,"Yeni Eser", "1223", Arrays.asList(yeniSanatci, sanatci4), yeniSergi);
            eserDao.update(yeniEser);

            System.out.println("Yeni eser yeni müze ve sergi için yeni ziyaretçilerin ilgisini çekiyor...");
            getAll();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

}
