package teammates.storage.entity;

import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Text;

/**
 * An association class that represents the association Giver
 * --> [comments about] --> Receiver.
 * Both giver and receiver must be in the same course.
 * Currently giver is restricted only to Instructor, and
 * receiver is restricted to Student. Comments are only visible by
 * the Giver.
 */
@PersistenceCapable
public class Comment {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private transient Long commentId = null;
	
	/** The foreign key to locate the Course object. */
	@Persistent
	private String courseId;

	/** The giver's email used for this comment. */
	@Persistent
	private String giverEmail;

	/** The receiver's email used for this comment. */
	@Persistent
	private String receiverEmail;
	
	/** The creation time of this comment. */
	@Persistent
	private Date createdAt;
	
	/** The comment from giver for receiver */
	@Persistent
	private Text commentText;

	public Comment(String courseId, String giverEmail, String receiverEmail, Text comment, Date date){
		this.commentId = null; //Auto generated by GAE
		this.courseId = courseId;
		this.giverEmail = giverEmail;
		this.receiverEmail = receiverEmail;
		this.createdAt = date;
		this.commentText = comment;
	}

	public Long getId() {
		return commentId;
	}

	/* Auto generated. Don't set this.
	public void setId(Long id) {
		this.id = id;
	}*/

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getGiverEmail() {
		return giverEmail;
	}

	public void setGiverEmail(String giverEmail) {
		this.giverEmail = giverEmail;
	}

	public String getReceiverEmail() {
		return receiverEmail;
	}

	public void setReceiverEmail(String receiverEmail) {
		this.receiverEmail = receiverEmail;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Text getCommentText() {
		return commentText;
	}

	public void setCommentText(Text commentText) {
		this.commentText = commentText;
	}
}