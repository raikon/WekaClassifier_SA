package json;

import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class User {

	@Expose
	private String location;
	@SerializedName("default_profile")
	@Expose
	private boolean defaultProfile;
	@SerializedName("profile_background_tile")
	@Expose
	private boolean profileBackgroundTile;
	@SerializedName("statuses_count")
	@Expose
	private int statusesCount;
	@Expose
	private String lang;
	@SerializedName("profile_link_color")
	@Expose
	private String profileLinkColor;
	@SerializedName("profile_banner_url")
	@Expose
	private String profileBannerUrl;
	@Expose
	private double id;
	@Expose
	private boolean following;
	@SerializedName("protected")
	@Expose
	private boolean _protected;
	@SerializedName("favourites_count")
	@Expose
	private int favouritesCount;
	@SerializedName("profile_text_color")
	@Expose
	private String profileTextColor;
	@Expose
	private String description;
	@Expose
	private boolean verified;
	@SerializedName("contributors_enabled")
	@Expose
	private boolean contributorsEnabled;
	@SerializedName("profile_sidebar_border_color")
	@Expose
	private String profileSidebarBorderColor;
	@Expose
	private String name;
	@SerializedName("profile_background_color")
	@Expose
	private String profileBackgroundColor;
	@SerializedName("created_at")
	@Expose
	private String createdAt;
	@SerializedName("is_translation_enabled")
	@Expose
	private boolean isTranslationEnabled;
	@SerializedName("default_profile_image")
	@Expose
	private boolean defaultProfileImage;
	@SerializedName("followers_count")
	@Expose
	private int followersCount;
	@SerializedName("profile_image_url_https")
	@Expose
	private String profileImageUrlHttps;
	@SerializedName("geo_enabled")
	@Expose
	private boolean geoEnabled;
	@SerializedName("profile_background_image_url")
	@Expose
	private String profileBackgroundImageUrl;
	@SerializedName("profile_background_image_url_https")
	@Expose
	private String profileBackgroundImageUrlHttps;
	@SerializedName("follow_request_sent")
	@Expose
	private boolean followRequestSent;
	@Expose
	private Entities_ entities;
	@Expose
	private Object url;
	@SerializedName("utc_offset")
	@Expose
	private Object utcOffset;
	@SerializedName("time_zone")
	@Expose
	private Object timeZone;
	@Expose
	private boolean notifications;
	@SerializedName("profile_use_background_image")
	@Expose
	private boolean profileUseBackgroundImage;
	@SerializedName("friends_count")
	@Expose
	private int friendsCount;
	@SerializedName("profile_sidebar_fill_color")
	@Expose
	private String profileSidebarFillColor;
	@SerializedName("screen_name")
	@Expose
	private String screenName;
	@SerializedName("id_str")
	@Expose
	private String idStr;
	@SerializedName("profile_image_url")
	@Expose
	private String profileImageUrl;
	@SerializedName("listed_count")
	@Expose
	private int listedCount;
	@SerializedName("is_translator")
	@Expose
	private boolean isTranslator;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public User withLocation(String location) {
		this.location = location;
		return this;
	}

	public boolean isDefaultProfile() {
		return defaultProfile;
	}

	public void setDefaultProfile(boolean defaultProfile) {
		this.defaultProfile = defaultProfile;
	}

	public User withDefaultProfile(boolean defaultProfile) {
		this.defaultProfile = defaultProfile;
		return this;
	}

	public boolean isProfileBackgroundTile() {
		return profileBackgroundTile;
	}

	public void setProfileBackgroundTile(boolean profileBackgroundTile) {
		this.profileBackgroundTile = profileBackgroundTile;
	}

	public User withProfileBackgroundTile(boolean profileBackgroundTile) {
		this.profileBackgroundTile = profileBackgroundTile;
		return this;
	}

	public int getStatusesCount() {
		return statusesCount;
	}

	public void setStatusesCount(int statusesCount) {
		this.statusesCount = statusesCount;
	}

	public User withStatusesCount(int statusesCount) {
		this.statusesCount = statusesCount;
		return this;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public User withLang(String lang) {
		this.lang = lang;
		return this;
	}

	public String getProfileLinkColor() {
		return profileLinkColor;
	}

	public void setProfileLinkColor(String profileLinkColor) {
		this.profileLinkColor = profileLinkColor;
	}

	public User withProfileLinkColor(String profileLinkColor) {
		this.profileLinkColor = profileLinkColor;
		return this;
	}

	public String getProfileBannerUrl() {
		return profileBannerUrl;
	}

	public void setProfileBannerUrl(String profileBannerUrl) {
		this.profileBannerUrl = profileBannerUrl;
	}

	public User withProfileBannerUrl(String profileBannerUrl) {
		this.profileBannerUrl = profileBannerUrl;
		return this;
	}

	public double getId() {
		return id;
	}

	public void setId(double id) {
		this.id = id;
	}

	public User withId(int id) {
		this.id = id;
		return this;
	}

	public boolean isFollowing() {
		return following;
	}

	public void setFollowing(boolean following) {
		this.following = following;
	}

	public User withFollowing(boolean following) {
		this.following = following;
		return this;
	}

	public boolean isProtected() {
		return _protected;
	}

	public void setProtected(boolean _protected) {
		this._protected = _protected;
	}

	public User withProtected(boolean _protected) {
		this._protected = _protected;
		return this;
	}

	public int getFavouritesCount() {
		return favouritesCount;
	}

	public void setFavouritesCount(int favouritesCount) {
		this.favouritesCount = favouritesCount;
	}

	public User withFavouritesCount(int favouritesCount) {
		this.favouritesCount = favouritesCount;
		return this;
	}

	public String getProfileTextColor() {
		return profileTextColor;
	}

	public void setProfileTextColor(String profileTextColor) {
		this.profileTextColor = profileTextColor;
	}

	public User withProfileTextColor(String profileTextColor) {
		this.profileTextColor = profileTextColor;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User withDescription(String description) {
		this.description = description;
		return this;
	}

	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}

	public User withVerified(boolean verified) {
		this.verified = verified;
		return this;
	}

	public boolean isContributorsEnabled() {
		return contributorsEnabled;
	}

	public void setContributorsEnabled(boolean contributorsEnabled) {
		this.contributorsEnabled = contributorsEnabled;
	}

	public User withContributorsEnabled(boolean contributorsEnabled) {
		this.contributorsEnabled = contributorsEnabled;
		return this;
	}

	public String getProfileSidebarBorderColor() {
		return profileSidebarBorderColor;
	}

	public void setProfileSidebarBorderColor(String profileSidebarBorderColor) {
		this.profileSidebarBorderColor = profileSidebarBorderColor;
	}

	public User withProfileSidebarBorderColor(String profileSidebarBorderColor) {
		this.profileSidebarBorderColor = profileSidebarBorderColor;
		return this;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User withName(String name) {
		this.name = name;
		return this;
	}

	public String getProfileBackgroundColor() {
		return profileBackgroundColor;
	}

	public void setProfileBackgroundColor(String profileBackgroundColor) {
		this.profileBackgroundColor = profileBackgroundColor;
	}

	public User withProfileBackgroundColor(String profileBackgroundColor) {
		this.profileBackgroundColor = profileBackgroundColor;
		return this;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public User withCreatedAt(String createdAt) {
		this.createdAt = createdAt;
		return this;
	}

	public boolean isIsTranslationEnabled() {
		return isTranslationEnabled;
	}

	public void setIsTranslationEnabled(boolean isTranslationEnabled) {
		this.isTranslationEnabled = isTranslationEnabled;
	}

	public User withIsTranslationEnabled(boolean isTranslationEnabled) {
		this.isTranslationEnabled = isTranslationEnabled;
		return this;
	}

	public boolean isDefaultProfileImage() {
		return defaultProfileImage;
	}

	public void setDefaultProfileImage(boolean defaultProfileImage) {
		this.defaultProfileImage = defaultProfileImage;
	}

	public User withDefaultProfileImage(boolean defaultProfileImage) {
		this.defaultProfileImage = defaultProfileImage;
		return this;
	}

	public int getFollowersCount() {
		return followersCount;
	}

	public void setFollowersCount(int followersCount) {
		this.followersCount = followersCount;
	}

	public User withFollowersCount(int followersCount) {
		this.followersCount = followersCount;
		return this;
	}

	public String getProfileImageUrlHttps() {
		return profileImageUrlHttps;
	}

	public void setProfileImageUrlHttps(String profileImageUrlHttps) {
		this.profileImageUrlHttps = profileImageUrlHttps;
	}

	public User withProfileImageUrlHttps(String profileImageUrlHttps) {
		this.profileImageUrlHttps = profileImageUrlHttps;
		return this;
	}

	public boolean isGeoEnabled() {
		return geoEnabled;
	}

	public void setGeoEnabled(boolean geoEnabled) {
		this.geoEnabled = geoEnabled;
	}

	public User withGeoEnabled(boolean geoEnabled) {
		this.geoEnabled = geoEnabled;
		return this;
	}

	public String getProfileBackgroundImageUrl() {
		return profileBackgroundImageUrl;
	}

	public void setProfileBackgroundImageUrl(String profileBackgroundImageUrl) {
		this.profileBackgroundImageUrl = profileBackgroundImageUrl;
	}

	public User withProfileBackgroundImageUrl(String profileBackgroundImageUrl) {
		this.profileBackgroundImageUrl = profileBackgroundImageUrl;
		return this;
	}

	public String getProfileBackgroundImageUrlHttps() {
		return profileBackgroundImageUrlHttps;
	}

	public void setProfileBackgroundImageUrlHttps(String profileBackgroundImageUrlHttps) {
		this.profileBackgroundImageUrlHttps = profileBackgroundImageUrlHttps;
	}

	public User withProfileBackgroundImageUrlHttps(String profileBackgroundImageUrlHttps) {
		this.profileBackgroundImageUrlHttps = profileBackgroundImageUrlHttps;
		return this;
	}

	public boolean isFollowRequestSent() {
		return followRequestSent;
	}

	public void setFollowRequestSent(boolean followRequestSent) {
		this.followRequestSent = followRequestSent;
	}

	public User withFollowRequestSent(boolean followRequestSent) {
		this.followRequestSent = followRequestSent;
		return this;
	}

	public Entities_ getEntities() {
		return entities;
	}

	public void setEntities(Entities_ entities) {
		this.entities = entities;
	}

	public User withEntities(Entities_ entities) {
		this.entities = entities;
		return this;
	}

	public Object getUrl() {
		return url;
	}

	public void setUrl(Object url) {
		this.url = url;
	}

	public User withUrl(Object url) {
		this.url = url;
		return this;
	}

	public Object getUtcOffset() {
		return utcOffset;
	}

	public void setUtcOffset(Object utcOffset) {
		this.utcOffset = utcOffset;
	}

	public User withUtcOffset(Object utcOffset) {
		this.utcOffset = utcOffset;
		return this;
	}

	public Object getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(Object timeZone) {
		this.timeZone = timeZone;
	}

	public User withTimeZone(Object timeZone) {
		this.timeZone = timeZone;
		return this;
	}

	public boolean isNotifications() {
		return notifications;
	}

	public void setNotifications(boolean notifications) {
		this.notifications = notifications;
	}

	public User withNotifications(boolean notifications) {
		this.notifications = notifications;
		return this;
	}

	public boolean isProfileUseBackgroundImage() {
		return profileUseBackgroundImage;
	}

	public void setProfileUseBackgroundImage(boolean profileUseBackgroundImage) {
		this.profileUseBackgroundImage = profileUseBackgroundImage;
	}

	public User withProfileUseBackgroundImage(boolean profileUseBackgroundImage) {
		this.profileUseBackgroundImage = profileUseBackgroundImage;
		return this;
	}

	public int getFriendsCount() {
		return friendsCount;
	}

	public void setFriendsCount(int friendsCount) {
		this.friendsCount = friendsCount;
	}

	public User withFriendsCount(int friendsCount) {
		this.friendsCount = friendsCount;
		return this;
	}

	public String getProfileSidebarFillColor() {
		return profileSidebarFillColor;
	}

	public void setProfileSidebarFillColor(String profileSidebarFillColor) {
		this.profileSidebarFillColor = profileSidebarFillColor;
	}

	public User withProfileSidebarFillColor(String profileSidebarFillColor) {
		this.profileSidebarFillColor = profileSidebarFillColor;
		return this;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public User withScreenName(String screenName) {
		this.screenName = screenName;
		return this;
	}

	public String getIdStr() {
		return idStr;
	}

	public void setIdStr(String idStr) {
		this.idStr = idStr;
	}

	public User withIdStr(String idStr) {
		this.idStr = idStr;
		return this;
	}

	public String getProfileImageUrl() {
		return profileImageUrl;
	}

	public void setProfileImageUrl(String profileImageUrl) {
		this.profileImageUrl = profileImageUrl;
	}

	public User withProfileImageUrl(String profileImageUrl) {
		this.profileImageUrl = profileImageUrl;
		return this;
	}

	public int getListedCount() {
		return listedCount;
	}

	public void setListedCount(int listedCount) {
		this.listedCount = listedCount;
	}

	public User withListedCount(int listedCount) {
		this.listedCount = listedCount;
		return this;
	}

	public boolean isIsTranslator() {
		return isTranslator;
	}

	public void setIsTranslator(boolean isTranslator) {
		this.isTranslator = isTranslator;
	}

	public User withIsTranslator(boolean isTranslator) {
		this.isTranslator = isTranslator;
		return this;
	}

	@Override
	public String toString() {
		return "User [location=" + location + ", defaultProfile="
				+ defaultProfile + ", profileBackgroundTile="
				+ profileBackgroundTile + ", statusesCount=" + statusesCount
				+ ", lang=" + lang + ", profileLinkColor=" + profileLinkColor
				+ ", profileBannerUrl=" + profileBannerUrl + ", id=" + id
				+ ", following=" + following + ", _protected=" + _protected
				+ ", favouritesCount=" + favouritesCount
				+ ", profileTextColor=" + profileTextColor + ", description="
				+ description + ", verified=" + verified
				+ ", contributorsEnabled=" + contributorsEnabled
				+ ", profileSidebarBorderColor=" + profileSidebarBorderColor
				+ ", name=" + name + ", profileBackgroundColor="
				+ profileBackgroundColor + ", createdAt=" + createdAt
				+ ", isTranslationEnabled=" + isTranslationEnabled
				+ ", defaultProfileImage=" + defaultProfileImage
				+ ", followersCount=" + followersCount
				+ ", profileImageUrlHttps=" + profileImageUrlHttps
				+ ", geoEnabled=" + geoEnabled + ", profileBackgroundImageUrl="
				+ profileBackgroundImageUrl
				+ ", profileBackgroundImageUrlHttps="
				+ profileBackgroundImageUrlHttps + ", followRequestSent="
				+ followRequestSent + ", entities=" + entities + ", url=" + url
				+ ", utcOffset=" + utcOffset + ", timeZone=" + timeZone
				+ ", notifications=" + notifications
				+ ", profileUseBackgroundImage=" + profileUseBackgroundImage
				+ ", friendsCount=" + friendsCount
				+ ", profileSidebarFillColor=" + profileSidebarFillColor
				+ ", screenName=" + screenName + ", idStr=" + idStr
				+ ", profileImageUrl=" + profileImageUrl + ", listedCount="
				+ listedCount + ", isTranslator=" + isTranslator + "]";
	}
	
	

}
