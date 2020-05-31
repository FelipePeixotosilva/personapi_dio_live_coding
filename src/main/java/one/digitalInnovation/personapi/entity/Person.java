package one.digitalInnovation.personapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import  java.time.LocalDate;
import  java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)//unique CPF unico, fica mais facil a INDEXIÇÃO, fica mais perfomatica
    private String cpf;

    private LocalDate birthDate;
    /*Relacionamento de dados Pessoa relaciona telefone
    ID->celular
    ID->Casa
    ID->commercial
    Estrategia de obtenção de dados "FetchType" LAZY usado para perfomance,
    "cascade" Cadastra telefone  na hora de fazer cadastro pessoa
    * */
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<Phone> phones;
}
