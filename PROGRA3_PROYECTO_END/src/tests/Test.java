package tests;

import comparators.ComparatorByPartialNote;
import comparators.ComparatorByString;
import enums.TypeId;
import models.FinalNote;
import models.PartialNote;
import models.Subject;
import models.Teacher;
import structures.AVLTree;

public class Test {
	
	public static void main(String[] args) {
		
		View view =  new View();
		
		AVLTree<PartialNote> partialNotes = new AVLTree<PartialNote>(new ComparatorByPartialNote());

		PartialNote p1 = new PartialNote("La luna", 3.5, "Desarrolla lso ejercicios ");
		PartialNote p2 = new PartialNote("El sol", 3.2, "Desarrolla lso  ");
		PartialNote p3 = new PartialNote("Los dias", 3.1, "Desarrolla  ejercicios ");
		
		partialNotes.insert(p1);
		partialNotes.insert(p2);
		partialNotes.insert(p3);
		
		Teacher te = new Teacher("Pedro", "Flores", TypeId.CC, 1234);
		Subject subject = new Subject(1, "Naturales", te);
		FinalNote finalNote = new FinalNote(subject);
		finalNote.setPartialNotes(partialNotes);
		
		

//		PartialNote result = partialNotes.ask(new PartialNote("La materia",3.9,"defaf"), partialNotes.getRoot()).getData();
//		view.showTreeInOrder(partialNotes.getRoot());
//		System.out.println(result.toString());
		System.out.println(finalNote.getValue());
		
	}

}
