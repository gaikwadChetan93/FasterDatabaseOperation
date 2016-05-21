package ultimatebackup.mobileutilities.com.fasterandroiddatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class StudentOperations {

	// Database fields
	private DataBaseWrapper dbHelper;
	private String[] STUDENT_TABLE_COLUMNS = { DataBaseWrapper.STUDENT_ID, DataBaseWrapper.STUDENT_NAME };
	private SQLiteDatabase database;

	public StudentOperations(Context context) {
		dbHelper = new DataBaseWrapper(context);
	}

	public void open() throws SQLException {
		database = dbHelper.getWritableDatabase();
	}

	public void addStudent(String name) {

		for(int i=0; i<1000;i++) {
			ContentValues values = new ContentValues();
			values.put(DataBaseWrapper.STUDENT_NAME, name);
			long studId = database.insert(DataBaseWrapper.STUDENTS, null, values);
		}
	}

	public void addStudentbulk(String name) {

		database.beginTransaction();
		for(int i=0; i<1000;i++) {
			ContentValues values = new ContentValues();
			values.put(DataBaseWrapper.STUDENT_NAME, name);
			database.insert(DataBaseWrapper.STUDENTS, null, values);
		}
		database.setTransactionSuccessful();
		database.endTransaction();
	}
}