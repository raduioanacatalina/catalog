package model;

import java.util.Date;

public class Examen {
    private Integer id;

    private Materie materie;
    private Student student;
    private Double nota;
    private Date dataExament;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Materie getMaterie() {
        return materie;
    }

    public void setMaterie(Materie materie) {
        this.materie = materie;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public Date getDataExament() {
        return dataExament;
    }

    public void setDataExament(Date dataExament) {
        this.dataExament = dataExament;
    }
}
