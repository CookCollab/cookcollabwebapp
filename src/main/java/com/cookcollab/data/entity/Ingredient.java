/*
* This file is used for the ingredients in our database
* Author: Christopher Pope
* Date: 8/31/2017
*/

package com.cookcollab.data.entity;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import javax.persistence.*;
import java.io.IOException;
import java.util.List;

@Entity
@Table(name="ingredient")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Ingredient {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ingredient_id")
	private long ingredientID;

	@ManyToOne
	@JoinColumn(name="event_id")
	@JsonSerialize(using = EventSerializer.class)
	private Event event;

	@ManyToOne
	@JoinColumn(name="user_id")
	@JsonSerialize(using = UserSerializer.class)
	private User user;

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

	public Event getEvent() {
		return this.event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
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

class IngredientSerializer extends StdSerializer<Ingredient> {
	public IngredientSerializer(){
		this(Ingredient.class);
	}

	public IngredientSerializer(Class<Ingredient> ingredient) {
		super(ingredient);
	}

	@Override
	public void serialize(Ingredient ingredient, JsonGenerator generator, SerializerProvider provider) throws IOException, JsonProcessingException {
		generator.writeStartObject();
		generator.writeNumberField("ingredientID", ingredient.getIngredientID());
		generator.writeNumberField("quanitity", ingredient.getQuantity());
		generator.writeStringField("name", ingredient.getName());
		generator.writeStringField("unit", ingredient.getUnit());
		generator.writeEndObject();
	}

}

class IngredientListSerializer extends StdSerializer<List<Ingredient>>{

	public IngredientListSerializer() {
		this(null);
	}

	public IngredientListSerializer(Class<List<Ingredient>> ingredientList) {
		super(ingredientList);
	}

	@Override
	public void serialize(List<Ingredient> ingredients, JsonGenerator generator, SerializerProvider provider)throws IOException, JsonProcessingException {
		generator.writeStartArray();
		for (Ingredient ingredient : ingredients) {
			generator.writeStartObject();
			generator.writeNumberField("ingredientID", ingredient.getIngredientID());
			generator.writeNumberField("quanitity", ingredient.getQuantity());
			generator.writeStringField("name", ingredient.getName());
			generator.writeStringField("unit", ingredient.getUnit());
			generator.writeEndObject();
		}
		generator.writeEndArray();
	}
}
