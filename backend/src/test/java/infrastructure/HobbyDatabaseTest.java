package infrastructure;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.iamcd.team4.backend.infrastructure.HobbyDatabase;
import com.iamcd.team4.backend.logic.model.Hobby;

class HobbyDatabaseTest {

	@Test
	void testWriteIntoDatabase() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("Rad");
		list.add("Essen");
		
		HobbyDatabase.writeIntoDatabase(new Hobby(6, list));
		
	}

	@Test
	void testCompareObjectWithDatabase() {
		Hobby h = HobbyDatabase.readFromDatabase(1);
		assertTrue(HobbyDatabase.compareObjectWithDatabase(h));
		List<String> list = Arrays.asList(new String[] {
				"Test",
				"Test2"
		});
		h.setHobbies(list);
		assertFalse(HobbyDatabase.compareObjectWithDatabase(h));
	}
	
	@Test
	void testReadFromDatabase() {
		int i = 1;
		assertEquals(i, HobbyDatabase.readFromDatabase(i).getUserId());
	}

}
