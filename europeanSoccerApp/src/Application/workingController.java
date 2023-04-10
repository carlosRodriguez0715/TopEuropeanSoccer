/**
 * @author: Carlos Rodriguez
 * Class handles the scene for the main application */

package Application;

import java.lang.NullPointerException;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class workingController {
	
	private Queries q = new Queries();
	private ArrayList<Player> results = new ArrayList<Player>();
	@FXML private AnchorPane bgPane;
	@FXML private TextField searchBar;
	@FXML public TextArea printArea;
	@FXML private ComboBox<String> teams;
	@FXML private ComboBox<String> age;
	@FXML private ComboBox<String> position;
	
	@FXML private void initialize() {
		loadTeams();
		loadAges();
		loadPositions();
	}
	
	private void loadAges() {
		this.q.searchByAge("1");
		ArrayList<Player> l = this.q.getFoundPlayers();
		int min = Integer.parseInt(l.get(0).getAge());
		int max = Integer.parseInt(l.get(l.size()-1).getAge());
		
		ArrayList<String> age = new ArrayList<String>();
		age.add("-");
		while(min < max) {
			age.add("" + min);
			min++;
		}
		age.add("" + max);
		this.age.getItems().addAll(age);
	}
	
	private void loadPositions() {
		this.q.searchByPosition("Left-Back");
		ArrayList<Player> l = this.q.getFoundPlayers();		
		ArrayList<String> pos = new ArrayList<String>();
		pos.add("-");
		for(int i=0; i<l.size(); i++) {
			if(!(pos.contains(l.get(i).getPosition()))) {
				pos.add(l.get(i).getPosition());
			}
		}
		this.position.getItems().addAll(pos);
	}
	
	private void loadTeams() {
		this.q.searchByTeam("LiverpoolFC");
		ArrayList<Player> l = this.q.getFoundPlayers();		
		ArrayList<String> t = new ArrayList<String>();
		t.add("-");
		for(int i=0; i<l.size(); i++) {
			if(!(t.contains(l.get(i).getCurrTeam()))) {
				t.add(l.get(i).getCurrTeam());
			}
		}
		this.teams.getItems().addAll(t);
	}
	 
	@FXML private void searchTeam() {
		try {
			 if(this.teams.getValue() == null) {
				 throw new NullPointerException();
			 }
			 else {
				 String value = this.teams.getValue();
				 if(value.equals("-") && (this.age.getValue() == null || this.age.getValue().equals("-")) && (this.position.getValue() == null || this.position.getValue().equals("-"))) {
					 this.printArea.clear();
					 this.results.clear();
				 }
				 else if(value.equals("-") && (!this.age.getValue().equals("-") || this.age.getValue() != null || this.position.getValue().equals("-") || this.position.getValue() != null)) {
					 this.printArea.clear();
					 if(!this.age.getValue().equals("-") && this.age.getValue() != null) {
						 searchAge();
					 }
					 if(!this.position.getValue().equals("-") && this.position.getValue() != null) {
						 searchPosition();
					 }
				 }
				 else {
					 if(this.results.isEmpty() || (this.age.getValue() == null || this.age.getValue().equals("-")) && (this.position.getValue() == null || this.position.getValue().equals("-"))) {
						 this.results = this.q.searchByTeam(value);
					 }
					 this.printArea.clear();
					 ArrayList<Player> sublist = new ArrayList<Player>();
					 for(int i=0; i<this.results.size(); i++) {
						 if(value.equals(this.results.get(i).getCurrTeam())) {
							 sublist.add(this.results.get(i));
						 }
					 }
					 this.results = sublist;
					 for(int i=0; i<this.results.size(); i++) {
						 this.printArea.setText(this.printArea.getText() + this.results.get(i).toString() + "\n");
					 }
				 }
			 }
		 }
		 catch(NullPointerException e) {
		 } 
	}
	
	@FXML private void searchAge() {
		try {
			 if(this.age.getValue() == null) {
				 throw new NullPointerException();
			 }
			 else {
				 String value = this.age.getValue();
				 if(value.equals("-") && (this.teams.getValue() == null || this.teams.getValue().equals("-")) && (this.position.getValue() == null || this.position.getValue().equals("-"))) {
					 this.printArea.clear();
					 this.results.clear();
				 }
				 else if(value.equals("-") && (!this.teams.getValue().equals("-") || this.teams.getValue() != null || this.position.getValue().equals("-") || this.position.getValue() != null)) {
					 this.printArea.clear();
					 if(!this.teams.getValue().equals("-") && this.teams.getValue() != null) {
						 searchTeam();
					 }
					 if(!this.position.getValue().equals("-") && this.position.getValue() != null) {
						 searchPosition();
					 }
				 }
				 else {
					 if(this.results.isEmpty() || (this.teams.getValue() == null || this.teams.getValue().equals("-")) && (this.position.getValue() == null || this.position.getValue().equals("-"))) {
						 this.results = this.q.searchByAge(value);
					 }
					 this.printArea.clear();
					 ArrayList<Player> sublist = new ArrayList<Player>();
					 for(int i=0; i<this.results.size(); i++) {
						 if(value.equals(this.results.get(i).getAge())) {
							 sublist.add(this.results.get(i));
						 }
					 }
					 this.results = sublist;
					 for(int i=0; i<this.results.size(); i++) {
						 this.printArea.setText(this.printArea.getText() + this.results.get(i).toString() + "\n");
					 }
				 }
			 }
		 }
		 catch(NullPointerException e) {
		 } 
	}
	
	@FXML private void searchPosition() {
		try {
			 if(this.position.getValue() == null) {
				 throw new NullPointerException();
			 }
			 else {
				 String value = this.position.getValue();
				 if(value.equals("-") && (this.age.getValue() == null || this.age.getValue().equals("-")) && (this.teams.getValue() == null || this.teams.getValue().equals("-"))) {
					 this.printArea.clear();
					 this.results.clear();
				 } 
				 else if(value.equals("-") && (!this.age.getValue().equals("-") || this.age.getValue() != null || this.teams.getValue().equals("-") || this.teams.getValue() != null)) {
					 this.printArea.clear();
					 if(!this.teams.getValue().equals("-") && this.teams.getValue() != null) {
						 searchTeam();
					 }
					 if(!this.age.getValue().equals("-") && this.age.getValue() != null) {
						 searchAge();
					 }
				 }
				 else {
					 if(this.results.isEmpty() || (this.age.getValue() == null || this.age.getValue().equals("-")) && (this.teams.getValue() == null || this.teams.getValue().equals("-"))) {
						 this.results = this.q.searchByPosition(value);
					 }
					 this.printArea.clear();
					 ArrayList<Player> sublist = new ArrayList<Player>();
					 for(int i=0; i<this.results.size(); i++) {
						 if(value.equals(this.results.get(i).getPosition())) {
							 sublist.add(this.results.get(i));
						 }
					 }
					 this.results = sublist;
					 for(int i=0; i<this.results.size(); i++) {
						 this.printArea.setText(this.printArea.getText() + this.results.get(i).toString() + "\n");
					 }
				 }
			 }
		 }
		 catch(NullPointerException e) {
		 } 
	}
	
	
}
