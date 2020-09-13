package Persistence;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import model.Person;
import model.User;


public class FileOperations {

	public ArrayList<User> readProductsFile(String pathFile) throws JsonParseException, IOException {
		JsonParser jsonParser = new JsonFactory().createParser(new File(pathFile));
		ArrayList<User> products = new ArrayList<User>();
		while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
			User user = new User();
			while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
				if (jsonParser.getCurrentName() != null) {
					switch (jsonParser.getCurrentName()) {
						case "nickName":
							jsonParser.nextToken();
							user.setNickName(jsonParser.getText());
							break;
						case "password":
							user.setNickName(jsonParser.getText());
							break;
						case "client":
							jsonParser.nextToken();
							user.setClient(readPerson(jsonParser));
							product.setSubcategory(readSubcategory(jsonParser));
							break;
						case "expirationDate":
							jsonParser.nextToken();
							product.setExpirationDate(Utils.formatDate(jsonParser.getText(), Constants.DATE_SEPARATOR));
							break;
						case "stock":
							jsonParser.nextToken();
							product.setStock(jsonParser.getIntValue());
							break;
						case "value":
							jsonParser.nextToken();
							product.setValue(jsonParser.getDoubleValue());
							break;
						case "iva":
							jsonParser.nextToken();
							product.setIva(jsonParser.getByteValue());
							break;
						case "warranty":
							jsonParser.nextToken();
							product.setWarranty(jsonParser.getShortValue());
							break;
					}
				}
			}
			products.add(product);
			System.out.println(product.getId());
		}
		return products;
	}
		
	private Person readPerson(JsonParser jsonParser) {
		Person person = new Person();
		while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
			if (jsonParser.getCurrentName() != null) {
				switch (jsonParser.getCurrentName()) {
				case "id":
					jsonParser.nextToken();
					subcategory.setId(jsonParser.getIntValue());
					break;
				case "name":
					jsonParser.nextToken();
					subcategory.setName(jsonParser.getText());
					break;
				case "category":
					jsonParser.nextToken();
					subcategory.setCategory(readCategory(jsonParser));
					break;
				}
			}
		}
		return null;
	}

	private Subcategory readSubcategory(JsonParser jsonParser) throws JsonParseException, IOException {
		Subcategory subcategory = new Subcategory();
		while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
			if (jsonParser.getCurrentName() != null) {
				switch (jsonParser.getCurrentName()) {
				case "id":
					jsonParser.nextToken();
					subcategory.setId(jsonParser.getIntValue());
					break;
				case "name":
					jsonParser.nextToken();
					subcategory.setName(jsonParser.getText());
					break;
				case "category":
					jsonParser.nextToken();
					subcategory.setCategory(readCategory(jsonParser));
					break;
				}
			}
		}
		return subcategory;
	}
	
	private Category readCategory(JsonParser jsonParser) throws JsonParseException, IOException {
		Category category = new Category();
		while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
			if (jsonParser.getCurrentName() != null) {
				switch (jsonParser.getCurrentName()) {
				case "id":
					jsonParser.nextToken();
					category.setId(jsonParser.getIntValue());
					break;
				case "name":
					category.setName(jsonParser.getText());
					break;
				}
			}	
		}
		return category;
	}

	
}
