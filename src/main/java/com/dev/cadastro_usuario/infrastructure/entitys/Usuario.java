package com.dev.cadastro_usuario.infrastructure.entitys;
//

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "usuario")
@Entity

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Cria um Id automáticamente
    private Integer id;

    @Column(name = "email", unique = true) // cria a coluna de email do tipo único.
    private String email;

    @Column(name = "nome")
    private String nome;



}
