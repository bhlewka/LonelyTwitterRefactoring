package ca.ualberta.cs.lonelytwitter;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;

// All refactorings in NormalLonelyTweet except for the @string change in main.xml

public class NormalLonelyTweet implements Serializable {

	// Made date and string private
	private static final long serialVersionUID = 1L;
	private Date tweetDate;
	private String tweetBody;

	// Removed unused (and ineffective constructor)
//	public NormalLonelyTweet() {
//}

	public NormalLonelyTweet(String text, Date date) {
		this.tweetDate = date;
		this.tweetBody = text;
	}

	public Date getTweetDate() {
		return tweetDate;
	}

	public void setTweetDate(Date tweetDate) {
		this.tweetDate = tweetDate;
	}

	public String getTweetBody() {
		return tweetBody;
	}

	public void setTweetBody(String tweetBody) {
		this.tweetBody = tweetBody;
	}

	private void writeObject(java.io.ObjectOutputStream out) throws IOException {
		out.writeObject(tweetDate);
		out.writeObject(tweetBody);
	}

	private void readObject(java.io.ObjectInputStream in) throws IOException,
			ClassNotFoundException {
		tweetDate = (Date) in.readObject();
		tweetBody = (String) in.readObject();
	}

	// Simplified if statement
	public boolean isValid() {
		return !(tweetBody.trim().length() == 0
				|| tweetBody.trim().length() > 10);

	}

	@Override
	public String toString() {
		return getTweetDate() + " | " + getTweetBody() ;
	}
}