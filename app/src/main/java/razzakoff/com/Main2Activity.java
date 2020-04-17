package razzakoff.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    public static String TEXT_KEY = "text_key";

    EditText editText;
    EditText editGroup;
    EditText editBirthday;
    EditText editAddress;
    SomeClass someClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView stName = findViewById(R.id.main_2_text);
        editText = findViewById(R.id.main_2_edit);
        TextView stGroup = findViewById(R.id.main_2_group);
        editGroup = findViewById(R.id.main_2_edit_group);
        TextView stBirthday = findViewById(R.id.main_2_birthday);
        editBirthday = findViewById(R.id.main_2_edit_birthday);
        TextView stAddress = findViewById(R.id.main_2_address);
        editAddress = findViewById(R.id.main_2_edit_address);

        Button save = findViewById(R.id.main_2_save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                someClass.text = editText.getText().toString();
                someClass.group = editGroup.getText().toString();
                someClass.birthday = editBirthday.getText().toString();
                someClass.address = editAddress.getText().toString();
                intent.putExtra(MainActivity.RESULT_KEY, someClass);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        if (getIntent() != null) {
            someClass = (SomeClass) getIntent().getSerializableExtra(TEXT_KEY);
            stName.setText(someClass.text);
            someClass = (SomeClass) getIntent().getSerializableExtra(TEXT_KEY);
            stGroup.setText(someClass.group);
            someClass = (SomeClass) getIntent().getSerializableExtra(TEXT_KEY);
            stBirthday.setText(someClass.birthday);
            someClass = (SomeClass) getIntent().getSerializableExtra(TEXT_KEY);
            stAddress.setText(someClass.address);
        } else {
        }

    }

}
