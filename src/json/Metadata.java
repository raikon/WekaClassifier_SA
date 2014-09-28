package json;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Metadata {

	@SerializedName("result_type")
	@Expose
	private String resultType;
	@SerializedName("iso_language_code")
	@Expose
	private String isoLanguageCode;

	public String getResultType() {
		return resultType;
	}

	public void setResultType(String resultType) {
		this.resultType = resultType;
	}

	public Metadata withResultType(String resultType) {
		this.resultType = resultType;
		return this;
	}

	public String getIsoLanguageCode() {
		return isoLanguageCode;
	}

	public void setIsoLanguageCode(String isoLanguageCode) {
		this.isoLanguageCode = isoLanguageCode;
	}

	public Metadata withIsoLanguageCode(String isoLanguageCode) {
		this.isoLanguageCode = isoLanguageCode;
		return this;
	}

	@Override
	public String toString() {
		return "Metadata [resultType=" + resultType + ", isoLanguageCode="
				+ isoLanguageCode + "]";
	}
	
	

}
