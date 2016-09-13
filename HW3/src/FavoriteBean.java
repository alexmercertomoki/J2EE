

// the favourite bean 
public class FavoriteBean {
	
	private int fav_id;
	private int user_id;
	private String URL;
	private String comment;
	private int click_count;
	
	public int getFav_id() {
		return fav_id;
	}
	public void setFav_id(int fav_id) {
		this.fav_id = fav_id;
	}
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public int getClick_count() {
		return click_count;
	}
	public void setClick_count(int click_count) {
		this.click_count = click_count;
	}
	
	
}
