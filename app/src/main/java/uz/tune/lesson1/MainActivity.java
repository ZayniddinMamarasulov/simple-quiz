package uz.tune.lesson1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView ivNext;
    ImageView ivFood;
    EditText etFirstName;
    Button btnSave;
    String firstName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five);

//        ivNext = findViewById(R.id.iv_next);
//        ivFood = findViewById(R.id.iv_food);
//

        etFirstName = findViewById(R.id.et_first_name);
        btnSave = findViewById(R.id.btn_save);

        clicks();
    }

    private void clicks() {
//        ivNext.setOnClickListener(this);
//        ivFood.setOnClickListener(this);
        btnSave.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.iv_food) {
            Toast.makeText(this, "food bosildi", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.iv_next) {
            Toast.makeText(this, "next bosildi", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.btn_save) {
            Toast.makeText(this, etFirstName.getText(), Toast.LENGTH_SHORT).show();
        }
    }
}