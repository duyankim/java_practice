package kr.ac.kopo.kopo03.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Board {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private String title;
    
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="board")
	private List<BoardItem> boardItems;
    
    public Board() {
        
    }
    
    public Board(String title) {
        this.title = title;
    }

    public Board(int id, String title) {
        this.id = id;
        this.title = title;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<BoardItem> getBoardItems() {
		return boardItems;
	}

	public void setBoardItems(List<BoardItem> boardItems) {
		this.boardItems = boardItems;
	}
}