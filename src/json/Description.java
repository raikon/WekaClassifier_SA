package json;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class Description {

	@Expose
	private List<Object> urls = new ArrayList<Object>();

	public List<Object> getUrls() {
		return urls;
	}

	public void setUrls(List<Object> urls) {
		this.urls = urls;
	}

	public Description withUrls(List<Object> urls) {
		this.urls = urls;
		return this;
	}

	@Override
	public String toString() {
		return "Description [urls=" + urls + "]";
	}
	
	

}
