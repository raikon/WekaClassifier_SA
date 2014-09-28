package json;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


@Generated("org.jsonschema2pojo")
public class Entities {

	@Expose
	private List<Object> symbols = new ArrayList<Object>();
	@Expose
	private List<Object> urls = new ArrayList<Object>();
	@Expose
	private List<Object> hashtags = new ArrayList<Object>();
	@SerializedName("user_mentions")
	@Expose
	private List<Object> userMentions = new ArrayList<Object>();

	public List<Object> getSymbols() {
		return symbols;
	}

	public void setSymbols(List<Object> symbols) {
		this.symbols = symbols;
	}

	public Entities withSymbols(List<Object> symbols) {
		this.symbols = symbols;
		return this;
	}

	public List<Object> getUrls() {
		return urls;
	}

	public void setUrls(List<Object> urls) {
		this.urls = urls;
	}

	public Entities withUrls(List<Object> urls) {
		this.urls = urls;
		return this;
	}

	public List<Object> getHashtags() {
		return hashtags;
	}

	public void setHashtags(List<Object> hashtags) {
		this.hashtags = hashtags;
	}

	public Entities withHashtags(List<Object> hashtags) {
		this.hashtags = hashtags;
		return this;
	}

	public List<Object> getUserMentions() {
		return userMentions;
	}

	public void setUserMentions(List<Object> userMentions) {
		this.userMentions = userMentions;
	}

	public Entities withUserMentions(List<Object> userMentions) {
		this.userMentions = userMentions;
		return this;
	}

	@Override
	public String toString() {
		return "Entities [symbols=" + symbols + ", urls=" + urls
				+ ", hashtags=" + hashtags + ", userMentions=" + userMentions
				+ "]";
	}
	
	

}