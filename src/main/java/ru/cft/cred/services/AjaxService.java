package ru.cft.cred.services;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Service
public class AjaxService {

	public String empty() {
		return "{}";
	}

	public String emptyList() {
		return "[]";
	}

	public String toJson(Object object) {
		Gson gson = new GsonBuilder().create();
		return gson.toJson(object);
	}

	public String toJsonWithNulls(Object object) {
		Gson gson = new GsonBuilder().serializeNulls().create();
		return gson.toJson(object);
	}

	public String toJsonPretty(Object object) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(object);
	}

	public String toJsonPrettyWithNulls(Object object) {
		Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
		return gson.toJson(object);
	}

	public <T> T fromJson(String json, Class<T> classOfT) {
		Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
		return gson.fromJson(json, classOfT);
	}

}
