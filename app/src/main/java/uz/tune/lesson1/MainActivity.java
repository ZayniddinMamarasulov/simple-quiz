package uz.tune.lesson1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterInside;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView ivNext;
    ImageView ivFood;
    EditText etFirstName;
    AppCompatImageView btnBack;
    AppCompatImageView ivProfile;
    String firstName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

//        ivNext = findViewById(R.id.iv_next);
//        ivFood = findViewById(R.id.iv_food);
//

//        etFirstName = findViewById(R.id.et_first_name);
        btnBack = findViewById(R.id.btn_back);
        ivProfile = findViewById(R.id.iv_profile1);

        Glide.with(this)
                .load("https://picsum.photos/id/100/200/300")
                .into(ivProfile);

        clicks();
    }

    private void clicks() {
//        ivNext.setOnClickListener(this);
//        ivFood.setOnClickListener(this);
        btnBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_back) {
            Toast.makeText(this, "back bosildi", Toast.LENGTH_SHORT).show();
        }
    }
}