package pl.honestit.spring.demo.model.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity @Table(name = "adverts")
@Getter @Setter @ToString
@EqualsAndHashCode(of = {"id"})
public class Advert {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String title;
	@Column(nullable = false, length = 1500)
	private String description;
	@Column
	private LocalDateTime posted;
	@ManyToOne // wiele obiektów klasy advert może odnosić się do jednego użytkownika. Czyli user może mieć wiele adwertów
	@JoinColumn (name = "user_id") //to jest kolumna klucza obcego, czyli wskazuje na inną kolumnę w innej tabeli (domyślnie na klucz główny w tabeli User). Ale nadaję jej nazwę "user_id"
	//w ten sposób tworzymy powiązanie pomiędzy tymi dwiema tabelami
	private User user;
}
