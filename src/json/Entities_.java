package json;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class Entities_ {

	@Expose
	private Description description;

	public Description getDescription() {
		return description;
	}

	public void setDescription(Description description) {
		this.description = description;
	}

	public Entities_ withDescription(Description description) {
		this.description = description;
		return this;
	}

	@Override
	public String toString() {
		return "Entities_ [description=" + description + "]";
	}
	
	

}
