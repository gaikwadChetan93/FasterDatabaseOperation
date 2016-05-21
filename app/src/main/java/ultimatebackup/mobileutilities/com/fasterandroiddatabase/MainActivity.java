package ultimatebackup.mobileutilities.com.fasterandroiddatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private StudentOperations studentDBoperation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studentDBoperation = new StudentOperations(this);
        studentDBoperation.open();
        long startTime = System.nanoTime();
        //studentDBoperation.addStudent("Chetan");
        studentDBoperation.addStudentbulk("Chetan");
        long endTime = System.nanoTime();
        long duration = (endTime - startTime)/1000000000;
        System.out.println("time taken : "+duration);
    }

}
