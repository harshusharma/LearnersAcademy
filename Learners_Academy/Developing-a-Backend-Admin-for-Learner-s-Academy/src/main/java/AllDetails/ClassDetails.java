package AllDetails;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="class_details")
public class ClassDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Id")
	private int Id;
	@Column(name="Class")
	private String Name;
	@Column(name="Section")
	private String section;
	@Column(name="Room_No")
	private String roomno;
	
	public ClassDetails() {}
	
	public ClassDetails(String className, String classSection, String classRoomNo) {
		Name = className;
		section = classSection;
		roomno = classRoomNo;
	}
	
	public ClassDetails(int id, String className, String classSection, String classRoomNo) {
		super();
		Id = id;
		Name = className;
		section = classSection;
		roomno = classRoomNo;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getClassName() {
		return Name;
	}

	public void setClassName(String className) {
		Name = className;
	}

	public String getClassSection() {
		return section;
	}

	public void setClassSection(String classSection) {
		section = classSection;
	}

	public String getClassRoomNo() {
		return roomno;
	}

	public void setClassRoomNo(String classRoomNo) {
		roomno = classRoomNo;
	}

	@Override
	public String toString() {
		return "ClassDetails [Id=" + Id + ", ClassName=" + Name + ", ClassSection=" + section
				+ ", ClassRoomNo=" + roomno + "]";
	}
	
	
}
