/*
* This file is used for the ingredients in our database
* Author: Christopher Pope
* Date: 8/31/2017
*/

package cookcollab.com.cookcollab.data.entity;

import javax.persistence.*;

@Entity
@Table(name="ingredient")
public class Ingredient {
 
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="ingredient_id")
	private long ingredientID;

	@Column(name="event_id")
	private long eventID;

	@Column(name="user_id")
	private long userID;

	@Column(name="quantity")
	private long quantity;
	@Column(name="unit")
	private String unit;
	@Column(name="name")
	private String name;
	 
	public long getIngredientID() {
		return this.ingredientID;
	}

	public void setIngredientID(long ingredientID) {
		this.ingredientID = ingredientID;
	}

	public long getEventID() {
		return this.eventID;
	}

	public void setEventID(long eventID) {
		this.eventID = eventID;
	}

	public long getUserID() {
		return this.userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	public long getQuantity() {
		return this.quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
