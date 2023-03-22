package labshop.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "GetStock_table")
@Data
public class GetStock {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
}
