package com.iamcd.team4.backend.infrastructure;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iamcd.team4.backend.logic.model.Hobby;

public class HobbyDatabase {

	public static void writeIntoDatabase(Hobby hobby) {
		try {
	
		final ObjectMapper mapper = new ObjectMapper();
		// TODO solve path issues
		File newState = new File("hobbyData.json"); 
			final ObjectMapper mapperReader = new ObjectMapper();
			// ignore all not needed fields
			mapperReader.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			List<Hobby> hobbyList = Arrays.asList(mapperReader.readValue(
					new File("hobbyData.json"), Hobby[].class));
			List<Hobby> updatedHobbyList = new ArrayList<Hobby>();
			updatedHobbyList.addAll(hobbyList);
			for (int i = 0; i < updatedHobbyList.size(); i++) {
				if (updatedHobbyList.get(i).equals(hobby)) {
					updatedHobbyList.remove(i);
				}				
			}
			updatedHobbyList.add(hobby);
			mapper.writeValue(newState, updatedHobbyList);
		} catch (FileNotFoundException e) {
			//TODO what if the test file does not exist locally?			
			try {
				//Try to copy personas as place holder
				Path personas = Paths.get("src/main/java/com/iamcd/team4/backend/infrastructure/personas.json");
				Files.copy(personas, Paths.get("hobbyData.json"));
				writeIntoDatabase(hobby);
			} catch (IOException io) {
				io.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Hobby readFromDatabase(int userId) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			// ignore all not needed fields
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			// TODO solve path issues
			List<Hobby> hobbies = Arrays.asList(mapper.readValue(
					new File("src/main/java/com/iamcd/team4/backend/infrastructure/personas.json"), Hobby[].class));
			for (int i = 0; i < hobbies.size(); i++) {
				if (hobbies.get(i).getUserId() == userId) {
					return hobbies.get(i);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	/**
	 * @param hobby
	 * @return true when the input hobbies equals the database hobbies under the
	 *         same userId
	 */
	public static boolean compareObjectWithDatabase(Hobby hobby) {
		Hobby entrance = readFromDatabase(hobby.getUserId());
		if (entrance.getHobbies().equals(hobby.getHobbies())) {
			return true;
		} else {
			return false;
		}
	}
}
