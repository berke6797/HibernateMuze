package Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Ziyaretci {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ziyaretciId;
    private String ziyaretciAdSoyad;
    private int ziyaretciYas;
    private long ziyaretciTelNo;
    @ManyToMany(cascade =CascadeType.ALL)
    private List<Sergi> ziyaretEdilenSergiler;

    public Ziyaretci(String ziyaretciAdSoyad, int ziyaretciYas, long ziyaretciTelNo) {
        this.ziyaretciAdSoyad = ziyaretciAdSoyad;
        this.ziyaretciYas = ziyaretciYas;
        this.ziyaretciTelNo = ziyaretciTelNo;
    }

    public Ziyaretci(String ziyaretciAdSoyad, int ziyaretciYas, long ziyaretciTelNo, List<Sergi> ziyaretEdilenSergiler) {
        this.ziyaretciAdSoyad = ziyaretciAdSoyad;
        this.ziyaretciYas = ziyaretciYas;
        this.ziyaretciTelNo = ziyaretciTelNo;
        this.ziyaretEdilenSergiler = ziyaretEdilenSergiler;
    }
}
