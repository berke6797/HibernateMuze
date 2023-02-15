package Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Sanatci {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sanatciId;
    private String sanatciAd;
    private String sanatciDogumYili;
    private String sanatciOlumYili;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Eser> sanatciEserler;

    public Sanatci(String sanatciAd, String sanatciDogumYili, String sanatciOlumYili, List<Eser> sanatciEserler) {
        this.sanatciAd = sanatciAd;
        this.sanatciDogumYili = sanatciDogumYili;
        this.sanatciOlumYili = sanatciOlumYili;
        this.sanatciEserler = sanatciEserler;
    }

    public Sanatci(String sanatciAd, String sanatciDogumYili, String sanatciOlumYili) {
        this.sanatciAd = sanatciAd;
        this.sanatciDogumYili = sanatciDogumYili;
        this.sanatciOlumYili = sanatciOlumYili;
    }
}
