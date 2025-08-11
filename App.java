package risrchanish.notes_manager;

import java.util.List;
import java.util.Scanner;

import risrchanish.notes_manager.entity.Note;
import risrchanish.notes_manager.service.NoteService;

public class App 
{
    public static void main( String[] args )
    {
        NoteService service = new NoteService();
        
        Scanner scanner = new Scanner(System.in);
        
        boolean running = true;
        
        while(running)
        {
        	System.out.println("Welcome to Notes Manager\n");
        	System.out.println("Press 1 to add notes in the file\n");
        	System.out.println("Press 2 to read notes of the file\n");
        	System.out.println("Press 3 to exit from the application\n");
        	
        	int input = scanner.nextInt();
        	scanner.nextLine();
        	
        	switch(input) 
        	{
        	
        		case 1 ->
        		{
        			
        			System.out.println("You have chosen to write notes. Please proceed \n");
        			String texts = scanner.nextLine();	
        			service.saveNewNotesToFile(new Note(texts));
        			System.out.println("\n");
        		}
        		
        		case 2 ->
        		{
        			System.out.println("You have chosen to read notes. Find below \n");
        			List<Note> notes = service.availableNotes();
        			notes.stream().forEach(note -> System.out.println(note));
        		}
        		
        		case 3 ->
        		{
        			System.out.println("You have chosen to exit. Good Bye!");
        			running = false;
        		}
        		
        		default -> 
        		{
        			System.out.println("\nWrong input try again");
        		}
        	}
        }
        
        scanner.close();
    }
}
