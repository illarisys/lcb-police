package lcb.com.pe.domain;
// Generated 21/02/2017 12:52:07 PM by Hibernate Tools 5.0.3.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PermisoRepositorioId generated by hbm2java
 */
@Embeddable
public class PermisoRepositorioId implements java.io.Serializable {

	private short idRol;
	private int idRepositorio;

	public PermisoRepositorioId() {
	}

	public PermisoRepositorioId(short idRol, int idRepositorio) {
		this.idRol = idRol;
		this.idRepositorio = idRepositorio;
	}

	@Column(name = "id_rol", nullable = false)
	public short getIdRol() {
		return this.idRol;
	}

	public void setIdRol(short idRol) {
		this.idRol = idRol;
	}

	@Column(name = "id_repositorio", nullable = false)
	public int getIdRepositorio() {
		return this.idRepositorio;
	}

	public void setIdRepositorio(int idRepositorio) {
		this.idRepositorio = idRepositorio;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PermisoRepositorioId))
			return false;
		PermisoRepositorioId castOther = (PermisoRepositorioId) other;

		return (this.getIdRol() == castOther.getIdRol()) && (this.getIdRepositorio() == castOther.getIdRepositorio());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getIdRol();
		result = 37 * result + this.getIdRepositorio();
		return result;
	}

}
