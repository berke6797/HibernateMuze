package Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Sergi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sergiId;

    private String sergiAd;
    private String sergiBaslangicTarih;
    private String sergiBitisTarih;
    private String sergiKonu;
    @ManyToOne(cascade = CascadeType.ALL)
    private Muze sergilendigiMuze;

    @OneToMany(cascade =CascadeType.ALL)
    private List<Eser> eserList;
    @LazyCollection(LazyCollectionOption.FALSE)

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Ziyaretci> ziyaretciList;

    public Sergi(String sergiAd, String sergiBaslangicTarih, String sergiBitisTarih, String sergiKonu) {
        this.sergiAd = sergiAd;
        this.sergiBaslangicTarih = sergiBaslangicTarih;
        this.sergiBitisTarih = sergiBitisTarih;
        this.sergiKonu = sergiKonu;
    }

    public Sergi(String sergiAd, String sergiBaslangicTarih, String sergiBitisTarih, String sergiKonu, Muze sergilendigiMuze,List<Ziyaretci> ziyaretciList) {
        this.sergiAd = sergiAd;
        this.sergiBaslangicTarih = sergiBaslangicTarih;
        this.sergiBitisTarih = sergiBitisTarih;
        this.sergiKonu = sergiKonu;
        this.sergilendigiMuze = sergilendigiMuze;
        this.ziyaretciList = ziyaretciList;

    }



    public Sergi(String sergiAd, String sergiBaslangicTarih, String sergiBitisTarih, String sergiKonu, Muze sergilendigiMuze, List<Eser> eserList, List<Ziyaretci> ziyaretciList) {
        this.sergiAd = sergiAd;
        this.sergiBaslangicTarih = sergiBaslangicTarih;
        this.sergiBitisTarih = sergiBitisTarih;
        this.sergiKonu = sergiKonu;
        this.sergilendigiMuze = sergilendigiMuze;
        this.eserList = eserList;
        this.ziyaretciList = ziyaretciList;
    }
}
