package models;

import comparators.ComparatorByFinalNoteStudent;
import enums.TypeId;
import structures.AVLTree;

public class Student extends Person {

	private AVLTree<FinalNote> finalNotes;

	public Student(String name, String lastName, TypeId typeId, int numberId) {
		super(name, lastName, typeId, numberId);
		finalNotes = new AVLTree<>(new ComparatorByFinalNoteStudent());
	}

	public void addPartialNote(PartialNote partialNote, String subjectName) {
		FinalNote auxiliar = this.askFinalNote(subjectName);
		auxiliar.addPartialNote(partialNote);
	}

	public void modifyPartialNote(String subjectName, String topic, double value, String notation) {
		FinalNote auxiliar = this.askFinalNote(subjectName);
		auxiliar.modifyPartialNote(topic, value, notation);
	}

	public PartialNote askPartialNote(String topic, String subjectName) {
		FinalNote auxiliar = this.askFinalNote(subjectName);
		return auxiliar.askPartialNote(topic);
	}

	public void addComment(String topic, String comment, String subjectName) {
		FinalNote auxiliar = this.askFinalNote(subjectName);
		PartialNote note = auxiliar.askPartialNote(topic);
		note.setComment(comment);
	}

	public FinalNote askFinalNote(String subjectName) {
		return finalNotes.ask(new FinalNote(new Subject(0, subjectName, null)), finalNotes.getRoot()).getData();

	}

	public AVLTree<FinalNote> getFinalNotes() {
		return finalNotes;
	}

	public void setFinalNotes(AVLTree<FinalNote> finalNotes) {
		this.finalNotes = finalNotes;
	}

}
