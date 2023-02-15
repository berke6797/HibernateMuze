package Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Muze {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int muzeId;
    private String muzeIsim;
    private String muzeSehir;
    private String muzeAcilisSaat;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Sergi> sergiList;

    public Muze(String muzeIsim, String muzeSehir, String muzeAcilisSaat, List<Sergi> sergiList) {

        this.muzeIsim = muzeIsim;
        this.muzeSehir = muzeSehir;
        this.muzeAcilisSaat = muzeAcilisSaat;
        this.sergiList = sergiList;
    }

    public Muze(String muzeIsim, String muzeSehir, String muzeAcilisSaat) {
        this.muzeIsim = muzeIsim;
        this.muzeSehir = muzeSehir;
        this.muzeAcilisSaat = muzeAcilisSaat;
    }
}
