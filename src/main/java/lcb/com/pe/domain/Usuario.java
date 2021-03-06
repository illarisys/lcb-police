package lcb.com.pe.domain;
// Generated 21/02/2017 12:52:07 PM by Hibernate Tools 5.0.3.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Usuario generated by hbm2java
 */
@Entity
@Table(name = "Usuario", schema = "dbo", catalog = "LCB_SECURITY")
public class Usuario implements java.io.Serializable {

	private String usuario;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private Date fechaNacimiento;
	private String contrasena;
	private String email;
	private boolean estado;
	private String usuarioRegistro;
	private Date fechaRegistro;
	private String usuarioModifico;
	private Date fechaModifico;
	private Set<UsuarioSistema> usuarioSistemas = new HashSet<UsuarioSistema>(0);

	public Usuario() {
	}

	public Usuario(String usuario, String nombre, String apellidoPaterno, boolean estado, String usuarioRegistro,
			Date fechaRegistro) {
		this.usuario = usuario;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.estado = estado;
		this.usuarioRegistro = usuarioRegistro;
		this.fechaRegistro = fechaRegistro;
	}

	public Usuario(String usuario, String nombre, String apellidoPaterno, String apellidoMaterno, Date fechaNacimiento,
			String contrasena, String email, boolean estado, String usuarioRegistro, Date fechaRegistro, String usuarioModifico,
			Date fechaModifico, Set<UsuarioSistema> usuarioSistemas) {
		this.usuario = usuario;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.fechaNacimiento = fechaNacimiento;
		this.contrasena = contrasena;
		this.estado = estado;
		this.email = email;
		this.usuarioRegistro = usuarioRegistro;
		this.fechaRegistro = fechaRegistro;
		this.usuarioModifico = usuarioModifico;
		this.fechaModifico = fechaModifico;
		this.usuarioSistemas = usuarioSistemas;
	}

	@Id

	@Column(name = "usuario", unique = true, nullable = false, length = 10)
	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@Column(name = "nombre", nullable = false, length = 50)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "apellido_paterno", nullable = false, length = 50)
	public String getApellidoPaterno() {
		return this.apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	@Column(name = "apellido_materno", length = 50)
	public String getApellidoMaterno() {
		return this.apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_nacimiento", length = 23)
	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@JsonIgnore
	@Column(name = "contrasena", length = 100)
	public String getContrasena() {
		return this.contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	@Column(name = "email", length = 100)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "estado", nullable = false)
	public boolean isEstado() {
		return this.estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	@Column(name = "usuario_registro", nullable = false, length = 10)
	public String getUsuarioRegistro() {
		return this.usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_registro", nullable = false, length = 23)
	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	@Column(name = "usuario_modifico", length = 10)
	public String getUsuarioModifico() {
		return this.usuarioModifico;
	}

	public void setUsuarioModifico(String usuarioModifico) {
		this.usuarioModifico = usuarioModifico;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modifico", length = 23)
	public Date getFechaModifico() {
		return this.fechaModifico;
	}

	public void setFechaModifico(Date fechaModifico) {
		this.fechaModifico = fechaModifico;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	public Set<UsuarioSistema> getUsuarioSistemas() {
		return this.usuarioSistemas;
	}

	public void setUsuarioSistemas(Set<UsuarioSistema> usuarioSistemas) {
		this.usuarioSistemas = usuarioSistemas;
	}

}
