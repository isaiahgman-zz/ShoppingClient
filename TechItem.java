public class TechItem {
	
	private int price;
	private int rating;
	private String name, description;
	
	public TechItem(String name, int price, int rating, String description) {
		this.name = name;
		this.price = price;
		this.rating = rating;
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
