package textProcessing;

import java.util.Date;

public class Tweet {
	private Long id;
	private String text;
	private Date date;
	private boolean isRetweet;
	private Long idAuthor;
	private boolean isFavorited;
	private double retweetCount;
	private String originalUser;

	public Tweet() {
		super();
	}

	public Tweet(Long id, String text, Date date, boolean isRetweet,
			Long idAuthor, boolean isFavorited, double retweetCount,
			String originalUser) {
		super();
		this.id = id;
		this.text = text;
		this.date = date;
		this.isRetweet = isRetweet;
		this.idAuthor = idAuthor;
		this.isFavorited = isFavorited;
		this.retweetCount = retweetCount;
		this.originalUser = originalUser;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isRetweet() {
		return isRetweet;
	}

	public void setRetweet(boolean isRetweet) {
		this.isRetweet = isRetweet;
	}

	public Long getIdAuthor() {
		return idAuthor;
	}

	public void setIdAuthor(Long idAuthor) {
		this.idAuthor = idAuthor;
	}

	public boolean isFavorited() {
		return isFavorited;
	}

	public void setFavorited(boolean isFavorited) {
		this.isFavorited = isFavorited;
	}

	public double getRetweetCount() {
		return retweetCount;
	}

	public void setRetweetCount(double retweetCount) {
		this.retweetCount = retweetCount;
	}

	public String getOriginalUser() {
		return originalUser;
	}

	public void setOriginalUser(String originalUser) {
		this.originalUser = originalUser;
	}

	@Override
	public String toString() {
		return "Tweet [id=" + id + ", text=" + text + ", date=" + date
				+ ", isRetweet=" + isRetweet + ", idAuthor=" + idAuthor
				+ ", isFavorited=" + isFavorited + ", retweetCount="
				+ retweetCount + ", originalUser=" + originalUser + "]";
	}

}
