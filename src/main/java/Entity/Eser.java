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
public class Eser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eserId;
    private String eserAd;
    private String eserYili;

    // Sanatçı-eser ilişkisi many many olduğunda EAGER kullanılması gerekir.
    // fakat EAGER aynı zamanda sergi-ziyaretçi ilişkisinde de kullanıldığı
    // için hibernate çakışma yaşamaktadır. Bu çakışmayı çözmenın yolu fetcType
    // yerine LazyCollectionOption.FALSE yazmaktır.
    //     LazyCollectionOption.FALSE= fetchType.EAGER

    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Sanatci> sanatciList;

    /*
    @ManyToOne(cascade = CascadeType.ALL)
    private Sanatci sanatci;
     */

    @ManyToOne(cascade = CascadeType.ALL)
    private Sergi sergi;

    public Eser(String eserAd, String eserYili,List<Sanatci> sanatciList, Sergi sergi) {
        this.eserAd = eserAd;
        this.eserYili = eserYili;
        this.sanatciList = sanatciList;
        this.sergi = sergi;
    }

    public Eser(int eserId, String eserAd, String eserYili, List<Sanatci> sanatciList, Sergi sergi) {
        this.eserId = eserId;
        this.eserAd = eserAd;
        this.eserYili = eserYili;
        this.sanatciList = sanatciList;
        this.sergi = sergi;
    }
}
