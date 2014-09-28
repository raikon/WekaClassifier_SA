package json;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Example {

	@Expose
	private Object contributors;
	@Expose
	private String text;
	@Expose
	private Object geo;
	@Expose
	private boolean retweeted;
	@SerializedName("in_reply_to_screen_name")
	@Expose
	private Object inReplyToScreenName;
	@Expose
	private boolean truncated;
	@Expose
	private String lang;
	@Expose
	private Entities entities;
	@SerializedName("in_reply_to_status_id_str")
	@Expose
	private Object inReplyToStatusIdStr;
	@Expose
	private double id;
	@Expose
	private String source;
	@SerializedName("in_reply_to_user_id_str")
	@Expose
	private Object inReplyToUserIdStr;
	@Expose
	private boolean favorited;
	@SerializedName("in_reply_to_status_id")
	@Expose
	private Object inReplyToStatusId;
	@SerializedName("retweet_count")
	@Expose
	private int retweetCount;
	@SerializedName("created_at")
	@Expose
	private String createdAt;
	@SerializedName("in_reply_to_user_id")
	@Expose
	private Object inReplyToUserId;
	@SerializedName("favorite_count")
	@Expose
	private int favoriteCount;
	@SerializedName("id_str")
	@Expose
	private String idStr;
	@Expose
	private Object place;
	@Expose
	private User user;
	@Expose
	private Object coordinates;
	@Expose
	private Metadata metadata;

	public Object getContributors() {
		return contributors;
	}

	public void setContributors(Object contributors) {
		this.contributors = contributors;
	}

	public Example withContributors(Object contributors) {
		this.contributors = contributors;
		return this;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Example withText(String text) {
		this.text = text;
		return this;
	}

	public Object getGeo() {
		return geo;
	}

	public void setGeo(Object geo) {
		this.geo = geo;
	}

	public Example withGeo(Object geo) {
		this.geo = geo;
		return this;
	}

	public boolean isRetweeted() {
		return retweeted;
	}

	public void setRetweeted(boolean retweeted) {
		this.retweeted = retweeted;
	}

	public Example withRetweeted(boolean retweeted) {
		this.retweeted = retweeted;
		return this;
	}

	public Object getInReplyToScreenName() {
		return inReplyToScreenName;
	}

	public void setInReplyToScreenName(Object inReplyToScreenName) {
		this.inReplyToScreenName = inReplyToScreenName;
	}

	public Example withInReplyToScreenName(Object inReplyToScreenName) {
		this.inReplyToScreenName = inReplyToScreenName;
		return this;
	}

	public boolean isTruncated() {
		return truncated;
	}

	public void setTruncated(boolean truncated) {
		this.truncated = truncated;
	}

	public Example withTruncated(boolean truncated) {
		this.truncated = truncated;
		return this;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public Example withLang(String lang) {
		this.lang = lang;
		return this;
	}

	public Entities getEntities() {
		return entities;
	}

	public void setEntities(Entities entities) {
		this.entities = entities;
	}

	public Example withEntities(Entities entities) {
		this.entities = entities;
		return this;
	}

	public Object getInReplyToStatusIdStr() {
		return inReplyToStatusIdStr;
	}

	public void setInReplyToStatusIdStr(Object inReplyToStatusIdStr) {
		this.inReplyToStatusIdStr = inReplyToStatusIdStr;
	}

	public Example withInReplyToStatusIdStr(Object inReplyToStatusIdStr) {
		this.inReplyToStatusIdStr = inReplyToStatusIdStr;
		return this;
	}

	public double getId() {
		return id;
	}

	public void setId(double id) {
		this.id = id;
	}

	public Example withId(int id) {
		this.id = id;
		return this;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Example withSource(String source) {
		this.source = source;
		return this;
	}

	public Object getInReplyToUserIdStr() {
		return inReplyToUserIdStr;
	}

	public void setInReplyToUserIdStr(Object inReplyToUserIdStr) {
		this.inReplyToUserIdStr = inReplyToUserIdStr;
	}

	public Example withInReplyToUserIdStr(Object inReplyToUserIdStr) {
		this.inReplyToUserIdStr = inReplyToUserIdStr;
		return this;
	}

	public boolean isFavorited() {
		return favorited;
	}

	public void setFavorited(boolean favorited) {
		this.favorited = favorited;
	}

	public Example withFavorited(boolean favorited) {
		this.favorited = favorited;
		return this;
	}

	public Object getInReplyToStatusId() {
		return inReplyToStatusId;
	}

	public void setInReplyToStatusId(Object inReplyToStatusId) {
		this.inReplyToStatusId = inReplyToStatusId;
	}

	public Example withInReplyToStatusId(Object inReplyToStatusId) {
		this.inReplyToStatusId = inReplyToStatusId;
		return this;
	}

	public int getRetweetCount() {
		return retweetCount;
	}

	public void setRetweetCount(int retweetCount) {
		this.retweetCount = retweetCount;
	}

	public Example withRetweetCount(int retweetCount) {
		this.retweetCount = retweetCount;
		return this;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public Example withCreatedAt(String createdAt) {
		this.createdAt = createdAt;
		return this;
	}

	public Object getInReplyToUserId() {
		return inReplyToUserId;
	}

	public void setInReplyToUserId(Object inReplyToUserId) {
		this.inReplyToUserId = inReplyToUserId;
	}

	public Example withInReplyToUserId(Object inReplyToUserId) {
		this.inReplyToUserId = inReplyToUserId;
		return this;
	}

	public int getFavoriteCount() {
		return favoriteCount;
	}

	public void setFavoriteCount(int favoriteCount) {
		this.favoriteCount = favoriteCount;
	}

	public Example withFavoriteCount(int favoriteCount) {
		this.favoriteCount = favoriteCount;
		return this;
	}

	public String getIdStr() {
		return idStr;
	}

	public void setIdStr(String idStr) {
		this.idStr = idStr;
	}

	public Example withIdStr(String idStr) {
		this.idStr = idStr;
		return this;
	}

	public Object getPlace() {
		return place;
	}

	public void setPlace(Object place) {
		this.place = place;
	}

	public Example withPlace(Object place) {
		this.place = place;
		return this;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Example withUser(User user) {
		this.user = user;
		return this;
	}

	public Object getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Object coordinates) {
		this.coordinates = coordinates;
	}

	public Example withCoordinates(Object coordinates) {
		this.coordinates = coordinates;
		return this;
	}

	public Metadata getMetadata() {
		return metadata;
	}

	public void setMetadata(Metadata metadata) {
		this.metadata = metadata;
	}

	public Example withMetadata(Metadata metadata) {
		this.metadata = metadata;
		return this;
	}

	@Override
	public String toString() {
		return "Example [contributors=" + contributors + ", text=" + text
				+ ", geo=" + geo + ", retweeted=" + retweeted
				+ ", inReplyToScreenName=" + inReplyToScreenName
				+ ", truncated=" + truncated + ", lang=" + lang + ", entities="
				+ entities + ", inReplyToStatusIdStr=" + inReplyToStatusIdStr
				+ ", id=" + id + ", source=" + source + ", inReplyToUserIdStr="
				+ inReplyToUserIdStr + ", favorited=" + favorited
				+ ", inReplyToStatusId=" + inReplyToStatusId
				+ ", retweetCount=" + retweetCount + ", createdAt=" + createdAt
				+ ", inReplyToUserId=" + inReplyToUserId + ", favoriteCount="
				+ favoriteCount + ", idStr=" + idStr + ", place=" + place
				+ ", user=" + user + ", coordinates=" + coordinates
				+ ", metadata=" + metadata + "]";
	}

	
}
