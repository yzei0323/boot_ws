package com.example.api;
import org.json.JSONObject;

 
public class ItemDto {

    private String title;
    private String link;
    private String image;
    private int lprice;

    public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getLprice() {
		return lprice;
	}

	public void setLprice(int lprice) {
		this.lprice = lprice;
	}

	public ItemDto(JSONObject itemJson){
        this.title = itemJson.getString("title");
        this.link = itemJson.getString("link");
         this.image = itemJson.getString("image");
         this.lprice = itemJson.getInt("lprice");
    }

	public ItemDto(String title, String link, String image, int lprice) {
		super();
		this.title = title;
		this.link = link;
		this.image = image;
		this.lprice = lprice;
	}

	@Override
	public String toString() {
		return "ItemDto [title=" + title + ", link=" + link + ", image=" + image + ", lprice=" + lprice + "]";
	}
	
	
	
}
