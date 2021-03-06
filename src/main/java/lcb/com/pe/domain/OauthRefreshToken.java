package lcb.com.pe.domain;
// Generated 21/02/2017 12:52:07 PM by Hibernate Tools 5.0.3.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * OauthRefreshToken generated by hbm2java
 */
@Entity
@Table(name = "oauth_refresh_token", schema = "dbo", catalog = "LCB_SECURITY")
public class OauthRefreshToken implements java.io.Serializable {

	private String tokenId;
	private String token;
	private String authentication;

	public OauthRefreshToken() {
	}

	public OauthRefreshToken(String tokenId, String token, String authentication) {
		this.tokenId = tokenId;
		this.token = token;
		this.authentication = authentication;
	}

	@Id
	@Column(name = "token_id", length = 256)
	public String getTokenId() {
		return this.tokenId;
	}

	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}

	@Column(name = "token")
	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Column(name = "authentication")
	public String getAuthentication() {
		return this.authentication;
	}

	public void setAuthentication(String authentication) {
		this.authentication = authentication;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof OauthRefreshToken))
			return false;
		OauthRefreshToken castOther = (OauthRefreshToken) other;

		return ((this.getTokenId() == castOther.getTokenId()) || (this.getTokenId() != null
				&& castOther.getTokenId() != null && this.getTokenId().equals(castOther.getTokenId())))
				&& ((this.getToken() == castOther.getToken()) || (this.getToken() != null
						&& castOther.getToken() != null && this.getToken().equals(castOther.getToken())))
				&& ((this.getAuthentication() == castOther.getAuthentication())
						|| (this.getAuthentication() != null && castOther.getAuthentication() != null
								&& this.getAuthentication().equals(castOther.getAuthentication())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getTokenId() == null ? 0 : this.getTokenId().hashCode());
		result = 37 * result + (getToken() == null ? 0 : this.getToken().hashCode());
		result = 37 * result + (getAuthentication() == null ? 0 : this.getAuthentication().hashCode());
		return result;
	}

}
