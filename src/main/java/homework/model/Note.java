package homework.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Note {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    @Column(length = 200, nullable = false)
    private String title;
    @Column(length = 1000, nullable = false)
    private String content;

}
