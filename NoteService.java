package risrchanish.notes_manager.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import risrchanish.notes_manager.entity.Note;

/*
 * This is Service class. Handles all I/O logic (business logic)
 */
public class NoteService {

	public static final String FILE_NAME = "notes.txt";
	
	
	// Logic to save new notes into the file
	
	public void saveNewNotesToFile(Note note) // Passing the note as parameter
	{
		try (FileWriter writer = new FileWriter(FILE_NAME,true)){
			
			writer.write(note.getContent() + System.lineSeparator());
			
		}catch(IOException e)
		{
			System.out.println("Error while writing notes in file: " + e.getMessage());
		}
		
	}
	
	
	// Logic to read the notes from the file
	
	public List<Note> availableNotes()
	{
		List<Note> notes = new ArrayList<>();
		
		try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME)))
		{
			// using a while loop to add new lines into the list
			String line;
			while((line = reader.readLine()) != null)
			{
				notes.add(new Note(line));
			}
			
		}catch(IOException e)
		{
			System.out.println("Error in reading notes in the file: "+e.getMessage());
		}
		
		return notes;
	}
	
}
