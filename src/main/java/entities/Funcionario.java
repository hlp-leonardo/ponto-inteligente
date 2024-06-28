package entities;

import enums.PerfilEnum;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "funcionario")
public class Funcionario implements Serializable {

    @Serial
    private static final long serialVersionUID = 5754246207015712518L;

    private Long id;
    private String name;
    private String email;
    private String senha;
    private String cpf;
    private BigDecimal valorHora;
    private Float qtHorasTrabalhoDia;
    private Float qtHorasAlmoco;
    private PerfilEnum perfil;
    private Date dataCriacao;
    private Date dataAtualizacao;
    private Empresa empresa;
    private List<Lancamento> lancamentos;

    public Funcionario() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "nome", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "email", nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "senha", nullable = false)
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Column(name = "cpf", nullable = false)
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Column(name = "valor_hora", nullable = false)
    public BigDecimal getValorHora() {
        return valorHora;
    }

    @Transient
    public Optional<BigDecimal> getValorHoraOpt() {
        return Optional.ofNullable(valorHora);
    }

    public void setValorHora(BigDecimal valorHora) {
        this.valorHora = valorHora;
    }

    @Column(name = "qtd_horas_trabalho_dia", nullable = false)
    public Float getQtHorasTrabalhoDia() {
        return qtHorasTrabalhoDia;
    }

    @Transient
    public Optional<Float> getQtHorasTrabalhoDiaOpt() {
        return Optional.ofNullable(qtHorasTrabalhoDia);
    }

    public void setQtHorasTrabalhoDia(Float qtHorasTrabalhoDia) {
        this.qtHorasTrabalhoDia = qtHorasTrabalhoDia;
    }

    @Column(name = "qt_horas_almoco", nullable = false)
    public Float getQtHorasAlmoco() {
        return qtHorasAlmoco;
    }

    @Transient
    public Optional<Float> getQtHorasAlmocoOpt() {
        return Optional.ofNullable(qtHorasAlmoco);
    }

    public void setQtHorasAlmoco(Float qtHorasAlmoco) {
        this.qtHorasAlmoco = qtHorasAlmoco;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "perfil", nullable = false)
    public PerfilEnum getPerfil() {
        return perfil;
    }

    public void setPerfil(PerfilEnum perfil) {
        this.perfil = perfil;
    }

    @Column(name = "data_criacao", nullable = false)
    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    @Column(name = "data_atualizacao", nullable = false)
    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @OneToMany(mappedBy = "funcionario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<Lancamento> getLancamentos() {
        return lancamentos;
    }

    public void setLancamentos(List<Lancamento> lancamentos) {
        this.lancamentos = lancamentos;
    }

    @PrePersist
    public void prePersist() {
        final Date atual = new Date();
        dataCriacao = atual;
        dataAtualizacao = atual;
    }

    @Override
    public String toString() {
        return "Funcionario [id = " + id +
                ", nome = " + name +
                ", email = " + email +
                ", senha = " + senha +
                ", cpf = " + cpf +
                ", valorHora = " + valorHora +
                ", qtHorasTrabalhoDia = " + qtHorasTrabalhoDia +
                ", qtHorasAlmoco = " + qtHorasAlmoco +
                ", perfil = " + perfil +
                ", dataCriacao = " + dataCriacao +
                ", dataAtualizacao = " + dataAtualizacao +
                ", empresa = " + empresa +
                "]";
    }
}
