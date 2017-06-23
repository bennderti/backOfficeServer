package cl.bennder.backoffice.model;

import cl.bennder.backoffice.request.UsuarioRequest;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Usuario {

    @Id
    @Column(name = "id_usuario")
    private Integer idUsuario;
    private String password;
    private String nombres;
    @Column(name = "apellido_p")
    private String apellidoPaterno;
    @Column(name = "apellido_m")
    private String apellidoMaterno;
    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_direccion")
    private Direccion direccion;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_contacto")
    private Contacto contacto;
    private String usuario;
    @ColumnDefault("false")
    private Boolean habilitado;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name="perfil_usuario",
            joinColumns=@JoinColumn(name="id_usuario", referencedColumnName="id_usuario"),
                inverseJoinColumns=@JoinColumn(name="id_perfil", referencedColumnName="id_perfil"))
    private List<Perfil> perfiles;


    public Usuario() {
    }

    public Usuario(UsuarioRequest usuarioRequest) {
        this.idUsuario = usuarioRequest.getIdUsuario();
        this.password = usuarioRequest.getPassword();
        this.nombres = usuarioRequest.getNombres();
        this.apellidoPaterno = usuarioRequest.getApellidoPaterno();
        this.apellidoMaterno = usuarioRequest.getApellidoMaterno();
        this.fechaNacimiento = usuarioRequest.getFechaNacimiento();
        this.usuario = usuarioRequest.getUsuario();
        this.habilitado = usuarioRequest.getHabilitado();
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Boolean getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(Boolean habilitado) {
        this.habilitado = habilitado;
    }

    public List<Perfil> getPerfiles() {
        return perfiles;
    }

    public void setPerfiles(List<Perfil> perfiles) {
        this.perfiles = perfiles;
    }

    @PrePersist
    public void onCreate() {
        if (habilitado == null)
            habilitado = false;
    }

}