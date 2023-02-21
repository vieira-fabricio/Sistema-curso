package br.com.springboot.springboot.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "matricula")
public class Matricula{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /*@Column(insertable=false, updatable=false)
    private Long curso_id;
    @Column(insertable=false, updatable=false)
    private Long aluno_id;
    */
    @Column(name = "data_matricula")
    private final LocalDate dataMatricula = LocalDate.now();

    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = true)
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "aluno_id", nullable = true)
    private Aluno aluno;

    @OneToOne(mappedBy = "matricula")
    private Pagamento pagamento;
}
