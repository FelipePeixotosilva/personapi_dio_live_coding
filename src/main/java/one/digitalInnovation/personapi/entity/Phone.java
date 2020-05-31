package one.digitalInnovation.personapi.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digitalInnovation.personapi.enums.PhoneType;

import javax.persistence.*;

//Reconecer pelo banco de dados como entidade
@Entity
//Get e Set não precisa ser implementado
@Data
//Padrao de projeto para construção de objetos
@Builder
//Inserir Construtores
@AllArgsConstructor
@NoArgsConstructor

public class Phone {
    @Id//chave primaria
    @GeneratedValue(strategy =  GenerationType.IDENTITY)//Estrategia de geracao de chave primaria, IDENTITY vai ser incremental
    private Long id;

    @Enumerated(EnumType.STRING)//
    @Column(nullable = false)//Ele seja cadastrado seja obrigatorio, ou seja notnull
    private PhoneType type;

    @Column(nullable = false)
    private String number;
}
